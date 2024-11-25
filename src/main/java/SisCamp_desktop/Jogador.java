package SisCamp_desktop;

import java.io.Serializable;

public class Jogador implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String nome, modalidade,categoria;
	protected int id,idade, anosClube, marcasRegistadas, jogosI, jogosN;
	
	public static int contJ = 1000;
	
	public Jogador(String nome, int idade, int anosClube, String modalidade, String categoria, int marcasRegistadas, int jogosI, int jogosN) {
		this.id = contJ++;
		this.nome = nome;
		this.idade = idade;
		this.anosClube = anosClube;
		this.modalidade = modalidade;
		this.categoria = categoria;
		this.marcasRegistadas = marcasRegistadas;
		this.jogosI = jogosI;
		this.jogosN = jogosN;
	}
	
	
	public Jogador()
	{
		this("",0,0,"","",0,0,0);
	}


	public int getId()
	{
		return id;
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


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public int getAnosClube() {
		return anosClube;
	}


	public void setAnosClube(int anosClube) {
		this.anosClube = anosClube;
	}


	public int getMarcasRegistadas() {
		return marcasRegistadas;
	}


	public void setMarcasRegistadas(int marcasRegistadas) {
		this.marcasRegistadas = marcasRegistadas;
	}


	public int getJogosI() {
		return jogosI;
	}


	public void setJogosI(int jogosI) {
		this.jogosI = jogosI;
	}


	public int getJogosN() {
		return jogosN;
	}


	public void setJogosN(int jogosN) {
		this.jogosN = jogosN;
	}


	public static void setContJ(int contJ) {
		Jogador.contJ = contJ;
	}
}
