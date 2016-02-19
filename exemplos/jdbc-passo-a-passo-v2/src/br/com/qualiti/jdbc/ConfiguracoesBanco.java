package br.com.qualiti.jdbc;

import java.sql.SQLException;
import java.util.Map;

public class ConfiguracoesBanco {

	private Map<String, String> configuracoes;

	public ConfiguracoesBanco() throws SQLException, ClassNotFoundException {

		DataAccessObject dao = new DataAccessObject();
		configuracoes = dao.consultaConfiguracoes();
	}

	public String getString(String key) {
		return configuracoes.get(key);
	}
}
