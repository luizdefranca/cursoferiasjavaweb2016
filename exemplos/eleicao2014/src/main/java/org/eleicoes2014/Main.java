package org.eleicoes2014;

import org.apache.commons.mail.EmailException;

public class Main {

	/**
	 * @param args
	 * @throws EmailException 
	 */
	public static void main(String[] args) throws EmailException {
		// TODO Auto-generated method stub
		
		EmailAlerta email  = new EmailAlerta();
		
		email.sendEmail();

	}

}
