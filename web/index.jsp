<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de sesión</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Inicio de sesión</h1>
                <form role="form" method="post" action="usersController">
                    <div class="form-group">
                        <label for="email">Digitar email</label>
                        <input type="email" class="form-control" name="email" id="email" placeholder="Ingrese su email">
                    </div>
                    <div class="form-group">
                        <label for="pass">Digitar contraseña</label>
                        <input type="password" class="form-control" name="pass" id="pass" placeholder="Ingrese su contraseña">
                    </div>
                    <button type="submit" class="btn btn-success">Iniciar sesión</button>
                </form>
            </div>
        </div>
    </body>
</html>
