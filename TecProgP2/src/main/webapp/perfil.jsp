<%@page import="jakarta.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Integer id = (Integer) request.getAttribute("id");
		System.out.println(request.getAttribute("idAluno"));
	if(request.getAttribute("idAluno") != null){
		id = (Integer) request.getAttribute("idAluno");
		session.setAttribute("id", id);
		
	}
	else if(request.getAttribute("id")!= null && request.getAttribute("nome") !=null)
	{
		
		id = (Integer) request.getAttribute("id");
		String nome = (String) request.getAttribute("nome");
		session.setAttribute("id", id);
		session.setAttribute("nome", id);
		 
		 
	}

	else{
		String mensagem = "Faça login para acessar!";
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("alunoId", session.getAttribute("id"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response); 
		
	}


	
	

	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfil</title>
</head>
<body>

<a href="logout.jsp">Sair</a><br>
<form action="consultarTarefas" method="post">
	<input type="hidden" name="idAluno" value="<%out.print(id);%>">
	<input type="submit" value="Consultar Tarefas">
</form>
<a href="consultarTarefas.jsp">Consultar minhas tarefas</a>


	<h1>Você está logado! <% out.print(id);%></h1>
	
	<br><br>
	
	<form action="criarTarefa" method="post">
		<label>Nome da tarefa:</label>
		<input type="text" name="titulo"><br><br>
		<label>descrição:</label>
		<input type="text" name="descricao"><br><br>
		<label>materia:</label>
		<input type="text" name="status"><br><br>
		
		<input type="hidden" name="idAluno"value="<%out.print(id);%>">
		
		<input type="submit" value="Criar tarefa">
		
	</form>
	
	<br>
	<%
		String mensagem = (String) request.getAttribute("mensagem");
		Integer alunoId = (Integer) request.getAttribute("idAluno");
		if(mensagem!= null){
			out.print(mensagem);
			out.print(alunoId);
		}	 
	%>
</body>
</html>