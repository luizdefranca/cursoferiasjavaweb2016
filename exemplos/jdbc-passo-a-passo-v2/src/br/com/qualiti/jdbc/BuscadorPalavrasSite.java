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
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.qualiti.jdbc.modelo.Envio;
import br.com.qualiti.jdbc.modelo.LinkAchado;

public class BuscadorPalavrasSite {

	private static ConfiguracoesBanco configuracoesBanco;

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

		configuracoesBanco = new ConfiguracoesBanco();

		String textoParaTeste = getConteudoURL(getValorConfig("url.site")); //$NON-NLS-1$

		String expressaoRegular =
				getValorConfig("expressao.regular.url"); //$NON-NLS-1$

		Pattern pattern = Pattern.compile(expressaoRegular);
		Matcher matcher = pattern.matcher(textoParaTeste);

		Pattern patternFiltro = Pattern.compile(getValorConfig("expressao.regular.filtro")); //$NON-NLS-1$
		Matcher matcherFiltro = null;

		String urlCapturada = null;

		/**/List<LinkAchado> linksPositivos = new ArrayList<>();

		while(matcher.find()){

			urlCapturada = matcher.group();

			matcherFiltro = patternFiltro.matcher(urlCapturada);


			if(matcherFiltro.find()){

				System.out.println(urlCapturada);
				/* + */LinkAchado linkAchado =
						new LinkAchado(urlCapturada);

				/**/linksPositivos.add(linkAchado);
			}
		}

		/**/DataAccessObject dao = new DataAccessObject();
		/**/dao.insereUrlsAchadas(linksPositivos);

		//ENVIAR O EMAIL
		enviarEmailNovosLinks(linksPositivos);

		//CRIAR INSTANCIA DE ENVIO
		Envio envio = new Envio();
		envio.setData(LocalDateTime.now());
		//CHAMAR O MÉTODO inserirEnvio do dao passando a
		//instancia de Envio criada anteriormente
		dao.insereEnvio(envio);

	}


	private static void enviarEmailNovosLinks(List<LinkAchado> linksPositivos) {

		StringBuilder textoLinksAchados = new StringBuilder();

		for (LinkAchado linkAchado : linksPositivos) {
			textoLinksAchados.append(linkAchado.getUrl());
			textoLinksAchados.append("\n");
		}

	}


	private static String getValorConfig(String chave){
		//configuracoes.getString(chave)
		return configuracoesBanco.getString(chave);
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
