package domain.service;

import domain.model.Email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService implements EmailService {
    @Override
    public void sendEmail(Email email) {
        // Sender's email ID needs to be mentioned
        String from = "projectweek2022groep2a@gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("projectweekgroup2@gmail.com", "pckerakpjpunqkbw");
            }
        });

        // Used to debug SMTP issues
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getReceiver()));

            // Set Subject: header field
            message.setSubject(email.getSubject());

            // Now set the actual message
            message.setText(email.getMessage());

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch(MessagingException mex){
            mex.printStackTrace();
        }
    }
}
