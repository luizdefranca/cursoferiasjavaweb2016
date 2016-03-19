package br.com.qualiti.crud.controlador;

import java.util.List;

import br.com.qualiti.crud.dao.GenericDAO;
import br.com.qualiti.crud.modelo.Pessoa;

public class ControladorPessoa {

	private GenericDAO<Pessoa, Long> dao;

	public ControladorPessoa() {
		dao = 
			new GenericDAO<>("crudJPA", Pessoa.class);
	}

	public void insert(Pessoa pessoa) throws Exception{
		dao.save(pessoa);
	}

	public void update(Pessoa pessoa) throws Exception{
		dao.save(pessoa);
	}

	public void delete(Long pessoaId) throws Exception{
		dao.deleteById(pessoaId);
	}

	public Pessoa get(Long pessoaId) throws Exception{
		return dao.find(pessoaId);
	}

	public List<Pessoa> getAll() throws Exception{
		return dao.findAll("Pessoa.findAll");
	}
}
