package objectos;
import java.io.Serializable;

public class ClientInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String email; // E-mail
    private String pass;  // Senha

    // Construtor que recebe apenas login (e-mail) e senha
    public ClientInfo(String login, String pass) {
        this.email = login;
        this.pass = pass;
    }

    // Método para obter o login (e-mail)
    public String getEmail() {
        return email;
    }

    // Método para obter a senha
    public String getPass() {
        return pass;
    }
}
