<%-- 
    Document   : newjsp
    Created on : 27/04/2023, 9:46:36 p. m.
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
     <h1>Iniciar Sesion</h1>
    <form class="post" >
       
         <div class="usuario">
             <input type="text" name="Campotxt_correo" placeholder="correo electronico">
         </div>
         
         <div class="usuario">
         <input type="password" name="Campotxt_contraseña" Placeholder="Contraseña">
         </div>
        <div class="olvidar">¿Olvido su contraseña?</div>
         <input type="submit" value="Iniciar Sesion" class="button">
         <div class="Registrarse">
         ¿No tienes una cuenta? <a class="link" href="registrarse.jsp">Registrate </a>
         </div>
     </div>
    </form>
</body>
</html>
