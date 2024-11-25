import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import pacote.*;

@WebServlet("/PublishNewsServlet")
public class PublishNewsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private News_DB newsDB;

    @Override
    public void init() throws ServletException {
        newsDB = new News_DB();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String horaInicio = request.getParameter("hora_inicio");
        String horaFim = request.getParameter("hora_fim");
        String equipasEmJogo = request.getParameter("equipas_em_jogo");
        String marcasJogo = request.getParameter("marcas_jogo");
        String autoresMarca = request.getParameter("autores_marca");
        String arbitros = request.getParameter("arbitros");

        NewsInfo newsInfo = new NewsInfo(titulo, horaInicio, horaFim, equipasEmJogo, marcasJogo, autoresMarca, arbitros);
        newsDB.storeNewNews(titulo, newsInfo);

        // Redirecionar para a página inicial onde as notícias serão carregadas
        response.sendRedirect("backOffice.jsp");

        System.out.println();
        System.out.println("-----------------------------------------------------------");
        System.out.println("Titulo: "+titulo);
        System.out.println("Horas de Inicio: "+horaInicio);
        System.out.println("Horas de Fim: "+horaFim);
        System.out.println("Equipas em Jogo: "+equipasEmJogo);
        System.out.println("Marcas de Jogo: "+marcasJogo);
        System.out.println("Autores: "+marcasJogo);
        System.out.println("Arbitros: "+arbitros);
        System.out.println();
        System.out.println("caracteristicas principais: ");
        
        List<String> headersToFileter = Arrays.asList("Host", "Connection", "content-length", "Content-Type", "Referer", "accept-language", "accept-encoding","User-Agent");
        
        for (String header : headersToFileter) {
        	String headerValue = request.getHeader(header);
        	if (headerValue != null) {
        		System.out.println(header +" : "+headerValue);
        	}
        }
        System.out.println("Cabeçalho de Resposta: "+response.getHeaderNames());
        System.out.println("Contéudo da Resposta: "+response.getContentType());
        System.out.println("Status: "+response.getStatus());
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        
    }
}
