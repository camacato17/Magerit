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
        if(Integer.parseInt (request.getAttribute("code").toString())== 200){
     %>
     <script> 
      alert("200 proceso exitoso");
     </script>
     <% }if(Integer.parseInt (request.getAttribute("code").toString())== 500){%>
      <script>
      alert("500 proceso erroneo, por la seguridad de tu cuenta digita la misma contraseña");
      </script>
    <% }if(Integer.parseInt (request.getAttribute("code").toString())== 300){ %>
     <script> 
      alert("300 proceso erroneo, Usuario existente");
     </script>
     <% }} %>
    
    <div class="formulario">    
     <h1>Registrate</h1>
     <form class="post" action="CuentaControlador">
       
         <div class="usuario">
             <input type="text" name="Campotxt_correoRegistrar" placeholder="corrreo@gmail.com" required=""
                    pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$">
         </div>
         
         <div class="usuario">
         <input type="password" name="Campotxt_contraseñaRegistrar" placeholder="contraseña min 6 caracteres"required=""
                minlength="6">
         </div>
        
        <div class="usuario">
         <input type="password" name="Campotxt_verificarcontraseñaRegistrar" placeholder="verificar contraseña" required=""
                minlength="6">
         </div>
         
         <input name="Boton_registrar" type="submit" value="Registrar" class="button">
         <p>Al registrarte, aceptas nuestras Condiciones de uso y Política de privacidad.</p>
         
         <div class="Registrarse">
         ¿Ya tienes cuenta? <a class="link" href="index.jsp">Login </a>
         </div>
       
    </form>
     </div>
</body>
</html>
