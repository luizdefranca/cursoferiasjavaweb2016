package serializacao.estaticos;

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

		Cachorro cachorro = new Cachorro("Rex",
				70, 7, "vira lata");

		System.out.println(cachorro.raca);

		/*
		 * SERIALIZAR
		 */

		FileOutputStream fileOutputStream =
				new FileOutputStream("estaticos.ser");

		ObjectOutputStream objectOutputStream =
				new ObjectOutputStream(fileOutputStream);

		objectOutputStream.writeObject(cachorro);
		objectOutputStream.close();

	}

}
