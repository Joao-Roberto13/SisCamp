package pacote;
import java.io.*;
import java.util.Hashtable;
import java.util.Enumeration;
import objectos.*;

public class UsersData implements Serializable {
    private Hashtable<String, ClientInfo> tabela;
    private int Id = 1;  // still not used

    // Constructor
    public UsersData() {
        tabela = new Hashtable<>();
    }

    // Modificado para retornar booleano
    public boolean storeNewUser(String email, ClientInfo c) {
        // Verifica se o usuário já existe
        if (userExist(email)) {
            return false; // O usuário já existe
        }

        System.out.println("DEBUG: Utilizador: email=" + email);
        tabela.put(email, c); // Adiciona o usuário usando o e-mail como chave
        Id++;
        return true; // Usuário registrado com sucesso
    }

    public boolean checkUser(String email, String Pass) {     
        ClientInfo c = tabela.get(email); // Obtenha o ClientInfo usando o e-mail
        if (c == null || Pass == null) {
            return false;
        }
        String password = c.getPass();
        System.out.println("DEBUG: checkUser: email=" + email + " Password= " + password + " Password_Log=" + Pass);
        return password.equals(Pass);
    }

    public boolean userExist(String email) {  
        return tabela.get(email) != null;  
    }

    public String[] listUsers() {  
        Enumeration<ClientInfo> enumeration = tabela.elements();
        ClientInfo aux;
        String[] lista = new String[tabela.size()];
        int i = 0;

        if (enumeration != null) {
            System.out.println("DEBUG: LIST OF USERS ");
            while (enumeration.hasMoreElements()) {
                aux = enumeration.nextElement();
                // Exibe o e-mail do usuário
                System.out.println("USER: " + aux.getEmail());
                lista[i++] = aux.getEmail(); 
            }
            return lista;
        } else {
            return null;   
        }
    }
}
