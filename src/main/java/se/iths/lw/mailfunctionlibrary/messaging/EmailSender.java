package se.iths.lw.mailfunctionlibrary.messaging;


import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import se.iths.lw.mailfunctionlibrary.model.Email;
import se.iths.lw.mailfunctionlibrary.model.Message;

import java.util.Properties;

@Component("email")
public class EmailSender implements Messenger{

    @Value("${spring.mail.username}")
    private String FROM;
    @Value("${spring.mail.password}")
    private String APP_PASSWORD;

    @Override
    public void send(Message message) {

        if(!(message instanceof Email email)){
            throw new IllegalArgumentException("Fel typ av meddelande.");
        }

        if (email.getRecipient() == null || email.getRecipient().isBlank()) {
            throw new IllegalArgumentException("Recipient address cannot be null or empty");
        }
        if (email.getSubject() == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }
        if (email.getMessage() == null) {
            throw new IllegalArgumentException("Message body cannot be null");
        }

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port","587");

        Session session = Session.getInstance(props, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(FROM,APP_PASSWORD);
            }
        });

        try{
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(FROM));
            mimeMessage.setRecipient(jakarta.mail.Message.RecipientType.TO,
                    new InternetAddress(email.getRecipient()));
            mimeMessage.setSubject(email.getSubject());
            mimeMessage.setText(email.getMessage());
            Transport.send(mimeMessage);

            System.out.println("Mail sent successfully.");

        } catch (Exception e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }

}
