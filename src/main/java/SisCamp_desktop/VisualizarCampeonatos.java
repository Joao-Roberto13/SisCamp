package SisCamp_desktop;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class VisualizarCampeonatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private String titulos[] = {"Titulo do Campeonato","Modalidade","Local","Periodo","Quant Equipas",};
	private String [][] tabDados;
	private JScrollPane scrl;

	public VisualizarCampeonatos(Vector vetor) {
		setTitle("--Campeonatos--");
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));	
		setContentPane(contentPane);
		
		tabDados = criarTabela(vetor);
		table = new JTable(tabDados, titulos);
		
		scrl = new JScrollPane(table);
		scrl.setEnabled(false);
		scrl.setBounds(10, 10, 1015, 374);
		contentPane.add(scrl);
		
		table.setRowHeight(25);
		table.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,13));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(32, 136, 203));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setIntercellSpacing(new Dimension(0,0));
		table.setFocusable(false);
		table.setEnabled(false);
		
		// Desabilitar reordenação das colunas...
        table.getTableHeader().setReorderingAllowed(false);
		
		table.addMouseMotionListener(
				new MouseAdapter() { //O mouselistener tem muitos metodos.Mais so iremos precisar de 2 entao pode-se usar mouse adapter...
					public void mouseMoved(MouseEvent e) {
						
						  // Obtenha a linha do evento do mouse
		                int row = table.rowAtPoint(e.getPoint());

		                //Cor de fundo quando mouse estiver a passar nas linhas...
		                table.setSelectionBackground(new Color(232, 57, 95));
		                table.setSelectionForeground(Color.BLACK);
		                table.setRowSelectionInterval(row, row);
					}
				});
			
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(100, 100, 949, 541);	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public String [][]criarTabela(Vector vetor)
	{
		//mudar para vetor o gold
		String [][] x = new String[Campeonato.contC][titulos.length];//tera o numero de linhas que a quantidade no contador... 
		Campeonato c;
		int cont = 0;
		
		for(int i = 0; i<vetor.size(); i++)
		{	
			if(vetor.elementAt(i) instanceof Campeonato)
			{
				c = (Campeonato) vetor.elementAt(i);
				x[cont][0] = c.getTitulo()+"";
				x[cont][1] = c.getModalidade()+"";
				x[cont][2] = c.getLocal()+"";
				x[cont][3] = c.getPeriodo()+"";
				x[cont][4] = c.getEquipes()+"";
				
				cont++;//para colocar na tabela de forma consecutiva...e nao saltar linha...
			}
		}
		return x;
	}
	

}
