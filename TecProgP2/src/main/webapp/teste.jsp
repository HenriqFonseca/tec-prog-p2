%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Tarefa" %>

<%
    Integer id = (Integer) session.getAttribute("id");
    List<Tarefa> tarefas = (List<Tarefa>) request.getAttribute("tarefas");

    if (id == null) {
        if (request.getAttribute("idAluno") != null) {
            id = (Integer) request.getAttribute("idAluno");
            session.setAttribute("id", id);
        } else {
            String mensagem = "Faça login para acessar!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
            return;
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Listar Tarefas</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<header>
    <span id='logo'>TaskManager</span>
    <nav class='menu'>
        <a href='criarTarefa.jsp' class='nav-link'>Criar Tarefa</a>
        <a href='listarTarefa.jsp' class='nav-link'>Listar Tarefa</a>
        <a href='logout.jsp' class='nav-link'>Deslogar</a>
    </nav>
</header>
<div class='task-list container'>
    <h2>Lista de tarefas</h2>
    <%
        if (tarefas != null && !tarefas.isEmpty()) {
            for (Tarefa tarefa : tarefas) {
    %>
                <div class='tarefas-lista'>
                    <div class='tarefa-container'>
                        <div class='tarefa-header'>
                            <h3>Título</h3>
                            <div class='tarefa-info'>
                                <span class='tarefa-id'><strong>Id:</strong> <%= tarefa.getIdTarefa() %></span>
                                <span class='status'><%= tarefa.getStatus() %></span>
                                <form action='excluirTarefa' method='post'>
                                    <input type='hidden' name='idTarefa' value='<%= tarefa.getIdTarefa() %>'>
                                    <input type='submit' name='deletar' value='Deletar'>
                                </form>
                            </div>
                        </div>
                        <span><%= tarefa.getDescricao() %></span>
                    </div>
                </div>
    <%
            }
        } else {
    %>
            <p>Nenhuma tarefa criada.</p>
    <%
        }
    %>
</div>
</body>
</html>