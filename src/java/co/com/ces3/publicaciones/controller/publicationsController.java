/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ces3.publicaciones.controller;

import co.com.ces3.publicaciones.DAO.categoriesDAO;
import co.com.ces3.publicaciones.DAO.publicationsDAO;
import co.com.ces3.publicaciones.model.publications;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian
 */
public class publicationsController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }
    
    protected void metGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if(accion.equals("listPublications")){
            categoriesDAO daoCategories = new categoriesDAO();
            publicationsDAO dao = new publicationsDAO();
            request.setAttribute("publications", dao.consultPublications());
            request.setAttribute("categories", daoCategories.consultCategories());
            request.getRequestDispatcher("publications.jsp").forward(request, response);
        }else if (accion.equals("deletePublication")){
            categoriesDAO daoCategories = new categoriesDAO();
            publicationsDAO dao = new publicationsDAO();
            String id = request.getParameter("id");
            dao.deletePublication(id);
            request.setAttribute("publications", dao.consultPublications());
             request.setAttribute("categories", daoCategories.consultCategories());
            request.getRequestDispatcher("publications.jsp").forward(request, response);
        }else if (accion.equals("updatePublication")){
            categoriesDAO daoCategories = new categoriesDAO();
            publications Publications = new publications();
            publicationsDAO dao = new publicationsDAO();
            String id = request.getParameter("id");
            String categoria = request.getParameter("categoria");
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");
            Publications.setId(id);
            Publications.setTitulo(titulo);
            Publications.setCategoria(categoria);
            Publications.setContenido(descripcion);
            dao.updatePublication(Publications);
            request.setAttribute("publications", dao.consultPublications());
            request.setAttribute("categories", daoCategories.consultCategories());
            request.getRequestDispatcher("publications.jsp").forward(request, response);
        }
    }

    protected void metPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            publications Publications = new publications();
            String titulo = request.getParameter("titulo");
            String categoria = request.getParameter("categoria");
            String descripcion = request.getParameter("descripcion");
            Publications.setTitulo(titulo);
            Publications.setCategoria(categoria);
            Publications.setContenido(descripcion);
                      
            publicationsDAO dao = new publicationsDAO();
            categoriesDAO daoCategories = new categoriesDAO();
            
            dao.createPublication(Publications);
            request.setAttribute("publications", dao.consultPublications());
            request.setAttribute("categories", daoCategories.consultCategories());
            request.getRequestDispatcher("publications.jsp").forward(request, response);  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        metGet(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        metPost(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
