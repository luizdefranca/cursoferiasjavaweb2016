package br.com.qualiti.jdbc;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Configuracao {
	private static final String BUNDLE_NAME = "br.com.qualiti.jdbc.config"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Configuracao() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
