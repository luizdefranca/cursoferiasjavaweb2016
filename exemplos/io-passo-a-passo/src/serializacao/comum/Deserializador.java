package serializacao.comum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializador {

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Cachorro cachorro = null;

		File file = new File("comum.ser");

		FileInputStream fileInputStream =
				new FileInputStream(file);

		ObjectInputStream objectInputStream =
				new ObjectInputStream(fileInputStream);

		cachorro = (Cachorro) objectInputStream.readObject();

		System.out.println(cachorro.getNome());
		System.out.println(cachorro.getRaca());
		System.out.println(cachorro.getAltura());
		System.out.println(cachorro.getPeso());

		objectInputStream.close();
	}

}
