package SisCamp_desktop;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VisualizarClubes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private String titulos[] = {"Nome", "Local", "Presidente", "Treinador"};
	private String [][] tabDados;
	private JScrollPane scrl;
	private JPanel contentPane;


	public VisualizarClubes(Vector vetor) {
		setTitle("--Clube--");
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1084, 541);	
	}
	
	public String [][] criarTabela(Vector vetor) 
	{
		//mudar para vetor o gold
				String [][] x = new String[Clube.contC][titulos.length];//tera o numero de linhas que a quantidade no contador...-1000 porque é o id do jogador 1001-1000 = 1 logo temos 1 player 
				Clube c;
				int cont = 0;

				vetor.trimToSize();
				for(int i = 0; i<vetor.size(); i++)
				{					
					if(vetor.elementAt(i) instanceof Clube)
					{
						c = (Clube) vetor.elementAt(i);
						x[cont][0] = c.getNome();
						x[cont][1] = c.getLocal()+"";
						x[cont][2] = c.getPresidente()+"";
						x[cont][3] = c.getTreinador();
													
						cont++;//para colocar na tabela de forma consecutiva...e nao saltar linha...
					}
				}
				return x;
	}

}
