/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ces3.publicaciones.controller;

import co.com.ces3.publicaciones.DAO.categoriesDAO;
import co.com.ces3.publicaciones.model.categories;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cristian
 */
public class categoriesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    HttpSession session;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }
    
    protected void metGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String accion = request.getParameter("accion");
        if(accion.equals("listCategories")){
            categoriesDAO dao = new categoriesDAO();
            request.setAttribute("categories", dao.consultCategories());
            request.getRequestDispatcher("categories.jsp").forward(request, response);
        }else if (accion.equals("deleteCategory")){
            categoriesDAO dao = new categoriesDAO();
            String id = request.getParameter("id");
            dao.deleteCategory(id);
            request.setAttribute("categories", dao.consultCategories());
            request.getRequestDispatcher("categories.jsp").forward(request, response);
        }else if (accion.equals("updateCategory")){
            categories Categories = new categories();
            categoriesDAO dao = new categoriesDAO();
            String id = request.getParameter("id");
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");
            Categories.setId(id);
            Categories.setTitulo(titulo);
            Categories.setDescripcion(descripcion);
            dao.updateCategory(Categories);
            request.setAttribute("categories", dao.consultCategories());
            request.getRequestDispatcher("categories.jsp").forward(request, response);
        }
    }

    protected void metPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            categories Categories = new categories();
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");
            Categories.setTitulo(titulo);
            Categories.setDescripcion(descripcion);
                      
            categoriesDAO dao = new categoriesDAO();
            
            dao.createCategory(Categories);
            request.setAttribute("categories", dao.consultCategories());
            request.getRequestDispatcher("categories.jsp").forward(request, response);  
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
