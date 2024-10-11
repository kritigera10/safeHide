package service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendOTPService {
   public static void sendOTP(String email, String genOTP) {
      String to = email;
      String from = "gerakriti30@gmail.com";
      String host = "smtp.gmail.com";
      
      Properties properties = System.getProperties();
      properties.put("mail.smtp.host", host);
      properties.put("mail.smtp.port", "465");
      properties.put("mail.smtp.ssl.enable", "true");
      properties.put("mail.smtp.auth", "true");

      Session session = Session.getInstance(properties, new SendOTPAuthenticator(from));
      session.setDebug(true);

      try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.addRecipient(RecipientType.TO, new InternetAddress(to));
         message.setSubject("OTP for file encryption app is this. Valid for only 5 mins.");
         message.setText("Your One-Time Password for File Enc app is " + genOTP);
         System.out.println("sending...");
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException e) {
         e.printStackTrace();
      }
   }
}
