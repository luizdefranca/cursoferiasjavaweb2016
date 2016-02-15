package serializacao.naoserializaveis.heranca.paiserializavel;

import java.io.Serializable;

public class Cachorro extends Animal{

	private String nome;
	private String raca;

	public Cachorro(String nome, double altura, double peso, String raca) {
		super();
		this.nome = nome;
		this.altura = altura;
		this.peso = peso;
		this.raca = raca;
		System.out.println("Cachorro nasceu !!!");
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
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
}
