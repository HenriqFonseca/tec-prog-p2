<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, width=device-width" />

    <link rel="stylesheet" href="./css/login.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap"
    />
  </head>
  <body>
    <div class="login-2">
      <div class="main">
        <div class="content">
          <h1 class="faa-login-e-container1">
            <p class="title">Faça login <br>E acesse seu sistema</p>
          </h1>
          <img
            class="image-1-icon1"
            loading="lazy"
            alt=""
            src="./public/Mobile testing.gif"
          />
        </div>
      </div>
      <div class="sidebar">
        <div class="right-container1"></div>
        <div class="login-form1">
          <div class="login-form-container1"></div>
          <div class="login-header1">
            <h1 class="login-h11">login</h1>
          
          </div>
          
          <form action="login" method="post" class="input-fields1">
            <div class="credentials">
              <label class="email1">email</label>
              <input class="user-input1" name="email"type="text" />
            </div>
            <div class="credentials1">
              <label class="senha1">senha</label>
              <input class="senha-input2" name="senha" type="password" />
            </div>
            <button type="submit" class="btn-login1">
              <div class="entrar">Entrar</div>
            </button>
          </form>
   			
          <div class="signup-link">
            <div class="create-acc">
              <a href="/TecProgP2/cadastrarAluno.jsp">Crie sua conta</a>
            </div>
            <div class="error-message" >
              <%
				 String mensagem = (String) request.getAttribute("mensagem");
				 if(mensagem!= null){
					out.print(mensagem);
				}
		 
				%>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
