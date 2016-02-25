package br.com.qualiti.helloworld;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/hello" })
public class HelloWorldServlet extends HttpServlet {
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
		String mensagem  = request.getParameter("mensagem");

		//DIPONIBILIZA UMA VARIÁVEL NA MEMÓRIA PARA O PROXIMA PÁGINA
		request.setAttribute("mensagemParaExibicao", mensagem);

		//CRIO UM ENDERECADOR QUE APONTA PARA O PROXIMO DESTINO
		RequestDispatcher requestDispatcher =
			request.getRequestDispatcher("/mensagem.jsp");

		//ENCAMINHA PARA O PROXIMO DESTINO
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
