package br.com.qualiti.helloworld;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class QualitiServlet extends HttpServlet {

	public QualitiServlet() {
		super();
	}

	protected void forward(HttpServletRequest request, HttpServletResponse response, String caminhoPagina) throws ServletException, IOException {
		//CRIO UM ENDERECADOR QUE APONTA PARA O PROXIMO DESTINO
		RequestDispatcher requestDispatcher =
			request.getRequestDispatcher(caminhoPagina);
	
		//ENCAMINHA PARA O PROXIMO DESTINO
		requestDispatcher.forward(request, response);
	}

}