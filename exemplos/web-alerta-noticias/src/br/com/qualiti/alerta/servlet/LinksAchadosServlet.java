package br.com.qualiti.alerta.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.qualiti.alerta.dao.DataAccessObject;
import br.com.qualiti.alerta.modelo.LinkAchado;

/**
 * Servlet implementation class LinksAchadosServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/linksachados" })
public class LinksAchadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LinksAchadosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			DataAccessObject dao = new DataAccessObject();
			List<LinkAchado> linksAchados = dao.consultaLinksAchados();
			request.setAttribute("linksAchados", linksAchados);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage(), e);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
