<%-- 
    Document   : Autenticacion
    Created on : 27/04/2023, 9:53:46 p. m.
    Author     : LUIS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JS</title>
        <link rel="stylesheet" href="Estilos.css">
 </head>
<body>
    <div class="formulario">    
     <h1>Autenticacion</h1>
     <h4>Ingrese el codigo de verificacion enviado
            al correo:</h4>
    <form class="post">
       
         <div class="usuario">
             <input type="text" placeholder="codigo de verificacion">
         </div>
        
         <input type="submit" value="verificar" class="button">
     </div>
    </form>
</body>
</html>
