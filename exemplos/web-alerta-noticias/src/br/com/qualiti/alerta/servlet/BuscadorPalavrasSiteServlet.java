package br.com.qualiti.alerta.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.qualiti.alerta.configuracao.ConfiguracoesBanco;
import br.com.qualiti.alerta.dao.DataAccessObject;
import br.com.qualiti.alerta.email.SendEmail;
import br.com.qualiti.alerta.modelo.Envio;
import br.com.qualiti.alerta.modelo.LinkAchado;

/**
 * Servlet implementation class BuscadorPalavrasSiteServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/buscador" })
public class BuscadorPalavrasSiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConfiguracoesBanco configuracoesBanco;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscadorPalavrasSiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			buscarLinksNoticias();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


	public void buscarLinksNoticias() throws IOException, ClassNotFoundException, SQLException {

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


	private void enviarEmailNovosLinks(List<LinkAchado> linksPositivos) {

		StringBuilder textoLinksAchados = new StringBuilder();

		for (LinkAchado linkAchado : linksPositivos) {
			textoLinksAchados.append(linkAchado.getUrl());
			textoLinksAchados.append("\n");
		}

		SendEmail.send(textoLinksAchados.toString());

	}


	private String getValorConfig(String chave){
		return configuracoesBanco.getString(chave);
	}

	private String getConteudoURL(String enderecoSite)
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
