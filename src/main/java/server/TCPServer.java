package server;

import java.net.*;
import java.util.Vector;
import java.io.*;
import SisCamp_desktop.*;

public class TCPServer {
	
	private static Vector<Serializable> vetor;
	
	public static void main(String[] args) {
	   	  ServerSocket listenSocket = null;
    	  Socket clientSocket = null;
          int serverPort = 7000;

  		vetor = new Vector<Serializable>();

          try {
          	
              // Inicia o servidor para escutar na porta 7001
              listenSocket = new ServerSocket(serverPort);
              System.out.println("A Escuta no Porto " + serverPort);

              while (true) {
                  // Aceita uma conexão do cliente
                  clientSocket = listenSocket.accept();
                  System.out.println("");
                  System.out.println("=================================================================================");
                  System.out.println("CLIENT_SOCKET (Created at Accept()) = " + clientSocket.getInetAddress());

                  // A ordem correta: primeiro ObjectOutputStream
                  ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                  ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

                  try {
                  	Object obj = in.readObject();

                  	if (obj instanceof Campeonato) {
                  		Campeonato c = (Campeonato) obj;
                  		System.out.println("Campeonato Recebido:");
                  		System.out.println("Título: " + c.getTitulo());
                  		System.out.println("Modalidade: "+c.getModalidade());
                  		System.out.println("Periodo: "+c.getPeriodo());
                  		System.out.println("Local: "+c.getLocal());
                  		System.out.println("Equipes: "+c.getEquipes());
                  		System.out.println("=================================================================================");
                  		// Exibe os outros atributos...
                		vetor.addElement(c);
                  		
                  	} else if (obj instanceof Jogador) {
                  		Jogador j = (Jogador) obj;
                  		System.out.println("Jogador Recebido:");
                  		System.out.println("ID: "+j.getId());
                  		System.out.println("Nome: " + j.getNome());
                  		System.out.println("Idade: "+j.getIdade());
                  		System.out.println("Anos no Clube: "+j.getAnosClube());
                  		System.out.println("Modalidade: "+j.getModalidade());
                  		System.out.println("Categoria: "+j.getCategoria());
                  		System.out.println("Marcas Registadas: "+j.getMarcasRegistadas());
                  		System.out.println("Quantidade de Jogos Nacionais: "+j.getJogosN());
                  		System.out.println("Quantidade de Jogos Internacionais: "+j.getJogosI());
                  		System.out.println("=================================================================================");
                  		// Exibe os outros atributos...
                		vetor.addElement(j);
                  		
                  	} else if (obj instanceof Clube) {
                  		Clube cl = (Clube) obj;
                  		System.out.println("Clube Recebido:");
                  		System.out.println("Nome: " + cl.getNome());
                  		System.out.println("Local: "+cl.getLocal());
                  		System.out.println("Nome do Presidente: "+cl.getPresidente());
                  		System.out.println("Treinador Principal: "+cl.getTreinador());
                  		System.out.println("=================================================================================");
                  		// Exibe os outros atributos...
                		vetor.addElement(cl);
                  		
                  	}
                  	else if (obj instanceof Arbitro) {
                  		Arbitro a = (Arbitro) obj;
                  		System.out.println("Arbitro Recebido:");
                  		System.out.println("Nome: "+a.getNome());
                  		System.out.println("Modalidade: "+a.getModalidade());
                  		System.out.println("Idade: "+a.getIdade());
                  		System.out.println("Experiencia: "+a.getExperiencia());
                  		System.out.println("Provinvia: "+a.getProvincia());
                  		System.out.println("=================================================================================");
                		vetor.addElement(a);
                  	}

                  	// Envia uma resposta ao cliente...
                  	out.writeUTF("Objeto recebido com sucesso!");
                  	out.flush();
                  	
                  	//Retorna o registro enviado...
                  	out.writeObject(obj);
                  	out.flush();
                  	
                  } 
                  catch (ClassNotFoundException e) {
                  	System.out.println("Classe não encontrada: " + e.getMessage());
                  }
                  // Fecha a conexão com o cliente
                  //clientSocket.close();
              }

          } 
          catch (IOException e) {
              System.out.println("IO:" + e.getMessage());
          } 
          finally {
              if (listenSocket != null)  
              {
                  try 
                  {
                      listenSocket.close();
                  } 
                  catch (IOException e) {
                      System.out.println("close:" + e.getMessage());
                  }
              }
          }           
    }
}
