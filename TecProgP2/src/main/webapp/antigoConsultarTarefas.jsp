<%@page import="java.util.List"%>
<%@page import="model.Tarefa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Integer id = (Integer) request.getAttribute("id");
	List<?> verifyList = (List<?>) request.getAttribute("tarefas");
	if(request.getAttribute("idAluno") != null){
		id = (Integer) request.getAttribute("idAluno");
		session.setAttribute("id", id);
		
	}
	else if(request.getAttribute("id")!= null && request.getAttribute("tarefas") !=null)
	{
		
		id = (Integer) request.getAttribute("idAluno");
		session.setAttribute("id", id);
		 
		 
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
<title>Insert title here</title>
</head>
<body>
<h1>BOM DIAAAA</h1>
<%
	
	if(request.getAttribute("tarefas") != null){
		List<?> tarefas = (List<?>) request.getAttribute("tarefas");
		for(int i=0; i<=(tarefas.size()-1); i++){
			Tarefa tarefa = (Tarefa) tarefas.get(i);
%>
<div >
	<h1>Id: <%out.print(tarefa.getIdTarefa());%></h1>
	<h1>Titulo: <%out.print(tarefa.getTitulo());%></h1>
	<h1>Descrição: <%out.print(tarefa.getDescricao());%></h1>
	<h1>Status <%out.print(tarefa.getStatus());%></h1>
	<form action="excluirTarefa" method="post">
	<input type="submit" name="deletar" value="deletar"> <br>
	<input type="hidden" name="idTarefa" value="<%out.print(tarefa.getIdTarefa());%>"> <br>
	<input type="hidden" name="idAluno" value="<%out.print(id);%>"> <br>
	</form>
</div>
	
<%	
   }
}
%>
</body>
</html>