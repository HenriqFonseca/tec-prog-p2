package project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tarefa;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class excluirTarefaServlet
 */
public class excluirTarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public excluirTarefaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Integer idTarefa, idAluno;
		
		idTarefa = Integer.valueOf(request.getParameter("idTarefa"));
		idAluno = Integer.valueOf(request.getParameter("idAluno"));
		
		new Tarefa().deletarTarefa(idTarefa);
		
		
		ArrayList<Tarefa> tarefas = new Tarefa().buscarTarefaPorId(idAluno);
		
		
		String mensagem = "Aluno cadastrado!";
		request.setAttribute("tarefas", tarefas);
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("idAluno", idAluno);
		RequestDispatcher dispatcher = request.getRequestDispatcher("consultarTarefas.jsp");
		dispatcher.forward(request, response);
		
	}

}
