package Bounty;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;


public class RelogioGraph extends JFrame {

	private JPanel contentPane;
	private JTextField textInsercao;
	private JTextField textDone;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelogioGraph frame = new RelogioGraph();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//for the commit delete after
	/**
	 * Create the frame.
	 */
	public RelogioGraph() {
		/*Janela*/
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**/

		/*Desenha Elementos Fixos
		 * e
		 *Adiciona Elementos que vão actualizar*/
		desenhaElementos();

		JPanel ponteirosLisboa = desenhaPonteirosLisboa();
		contentPane.add(ponteirosLisboa);

		JLabel relogioDigitalFuso = desenhaRelogioDigitalFuso();
		contentPane.add(relogioDigitalFuso);

		JLabel relogioDigitalLisboa = desenhaRelogioDigitalLisboa();
		contentPane.add(relogioDigitalLisboa);

		JComboBox fusoSelector = fillFusoSelectorOptions();
		contentPane.add(fusoSelector);
		/**/

		/*Actualiza Ponteiros
		 * e
		 * JLabels*/
		ActionListener updateClock = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//...Tarefas a executar...
				relogioDigitalLisboa.setText(BuscaHora.getRelogio());
				ponteirosLisboa.repaint();
				String nomeDaCidade;
				nomeDaCidade = fusoSelector.getSelectedItem().toString();
				relogioDigitalFuso.setText(BuscaHora.getRelogioFuso(nomeDaCidade, FusosHorarios.fusosHorarios));
			}
		};
		Timer t = new Timer(1000,updateClock);
		t.start();
		/**/


		JTabbedPane tabTarefas = new JTabbedPane(JTabbedPane.TOP);
		tabTarefas.setBounds(24, 279, 600, 125);
		contentPane.add(tabTarefas);

		JPanel panelTarefas = new JPanel();
		tabTarefas.addTab("Tarefas", null, panelTarefas, null);
		panelTarefas.setLayout(null);

		JCheckBox chbxValidar = new JCheckBox("");
		chbxValidar.setBounds(6, 10, 21, 23);
		panelTarefas.add(chbxValidar);

		// teste
		ArrayList<Tarefas> tarefas = new ArrayList<Tarefas>();
		tarefas.add(new Tarefas(1,"Teste",false));


		textInsercao = new JTextField();
		textInsercao.setBounds(33, 10, 341, 20);
		panelTarefas.add(textInsercao);
		textInsercao.setColumns(10);

		JPanel panelDone = new JPanel();
		tabTarefas.addTab("Done", null, panelDone, null);
		panelDone.setLayout(null);

		JButton btnRemove = new JButton("");
		btnRemove.setIcon(new ImageIcon(RelogioGraph.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-error.png")));
		btnRemove.setBounds(10, 0, 15, 17);
		panelDone.add(btnRemove);

		textDone = new JTextField();
		textDone.setEditable(false);
		textDone.setBounds(28, 0, 346, 20);
		panelDone.add(textDone);
		textDone.setColumns(10);

		textDone.setText(tarefas.get(0).getTarefa());







	}



	public void adicionaBotaoSobre(){
		JButton btnSobre = new JButton("Sobre");
		btnSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SobrePopup.main(null);
			}
		});
		btnSobre.setBounds(546, 11, 89, 23);
		btnSobre.setBounds(546, 11, 89, 23);
		contentPane.add(btnSobre);
	}


	public void desenhaElementos(){
		JLabel lblLisboa = new JLabel("Lisboa");
		lblLisboa.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLisboa.setHorizontalAlignment(SwingConstants.CENTER);
		lblLisboa.setBounds(43, 15, 114, 23);
		contentPane.add(lblLisboa);

		JPanel relogioAnalogPanel = new JPanel(){
			@Override
			//desenha o relogio (ponteiros sao desenhados no Jpanel ponteiros)
			protected void paintComponent(Graphics relogioAnalog) {
				super.paintComponent(relogioAnalog);

				Graphics2D g2d = (Graphics2D) relogioAnalog;
				//Circulo
				g2d.drawOval(0,0,100,100);
				//Tracinhos das Horas
				g2d.drawLine(50, 0, 50, 5); //12
				g2d.drawLine(95, 50, 100, 50); //3
				g2d.drawLine(50, 95, 50, 100); //6
				g2d.drawLine(0, 50, 5, 50); //9


			}
		};
		relogioAnalogPanel.setBounds(50, 127, 101, 101);
		relogioAnalogPanel.setLayout(null);

		JLabel hora12 = new JLabel("12");
		hora12.setBounds(43, 8, 22, 14);
		relogioAnalogPanel.add(hora12);

		JLabel hora3 = new JLabel("3");
		hora3.setBounds(85, 43, 12, 14);
		relogioAnalogPanel.add(hora3);

		JLabel hora9 = new JLabel("9");
		hora9.setBounds(10, 43, 22, 14);
		relogioAnalogPanel.add(hora9);

		JLabel hora6 = new JLabel("6");
		hora6.setBounds(48, 75, 12, 14);
		relogioAnalogPanel.add(hora6);
		relogioAnalogPanel.setOpaque(false);
		contentPane.add(relogioAnalogPanel);
		adicionaBotaoSobre();
	}

	public JLabel desenhaRelogioDigitalLisboa(){
		JLabel relogioDigitalLisboa = new JLabel(BuscaHora.getRelogio());
		relogioDigitalLisboa.setHorizontalAlignment(SwingConstants.CENTER);
		relogioDigitalLisboa.setFont(new Font("Tahoma", Font.BOLD, 40));
		relogioDigitalLisboa.setBounds(10, 48, 187, 88);
		return relogioDigitalLisboa;
	}

	public JLabel desenhaRelogioDigitalFuso(){
		JLabel relogioDigitalFuso = new JLabel(BuscaHora.getRelogio());
		relogioDigitalFuso.setHorizontalAlignment(SwingConstants.CENTER);
		relogioDigitalFuso.setFont(new Font("Tahoma", Font.BOLD, 40));
		relogioDigitalFuso.setBounds(261, 48, 187, 88);
		return relogioDigitalFuso;
	}


	public JPanel desenhaPonteirosLisboa(){
		JPanel ponteirosLisboa = new JPanel(){
			@Override
			//Desenha os ponteiros
			protected void paintComponent(Graphics relogioAnalog) {
				super.paintComponent(relogioAnalog);

				Graphics2D g2d = (Graphics2D) relogioAnalog;
				int grau;

				/* Função getCoord
				 * Ponteiros.getCoordPonteiro(graus, raio, centroX, centroY)
				 * */

				/*draw Horas*/
				grau = Ponteiros.getGrausFromHora();
				g2d.drawLine(50, 50, Ponteiros.getCoordXfromGraus(grau, 20, 50), Ponteiros.getCoordYfromGraus(grau, 25, -50));

				/*draw Minutos*/
				grau = Ponteiros.getGrausFromMinuto();
				g2d.drawLine(50, 50,Ponteiros.getCoordXfromGraus(grau, 35, 50),(Ponteiros.getCoordYfromGraus(grau, 35, -50)));

				/*draw Segundos*/
				grau= Ponteiros.getGrausFromSegundo();
				g2d.drawLine(50, 50,Ponteiros.getCoordXfromGraus(grau, 40, 50),(Ponteiros.getCoordYfromGraus(grau, 40, -50)));

			}
		};
		ponteirosLisboa.setBounds(51, 128, 100, 100);
		ponteirosLisboa.setOpaque(false);
		return ponteirosLisboa;
	}

	public JComboBox<String> fillFusoSelectorOptions(){
		JComboBox<String> fusoSelector = new JComboBox<String>();
		fusoSelector.setBounds(290, 17, 143, 20);

		FusosHorarios.listaFusos();


		for (int i = 0; i < FusosHorarios.fusosHorarios.size();i++){
			fusoSelector.addItem(FusosHorarios.fusosHorarios.get(i).cidade);
		}
		return fusoSelector;
	}
}
