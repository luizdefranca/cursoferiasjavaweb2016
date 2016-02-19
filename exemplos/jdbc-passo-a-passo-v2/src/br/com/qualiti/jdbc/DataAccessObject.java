package br.com.qualiti.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DataAccessObject {

	private Connection connection;

	public DataAccessObject() throws SQLException, ClassNotFoundException {

		String driverClassName = Configuracao.getString("jdbc.default.driverClassName");
		String url = Configuracao.getString("jdbc.default.url");
		String user = Configuracao.getString("jdbc.default.username");
		String password = Configuracao.getString("jdbc.default.password");

		//ESTA LINHA É SÓ PARA MIGUEL ANGELO - VC NAO PRECISA USAR!
		password = null;

		Class.forName(driverClassName);//opcional

		connection = DriverManager.getConnection(url, user, password);
	}

	public Map<String, String> consultaConfiguracoes() throws SQLException{

		Map<String, String> configuracoes = new HashMap<>();

		String sql = "SELECT chave, valor "
				+ "FROM buscadorpalavras.configuracao";

		//STATEMENT - COMANDO SQL

		Statement comandoSQL = connection.createStatement();

		//EXECUÇÃO DA CONSULTA
		ResultSet resultados = comandoSQL.executeQuery(sql);

		//PERCORRENDO OS RESULTADOS DA CONSULTA
		//E USANDO-OS PARA PREENCHER O MAP

		while(resultados.next()){
			String chave = resultados.getString("chave");
			String valor = resultados.getString("valor");

			configuracoes.put(chave, valor);
		}

		resultados.close();
		comandoSQL.close();

		return configuracoes;

	}
}
