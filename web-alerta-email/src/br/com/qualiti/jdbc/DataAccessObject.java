package br.com.qualiti.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.qualiti.jdbc.modelo.ConfiguracaoPropriedade;
import br.com.qualiti.jdbc.modelo.Envio;
import br.com.qualiti.jdbc.modelo.LinkAchado;

public class DataAccessObject {

	private Connection connection;

	public DataAccessObject() throws SQLException, ClassNotFoundException {

		String driverClassName = ConfiguracaoArquivo.getString("jdbc.default.driverClassName");
		String url = ConfiguracaoArquivo.getString("jdbc.default.url");
		String user = ConfiguracaoArquivo.getString("jdbc.default.username");
		String password = ConfiguracaoArquivo.getString("jdbc.default.password");

		//ESTA LINHA É SÓ PARA MIGUEL ANGELO - VC NAO PRECISA USAR!
		password = null;

		Class.forName(driverClassName);//opcional

		connection = DriverManager.getConnection(url, user, password);
	}

	public void insereUrlsAchadas(List<LinkAchado> linksAchados) throws SQLException{

		connection.setAutoCommit(false);

		String sql = "insert into "
				+ "buscadorpalavras.links_achados(url,data) "
				+ "values (?,?)";

		//STATEMENT - COMANDO SQL

		PreparedStatement comandoSQL = connection.prepareStatement(sql);

		for (LinkAchado linkAchado : linksAchados) {
			comandoSQL.setString(1, linkAchado.getUrl());

			comandoSQL.setTimestamp(
					2, Timestamp.valueOf(linkAchado.getData()));

			comandoSQL.executeUpdate();
		}

		connection.commit();
	}


	public void insereEnvio(Envio envio) throws SQLException{

		connection.setAutoCommit(false);

		String sql = "insert into "
				+ "buscadorpalavras.envios(data) "
				+ "values (?)";

		PreparedStatement comandoSQL = connection.prepareStatement(sql);

		comandoSQL.setTimestamp(
				1, Timestamp.valueOf(envio.getData()));

		comandoSQL.executeUpdate();

		connection.commit();
	}


	public List<ConfiguracaoPropriedade> consultaConfiguracoes() throws SQLException{

		List<ConfiguracaoPropriedade> configuracoesPropriedade = new ArrayList<>();

		String sql = "SELECT id, chave, valor "
				+ "FROM buscadorpalavras.configuracao";

		//STATEMENT - COMANDO SQL

		Statement comandoSQL = connection.createStatement();

		//EXECUÇÃO DA CONSULTA
		ResultSet resultados = comandoSQL.executeQuery(sql);

		//PERCORRENDO OS RESULTADOS DA CONSULTA
		//E USANDO-OS PARA PREENCHER O MAP

		while(resultados.next()){
			Long id = resultados.getLong("id");
			String chave = resultados.getString("chave");
			String valor = resultados.getString("valor");

			ConfiguracaoPropriedade propriedade = new ConfiguracaoPropriedade();
			propriedade.setId(id);
			propriedade.setChave(chave);
			propriedade.setValor(valor);

			configuracoesPropriedade.add(propriedade);
		}

		resultados.close();
		comandoSQL.close();

		return configuracoesPropriedade;

	}
}
