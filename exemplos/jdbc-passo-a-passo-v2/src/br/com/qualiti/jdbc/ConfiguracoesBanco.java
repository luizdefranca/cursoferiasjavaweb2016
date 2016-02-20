package br.com.qualiti.jdbc;

import java.sql.SQLException;
import java.util.List;

import br.com.qualiti.jdbc.modelo.ConfiguracaoPropriedade;

public class ConfiguracoesBanco {

	private List<ConfiguracaoPropriedade> configuracoesPropriedades;

	public ConfiguracoesBanco() throws SQLException, ClassNotFoundException {

		DataAccessObject dao = new DataAccessObject();
		configuracoesPropriedades = dao.consultaConfiguracoes();
	}

	public String getString(String chave) {

		ConfiguracaoPropriedade propriedadeBuscada = new ConfiguracaoPropriedade();
		propriedadeBuscada.setChave(chave);

		int indice = configuracoesPropriedades.indexOf(propriedadeBuscada);

		ConfiguracaoPropriedade propriedadeAchada =
				configuracoesPropriedades.get(indice);

		return propriedadeAchada.getValor();
	}
}
