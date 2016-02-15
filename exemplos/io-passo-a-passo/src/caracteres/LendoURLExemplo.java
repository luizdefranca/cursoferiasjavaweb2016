package caracteres;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LendoURLExemplo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		URL url = new URL("http://www1.folha.uol.com.br/ciencia/1259793-concurso-para-reconstruir-base-na-antartida-tem-74-projetos-na-disputa.shtml");

		InputStream inputStream = url.openStream();

		InputStreamReader inputStreamReader =
				new InputStreamReader(inputStream);
		//<div id="articleNew">
		//<div id="articleEnd">
		//CAMADA DE ABSTRA��O
		//(ADICIONA FUNCIONALIDADES DE ALTO N�VEL

		int bufferBytes = 100 * 1024;
		BufferedReader bufferedReader =	new BufferedReader(inputStreamReader,bufferBytes);

		//LEITURA
		StringBuilder conteudo = new StringBuilder();

		String lido = null;

		while(bufferedReader.ready()){
			lido = bufferedReader.readLine();
			conteudo.append(lido);
			conteudo.append("\n");
		}


		/*
		 * Recuperar o texto do artigo que fica entre as tags <div id="articleNew"> <div id="articleEnd">
		 */

		int indiceInicial = conteudo.indexOf("<div id=\"articleNew\">") + "<div id=\"articleNew\">".length();
		int indiceFinal = conteudo.indexOf("<div id=\"articleEnd\">");
		String textoCapturado = conteudo.substring(indiceInicial, indiceFinal);


		System.out.println(textoCapturado);

		StringBuilder monetarios = new StringBuilder();

		int indiceMonetario = -1;
		int indiceMonetarioFinal = -1;

		while((indiceMonetario = textoCapturado.indexOf("R$")) > -1){
//
//			if(textoCapturado.indexOf("mil")){
//
//			}

		}


		/*
		 * Recuperar todos os n�meros monet�rios citados no texto
		 */




		bufferedReader.close();
	}

}
