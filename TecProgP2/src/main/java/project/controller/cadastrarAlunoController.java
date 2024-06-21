package project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;
import project.dao.AlunoDAO;

import java.io.IOException;


public class cadastrarAlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastrarAlunoController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		String email = request.getParameter("email");
		String senha;
		String nome;
		String mensagem;
		
		if(request.getParameter("email") != null && !request.getParameter("email").isEmpty() 
			&& request.getParameter("senha") != null&& !request.getParameter("email").isEmpty()
			&& request.getParameter("nome") != null&& !request.getParameter("nome").isEmpty())
		{
			email = request.getParameter("email");
			senha = request.getParameter("senha");
			nome = request.getParameter("nome");
			
			Aluno aluno = new Aluno(nome,email,senha);
			aluno.salvar();
//			Enviar mensagem e redirecionar de volta para a página
			mensagem = "Aluno cadastrado!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		else {
			mensagem = "Todos os campos devem ser preenchidos!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarAluno.jsp");
			dispatcher.forward(request, response);
			System.out.println(new AlunoDAO().buscarAlunoPorId(1)); 	
			}
	}

}
