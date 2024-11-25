package objectos;

public class Utilizador {
	
	private String email,senha;
	
	public Utilizador(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	
	public Utilizador() {
		this("","");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
