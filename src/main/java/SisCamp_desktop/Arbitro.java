package SisCamp_desktop;

import java.io.Serializable;

public class Arbitro implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String nome, modalidade,provincia;
	protected int idade, experiencia;
	
	public Arbitro(String nome, int idade, String modalidade, int experiencia, String provincia) {
		this.nome = nome;
		this.modalidade = modalidade;
		this.idade = idade;
		this.experiencia = experiencia;
		this.provincia = provincia;
	}
	
	public Arbitro()
	{
		this("", 0,"", 0,"");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	
	

}
