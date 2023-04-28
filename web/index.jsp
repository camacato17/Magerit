<%-- 
    Document   : newjsp
    Created on : 27/04/2023, 9:46:36 p. m.
    Author     : LUIS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>
        <body>
            <div class="container" mt-5>
                <div class="row">
                    <div class="col-sm">
                <form>
                <h1>inicio de sesion</h1>
                
                   <div class="username" >
                        <label>Correo</label>
                        <input type="text" name="usuario" placeholder="Escriba su correo">
                   </div>
                
                <div class="password">
                    <label>Contraseña</label>
                    <input type="password" name="contraseña" placeholder="Escriba su usuario">
                </div>
                
                <button type="submit" class="btn btn-primary">Iniciar sesion</button>  
                <button type="submit" class="btn btn-primary">Registrar</button> 
  
              </form>  
             </div>
           </div>

        </div>
    </body>
</html>
