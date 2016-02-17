package caracteres;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExemplo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		//DESTINO DOS DADOS
		File file = new File("filewriter.txt");
		file.createNewFile();

		//ESCRITOR DOS DADOS
		FileWriter fileWriter = new FileWriter(file);

		//ESCRITA
		fileWriter.write("miguel");
		fileWriter.write("\n");
		fileWriter.write("angelo");

		fileWriter.flush();

		fileWriter.close();

	}

}
