package br.com.qualiti.crud.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.qualiti.crud.modelo.Pessoa;

public class PessoaDAOJPA implements PessoaDAO {

	@Override
	public void insert(Pessoa pessoa) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Pessoa pessoa) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long pessoaId) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Pessoa get(Long pessoaId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cpfExiste(String cpf) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean emailExiste(String email) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pessoa> find(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return null;
	}

}
