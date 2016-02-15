package serializacao.estaticos;

import java.io.Serializable;

public class Cachorro implements Serializable{

	private String nome;
	private double altura;
	private double peso;
	public static String raca = "Fox Paulistinha";

	public Cachorro(String nome, double altura, double peso, String racaNova) {
		super();
		this.nome = nome;
		this.altura = altura;
		this.peso = peso;
		raca = racaNova;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
}
