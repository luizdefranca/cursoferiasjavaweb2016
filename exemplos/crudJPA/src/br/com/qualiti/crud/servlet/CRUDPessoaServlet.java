package br.com.qualiti.crud.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.qualiti.crud.controlador.ControladorPessoa;
import br.com.qualiti.crud.enums.SexoEnum;
import br.com.qualiti.crud.modelo.Pessoa;
import br.com.qualiti.crud.modelo.ValidadorPessoa;

/**
 * Servlet implementation class CRUDPessoaServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/pessoas" })
public class CRUDPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ControladorPessoa controlador;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDPessoaServlet() {
    	controlador = new ControladorPessoa();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String metodo =
				request.getParameter("metodo");

			switch (metodo) {
			case "inserir":
				inserir(request, response);
				break;
			case "editar":
				editar(request, response);
				break;
			case "excluir":
				excluir(request, response);
				break;
			case "detalhar":
				detalhar(request, response);
				break;
			case "listar":
				listar(request, response);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("exception", e);
			forward(request, response, "/exception");
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Pessoa> listaDePessoas = controlador.getAll();
		request.setAttribute("listaDePessoas", listaDePessoas);
		forward(request, response, "/listaPessoas.jsp");
	}

	private void detalhar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("idPessoa");
		Long pessoaId = Long.parseLong(id);

		Pessoa pessoa = controlador.get(pessoaId);
		request.setAttribute("pessoa", pessoa);

		forward(request, response, "/index.jsp");
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("idPessoa");
		Long pessoaId = Long.parseLong(id);

		controlador.delete(pessoaId);
		request.setAttribute("mensagem", "Pessoa removida com sucesso.");

		forward(request, response, "/listaPessoas.jsp");

	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String sexo = request.getParameter("sexo");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");

		Pessoa pessoa = new Pessoa();


		boolean dadosValidos = isDadosValidos(request, response);

		if(dadosValidos){
			pessoa.setCpf(cpf);
			pessoa.setEmail(email);
			pessoa.setNome(nome);
			pessoa.setSexo(sexo);
			controlador.update(pessoa);
			request.setAttribute("mensagem", "Pessoa:<br>Nome: " + nome + "<br>CPF: " + cpf + "<br>");
		}

		forward(request, response, "/index.jsp");
	}

	private void inserir(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nome = request.getParameter("nome");
		String sexo = request.getParameter("sexo");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");

		Pessoa pessoa = new Pessoa();


		boolean dadosValidos = isDadosValidos(request, response);

		if(dadosValidos){
			pessoa.setCpf(cpf);
			pessoa.setEmail(email);
			pessoa.setNome(nome);
			pessoa.setSexo(sexo);
			controlador.insert(pessoa);
			request.setAttribute("mensagem", "Pessoa:<br>Nome: " + nome + "<br>CPF: " + cpf + "<br>");
		}

		forward(request, response, "/index.jsp");
	}

	protected void forward(HttpServletRequest request,
						   HttpServletResponse response,
						   String caminhoPagina) throws ServletException, IOException{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(caminhoPagina);
		requestDispatcher.forward(request, response);
	}

	private boolean isDadosValidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String sexo = request.getParameter("sexo");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");

		boolean valido = true;
		StringBuilder mensagensErro = new StringBuilder();

		if (ValidadorPessoa.isStringInvalida(nome)) {
			mensagensErro.append("\nNome inv�lido.Não pode ser vazio.");
		}

		if (!ValidadorPessoa.sexoValido(sexo)) {
			mensagensErro.append("\nSexo inv�lido.<br>Deve ser m, f ou t." + "<br>Tente novamente.");
		}

		if (!ValidadorPessoa.emailValido(email)) {
			mensagensErro.append("\nE-mail inv�lido, tente novamente.");
		}

		if (!ValidadorPessoa.cpfValido(cpf)) {
			mensagensErro.append("\nCpf inv�lido, tente novamente.");
		}

		if(!valido){
			request.setAttribute("mensagem", mensagensErro.toString());
		}

		return valido;
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
