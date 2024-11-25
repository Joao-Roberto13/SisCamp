package SisCamp_desktop;
import jakarta.servlet.*;
import java.io.Serializable;

public class Campeonato implements Serializable{
	private static final long serialVersionUID = 1L;  // Adicione um serialVersionUID para melhor controle da serialização
	
	protected String nome, modalidade,local,periodo;
	protected int equipes;
	public static int contC = 0;
	public Campeonato(String nome, String modalidade, String local, String periodo, int equipes) {
		this.nome = nome;
		this.modalidade = modalidade;
		this.local = local;
		this.periodo = periodo;
		this.equipes = equipes;
		contC++;
	}
	
	public Campeonato()
	{
		this("","","","",0);
	}


	public String getTitulo() {
		return nome;
	}


	public void setTitulo(String titulo) {
		this.nome = titulo;
	}


	public String getModalidade() {
		return modalidade;
	}


	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public String getPeriodo() {
		return periodo;
	}


	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}


	public int getEquipes() {
		return equipes;
	}


	public void setEquipes(int equipes) {
		this.equipes = equipes;
	}

	
}
