/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon_1;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Otp {
    public Otp(String to,String userName,long otpNo ){
       
      String from = "srikrishnaelectricity@gmail.com";
      final String username = "srikrishnaelectricity@gmail.com";
      final String password = "srikrishna123";
      String host = "smtp.gmail.com";
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });
      try {
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));
         message.setSubject("OTP from Krishna Electricity Board");
         message.setText("Dont share your OTP to others.\n Your OTP is "+otpNo);
         Transport.send(message);
         
         System.out.println("Sent message successfully....");
      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
      JOptionPane.showMessageDialog(null,"OTP sent Successfully");
      new Password(otpNo,userName);
    }
   public Otp(String to, long otpNo,String msg){
       
    String from = "srikrishnaelectricity@gmail.com";
      final String username = "srikrishnaelectricity@gmail.com";
      final String password = "srikrishna123";
      String host = "smtp.gmail.com";
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });
      try {
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));
         message.setSubject("OTP from Krishna Electricity Board");
         message.setText(msg+" "+otpNo);
         Transport.send(message);
         
      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
      JOptionPane.showMessageDialog(null,"OTP sent Successfully");
}
   /* public Otp(String to,long otpNo ){
        
      String from = "srikrishnaelectricity@gmail.com";
      final String username = "srikrishnaelectricity@gmail.com";
      final String password = "srikrishna123";
      String host = "smtp.gmail.com";
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });
      try {
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));
         message.setSubject("OTP from Krishna Electricity Board");
         message.setText("Dont share your OTP to others.\n Your OTP is "+otpNo);
         Transport.send(message);
         
         System.out.println("Sent message successfully....");
      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
      JOptionPane.showMessageDialog(null,"OTP sent Successfully");
      new Password(otpNo,userName);
    } 
   */
    public Otp(String from1,String sub, String text){
      String to = "srikrishnaelectricity@gmail.com";

      String from = "systemadkrish@gmail.com";
      final String username = "systemadkrish@gmail.com";
      final String password = "Systemadkrish123@";

      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });
      try {
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));
         message.setSubject(sub);
         message.setText("Email from : "+from1+"\n"+text);
         Transport.send(message);
         
         System.out.println("Sent message successfully....");
      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
      JOptionPane.showMessageDialog(null,"Message sent Successfully");
    }
   public static void main(String[] args) {
       
   }
}
