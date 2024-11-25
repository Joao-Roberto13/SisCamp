package SisCamp_desktop;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

public class Executavel extends JFrame {
	private Container contain;
	private JButton buttonRegistar, buttonRemover, buttonSair;
	private JLabel labelHora;
	
	public static void main(String[] args) {
		new Executavel();
	}
	
	public Executavel() {
		getContentPane().setBackground(new Color(255, 255, 255));

		new Tarefas().lerFicheiroObjecto();

		setTitle("Basketball Management");
		contain = getContentPane();
		contain.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 284, 592);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		buttonSair = new JButton("Sair");
		buttonSair.setBounds(10, 446, 264, 68);
		panel.add(buttonSair);
		buttonSair.setFocusable(false);
		buttonSair.setMnemonic('s');
		buttonSair.setBackground(new Color(255,185,0));
		buttonSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		buttonSair.addMouseListener(new MouseAdapter() {
					public void mouseExited(MouseEvent e) {
						buttonSair.setBackground(new Color(255,185,0));
					}
					
					public void mouseEntered(MouseEvent e) {
						buttonSair.setBackground(new Color(255,125,0));
					}
				});
		
		buttonRemover = new JButton("Excluir");
		buttonRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog(null, "Introduza o Nome");
				
				if (nome.length() > 3) {
					int i =  new Pesquisa().pesquisar(nome);
					
					if(i<0)
					{
						JOptionPane.showMessageDialog(null, "Item não existe","Nome Invalido!!!!",JOptionPane.ERROR_MESSAGE);
					}
					else
					{				
						Tarefas.vetor.remove(i);
						Tarefas.vetor.trimToSize();
						JOptionPane.showMessageDialog(null, "Item removido com Sucesso :)");
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Nome Invalido","Warning", JOptionPane.INFORMATION_MESSAGE);
				
		}});
		buttonRemover.setBounds(10, 377, 264, 68);
		panel.add(buttonRemover);
		buttonRemover.setFocusable(false);
		buttonRemover.setMnemonic('e');
		buttonRemover.setBackground(new Color(255,185,0));
		
		buttonRemover.addMouseListener(
				new MouseAdapter() {
					public void mouseExited(MouseEvent e) {
						buttonRemover.setBackground(new Color(255,185,0));
					}
					
					public void mouseEntered(MouseEvent e) {
						buttonRemover.setBackground(new Color(255,125,0));
					}
				});
		
		buttonRegistar = new JButton("Cadastrar");
		buttonRegistar.setBounds(10, 308, 264, 68);
		panel.add(buttonRegistar);
		buttonRegistar.setForeground(Color.BLACK);
		buttonRegistar.setFocusable(false);
		buttonRegistar.setMnemonic('c');
		buttonRegistar.setBackground(new Color(255,185,0));
		buttonRegistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new registrar();
			}
		});
		
		buttonRegistar.addMouseListener(
				new MouseAdapter() {
					public void mouseExited(MouseEvent e) {
						buttonRegistar.setBackground(new Color(255,185,0));
					}
					
					public void mouseEntered(MouseEvent e) {
						buttonRegistar.setBackground(new Color(255,125,0));
					}
				});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(58, 111, 161, 25);
		panel.add(separator);
		
		labelHora = new JLabel("00:00 PM");
		labelHora.setHorizontalAlignment(SwingConstants.CENTER);
		labelHora.setBounds(10, 69, 264, 56);
		panel.add(labelHora);
		labelHora.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelHora.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(0, -16, 284, 556);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\jring\\.vscode\\P.O.O\\sd_Projecet_Z_Distribuido\\menu.jpeg"));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\jring\\.vscode\\P.O.O\\sd_Projecet_Z_Distribuido\\pane.jpg"));
		lblNewLabel_2.setBounds(300, 11, 1008, 525);
		getContentPane().add(lblNewLabel_2);
		
				
		JMenuBar menuBar = new JMenuBar();
		
		
		JMenu menuFiles = new JMenu("Files");
		menuFiles.setFocusable(false);
		menuFiles.setMnemonic('f');
		JMenuItem itemRefresh = new JMenuItem("Refresh");
		itemRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Done","Confirm",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		itemRefresh.setMnemonic('e');
		menuFiles.add(itemRefresh);
		
		JMenuItem itemSair = new JMenuItem("Sair");
		itemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Volte Sempre!","Confirm",JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		itemSair.setMnemonic('s');
		menuFiles.add(itemSair);
		menuBar.add(menuFiles);
		
		JMenu menuVisualizar = new JMenu("Visualizar");
		menuVisualizar.setFocusable(false);
		menuVisualizar.setMnemonic('v');
		
		JMenuItem itemCampeonatos = new JMenuItem("Campeonatos");
		itemCampeonatos.setMnemonic('c');
		itemCampeonatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VisualizarCampeonatos(Tarefas.vetor);
			}
		});
		menuVisualizar.add(itemCampeonatos);
		
		JMenuItem itemJogadores = new JMenuItem("Jogadores");
		itemJogadores.setMnemonic('j');
		itemJogadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VisualizarJogadores(Tarefas.vetor);
			}
		});
		menuVisualizar.add(itemJogadores);
		
		JMenuItem itemClubes = new JMenuItem("Clubes");
		itemClubes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VisualizarClubes(Tarefas.vetor);
			}
		});
		itemClubes.setMnemonic('b');
		menuVisualizar.add(itemClubes);
		
		JMenuItem itemArbitros = new JMenuItem("Arbitros");
		itemArbitros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VisualizarArbitro(Tarefas.vetor);
			}
		});
		itemArbitros.setMnemonic('a');
		menuVisualizar.add(itemArbitros);
		menuBar.add(menuVisualizar);
		setJMenuBar(menuBar);
		
		relogio();
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1329, 608);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void relogio() {
		//essa thread para executar o programa e essa parte da hora em threads separadas sem interroper um ao outro...
	    Thread threadRelogio = new Thread(() -> {
	        while (true) {
	            Calendar cal = Calendar.getInstance();//Pega a data e hora atual

	            //Formatação da hora 24h....
	            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	            Date hora = cal.getTime();
	            String time = sdf.format(hora);
	            
	            labelHora.setText(time);
	            
	            try
	            {
	                Thread.sleep(1000); // Aguarda 1 segundo antes de atualizar novamente...A cada 1000 milisegundo atualiza...
	            } catch (InterruptedException e) {JOptionPane.showMessageDialog(null, e.getMessage());}
	        }
	    });
	    threadRelogio.start();
	}
}