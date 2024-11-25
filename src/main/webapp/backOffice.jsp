<%@ page import="java.util.Hashtable"%>
<%@ page import="pacote.News_DB"%>
<%@ page import="pacote.NewsInfo"%>
<%@ page import="jakarta.servlet.http.*"%>

<%
    HttpSession sessions = request.getSession(false);
    if (sessions == null || sessions.getAttribute("email") == null) {
        response.sendRedirect("Login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home - Publica��o de Not�cias</title>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }

    body {
        display: flex;
        background-color: #f0f2f5;
        color: #333;
    }

    /* Menu lateral */
    .sidebar {
        width: 220px;
        background-color: #2c3e50;
        color: #ecf0f1;
        padding: 20px;
        height: 100vh;
        display: flex;
        flex-direction: column;
        gap: 15px;
        box-shadow: 2px 0 10px rgba(0, 0, 0, 0.2);
    }

    .sidebar h2 {
        color: #ecf0f1;
    }

    .sidebar button, .sidebar form button {
        width: 100%;
        padding: 10px;
        border: none;
        background-color: #1abc9c;
        color: white;
        cursor: pointer;
        font-size: 1rem;
        transition: 0.3s;
        border-radius: 8px;
    }

    .sidebar button:hover, .sidebar form button:hover {
        background-color: #16a085;
    }

    /* �rea principal */
    .main-content {
        flex: 1;
        padding: 40px;
        background-color: #ecf0f1;
    }

    .main-content h2 {
        text-align: center;
        color: #34495e;
        margin-bottom: 30px;
    }

    .section {
        display: none;
        background-color: #fff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
        animation: fadeIn 0.5s ease-in-out;
    }

    .section.active {
        display: block;
    }

    @keyframes fadeIn {
        from { opacity: 0; }
        to { opacity: 1; }
    }

    /* Estilo para listas e formul�rios */
    ul {
        list-style: none;
        padding: 0;
        margin: 20px 0;
    }

    ul li {
        padding: 10px;
        background-color: #f9f9f9;
        margin-bottom: 10px;
        border-left: 5px solid #2980b9;
    }

    .form-group {
        margin-bottom: 20px;
    }

    .form-group label {
        display: block;
        margin-bottom: 8px;
        color: #34495e;
    }

    .form-group input, .form-group select, .form-group button {
        width: 100%;
        padding: 12px;
        border: 1px solid #ddd;
        border-radius: 5px;
        font-size: 1rem;
    }

    .form-group button {
        background-color: #3498db;
        color: #fff;
        cursor: pointer;
    }

    .form-group button:hover {
        background-color: #2980b9;
    }

    /* Layout responsivo */
    @media (max-width: 768px) {
        .sidebar {
            width: 80px;
            padding: 15px;
        }
        .main-content {
            padding: 20px;
        }
    }
</style>
</head>
<body>
    <div class="sidebar">
        <button onclick="showSection('Home')">Home</button>
        <button onclick="showSection('viewNews')">Not�cias</button>
        <button onclick="showSection('insertNews')">Inserir Not�cia</button>
        <form action="LogoutServlet" method="post">
            <button type="submit">Logout</button>
        </form>
    </div>

    <div class="main-content">
        <h2>SisCamps - Informa��es de Basquete</h2>

        <!-- Se��o Home -->
        <div id="Home" class="section active">
            <h3>Bem-vindo ao SisCamps</h3>
            <p>Aqui voc� encontrar� as �ltimas informa��es sobre o basquete mo�ambicano, incluindo estat�sticas, pr�ximos jogos e muito mais!</p>
            <h4>Pr�ximos Jogos</h4>
            <ul>
                <li>Time A vs Time B - Data: 01/11/2024</li>
                <li>Time C vs Time D - Data: 03/11/2024</li>
                <li>Time E vs Time F - Data: 05/11/2024</li>
            </ul>
            <h4>Estat�sticas Recentes</h4>
            <ul>
                <li>Jogador X - 30 pontos no �ltimo jogo</li>
                <li>Time Y - 10 vit�rias consecutivas</li>
                <li>Jogador Z - L�der em assist�ncias da liga</li>
            </ul>
        </div>

        <!-- Formul�rio para Inserir Not�cia -->
        <div id="insertNews" class="section">
            <h3>Inserir Not�cia</h3>
            <form action="PublishNewsServlet" method="POST">
                <div class="form-group">
                    <label>Tema:</label>
                    <select name="titulo" required>
                        <option value="">Selecione o T�tulo</option>
                        <option value="A">3Pt-Contest</option>
                        <option value="B">Copa Nacional de BasketBall</option>
                        <option value="C">Torneiro de Ver�o de Basquete</option>
                        <option value="D">Copa Nacional de Basquete</option>
                        <option value="E">Dunk Contest</option>
                        <option value="F">Cesto de Platina</option>
                        <option value="G">Basket de Praia</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Hora In�cio:</label>
                    <input type="time" name="hora_inicio" required>
                </div>
                <div class="form-group">
                    <label>Hora Fim:</label>
                    <input type="time" name="hora_fim" required>
                </div>
                <div class="form-group">
                    <label>Equipas em Jogo:</label>
                    <select name="equipas_em_jogo">
                        <option value="">Selecione a Equipe</option>
                        <option value="Los Angeles Lakers">LA vs GSW</option>
                        <option value="Boston Celtics">Celtics VS Bulls</option>
                        <!-- Adicione mais op��es conforme necess�rio -->
                    </select>
                </div>
                <div class="form-group">
                    <label>Marcas do Jogo:</label>
                    <input type="text" name="marcas_jogo" placeholder="Gols Equipe1, Gols Equipe2" required>
                </div>
                <div class="form-group">
                    <label>Autores da Marca:</label>
                    <input type="text" name="autores_marca" placeholder="Jogador1, Jogador2" required>
                </div>
                <div class="form-group">
                    <label>�rbitros:</label>
                    <input type="text" name="arbitros" placeholder="�rbitro1, �rbitro2" required>
                </div>
                <div class="form-group">
                    <button type="submit">Publicar Not�cia</button>
                </div>
            </form>
        </div>

        <!-- Se��o para Ver Not�cias -->
        <div id="viewNews" class="section">
            <h3>Not�cias Publicadas</h3>
            <%
                News_DB newsDB = new News_DB();
                Hashtable<String, NewsInfo> noticias = newsDB.getAllNews();

                if (noticias.isEmpty()) {
                    out.println("<p>Nenhuma not�cia dispon�vel.</p>");
                } else {
                    out.println("<ul>");
                    for (String title : noticias.keySet()) {
                        NewsInfo news = noticias.get(title);
                        out.println("<li><strong>T�tulo:</strong> " + news.getTitulo() + "<br>");
                        out.println("<strong>Hora In�cio:</strong> " + news.getHoraInicio() + "<br>");
                        out.println("<strong>Hora Fim:</strong> " + news.getHoraFim() + "<br>");
                        out.println("<strong>Equipas em Jogo:</strong> " + news.getEquipasEmJogo() + "<br>");
                        out.println("<strong>Marcas do Jogo:</strong> " + news.getMarcasJogo() + "<br>");
                        out.println("<strong>Autores da Marca:</strong> " + news.getAutoresMarca() + "<br>");
                        out.println("<strong>�rbitros:</strong> " + news.getArbitros() + "</li><br>");
                    }
                    out.println("</ul>");
                }
            %>
        </div>
    </div>

    <script>
        function showSection(sectionId) {
            const sections = document.getElementsByClassName('section');
            for (let section of sections) {
                section.classList.remove('active');
            }
            document.getElementById(sectionId).classList.add('active');
        }

        document.addEventListener("DOMContentLoaded", function() {
            showSection('Home');
        });
    </script>
</body>
</html>
