package br.com.qualiti.exemplo.er;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ERExemploURL {

	public static void main(String[] args) throws IOException {

		String textoParaTeste = getConteudoURL("http://www.folha.com");

		writeToFile("/Users/miguelangelo/conteudo.html", textoParaTeste);
		String expressaoRegular =
				"(http)(s)?(://)([\\w\\-]+\\.?\\/?)+((\\?|&)[\\w;]*=?[\\w;]*)*";

			Pattern pattern = Pattern.compile(expressaoRegular);

		//=========================================
		Path pathLinksFolha = Paths.get("/Users/miguelangelo/conteudo.html");

		Files.readAllLines(pathLinksFolha)
			.stream()
			.filter(s -> pattern.matcher(s).find())
			.map (s -> {

				Matcher matcher = pattern.matcher(s);
				matcher.find();
				return matcher.group();
			})
			.filter(s -> s.toLowerCase().contains("lula"))
			//.map(s -> s.toUpperCase())
			.forEach(System.out::println);
		//====================================================

		/*
		String expressaoRegular =
			"(http)(s)?(://)([\\w\\-]+\\.?\\/?)+((\\?|&)[\\w;]*=?[\\w;]*)*";

		Pattern pattern = Pattern.compile(expressaoRegular);
		Matcher matcher = pattern.matcher(textoParaTeste);

		String stringCapturada = null;
		while(matcher.find()){
			stringCapturada = matcher.group();
			System.out.println(stringCapturada);
		}
		*/
	}

	private static void writeToFile(String caminhoArquivo, String conteudo) throws IOException{

		Path path = Paths.get(caminhoArquivo);
		Files.write(path, conteudo.getBytes());
	}

	private static String getConteudoURL(String enderecoSite)
			throws IOException{

		String conteudoUrl = null;

		//Criar url
		URL url = new URL(enderecoSite);

		//Abrir conexão com o site
		URLConnection urlConnection = url.openConnection();

		//Consumir o conteúdo html

		//->Pegar os bytes do site
		InputStream inputStream = urlConnection.getInputStream();

		InputStreamReader inputStreamReader =
			new InputStreamReader(inputStream);

		int buffer = 1024 * 1024 * 1;

		BufferedReader bufferedReader =
			new BufferedReader(inputStreamReader, buffer);

		StringBuilder stringBuilder = new StringBuilder();

		while(bufferedReader.ready()){
			stringBuilder.append(bufferedReader.readLine());
			//COLOQUEM A LINHA ABAIXO - MÉTODO getConteudoURL
			stringBuilder.append("\n");
			//================================
		}

		conteudoUrl = stringBuilder.toString();

		return conteudoUrl;
	}

}
