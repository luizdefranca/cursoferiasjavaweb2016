package arquivos;

import java.io.File;
import java.io.IOException;

public class FileExemplo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		String diretorio = "/Users/miguelangelo/javaioaaassss/filennnn";
//		//CRIAR UM ARQUIVO
		File arquivoCriado =
				new File(diretorio+"/arquivocriado.txt");
		boolean ok = arquivoCriado.createNewFile();
		System.out.println(ok);

		//CRIAR UM DIRET�RIO
		File diretorioCriado =
				new File(diretorio);
		ok = diretorioCriado.mkdirs();
		System.out.println(ok);
//
		//TESTAR SE � ARQUIVO OU DIRET�RIO

		System.out.println(diretorioCriado.isFile());
		System.out.println(diretorioCriado.isDirectory());

		//RENOMEAR / MOVER
		File arquivoRenomeado =
				new File(diretorio+"/arquivorenomeado.txt");
		ok = arquivoCriado.renameTo(arquivoRenomeado);
//		//DELETAR
//		ok = arquivoRenomeado.delete();
//		System.out.println(ok);
//		//SABER O TAMANHO
//		arquivoCriado.createNewFile();
//		System.out.println(arquivoCriado.length());
//		//SABER O PATH
//		System.out.println(arquivoCriado.getPath());
//		//LISTAR OS ARQUIVOS DE UM DIRET�RIO
//		String[] caminhos =
//				diretorioCriado.list();
//
//		for (String caminho : caminhos) {
//			System.out.println(caminho);
//		}


	}

}
