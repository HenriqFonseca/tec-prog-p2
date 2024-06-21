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
 * Servlet implementation class consultarTarefas
 */
public class consultarTarefasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consultarTarefasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("id");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		 
		Integer idAluno;
		
		idAluno = Integer.valueOf(request.getParameter("idAluno"));
		
		
		ArrayList<Tarefa> tarefas = new Tarefa().buscarTarefaPorId(idAluno);
		
		
		request.setAttribute("tarefas", tarefas);
		request.setAttribute("idAluno", idAluno);
		RequestDispatcher dispatcher = request.getRequestDispatcher("consultarTarefas.jsp");
		dispatcher.forward(request, response);
	}

}
