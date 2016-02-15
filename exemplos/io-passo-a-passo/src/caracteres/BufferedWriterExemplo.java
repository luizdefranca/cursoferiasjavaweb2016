package caracteres;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExemplo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		//DESTINO DOS DADOS
		File file = new File("bufferedwriter.txt");
		file.createNewFile();

		//ESCRITOR DOS DADOS
		FileWriter fileWriter = new FileWriter(file);

		//CAMADA DE ABSTRA��O
		//(ADICIONA FUNCIONALIDADES DE ALTO N�VEL
		int bufferBytes = 100 * 1024;
		BufferedWriter bufferedWriter =
				new BufferedWriter(fileWriter,bufferBytes);

		bufferedWriter.write("\nteste3");
		bufferedWriter.write("\n");
		bufferedWriter.write("teste4");

		bufferedWriter.close();
	}

}
