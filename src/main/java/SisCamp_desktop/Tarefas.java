package SisCamp_desktop;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;
import server.TCPClient;


public class Tarefas 
{
	private TCPClient tcp;
	private String host;
	public static Vector<Serializable> vetor = new Vector<Serializable>();
	public static int cont = 0;
	
	public Tarefas() {
		tcp = new TCPClient();
		host = "localhost";
	}
	
	public void mandarArbitror(String nome, int idade, String modalidade, int experiencia, String provincia) {
		Arbitro a = new Arbitro(nome, idade, modalidade, experiencia, provincia);
		tcp.mandarObjeto(a, host);
		cont++;
	}
	
	public void mandarCampeonato(String titulo, String modalidade, String local, String periodo, int equipas) {
	    Campeonato c = new Campeonato();
	    
	    c.setTitulo(titulo);
	    c.setModalidade(modalidade);
	    c.setLocal(local);
	    c.setPeriodo(periodo);
	    c.setEquipes(equipas);
	    
	    tcp.mandarObjeto(c, host);  // Enviar objeto Campeonato para o TCPClient
		cont++;
	}
	
	public void mandarClube(String nome, String local, String presidente, String treinador)
	{
		Clube c = new Clube(nome, local, presidente, treinador);
		tcp.mandarObjeto(c, host);
		cont++;
	}
	
	public void mandarJogador(String nome, int idade, int anosClube, String modalidade, String categoria, int marcasRegistadas, int jogosI, int jogosN) {
		Jogador j = new Jogador(nome, idade, anosClube, modalidade, categoria, marcasRegistadas, jogosI, jogosN);
		tcp.mandarObjeto(j, host); 
		cont++;
	}
	
	public void lerFicheiroObjecto() {
		String umaLinha, nome, criterio, titulo, modalidade, provincia, local, periodo,presidente, treinador, categoria, file = "SisCamp.txt";
		int idade, experiencia, equipas, anosClube, marcasRegistadas, jogosI, jogsoN;
		StringTokenizer umaCadeia;
				
		try
		{
			BufferedReader x = new BufferedReader(new FileReader(file));
			
			umaLinha = x.readLine();		
			while(umaLinha != null)
			{
				umaCadeia = new StringTokenizer(umaLinha, ";");
				criterio = umaCadeia.nextToken();
				
				switch(criterio)
				{
					case "A":
						nome = umaCadeia.nextToken();
						idade = Integer.parseInt(umaCadeia.nextToken());
						modalidade = umaCadeia.nextToken();
						experiencia = Integer.parseInt(umaCadeia.nextToken());
						provincia = umaCadeia.nextToken();
						
						criarObjArbitro(nome, idade, modalidade, experiencia, provincia);
						break;
				}
				umaLinha = x.readLine();
			}	
			System.out.println("Ficheiro Lido com sucesso!!!");
			x.close();
		}
		catch(FileNotFoundException f) {JOptionPane.showMessageDialog(null, "Erro: Ficheiro "+file+" não encontrado :(","Erro no Arquivo",JOptionPane.ERROR_MESSAGE);}
		catch(NumberFormatException n) {JOptionPane.showMessageDialog(null, "Erro: o arquivo contém dados incorretos :(", "Erro no arquivo", JOptionPane.ERROR_MESSAGE);}
		catch(NoSuchElementException nn) {JOptionPane.showMessageDialog(null, "Erro: Certifique-se de estar a ler o ficheiro de Texto correto","Erro no Arquivo",JOptionPane.ERROR_MESSAGE);}
		catch(IOException i) {JOptionPane.showMessageDialog(null, "ERRO: Ficheiro de Contem erro :(","Erro no Arquivo",JOptionPane.ERROR_MESSAGE);}
	}
	
	public void criarObjArbitro(String nome, int idade, String modalidade, int experiencia, String provincia) {
		Arbitro a = new Arbitro();
		
		a.setNome(nome);
		a.setIdade(idade);
		a.setModalidade(modalidade);
		a.setExperiencia(experiencia);
		a.setProvincia(provincia);
		
		vetor.addElement(a);
		vetor.trimToSize();
	}
	
}
