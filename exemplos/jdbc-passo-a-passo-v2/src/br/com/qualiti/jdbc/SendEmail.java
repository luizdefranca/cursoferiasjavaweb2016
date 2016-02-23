package br.com.qualiti.jdbc;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	public static void main(String[] args) {

		final String username = "27859746@liferay.com";

		final String password = "m@4j25m13k";

		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.host", "smtp.gmail.com");

		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,

				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {

						return new PasswordAuthentication(username, password);

					}

				});

		try {

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress("miguel.angelo@liferay.com"));

			message.setRecipients(Message.RecipientType.TO,

					InternetAddress.parse("miguel.angelo@liferay.com"));

			message.setSubject("Test JCG Example");

			message.setText("Hi," +

			"This is a Test mail for JCG Example!");

			Transport.send(message);

			System.out.println("Mail sent succesfully!");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}
}