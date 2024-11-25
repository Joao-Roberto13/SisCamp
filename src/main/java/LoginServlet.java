import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
			// Verifica se já há uma sessão ativa
			HttpSession session = request.getSession(false);
			if (session != null && session.getAttribute("email") != null) {
				response.sendRedirect("backOffice.jsp"); // Redireciona ao dashboard se já estiver logado
				return;
			}

			String email = request.getParameter("email");
			String pwd = request.getParameter("senha");

			// Valida o usuário usando UsersData
			if ((email.equalsIgnoreCase("admin") && pwd.equalsIgnoreCase("1234"))) {
				session = request.getSession(); // Cria uma nova sessão
				session.setAttribute("email", email);
				session.setMaxInactiveInterval(30 * 60); // Define a expiração para 30 minutos
				response.sendRedirect("backOffice.jsp"); // Redireciona ao dashboard
			} else {
				out.println("<script type='text/javascript'>");
				out.println("alert('Email ou Senha incorretos!');");
				out.println("window.location.href = 'Login.jsp';"); // Redireciona de volta para o login
				out.println("</script>");
			}
	}
}
