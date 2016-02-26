package br.com.qualiti.helloworld.configuracao;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ConfiguracaoArquivo {
	private static final String BUNDLE_NAME = "br.com.qualiti.jdbc.config"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private ConfiguracaoArquivo() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
