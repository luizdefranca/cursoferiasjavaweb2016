package serializacao.comum;

import java.io.File;
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

		/*
		 * SERIALIZAR
		 */

		File file = new File("comum.ser");

		FileOutputStream fileOutputStream =
				new FileOutputStream(file);

		ObjectOutputStream objectOutputStream =
				new ObjectOutputStream(fileOutputStream);

		objectOutputStream.writeObject(cachorro);
		objectOutputStream.close();
	}

}
