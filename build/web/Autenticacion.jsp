<%-- 
    Document   : Autenticacion
    Created on : 27/04/2023, 9:53:46 p. m.
    Author     : LUIS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
    </head>
   <body>
       <div class="container " mt-5 >
        <h1>Factor de autenticacion</h1>
        <h4>Ingrese el codigo de verificacion enviado
            al correo:
        </h4>
        
                    <div class="codigo" >
                        <label>Codigo</label>
                        <input type="text" name="codigo" placeholder="Escriba el codigo de verificacion">
                   </div>
        
                   <button type="submit" class="btn btn-primary">verificar</button>
        </div>
    </body>
</html>
