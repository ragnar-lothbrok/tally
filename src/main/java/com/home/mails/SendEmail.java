package com.home.mails;

import java.io.StringWriter;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class SendEmail {

    public static void main(String[] args) {

    	
    	System.out.println(UUID.randomUUID().toString());
        try {
            final String username = "xxx@gmail.com";
            final String password = "xxx";

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            VelocityEngine ve = new VelocityEngine();
            ve.init();
            Template t = ve.getTemplate( "email_template.vm" );
            VelocityContext context = new VelocityContext();
            context.put("username", "Facebook User");
            context.put("passwordResetLink", "http://www.facebook.com/reset");
            context.put("supportemail", "support@facebook.com");
            context.put("siteLink", "http://www.facebook.com");
            context.put("siteTitle", "Facebook");
            StringWriter writer = new StringWriter();
            t.merge( context, writer );

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("xxx@gmail.com"));
            message.setSubject("Reset your password");
            message.setContent(writer.toString(), "text/html");

            Transport.send(message);

            System.out.println("Done");
            
            
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
    }
}
