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
		fileWriter.write("Teste");
		fileWriter.write("\n");
		fileWriter.write("Teste2");

		fileWriter.flush();

		fileWriter.close();

	}

}
