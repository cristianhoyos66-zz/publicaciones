<%-- 
    Document   : menu
    Created on : 11-mar-2015, 22:14:44
    Author     : Cristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú</title>
    </head>
    <body>
        <h1>Menú</h1>
        <ul>
            <li><a href="publicationsController?accion=listPublications">Publicaciones</a></li>
            <li><a href="categoriesController?accion=listCategories">Categorías</a></li>
        </ul>
    </body>
</html>
