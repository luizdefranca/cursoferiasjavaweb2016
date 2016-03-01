package br.com.qualiti.helloworld.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public void inserirMensagem(Mensagem mensagem) throws SQLException{

		//CHAMAR O BANCO DE DADOS PARA INSERIR
		String sqlInsert = "insert into mensagens.mensagem(texto) values(?)";
		PreparedStatement comando = connection.prepareStatement(sqlInsert);

		comando.setString(1, mensagem.getTexto());
		comando.executeUpdate();
		comando.close();
	}

	public List<Mensagem> listarMensagens() throws SQLException{

		//SQL
		String sqlSelect = "select id, texto from mensagens.mensagem";

		//CLASSE QUE EXECUTA O SQL
		PreparedStatement consulta =
			connection.prepareStatement(sqlSelect);

		//EXECUÇÃO E RETORNO DOS RESULTADOS DO SQL
		ResultSet resultado = consulta.executeQuery();

		//CRIAR UMA LISTA DE MENSAGENS PARA CONTER OS RESULTADOS
		List<Mensagem> listaDeMensagens = new ArrayList<>();

		//PERCORRER O RESULTSET E ADICIONAR NOVAS MENSAGENS
		//NA LISTA
		while(resultado.next()){
			//instanciando uma nova mensagem
			Mensagem registroMensagem = new Mensagem();
			//transferindo os dados do registro atual do banco
			//para o objeto registroMensagem
			registroMensagem.setId(resultado.getLong("id"));
			registroMensagem.setTexto(resultado.getString("texto"));
			//adicionando a nova mensagem instanciada à lista
			listaDeMensagens.add(registroMensagem);
		}

		//LIBERANDO OS RECURSOS DO BANCO
		resultado.close();
		consulta.close();

		return listaDeMensagens;
	}
}
