<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, width=device-width" />

    <link rel="stylesheet" href="./css/index.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap"
    />
  </head>
  <body>
    <div class="register">
      <div class="register-inner">
        <div class="faa-login-e-acesse-seu-sistem-parent">
          <h1 class="faa-login-e-container">
            <p class="faa-login">Faça login</p>
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
      <div class="right-container-parent">
        <div class="right-container"></div>
        <form action="cadastrarAluno" method="post" class="main-content">
          <div class="login-form-container"></div>
          <div class="login-header">
            <h1 class="login-h1">Cadastre-se</h1>
          </div>
          <div class="login-form">
            <div class="input-fields">
              <div class="input-labels">
                <label class="usurio">nome</label>
                <input class="user-input" name="nome" type="text" />
              </div>
              <div class="input-labels1">
                <label class="email">email</label>
                <input class="senha-input" name="email" type="text" />
              </div>
              <div class="input-labels2">
                <label class="senha">senha</label>
                <input class="senha-input1" name="senha" type="text" />
              </div>
            </div>
          </div>
          <button type="submit" class="btn-login">
            <div class="criar-conta">Criar conta
            </div>
          </button>
          
        </form>
        <%
				 String mensagem = (String) request.getAttribute("mensagem");
				 if(mensagem!= null){
					out.print(mensagem);
				}
		 
				%>
      </div>
    </div>
  </body>
</html>
