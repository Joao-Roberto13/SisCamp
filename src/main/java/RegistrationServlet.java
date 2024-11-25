import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import objectos.*;
import pacote.UsersData;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsersData usersData;

	@Override
	public void init() throws ServletException {
		super.init();
		usersData = new UsersData(); // Inicialize sua instância de UsersData
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("pass"); // Corrigido para corresponder ao formulário
		String rePassword = request.getParameter("re_pass");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Verifica se as senhas coincidem
		if (!password.equals(rePassword)) {
			out.println("<font color='red' size='14'>As senhas não coincidem!</font>");
			RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
			rd.include(request, response);
			return;
		}

		// Adiciona o novo usuário
		if (usersData.storeNewUser(email, new ClientInfo(email, password))) {
			// Registro realizado com sucesso
			response.sendRedirect("registration.jsp?message=Registro realizado com sucesso!");
		}
		else {
			// E-mail já cadastrado
			out.println("<font color='red' size='14'>Erro ao registrar usuário! E-mail já cadastrado.</font>");
			RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
			rd.include(request, response);
		}
	}
}
