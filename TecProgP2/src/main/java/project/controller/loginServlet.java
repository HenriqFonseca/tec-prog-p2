package project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;

import java.io.IOException;

import com.mysql.cj.Session;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		String email = request.getParameter("email");
		String senha;
		String mensagem;
		
		if(request.getParameter("email") != null && !request.getParameter("email").isEmpty() 
			&& request.getParameter("senha") != null&& !request.getParameter("email").isEmpty())
		{
			email = request.getParameter("email");
			senha = request.getParameter("senha");
			
			
//			Enviar mensagem e redirecionar de volta para a página
			mensagem = "Login feito com sucesso!!!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarAluno.jsp");
			dispatcher.forward(request, response);
		}
		else {
			mensagem = "Todos os campos devem ser preenchidos!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarAluno.jsp");
			dispatcher.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String email, senha,mensagem; 
		Aluno aluno,aluno2;
		
		if(request.getParameter("email") != null && !request.getParameter("email").isEmpty() 
				&& request.getParameter("senha") != null&& !request.getParameter("senha").isEmpty())
			{

			email = request.getParameter("email");
			senha = request.getParameter("senha");

			
			aluno = new Aluno();
			aluno.setEmail(email);
			if(aluno.Login(email, senha)== true) {
				aluno = aluno.buscarAlunoPorEmail(email);
				if (aluno == null) {
					mensagem = "Email ou senha incorretos!!";
					request.setAttribute("mensagem", mensagem);
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
				}
				
				int id = aluno.getIdAluno();
				request.setAttribute("id", id);
				request.setAttribute("nome", aluno.getNome());
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("perfil.jsp");
				dispatcher.forward(request, response);
				
			}else {
				mensagem = "Erro ao realizar login";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
			
			}
			else {
				mensagem = "Todos os campos devem ser preenchidos!";
				request.setAttribute("mensagem", mensagem);
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
				
			}
	}

}
