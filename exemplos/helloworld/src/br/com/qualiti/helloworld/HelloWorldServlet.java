package br.com.qualiti.helloworld;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.qualiti.helloworld.dao.DataAccessObject;
import br.com.qualiti.helloworld.modelo.Mensagem;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/hello" })
public class HelloWorldServlet extends QualitiServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//RECUPERA PARAMETRO DA URL
		String texto  = request.getParameter("mensagem");

		//DIPONIBILIZA UMA VARIÁVEL NA MEMÓRIA PARA O PROXIMA PÁGINA
		request.setAttribute("mensagemParaExibicao", texto);

		//CRIAR UM OBJETO MENSAGEM(ID, TEXTO)
		Mensagem mensagem = new Mensagem();

		//SETAR A VARIÁVEL texto NO OBJETO mensagem.setTexto(texto)
		mensagem.setTexto(texto);

		//CHAMAR O DATA ACCESS OBJECT
		//para salvar o objeto mensagem
		//no banco

		try {
			DataAccessObject dataAccessObject = new DataAccessObject();
			dataAccessObject.inserirMensagem(mensagem);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}


		//Redirecionar para a próxima página
		String caminhoPagina = "/mensagem.jsp";

		forward(request, response, caminhoPagina);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
