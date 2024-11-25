package server;

import java.net.*;
import javax.swing.JOptionPane;
import java.io.*;
import SisCamp_desktop.*;

public class TCPClient {	
    public void mandarObjeto(Object obj, String hostname) {
        Socket s = null;
        int serverPort = 7000;
                
        try {
            // Conecta ao servidor
            s = new Socket(hostname, serverPort);//cria socket
            System.out.println("SOCKET=" + s);
            s.setReuseAddress(true);//permiti a reutilização do endereço..

            // Cria as streams na ordem correta
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());

            // Escreve o objeto (pode ser Campeonato, Jogador ou Clube) no socket
            out.writeObject(obj);
            out.flush();

            // Lê a resposta do servidor
            String data = in.readUTF();//resposta que o servidor recebeu...
            System.out.println("Received: " + data);
            
            try {
				Object obj1 = in.readObject();
				Tarefas.vetor.addElement((Serializable) obj1);
				Tarefas.vetor.trimToSize();
				
				if (obj instanceof Campeonato) {
              		Campeonato c = (Campeonato) obj;
              		System.out.println("=================================================================================");
              		System.out.println("Campeonato Recebido:");
              		System.out.println("Título: " + c.getTitulo());
              		System.out.println("Modalidade: "+c.getModalidade());
              		System.out.println("Periodo: "+c.getPeriodo());
              		System.out.println("Local: "+c.getLocal());
              		System.out.println("Equipes: "+c.getEquipes());
              		System.out.println("=================================================================================");
              		             		
              	} else if (obj instanceof Jogador) {
              		Jogador j = (Jogador) obj;
              		System.out.println("=================================================================================");
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
              		              		
              	} else if (obj instanceof Clube) {
              		Clube cl = (Clube) obj;
              		System.out.println("=================================================================================");
              		System.out.println("Clube Recebido:");
              		System.out.println("Nome: " + cl.getNome());
              		System.out.println("Local: "+cl.getLocal());
              		System.out.println("Nome do Presidente: "+cl.getPresidente());
              		System.out.println("Treinador Principal: "+cl.getTreinador());
              		System.out.println("=================================================================================");
              		              		
              	}
              	else if (obj instanceof Arbitro) {
              		Arbitro a = (Arbitro) obj;
              		System.out.println("=================================================================================");
              		System.out.println("Arbitro Recebido:");
              		System.out.println("Nome: "+a.getNome());
              		System.out.println("Modalidade: "+a.getModalidade());
              		System.out.println("Idade: "+a.getIdade());
              		System.out.println("Experiencia: "+a.getExperiencia());
              		System.out.println("Provinvia: "+a.getProvincia());
              		System.out.println("=================================================================================");
            		
              	}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Socket: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        } catch (EOFException e) {
            JOptionPane.showMessageDialog(null,"EOF: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Não foi possível contactar o servidor"+"\nIO: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            if (s != null && !s.isClosed()) {
                try {
                    s.close();
                } 
                catch (IOException e) {
                    JOptionPane.showMessageDialog(null,"close:" + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
