/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UCC.conexion;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author LUIS
 */
public class Mail {
    
public static void enviarCorreo(String destinatario, String mensaje) throws MessagingException {

        // Configuración de las propiedades del servidor SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "correo");
        props.setProperty("mail.smtp.auth", "true");
        
        
        Session session = Session.getInstance(props);

        // Creación del mensaje de correo electrónico
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("correoconfirmacioncuenta@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,  InternetAddress.parse(destinatario));
        message.setSubject("CODIGO DE VERIFICACION");
        message.setText(mensaje);

        // Envío del mensaje de correo electrónico
        Transport t = session.getTransport("smtp");
        t.connect("correoconfirmacioncuenta@gmail.com"," wvufapxbyyvsupzz");
        t.sendMessage(message, message.getAllRecipients());
        t.close();
        System.out.println("se envio el correo");
    }


      
}