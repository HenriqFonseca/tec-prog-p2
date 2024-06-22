package project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Tarefa;
import project.dao.AlunoDAO;

import java.io.IOException;

import com.mysql.cj.Session;

/**
 * Servlet implementation class criarTarefaServlet
 */
public class criarTarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public criarTarefaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		String titulo, mensagem;
		String descricao;
		String status;
		Integer idAluno;
		idAluno = Integer.valueOf(request.getParameter("idAluno"));
		System.out.println("Criar tarefa: Id aluno: " + request.getParameter("idAluno"));
		if(request.getParameter("titulo") != null && !request.getParameter("titulo").isEmpty() 
			&& request.getParameter("descricao") != null&& !request.getParameter("descricao").isEmpty()
			&& request.getParameter("status") != null&& !request.getParameter("status").isEmpty()
			&& request.getParameter("idAluno")!= null)
		{
			titulo = request.getParameter("titulo");
			descricao = request.getParameter("descricao");
			status = request.getParameter("status");
			System.out.println("Criar tarefa: Id aluno: " + titulo+descricao+status);
			Tarefa tarefa = new Tarefa(titulo,descricao,status,idAluno);
			tarefa.salvar();
//			Enviar mensagem e redirecionar de volta para a página
			mensagem = "Tarefa criada com sucesso!!";
			request.setAttribute("mensagem", mensagem);
			request.setAttribute("idAluno", idAluno);
			RequestDispatcher dispatcher = request.getRequestDispatcher("perfil.jsp");
			dispatcher.forward(request, response);
		}
		else {
			mensagem = "Todos os campos devem ser preenchidos!";
			request.setAttribute("mensagem", mensagem);
			request.setAttribute("idAluno", idAluno);
			RequestDispatcher dispatcher = request.getRequestDispatcher("perfil.jsp");
			dispatcher.forward(request, response);
			}
	   }

}
