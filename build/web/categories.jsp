<%-- 
    Document   : listaProductos
    Created on : 11-mar-2015, 21:02:20
    Author     : Cristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html ng-app>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorías</title>
    </head>
    <body>
        <div class="container" ng-init="active=false">
            <h1>Categorías</h1>
            <a href="" class="btn btn-success" ng-click="active=true">Crear nueva categoría</a>
            <a href="menu.jsp" class="btn btn-info">Volver al menú</a>
            <br><br>
            <div class="row" ng-show="active===true">
                <h1>Crear nueva categoría</h1>
                <form role="form" method="post" action="categoriesController">
                    <div class="form-group">
                        <label for="titulo">Digitar titulo</label>
                        <input type="text" class="form-control" name="titulo" id="titulo" placeholder="Ingrese el título de la categoría">
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Digitar descripción</label>
                        <input type="descripcion" class="form-control" name="descripcion" id="descripcion" placeholder="Ingrese la descripción de la categoría">
                    </div>
                    <button type="submit" class="btn btn-success">Crear categoría</button>
                    <a href="" class="btn btn-info" ng-click="active=false">Esconder formulario</a>
                </form>
                <br><br>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Lista de categorías</div>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Titulo</th>
                            <th>Descripción</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${categories}" var = "category">
                            <tr ng-init="activeUpdate${category.getId()}=false">
                                <td ng-show="activeUpdate${category.getId()}===false"><c:out value="${category.getTitulo()}"/></td>
                                <td ng-show="activeUpdate${category.getId()}===false"><c:out value="${category.getDescripcion()}"/></td>
                                <td ng-show="activeUpdate${category.getId()}===true"><input ng-model="titulo" type="text"></td>
                                <td ng-show="activeUpdate${category.getId()}===true"><input ng-model="descripcion" type="text"></td>
                                <td ng-show="activeUpdate${category.getId()}===true"><a href="categoriesController?accion=updateCategory&id=${category.getId()}&titulo={{titulo}}&descripcion={{descripcion}}" class="btn btn-success">Modificar Registro</a></td>
                                <td><a href="" class="" ng-click="activeUpdate${category.getId()}=!activeUpdate${category.getId()}">Modificar Registro</a></td>
                                <td><a href="categoriesController?accion=deleteCategory&id=<c:out value="${category.getId()}"/>" class="btn btn-success">Eliminar Registro</a></td>
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
