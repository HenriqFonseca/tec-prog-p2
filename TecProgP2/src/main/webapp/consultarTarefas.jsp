<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import= "model.Tarefa" %>
    
<%
    Integer id = (Integer) request.getAttribute("id");
    List<?> tarefas = (List<?>) request.getAttribute("tarefas");
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
<title>Consultar Tarefas</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<header>
		<span id='logo'>TaskManager</span>
		<nav class='menu'>
	            
	            <form action="perfil.jsp" method="post">
					<input type="hidden" name="id" value="<%out.print(id);%>">
					<input class="nav-link" type="submit" value="Criar Tarefas">
				</form>
	            <a href='logout.jsp' class='nav-link'>Deslogar</a>
	        </nav>
	</header>
<div class='task-list container'>
    <h2>Lista de tarefas</h2>
    <div class='tarefas-lista'>
    <%
    if(request.getAttribute("tarefas") != null && !tarefas.isEmpty()){
		for(int i=0; i<=(tarefas.size()-1); i++){
			Tarefa tarefa = (Tarefa) tarefas.get(i);
    %>
                    <div class='tarefa-container'>
                        <div class='tarefa-header'>
                            <h3>Título</h3>
                            <div class='tarefa-info'>
                                <span class='tarefa-id'><strong>Id:</strong> <%= tarefa.getIdTarefa() %></span>
                                <span class='status'><%= tarefa.getStatus() %></span>
                                <form action='excluirTarefa' method='post'>
                                    <input type="hidden" name="idTarefa" value="<%out.print(tarefa.getIdTarefa());%>"> <br>
									<input type="hidden" name="idAluno" value="<%out.print(id);%>"> <br>
                                    <input type='submit' name='deletar' value='Deletar'>
                                </form>
                            </div>
                        </div>
                        <span><%= tarefa.getDescricao() %></span>
                    </div>
    <%
            }
                out.print("</div>");
        } else {
    %>
            <p>Nenhuma tarefa criada.</p>
    <%
        }
    %>
</div>
</body>
</html>