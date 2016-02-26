package br.com.qualiti.helloworld.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.qualiti.helloworld.configuracao.ConfiguracaoArquivo;
import br.com.qualiti.helloworld.modelo.Mensagem;

public class DataAccessObject {

	private Connection connection;

	public DataAccessObject() throws SQLException, ClassNotFoundException {

		String driverClassName = ConfiguracaoArquivo.getString("jdbc.default.driverClassName");
		String url = ConfiguracaoArquivo.getString("jdbc.default.url");
		String user = ConfiguracaoArquivo.getString("jdbc.default.username");
		String password = ConfiguracaoArquivo.getString("jdbc.default.password");

		Class.forName(driverClassName);//opcional

		connection = DriverManager.getConnection(url, user, password);
	}

	public void inserirMensagem(Mensagem mensagem){

		//CHAMAR O BANCO DE DADOS PARA INSERIR
	}
}
