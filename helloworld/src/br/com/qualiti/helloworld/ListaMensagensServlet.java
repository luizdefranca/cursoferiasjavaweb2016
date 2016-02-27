package br.com.qualiti.helloworld;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.qualiti.helloworld.dao.DataAccessObject;
import br.com.qualiti.helloworld.modelo.Mensagem;

/**
 * Servlet implementation class ListaMensagensServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/listar" })
public class ListaMensagensServlet extends QualitiServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaMensagensServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			//INSTANCIAR O DAO
			DataAccessObject dataAccessObject = new DataAccessObject();
			//CHAMAR O MÉTODO DE LISTAR MENSAGENS
			List<Mensagem> listaDeMensagens = dataAccessObject.listarMensagens();

			//COLOCAR A LISTA DE MENSAGENS NO REQUEST(NA MEMÓRIA)
			request.setAttribute("listaDeMensagens", listaDeMensagens);

			//REPASSAR PARA A PÁGINA DE LISTAGEM
			forward(request, response,
					"/listaMensagens.jsp");

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

}
