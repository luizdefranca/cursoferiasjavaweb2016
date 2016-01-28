package br.com.qualiti.agendador.modelo.pessoa;

import java.util.List;

import br.com.qualiti.agendador.modelo.endereco.Endereco;

public class Pessoa {

	private String nome;
	private String cpf;
	private String dataNascimento;

	//TEM-UM (MUITOS-PARA-MUITOS - NAO BIDIRECIONAL)
	private List<Endereco> enderecos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
