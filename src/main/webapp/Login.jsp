<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.*" %>

<%
    // Verifica se a sessão já está iniciada
    HttpSession userSession = request.getSession(false); // Renomeie a variável
    if (userSession != null && userSession.getAttribute("email") != null) {
        // Se já estiver logado, redireciona para o backoffice
        response.sendRedirect("backOffice.jsp");
        return; // Interrompe a execução da página
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Tela de Login</title>
    <link rel="stylesheet" href="stylelogin.css">
    <script src="actionlogin.js"></script>
</head>
<body>
    <!--CONTAINER PRINCIPAL-->
    <div class="main-container">

        <!--CONTAINER DA ESQUERDA-->
        <div class="container-esquerda">
            <div class="sobre">
                <div class="sobre-label">
                    <img src="images/sobre.png" alt="Sobre">
                    <h4>Sobre nós</h4>
                </div>
                <p>Gestão de campeonatos desportivos a nível de todo o país.
                    Registro de campeonatos, clubes, jogadores e/ou árbitros
                    moçambicanos. Se cadastre na nossa plataforma para ter acesso a
                    notícias e informações que dizem respeito à organização desportiva
                    em Moçambique.</p>
            </div>

            <!--ICONES DOS CONTATOS-->
            <div class="contatos">
                <h4>Contate-nos</h4>
                <div class="icones-contato">
                    <a href="tel:+258829999999"><img src="images/tel1.png" alt="Telefone"></a>
                    <a href="mailto:siscamps@gmail.com"><img src="images/email2.png" alt="Email"></a>
                    <a href="https://www.facebook.com" target="_blank"><img src="images/fb.png" alt="Facebook"></a>
                </div>
            </div>            
		<button class="top-button" onclick="window.location.href='Main_Scren.jsp';">Home-Noticias</button>
        </div>

        <!--CONTAINER DA DIREITA-->
        <div class="container-direita">
            <div>
                <h1>Bem-vindo ao SisCamps</h1>
                <h2>Secretaria de Estado de Desportos de Moçambique</h2>
            </div>

            <!--CONTAINER DOS FORMULÁRIOS-->
            <div class="form-container">

                <!--FORMULÁRIO DE LOGIN-->
                <form action="LoginServlet" method="post">
                    <h2>Login</h2>
                    <label for="email">Email</label>
                    <input type="text" name="email" autocomplete="off" required>
                    <label for="senha">Senha</label>
                    <input type="password" name="senha" autocomplete="off" required>
                    <button type="submit" name="entrar">Entrar</button>
                    <p>Não tem uma conta? <a href="registration.jsp">Clique aqui para registrar-se</a></p>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
