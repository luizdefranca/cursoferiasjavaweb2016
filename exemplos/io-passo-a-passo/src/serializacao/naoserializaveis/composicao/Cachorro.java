package serializacao.naoserializaveis.composicao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Cachorro implements Serializable{

	private String nome;
	private double altura;
	private double peso;
	private transient Raca raca;

	public Cachorro(String nome,
			double altura,
			double peso,
			Raca raca) {
		super();
		this.nome = nome;
		this.altura = altura;
		this.peso = peso;
		this.raca = raca;
		System.out.println("Cachorro nasceu !!!");
	}

	private void writeObject(ObjectOutputStream oo){
		try {
			oo.defaultWriteObject();
			oo.writeUTF(getRaca().getNome());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readObject(ObjectInputStream oi){
		try {
			oi.defaultReadObject();
			String nomeRaca = oi.readUTF();
			this.raca = new Raca(nomeRaca);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public Raca getRaca() {
		return raca;
	}
	public void setRaca(Raca raca) {
		this.raca = raca;
	}
}
