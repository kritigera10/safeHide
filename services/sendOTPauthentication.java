package service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

class SendOTPAuthenticator extends Authenticator {
   private String from;

   public SendOTPAuthenticator(String from) {
      this.from = from;
   }

   @Override
   protected PasswordAuthentication getPasswordAuthentication() {
      return new PasswordAuthentication(this.from, "your-email-password");
   }
}
