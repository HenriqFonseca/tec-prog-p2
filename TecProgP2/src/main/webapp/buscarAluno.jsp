<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buscar here</title>
</head>
<body>
<form action="buscarAluno" method="post">
		<label>buscar nome: </label>
		<input type="email" name="email"><br>
		
		<input type="submit" name="salvar" value="Cadastrar Produto"><br>
		
		
	</form>
	<%
		String mensagem = (String) request.getAttribute("mensagem");
		 if(mensagem!= null){
			out.print(mensagem);
		}
	%>
</body>
</html>