package serializacao.naoserializaveis.composicao;

import java.io.Serializable;

public class Raca /*implements Serializable*/{

	private String nome;

	public Raca(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
