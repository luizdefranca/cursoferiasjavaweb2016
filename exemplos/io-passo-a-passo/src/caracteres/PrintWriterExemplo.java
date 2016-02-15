package caracteres;

import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrintWriterExemplo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		//DESTINO DOS DADOS
		File file = new File("printwriter.txt");
		file.createNewFile();

		//ESCRITOR DOS DADOS
		FileWriter fileWriter = new FileWriter(file);

		//CAMADA DE ABSTRAÇÃO
		//(ADICIONA FUNCIONALIDADES DE ALTO NÍVEL
		PrintWriter printWriter =
				new PrintWriter(fileWriter);

		printWriter.println("teste3");
		printWriter.println("teste4");

		printWriter.close();

	}

}
