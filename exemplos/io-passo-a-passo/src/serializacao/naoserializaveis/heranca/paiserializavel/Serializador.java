package serializacao.naoserializaveis.heranca.paiserializavel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializador {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Animal cachorro = new Cachorro("Rex",
				70, 7, "vira lata");

		/*
		 * SERIALIZAR
		 */

		FileOutputStream fileOutputStream =
				new FileOutputStream("paiserializavel.ser");

		ObjectOutputStream objectOutputStream =
				new ObjectOutputStream(fileOutputStream);

		objectOutputStream.writeObject(cachorro);
		objectOutputStream.close();

	}

}
