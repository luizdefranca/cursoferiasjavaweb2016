package br.com.qualiti.crud.controlador;

import java.util.List;

import br.com.qualiti.crud.configuracao.Configuracao;
import br.com.qualiti.crud.dao.PessoaDAO;
import br.com.qualiti.crud.modelo.Pessoa;

public class ControladorPessoa {

	private PessoaDAO dao;

	public ControladorPessoa() {
		try {

			String classeDAO = Configuracao.getString("classe.dao");


			/*
"br.com.qualiti.crud.dao.PessoaDAOImpl"	Class<PessoaDAOImpl>
			 */

			Class<?> definicaoClasseDAO = Class.forName(classeDAO);
			dao = (PessoaDAO)definicaoClasseDAO.newInstance();

		} catch (IllegalAccessException |InstantiationException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void insert(Pessoa pessoa) throws Exception{
		dao.insert(pessoa);
	}

	public void update(Pessoa pessoa) throws Exception{
		dao.update(pessoa);
	}

	public void delete(Long pessoaId) throws Exception{
		dao.delete(pessoaId);
	}

	public Pessoa get(Long pessoaId) throws Exception{
		return dao.get(pessoaId);
	}

	public List<Pessoa> getAll() throws Exception{
		return dao.getAll();
	}
}
