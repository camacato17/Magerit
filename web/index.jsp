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
    
    
    <% 
       if(request.getAttribute("code") != null){
        if(Integer.parseInt (request.getAttribute("code").toString())== 200){
     %>
     <script> 
      alert("Usuario Verificado, Inicia sesion");
     </script>
     <% }if(Integer.parseInt (request.getAttribute("code").toString())== 500){%>
      <script>
      alert("500 proceso erroneo, digite usuario y contraseña valida, existente");
      </script>
    <%}   %>
    <% if(Integer.parseInt (request.getAttribute("code").toString())== 300){ %>
     <script> 
      alert("300 proceso exitoso, Usuario verificado, inicie sesion");
     </script>
     <% } %>
     <% if(Integer.parseInt (request.getAttribute("code").toString())== 400){ %>
     <script> 
      alert("400, Usuario registrado");
     </script>
     <% }} %>
    
    <div class="formulario">    
     <h1>Iniciar Sesion</h1>
     <form class="post" action="CuentaControlador">
       
         <div class="usuario">
             <input type="text" name="Campotxt_correo" placeholder="corrreo@gmail.com" required=""
                    pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$">
         </div>
         
         <div class="usuario">
         <input type="password" name="Campotxt_contraseña" placeholder="contraseña min 6 caracteres"required=""
                minlength="6">
         </div>
         
        <div class="olvidar">¿Olvido su contraseña?</div>
        
         <input name="Boton_login" type="submit" value="Iniciar Sesion" class="button">
         
         <div class="Registrarse">
         ¿No tienes una cuenta? <a class="link" href="registrarse.jsp">Registrate </a>
         </div>
         
      </form>
     </div>
</body>
</html>
