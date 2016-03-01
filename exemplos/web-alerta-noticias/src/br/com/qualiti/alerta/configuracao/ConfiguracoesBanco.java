package br.com.qualiti.alerta.configuracao;

import java.sql.SQLException;
import java.util.List;

import br.com.qualiti.alerta.dao.DataAccessObject;
import br.com.qualiti.alerta.modelo.ConfiguracaoPropriedade;

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
