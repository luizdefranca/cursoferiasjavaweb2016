package br.com.qualiti.crud.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CRUDPessoaServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/exception" })
public class ExceptionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExceptionHandlerServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mensagemExcecao = "";

		Exception exception =
			(Exception)request.getAttribute("exception");

		if(exception instanceof SQLException){
			mensagemExcecao = "Banco de dados";
		}else if(exception instanceof ClassNotFoundException){
			mensagemExcecao = "Driver não existe";
		}else if(exception instanceof RuntimeException){
			mensagemExcecao = "Erro inesperado";
		}

		request.setAttribute("mensagemExcecao",
				mensagemExcecao + "\n" + exception.getMessage());

		request
		.getRequestDispatcher("/erro.jsp")
		.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}