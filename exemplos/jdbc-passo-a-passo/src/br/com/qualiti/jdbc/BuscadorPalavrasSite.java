package br.com.qualiti.jdbc;


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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuscadorPalavrasSite {

	public static void main(String[] args) throws IOException {

		String textoParaTeste = getConteudoURL(getValorConfig("url.site")); //$NON-NLS-1$

		String expressaoRegular =
				getValorConfig("expressao.regular.url"); //$NON-NLS-1$

		Pattern pattern = Pattern.compile(expressaoRegular);
		Matcher matcher = pattern.matcher(textoParaTeste);

		Pattern patternFiltro = Pattern.compile(getValorConfig("expressao.regular.filtro")); //$NON-NLS-1$
		Matcher matcherFiltro = null;

		String stringCapturada = null;

		List<String> linksPositivos = new ArrayList<>();

		while(matcher.find()){

			stringCapturada = matcher.group();

			matcherFiltro = patternFiltro.matcher(stringCapturada);

			System.out.println(stringCapturada);

			if(matcherFiltro.find()){
				linksPositivos.add(stringCapturada);
			}
		}

		Path caminhoArquivoLinksPositivos = Paths.get(getValorConfig("arquivo.caminho")); //$NON-NLS-1$
		Files.write(caminhoArquivoLinksPositivos, linksPositivos);
	}


	private static String getValorConfig(String chave){

		return Configuracao.getString(chave);
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
		}

		conteudoUrl = stringBuilder.toString();

		return conteudoUrl;
	}

}
