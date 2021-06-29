/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dtos.sendEmail;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

    //generate vrification code
    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    //send email to the user email
    public boolean sendEmail(String userMail, String codeVerify) {
        boolean test = false;

        String toEmail = userMail;
        String fromEmail = "ngocphucdo2601@gmail.com";
        String password = "0987215804";

        try {
            Properties pr = new Properties();

            pr.put("mail.smtp.auth", "true");
            pr.put("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.host", "smtp.gmail.com");
            pr.put("mail.smtp.port", "587");

            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            Message mess = new MimeMessage(session);
            mess.setFrom(new InternetAddress(fromEmail));
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mess.setSubject("User Email Verification");
            mess.setText("Registered successfully.Please verify your account using this code: " + codeVerify);
            Transport.send(mess);

            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }
}
