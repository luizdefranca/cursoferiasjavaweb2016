package br.com.qualiti.colecoes.list.arraylist.ordenacao;

import java.time.LocalDate;

public class Pessoa implements Comparable<Pessoa>, Cloneable {

	private String nome;
	private LocalDate dataNascimento;



	public Pessoa(String nome, LocalDate dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	@Override
	public int compareTo(Pessoa outra) {

		System.out.println(
				"Pessoa.compareTo() "+ toString() + " -> "+ outra.toString());

		int resultado = nome.compareTo(outra.nome);

		if(resultado == 0){
			resultado = dataNascimento.compareTo(outra.dataNascimento);
		}

		return resultado;
	}

	@Override
	public String toString() {
		return getNome() + "/"+getDataNascimento();
	}



	@Override
	public boolean equals(Object obj) {

		if((obj instanceof Pessoa) == false){
			return false;
		}

		Pessoa outra = (Pessoa)obj;

		boolean nomeIgual = nome.equals(outra.nome);
		boolean dataNascimentoIgual = dataNascimento.equals(outra.dataNascimento);

		return nomeIgual && dataNascimentoIgual;

//		return nome.equals(outra.nome) &&
//			dataNascimento.equals(outra.dataNascimento);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Pessoa(nome, dataNascimento);
	}
}
