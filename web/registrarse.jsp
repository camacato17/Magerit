<%-- 
    Document   : login
    Created on : 4/05/2023, 8:38:28 a. m.
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
    <% 
       if(request.getAttribute("code") != null){
        if(request.getAttribute("code") == "200"){
     %>
     <script> 
      alert("200 proceso exitoso");
     </script>
     <% }else{
     %>
      <script>
      alert("500 proceso erroneo");
      </script>
    <%
        } 
        }
    %>
    
    <div class="formulario">    
     <h1>Registrate</h1>
     <form class="post" action="cuentacontrolador">
       
         <div class="usuario">
             <input type="text" name="Campotxt_correoRegistrar" placeholder="correo electronico">
         
         
         </div>
         
         <div class="usuario">
         <input type="password" name="Campotxt_contraseñaRegistrar" placeholder="contraseña">
          
         </div>
        
        <div class="usuario">
         <input type="password" name="Campotxt_verificarcontraseñaRegistrar" placeholder="verificar contraseña">
          
         </div>
         <input name="Boton_registrar" type="submit" value="Registrar" class="button">
         <p>Al registrarte, aceptas nuestras Condiciones de uso y Política de privacidad.</p>
       
    </form>
     </div>
</body>
</html>
