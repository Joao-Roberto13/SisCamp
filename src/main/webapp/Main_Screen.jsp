<%@ page import="java.util.Hashtable"%>
<%@ page import="pacote.News_DB"%>
<%@ page import="pacote.NewsInfo"%>
<%@ page import="jakarta.servlet.http.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Noticias</title>
<link rel="stylesheet" href="styleMain_Screen.css">
</head>
<body>

    <button class="top-button" onclick="window.location.href='Login.jsp';">Login</button>

    <!-- Contêiner principal para alinhar os contêineres à esquerda e à direita -->
    <div class="main-container">
        <!-- Títulos dos Jogos acima do container-direita -->
        <div class="container-esquerda">
        	<h2> Jogos </h2>  
            <%
            // Instanciar ou acessar o objeto de banco de dados de notícias
            News_DB newsDB = new News_DB();
            Hashtable<String, NewsInfo> noticias = newsDB.getAllNews();

            if (noticias.isEmpty()) {
                out.println("<p>Nenhuma notícia disponível.</p>");
            } else {
                out.println("<ul>");
                for (String title : noticias.keySet()) {
                    NewsInfo news = noticias.get(title);
                    out.println("<li><strong>Título:</strong> " + news.getTitulo() + "<br>");
                    out.println("<strong>Hora Início:</strong> " + news.getHoraInicio() + "<br>");
                    out.println("<strong>Hora Fim:</strong> " + news.getHoraFim() + "<br>");
                    out.println("<strong>Equipas em Jogo:</strong> " + news.getEquipasEmJogo() + "<br>");
                    out.println("<strong>Marcas do Jogo:</strong> " + news.getMarcasJogo() + "<br>");
                    out.println("<strong>Autores da Marca:</strong> " + news.getAutoresMarca() + "<br>");
                    out.println("<strong>Árbitros:</strong> " + news.getArbitros() + "</li><br>");
                }
                out.println("</ul>");
            }
            %>
        </div>

        <!-- Container direito para conteúdo centralizado -->
        <div class="container-direita">
			<div>
				<h1>Bem-vindo ao SisCamps</h1>
			</div>			
			<img src="images/pic2.jpeg" class="image-large" alt="Image 1"> 
		</div>
    </div>
</body>
</html>
