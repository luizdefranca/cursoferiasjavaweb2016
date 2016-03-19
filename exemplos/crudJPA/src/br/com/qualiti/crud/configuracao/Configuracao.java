package br.com.qualiti.crud.configuracao;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Configuracao {
	private static final String BUNDLE_NAME = "br.com.qualiti.crud.configuracao.config"; //$NON-NLS-1$

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
