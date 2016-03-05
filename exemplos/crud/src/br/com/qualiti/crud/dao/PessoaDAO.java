package br.com.qualiti.crud.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.qualiti.crud.modelo.Pessoa;

public interface PessoaDAO {

	void insert(Pessoa pessoa) throws SQLException;

	void update(Pessoa pessoa) throws SQLException;

	void delete(Long pessoaId) throws SQLException;

	Pessoa get(Long pessoaId) throws SQLException;

	List<Pessoa> getAll() throws SQLException;

	boolean cpfExiste(String cpf) throws SQLException;

	boolean emailExiste(String email) throws SQLException;

	List<Pessoa> find(Pessoa pessoa);

}