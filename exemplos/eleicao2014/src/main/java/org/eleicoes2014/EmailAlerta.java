package org.eleicoes2014;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailAlerta {

	
	public void sendEmail() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(
				new DefaultAuthenticator(
						"miguel.angelo@liferay.com", "m@j25m13K"));
		email.setSSLOnConnect(true);
		email.setFrom("gallindo@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("gallindo@gmail.com");
		email.send();
	}
}
