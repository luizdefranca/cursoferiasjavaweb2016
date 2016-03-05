package br.com.qualiti.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.qualiti.crud.configuracao.Configuracao;
import br.com.qualiti.crud.enums.SexoEnum;
import br.com.qualiti.crud.modelo.Pessoa;

public class PessoaDAOImpl implements PessoaDAO {

	private Connection connection;

	public PessoaDAOImpl() throws ClassNotFoundException, SQLException {
		String url = Configuracao.getString("url"); //$NON-NLS-1$
		String user = Configuracao.getString("user"); //$NON-NLS-1$
		String password = Configuracao.getString("password"); //$NON-NLS-1$
		String driverClassName = Configuracao.getString("driverClassName"); //$NON-NLS-1$

		Class.forName(driverClassName);

		connection = DriverManager.getConnection(url, user, password);
	}

	/* (non-Javadoc)
	 * @see br.com.qualiti.crud.dao.PessoaDAO#insert(br.com.qualiti.crud.modelo.Pessoa)
	 */
	@Override
	public void insert(Pessoa pessoa) throws SQLException {

		String insertSQL = "insert into crud.pessoa(nome, sexo, email, cpf) values(?,?,?,?)";

		PreparedStatement comandoSQL = connection.prepareStatement(insertSQL);

		comandoSQL.setString(1, pessoa.getNome());
		comandoSQL.setString(2, pessoa.getSexo().getChar() + "");
		comandoSQL.setString(3, pessoa.getEmail());
		comandoSQL.setString(4, pessoa.getCpf());

		comandoSQL.executeUpdate();

		comandoSQL.close();

	}

	/* (non-Javadoc)
	 * @see br.com.qualiti.crud.dao.PessoaDAO#update(br.com.qualiti.crud.modelo.Pessoa)
	 */
	@Override
	public void update(Pessoa pessoa) throws SQLException {

		String updateSQL = "update crud.pessoa set nome= ?, sexo = ?, email = ?, cpf = ? where id = ?";

		PreparedStatement comandoSQL = connection.prepareStatement(updateSQL);
		comandoSQL.setString(1, pessoa.getNome());
		comandoSQL.setString(2, pessoa.getSexo().getChar() + "");
		comandoSQL.setString(3, pessoa.getEmail());
		comandoSQL.setString(4, pessoa.getCpf());
		comandoSQL.setLong(5, pessoa.getId());

		comandoSQL.executeUpdate();

		comandoSQL.close();

	}

	/* (non-Javadoc)
	 * @see br.com.qualiti.crud.dao.PessoaDAO#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long pessoaId) throws SQLException {

		String deleteSQL = "delete from crud.pessoa where id = " + pessoaId;

		Statement comandoSQL = connection.createStatement();

		comandoSQL.executeUpdate(deleteSQL);

		comandoSQL.close();

	}

	/* (non-Javadoc)
	 * @see br.com.qualiti.crud.dao.PessoaDAO#get(java.lang.Long)
	 */
	@Override
	public Pessoa get(Long pessoaId) throws SQLException {

		String getSQL = "select * from crud.pessoa where id = " + pessoaId;

		Statement comandoSQL = connection.createStatement();

		ResultSet resultado = comandoSQL.executeQuery(getSQL);

		Pessoa pessoa = new Pessoa();

		if (resultado.next()) {

			pessoa.setNome(resultado.getString("nome"));
			pessoa.setCpf(resultado.getString("cpf"));
			pessoa.setEmail(resultado.getString("email"));
			pessoa.setId(resultado.getLong("id"));

			char sexo = resultado.getString("sexo").charAt(0);

			pessoa.setSexo(SexoEnum.charToEnum(sexo));

		}

		comandoSQL.close();

		return pessoa;

	}

	/* (non-Javadoc)
	 * @see br.com.qualiti.crud.dao.PessoaDAO#getAll()
	 */
	@Override
	public List<Pessoa> getAll() throws SQLException {

		String selectSQL = "select * from crud.pessoa";
		Statement comandoSQL = connection.createStatement();
		ResultSet resultados = comandoSQL.executeQuery(selectSQL);
		List<Pessoa> listaDePessoas = new ArrayList<>();

		while (resultados.next()) {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(resultados.getLong("id"));
			pessoa.setNome(resultados.getString("nome"));
			pessoa.setCpf(resultados.getString("cpf"));
			pessoa.setEmail(resultados.getString("email"));
			char sexo = resultados.getString("sexo").charAt(0);
			pessoa.setSexo(SexoEnum.charToEnum(sexo));
			listaDePessoas.add(pessoa);
		}

		resultados.close();
		comandoSQL.close();

		return listaDePessoas;
	}

	/* (non-Javadoc)
	 * @see br.com.qualiti.crud.dao.PessoaDAO#cpfExiste(java.lang.String)
	 */
	@Override
	public boolean cpfExiste(String cpf) throws SQLException {

		String sql = "select * from crud.pessoa where cpf = " + cpf;
		Statement comandoSQL = connection.createStatement();
		ResultSet resultado = comandoSQL.executeQuery(sql);
		boolean jaExiste = resultado.next();

		resultado.close();
		comandoSQL.close();

		return jaExiste;
	}
	/* (non-Javadoc)
	 * @see br.com.qualiti.crud.dao.PessoaDAO#emailExiste(java.lang.String)
	 */
	@Override
	public boolean emailExiste(String email) throws SQLException {
		
		String sql = "select * from crud.pessoa where email = " + email;
		Statement comandoSQL = connection.createStatement();
		ResultSet resultado = comandoSQL.executeQuery(sql);
		boolean jaExiste = resultado.next();
		
		resultado.close();
		comandoSQL.close();
		
		return jaExiste;
	}

	/* (non-Javadoc)
	 * @see br.com.qualiti.crud.dao.PessoaDAO#find(br.com.qualiti.crud.modelo.Pessoa)
	 */
	@Override
	public List<Pessoa> find(Pessoa pessoa) {
		return null;
	}

}
