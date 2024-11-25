package SisCamp_desktop;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registrar extends JFrame {

	private String [] titulos = {"Campeonato" , "Clubes", "Jogadores", "Arbitros"},
	categoria = {"Infantil", "Junior", "Senior"},
	provincia = {"Maputo", "Gaza", "Inhambane", "Zambézia", "Manica", "Sofala","Niassa", "Nampula", "Tete","Cabo Delgado"};
	private JPanel contentPane, panelCampeonatos, panelClubes, panelJogadores, panelArbitros;
	private JTabbedPane tabbedPane;
	private JTextField fieldTitulo,fieldModalidade,fieldLocal,fieldPeriodo;
	private JLabel lblNewLabel_2,lblNewLabel_3,lblNewLabel_4,lblNewLabel_5,lblNewLabel_6,lblNewLabel_7,lblNewLabel_8,lblNewLabel_10,lblNewLabel_12,
			lblNewLabel_12_1,lblNewLabel_12_2,lblNewLabel_12_3_1,lblNewLabel_12_3,lblNewLabel_11,lblNewLabel_11_2,lblNewLabel_9;
	private JButton buttonCampeonato,buttonClubes, buttonJogadores,buttonArbitro;
	private JTextField fieldJogador,fieldPresidenteJ,fieldModalidadeA,fieldTreinador,fieldPresidente,fieldLocalClube,fieldNomeClube,fieldArbitro,fieldModalidadeJ;
	private JComboBox comboBox_1,comboBox;
	private JSpinner spinnerEquipas;
	private Tarefas t;
	
	public static void main(String[] args) {
		new registrar();
	}

	public registrar() { 
		t = new Tarefas();
		setTitle("Registrar");
				
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Campeonato...
		panelCampeonatos = new JPanel();
		panelClubes = new JPanel();	

		tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(10, 10, 876, 461);
		tabbedPane.setFocusable(false);
		tabbedPane.add(titulos[0], panelCampeonatos);
		panelCampeonatos.setLayout(null);
		
		fieldTitulo = new JTextField();
		fieldTitulo.setBounds(104, 102, 248, 25);
		panelCampeonatos.add(fieldTitulo);
		fieldTitulo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Titulo do Campeonato");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(104, 70, 258, 26);
		panelCampeonatos.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Modalidade");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(104, 157, 154, 19);
		panelCampeonatos.add(lblNewLabel_1);
		
		fieldModalidade = new JTextField();
		fieldModalidade.setBounds(104, 185, 248, 25);
		panelCampeonatos.add(fieldModalidade);
		fieldModalidade.setColumns(10);
		
		fieldLocal = new JTextField();
		fieldLocal.setBounds(104, 272, 689, 36);
		panelCampeonatos.add(fieldLocal);
		fieldLocal.setColumns(10);
		
		fieldPeriodo = new JTextField();
		fieldPeriodo.setBounds(545, 102, 248, 25);
		panelCampeonatos.add(fieldPeriodo);
		fieldPeriodo.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Local de Realização");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(104, 246, 177, 19);
		panelCampeonatos.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Número de Equipas");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(545, 159, 177, 17);
		panelCampeonatos.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Período da Realização");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(545, 76, 192, 14);
		panelCampeonatos.add(lblNewLabel_4);
		
		spinnerEquipas = new JSpinner(new SpinnerNumberModel(15, 10, 30, 1));// Valor inicial = 15, mínimo = 10, máximo = 30, incremento = 1
		spinnerEquipas.setBounds(545, 187, 104, 20);
		panelCampeonatos.add(spinnerEquipas);
		tabbedPane.add(titulos[1], panelClubes);
		panelClubes.setLayout(null);
		
		buttonCampeonato = new JButton("Cadastrar");
		buttonCampeonato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = fieldTitulo.getText();
				String modalidade = fieldModalidade.getText();
				String local = fieldLocal.getText();
				String periodo = fieldPeriodo.getText();
				int equipas = Integer.parseInt(spinnerEquipas.getValue()+""); 
				
				if (titulo.length() < 3 || modalidade.equals("") || local.length() < 3 || periodo.length() < 3)
                    JOptionPane.showMessageDialog(null ,"Certifique-se de ter preenchido corretamente","Error",JOptionPane.ERROR_MESSAGE);
				else				
					t.mandarCampeonato(titulo, modalidade, local, periodo, equipas);
				//Campeonato c = new Campeonato(titulo,modalidade, local, periodo, equipas);
				//new TCPClient().mandarObjeto(c, "localhost");
			}
		});
		buttonCampeonato.setMnemonic('c');
		buttonCampeonato.setBounds(333, 358, 209, 45);
		buttonCampeonato.setFocusable(false);
		panelCampeonatos.add(buttonCampeonato);
		
		//Clube
		lblNewLabel_5 = new JLabel("Nome do Clube");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(82, 41, 258, 26);
		panelClubes.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Localização");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(523, 47, 192, 14);
		panelClubes.add(lblNewLabel_6);
		
		fieldLocalClube = new JTextField();
		fieldLocalClube.setColumns(10);
		fieldLocalClube.setBounds(523, 73, 248, 25);
		panelClubes.add(fieldLocalClube);
		
		fieldNomeClube = new JTextField();
		fieldNomeClube.setColumns(10);
		fieldNomeClube.setBounds(82, 73, 248, 25);
		panelClubes.add(fieldNomeClube);
		
		lblNewLabel_7 = new JLabel("Nome do Presidente");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(82, 128, 154, 19);
		panelClubes.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Treinador Principal");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(523, 130, 177, 17);
		panelClubes.add(lblNewLabel_8);
		
		fieldTreinador = new JTextField();
		fieldTreinador.setColumns(10);
		fieldTreinador.setBounds(523, 156, 248, 25);
		panelClubes.add(fieldTreinador);
		
		fieldPresidente = new JTextField();
		fieldPresidente.setColumns(10);
		fieldPresidente.setBounds(82, 156, 248, 25);
		panelClubes.add(fieldPresidente);
		
		buttonClubes = new JButton("Cadastrar");
		buttonClubes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = fieldNomeClube.getText()+"";
				String local = fieldLocalClube.getText()+"";
				String presidente = fieldPresidente.getText()+"";
				String treinador = fieldTreinador.getText()+"";
				
				if (nome.length() < 3 || local.length() < 3 || presidente.length() < 3 || treinador.length() < 3)
                    JOptionPane.showMessageDialog(null ,"Certifique-se de ter preenchido corretamente","Error",JOptionPane.ERROR_MESSAGE);
				else		
					t.mandarClube(nome, local, presidente, treinador);
			}
		});
		buttonClubes.setMnemonic('c');
		buttonClubes.setBounds(311, 329, 209, 45);
		buttonClubes.setFocusable(false);
		panelClubes.add(buttonClubes);
		contentPane.add(tabbedPane);
	
		//Jogadores...
		panelJogadores = new JPanel();
		tabbedPane.add(titulos[2], panelJogadores);
		panelJogadores.setLayout(null);
		
		
		JSpinner spinnerMarcas = new JSpinner(new SpinnerNumberModel(1, 0, 1000, 1));// Valor inicial = 14, mínimo = 13, máximo = 100, incremento = 1);
		spinnerMarcas.setBounds(471, 167, 81, 20);
		panelJogadores.add(spinnerMarcas);
		
		JSpinner spinnerAnosClube = new JSpinner(new SpinnerNumberModel(1, 1, 40, 1));// Valor inicial = 1, mínimo = 1, máximo = 40, incremento = 1);
		spinnerAnosClube.setBounds(683, 101, 81, 20);
		panelJogadores.add(spinnerAnosClube);
		
		JSpinner spinnerIdade = new JSpinner(new SpinnerNumberModel(16, 13, 50, 1));
		spinnerIdade.setBounds(471, 101, 81, 20);
		panelJogadores.add(spinnerIdade);
		
		lblNewLabel_9 = new JLabel("Nome do Jogador");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(53, 67, 258, 26);
		panelJogadores.add(lblNewLabel_9);
		
		fieldJogador = new JTextField();
		fieldJogador.setColumns(10);
		fieldJogador.setBounds(53, 99, 248, 25);
		panelJogadores.add(fieldJogador);
		
		fieldPresidenteJ = new JTextField();
		fieldPresidenteJ.setColumns(10);
		fieldPresidenteJ.setBounds(53, 165, 248, 25);
		panelJogadores.add(fieldPresidenteJ);
		
		lblNewLabel_11 = new JLabel("Nome do Presidente");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(53, 135, 154, 19);
		panelJogadores.add(lblNewLabel_11);
		
		
		comboBox = new JComboBox(categoria);
		comboBox.setBounds(53, 226, 248, 26);
		comboBox.setSelectedIndex(-1);
		comboBox.setFocusable(false);
		panelJogadores.add(comboBox);
		
		lblNewLabel_10 = new JLabel("Categoria");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(53, 204, 125, 14);
		panelJogadores.add(lblNewLabel_10);
		
		JSpinner spinnerNacionais = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
		spinnerNacionais.setBounds(683, 167, 81, 20);
		panelJogadores.add(spinnerNacionais);
		
		lblNewLabel_12 = new JLabel("Idade");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(471, 73, 54, 14);
		panelJogadores.add(lblNewLabel_12);
		
		lblNewLabel_12_1 = new JLabel("Marcas Registadas");
		lblNewLabel_12_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_12_1.setBounds(471, 142, 99, 14);
		panelJogadores.add(lblNewLabel_12_1);
		
		lblNewLabel_12_2 = new JLabel("Anos no Clube");
		lblNewLabel_12_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_12_2.setBounds(683, 73, 91, 14);
		panelJogadores.add(lblNewLabel_12_2);
		
		lblNewLabel_12_3 = new JLabel("Jogos Nacionais");
		lblNewLabel_12_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_12_3.setBounds(683, 142, 81, 14);
		panelJogadores.add(lblNewLabel_12_3);
		
		lblNewLabel_12_3_1 = new JLabel("Jogos Internacionais");
		lblNewLabel_12_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_12_3_1.setBounds(471, 207, 99, 14);
		panelJogadores.add(lblNewLabel_12_3_1);
		
		JSpinner spinnerInternacionais = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
		spinnerInternacionais.setBounds(471, 232, 81, 20);
		panelJogadores.add(spinnerInternacionais);
		
		fieldModalidadeJ = new JTextField();
		fieldModalidadeJ.setColumns(10);
		fieldModalidadeJ.setBounds(53, 287, 248, 25);
		panelJogadores.add(fieldModalidadeJ);
		
		JLabel lblNewLabel_13 = new JLabel("Modalidade");
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_13.setBounds(53, 272, 91, 14);
		panelJogadores.add(lblNewLabel_13);
		panelArbitros = new JPanel();
		tabbedPane.add(titulos[3], panelArbitros);
		panelArbitros.setLayout(null);
		
		JLabel lblNewLabel_12_4 = new JLabel("Idade");
		lblNewLabel_12_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_12_4.setBounds(558, 55, 54, 14);
		panelArbitros.add(lblNewLabel_12_4);
		
		JSpinner spinnerArbitroIdade = new JSpinner(new SpinnerNumberModel(1, 1, 50, 1));
		spinnerArbitroIdade.setBounds(558, 83, 81, 20);
		panelArbitros.add(spinnerArbitroIdade);
		
		fieldArbitro = new JTextField();
		fieldArbitro.setColumns(10);
		fieldArbitro.setBounds(140, 81, 248, 25);
		panelArbitros.add(fieldArbitro);
		
		buttonJogadores = new JButton("Cadastrar");
		buttonJogadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = fieldJogador.getText();
				int idade = Integer.parseInt(spinnerIdade.getValue()+"");
				int anosClube = Integer.parseInt(spinnerAnosClube.getValue()+"");
				String modalidade = fieldModalidadeJ.getText();
				String categoria = comboBox.getSelectedItem()+"";
				int marcasRegistadas = Integer.parseInt(spinnerMarcas.getValue()+"");
				int jogosI = Integer.parseInt(spinnerInternacionais.getValue()+"");
				int jogosN = Integer.parseInt(spinnerNacionais.getValue()+"");
				
				if(nome.length() < 3 || modalidade.length() < 3 || categoria.length() < 3)
                    JOptionPane.showMessageDialog(null ,"Certifique-se de ter preenchido corretamente","Error",JOptionPane.ERROR_MESSAGE);
				else
					t.mandarJogador(nome, idade, anosClube, modalidade, categoria, marcasRegistadas, jogosI, jogosN); 
			}});	
		buttonJogadores.setMnemonic('c');
		buttonJogadores.setBounds(316, 339, 209, 45);
		buttonJogadores.setFocusable(false);
		panelJogadores.add(buttonJogadores);
		
		//Arbitro...
		JLabel lblNewLabel_9_1 = new JLabel("Nome do Arbitro");
		lblNewLabel_9_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_9_1.setBounds(140, 49, 258, 26);
		panelArbitros.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_11_1 = new JLabel("Modalidade");
		lblNewLabel_11_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_11_1.setBounds(140, 117, 154, 19);
		panelArbitros.add(lblNewLabel_11_1);
		
		fieldModalidadeA = new JTextField();
		fieldModalidadeA.setColumns(10);
		fieldModalidadeA.setBounds(140, 147, 248, 25);
		panelArbitros.add(fieldModalidadeA);
		
		JSpinner spinnerExperiencia = new JSpinner(new SpinnerNumberModel(1, 1, 40, 1));
		spinnerExperiencia.setBounds(558, 149, 81, 20);
		panelArbitros.add(spinnerExperiencia);
		
		JLabel lblNewLabel_12_1_1 = new JLabel("Anos de Experiência");
		lblNewLabel_12_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_12_1_1.setBounds(558, 124, 107, 14);
		panelArbitros.add(lblNewLabel_12_1_1);
		
		lblNewLabel_11_2 = new JLabel("Província Morada");
		lblNewLabel_11_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_11_2.setBounds(138, 187, 154, 19);
		panelArbitros.add(lblNewLabel_11_2);
		
		comboBox_1 = new JComboBox(provincia);
		comboBox_1.setBounds(140, 209, 248, 33);
		comboBox.setSelectedIndex(-1);
		comboBox.setFocusable(false);
		panelArbitros.add(comboBox_1);
		
		buttonArbitro = new JButton("Cadastrar");
		buttonArbitro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = fieldArbitro.getText();
				int idade = Integer.parseInt(spinnerArbitroIdade.getValue()+"");
				String modalidade = fieldModalidadeA.getText();
				int experiencia = Integer.parseInt(spinnerExperiencia.getValue()+"");
				String provincia = comboBox_1.getSelectedItem()+"";
				
				if (nome.length() < 3 || modalidade.length() < 3 || provincia.length() < 3)
                    JOptionPane.showMessageDialog(null ,"Certifique-se de ter preenchido corretamente","Error",JOptionPane.ERROR_MESSAGE);
				else
					t.mandarArbitror(nome, idade, modalidade, experiencia, provincia);
			}
		});
		buttonArbitro.setMnemonic('c');
		buttonArbitro.setBounds(298, 302, 209, 45);
		buttonArbitro.setFocusable(false);
		panelArbitros.add(buttonArbitro);
				
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setBounds(100, 100, 909, 517);
	}
}
