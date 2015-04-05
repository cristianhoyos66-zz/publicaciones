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
            <h1>Publicaciones</h1>
            <a href="" class="btn btn-success" ng-click="active=true">Crear nueva publicación</a>
            <a href="menu.jsp" class="btn btn-info">Volver al menú</a>
            <br><br>
            <div class="row" ng-show="active===true">
                <h1>Crear nueva publicación</h1>
                <form role="form" method="post" action="publicationsController">
                    <div class="form-group">
                        <label for="titulo">Digitar titulo</label>
                        <input type="text" class="form-control" name="titulo" id="titulo" placeholder="Ingrese el título de la publicación" required>
                    </div>
                    <div class="form-group">
                        <label for="categoria">Seleccionar categoría</label>
                        <select class="form-control" name="categoria" id="categoria" required>
                            <c:forEach items="${categories}" var = "category">
                                <option value="${category.getId()}" >${category.getTitulo()}</option>
                            </c:forEach> 
                        </select> 
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Digitar descripción</label>
                        <input type="descripcion" class="form-control" name="descripcion" id="descripcion" placeholder="Ingrese la descripción de la publicación" required>
                    </div>
                    <button type="submit" class="btn btn-success">Crear publicación</button>
                    <a href="" class="btn btn-info" ng-click="active=false">Esconder formulario</a>
                </form>
                <br><br>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Lista de publicaciones</div>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Titulo</th>
                            <th>Categoría</th>
                            <th>Descripción</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${publications}" var = "publication">
                            <tr ng-init="activeUpdate${publication.getId()}=false">
                                <td ng-show="activeUpdate${publication.getId()}===false"><c:out value="${publication.getTitulo()}"/></td>
                                <td ng-show="activeUpdate${publication.getId()}===false"><c:out value="${publication.getCategoria()}"/></td>
                                <td ng-show="activeUpdate${publication.getId()}===false"><c:out value="${publication.getContenido()}"/></td>
                                <td ng-show="activeUpdate${publication.getId()}===true"><input ng-model="titulo" type="text" required></td>
                                <td ng-show="activeUpdate${publication.getId()}===true">
                                    <select class="form-control" ng-model="categoria" id="categoria" required>
                                        <c:forEach items="${categories}" var = "category">
                                            <option value="${category.getId()}" >${category.getTitulo()}</option>
                                        </c:forEach> 
                                    </select>
                                </td>
                                <td ng-show="activeUpdate${publication.getId()}===true"><input ng-model="descripcion" type="text" required></td>
                                <td ng-show="activeUpdate${publication.getId()}===true"><a href="publicationsController?accion=updatePublication&id=${publication.getId()}&titulo={{titulo}}&descripcion={{descripcion}}&categoria={{categoria}}" class="btn btn-success">Modificar Registro</a></td>
                                <td><a href="" class="" ng-click="activeUpdate${publication.getId()}=!activeUpdate${publication.getId()}; titulo='${publication.getTitulo()}'; descripcion='${publication.getContenido()}'">Modificar Registro</a></td>
                                <td><a href="publicationsController?accion=deletePublication&id=<c:out value="${publication.getId()}"/>" class="btn btn-success">Eliminar Registro</a></td>
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
