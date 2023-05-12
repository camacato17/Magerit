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
    <% 
       if(request.getAttribute("code") != null){
        if(Integer.parseInt (request.getAttribute("code").toString())== 200){
     %>
     <script> 
      alert("200 proceso exitoso, Usuario registrado,verifique su usuario");
     </script>
     <% }if(Integer.parseInt (request.getAttribute("code").toString())== 500){%>
      <script>
      alert("500 proceso erroneo, por la seguridad de tu cuenta ingresa el codigo enviado al correo");
      </script>
    <%}}%>
    
    <div class="formulario">    
          <form class="post" action="CuentaControlador">
     <h1>Autenticacion</h1>
     <h4>Ingrese el codigo de verificacion enviado
         al correo:<%String correo = (String) session.getAttribute("correo"); out.println( correo);%></h4>
       
         <div class="usuario">
             <input type="text" name="Campotxt_codigoverificacion" placeholder="Codigo de 6 caracteres" required=""  minlength="6">
         </div>
        
         <input name="Boton_verificar" type="submit" value="verificar" class="button">
    </form>
     </div>
</body>
</html>
