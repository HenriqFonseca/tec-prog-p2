<%@page import="jakarta.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Integer id = (Integer) request.getAttribute("id");
		
	System.out.println("Printando id normal: "+request.getAttribute("id"));
	if(request.getAttribute("idAluno") != null){
		id = (Integer) request.getAttribute("idAluno");
		session.setAttribute("id", id);
		
	}
	else if(request.getAttribute("id")!= null)
	{
		System.out.println("Printando id no elseif: "+request.getAttribute("id"));
		id = (Integer) request.getAttribute("id");
		session.setAttribute("id", id);	 
		 
	}

	else{
		String mensagem = "Faça login para acessar!";
		request.setAttribute("mensagem", mensagem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response); 
		
	}


%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Perfil</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<header>
	        <span id='logo'>TaskManager</span>
	        <nav class='menu'>
	           
	            <form action="consultarTarefas" method="post">
					<input type="hidden" name="idAluno" value="<%out.print(id);%>">
					<input class="nav-link" type="submit" value="Consultar Tarefas">
				</form>
	            <a href='logout.jsp' class='nav-link'>Deslogar</a>
	        </nav>
	</header>
	<div class='container welcome-text'>
		<h1>Bem vindo!</h1>
		<p>Nesse sistema você pode criar e excluir tarefas, as tarefas criadas aparecerão abaixo.</p>
	</div>
    <div class='container create-task-container'>
		<h1>Criar Tarefa</h1>
    	<form action="criarTarefa" method="post">
	    	<div class='form-items'>
	    		<label>Título:</label>
	        	<input type="text" name="titulo" required><br />
	        
	        	<label>Descrição:</label>
	        	<textarea name="descricao" required></textarea><br />
	        
	        	<label>Status: </label>
	        	<input type="text" name="status" required><br />
	        	<input type="hidden" name="idAluno" value="<%out.print(id);%>">
	    	</div>
	        <button type="submit">Criar tarefa</button>
    	</form>
	</div>

	
</body>
</html>