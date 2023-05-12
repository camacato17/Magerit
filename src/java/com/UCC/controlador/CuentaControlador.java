/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.UCC.controlador;

import com.UCC.conexion.Cuenta;
import static com.UCC.conexion.Mail.enviarCorreo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.UCC.conexion.Security.*;




@WebServlet(name = "CuentaControlador", urlPatterns = {"/CuentaControlador"})
public class CuentaControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
         if(request.getParameter("Boton_registrar") != null){
             registrarUsuario(request, response);
         } else if(request.getParameter("Boton_login") != null){
             loginusuario(request, response);
         }else if(request.getParameter("Boton_verificar") != null){
             Autenticacion(request, response);
         }
    }
    private void Autenticacion(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
        String numero_verificacion = (String)request.getSession().getAttribute("numero_verificacion");
        String numero_ingresado = request.getParameter("Campotxt_codigoverificacion");
        
        String mensaje="";
        if (numero_ingresado.trim().length()==0) {
                mensaje="La contraseña es vacia";
            }if (mensaje.length() !=0) {
                throw new Exception(mensaje.substring(0,mensaje.length() -1));
                
            }
        if(numero_verificacion.equals(numero_ingresado)){
          request.setAttribute("code", 200);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if(!numero_verificacion.equals(numero_ingresado)){
        request.setAttribute("code", 500);
         request.getRequestDispatcher("Autenticacion.jsp").forward(request, response);
         
        }
         
        } catch (Exception e) {
         request.setAttribute("code", 500);
         request.getRequestDispatcher("Autenticacion.jsp").forward(request, response);
         
        }
    
    }
    
    private void loginusuario(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        
        try {
        String correo = request.getParameter("Campotxt_correo");
        String contraseña = request.getParameter("Campotxt_contraseña");
           
        String mensaje1="";
        if(correo.trim().length() == 0){
        mensaje1="el correo es requerido";
        }if(contraseña.trim().length() == 0){
        mensaje1="la contraseña es requerida";
        }if(mensaje1.length() !=0){
         throw new Exception(mensaje1.substring(0, mensaje1.length() -1));
        }
        
        
        String hashcontraseña = convertirSHA256(contraseña);
            boolean existe = Cuenta.Login(correo, hashcontraseña);
//            boolean existe1 = Cuenta.Verificarcorreo(correo);
        
            if (existe) {
         request.getRequestDispatcher("inicio.jsp").forward(request, response);         
            }
//                if (!existe1) {
//                request.setAttribute("code", 400);
//         request.getRequestDispatcher("index.jsp").forward(request, response);
//           throw new Exception();
//            }
//            
         request.setAttribute("code", 500);
         request.getRequestDispatcher("index.jsp").forward(request, response);
         
        } catch (Exception e) {
         request.setAttribute("mensaje",e.getMessage());
         request.setAttribute("code", 500);
         request.getRequestDispatcher("index.jsp").forward(request, response);
         
        }
    }
    private void verificarcampo(String correo,String contraseña, String Vrfcontraseña) throws Exception{
     String mensaje1="";
        if(correo.trim().length() == 0){
        mensaje1="el correo es requerido";
        }if(contraseña.trim().length() == 0){
        mensaje1="la contraseña es requerida";
        }if(Vrfcontraseña.trim().length() == 0){
        mensaje1="la contraseña es requerida";
        }if(mensaje1.length() !=0){
         throw new Exception(mensaje1.substring(0, mensaje1.length() -1));
        }
    }
    
    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try{
        String correo = request.getParameter("Campotxt_correoRegistrar");
        String contraseña = request.getParameter("Campotxt_contraseñaRegistrar");
        String Vrfcontraseña =request.getParameter("Campotxt_verificarcontraseñaRegistrar");
            verificarcampo(correo, contraseña, Vrfcontraseña);
            
         if(!contraseña.equals(Vrfcontraseña)){
             throw new Exception("contraseña diferente"); 
         }
        String hashcontraseña = convertirSHA256(contraseña);
         boolean existe = Cuenta.Login(correo, hashcontraseña);
        
         if (existe){
         request.setAttribute("code", 300);
         request.getRequestDispatcher("registrarse.jsp").forward(request, response);
         throw new Exception("usuario ya registrado");
         }
//         
         
         Cuenta c = new Cuenta();
         c.registrar(correo, hashcontraseña);
         request.getSession().setAttribute("correo", correo);
        
         
         
         request.setAttribute("mensaje","Proceso realizado correctamente");
         request.setAttribute("code", 200);
         request.getRequestDispatcher("Autenticacion.jsp").forward(request, response);
         
         String mensaje= "SU CODIGO DE VERFICACION ES : ";
         String numero = numeroaleatorio();
         enviarCorreo(correo,mensaje+numero );
         
         request.getSession().setAttribute("numero_verificacion", numero);


        }catch(Exception e){
        request.setAttribute("mensaje",e.getMessage());
         request.setAttribute("code", 500);
         request.getRequestDispatcher("registrarse.jsp").forward(request, response);
         
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
