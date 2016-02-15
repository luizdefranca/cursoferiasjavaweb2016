package serializacao.naoserializaveis.heranca.paiserializavel;

import java.io.Serializable;

public class Animal implements Serializable{

	protected double altura;
	protected double peso;

	public Animal() {
		super();
		System.out.println("Animal");
	}

}