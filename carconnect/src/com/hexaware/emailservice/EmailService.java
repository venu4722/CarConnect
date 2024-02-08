package com.hexaware.emailservice;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * This class provides functionality for sending confirmation emails.
 */
public class EmailService {
    private static final String EMAIL_USERNAME = "nakkellavenu72@gmail.com";
    private static final String EMAIL_PASSWORD = "fwpp zijk mczm bwao";
    private static final String EMAIL_HOST = "smtp.gmail.com";
    private static final String EMAIL_PORT = "587";

    /**
     * Sends a confirmation email.
     * 
     * @param emailAddress The recipient email address.
     * @param subject The subject of the email.
     * @param body The body of the email.
     */
    public static void sendConfirmationEmail(String emailAddress, String subject, String body) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", EMAIL_HOST);
            props.put("mail.smtp.port", EMAIL_PORT);

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddress));
            message.setSubject(subject);
            message.setText(body);
            System.out.println("Reservation is sent to your Email..");

            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Implement method for sending SMS reminders
}
