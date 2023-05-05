/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.UCC.controlador;

import com.UCC.conexiones.Cuenta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.security.util.Password;
import com.UCC.conexiones.Cuenta;
/**
 *
 * @author LUIS
 */
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
         }
    }
    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try{
        String correo = request.getParameter("Campotxt_correoRegistrar");
        String contraseña = request.getParameter("Campotxt_contraseñaRegistrar");
        String Vrfcontraseña =request.getParameter("Campotxt_verificarcontraseñaRegistrar");
         if(!contraseña.equals(Vrfcontraseña)){
             throw new Exception("contraseña diferente"); 
         }
         Cuenta c = new Cuenta();
         c.registrar(correo, contraseña);
         
         request.setAttribute("mensaje","Proceso realizado correctamente");
         request.setAttribute("code", 200);
         request.getRequestDispatcher("index.jsp").forward(request, response);
        }catch(Exception e){
        request.setAttribute("mensaje",e.getMessage());
         request.setAttribute("code", 500);
         request.getRequestDispatcher("registrar.jsp").forward(request, response);
         
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
