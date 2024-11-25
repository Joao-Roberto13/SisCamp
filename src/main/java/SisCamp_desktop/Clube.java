package SisCamp_desktop;

import java.io.Serializable;

public class Clube implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String nome, local, presidente, treinador;
	public static int contC = 0;
	
	public Clube (String nome, String local, String presidente, String treinador) {
		this.nome = nome;
		this.local = local;
		this.presidente = presidente;
		this.treinador = treinador;
		
		contC++;
	}
	
	public Clube ()
	{
		this("","","","");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public String getTreinador() {
		return treinador;
	}

	public void setTreinador(String treinador) {
		this.treinador = treinador;
	}
	
}
