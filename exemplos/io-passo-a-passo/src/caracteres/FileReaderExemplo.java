package caracteres;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExemplo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		//FONTE DOS DADOS
		File file = new File("filewriter.txt");

		//LEITOR DOS DADOS
		FileReader fileReader = new FileReader(file);

		//LEITURA
		int lido = -1;

		StringBuilder conteudo = new StringBuilder();

		lido = fileReader.read();
		while(lido != -1){
			conteudo.append((char)lido);
			lido = fileReader.read();
		}

		System.out.println(conteudo);

		fileReader.close();
	}

}
