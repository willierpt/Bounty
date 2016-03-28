package Bounty;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;


public class RelogioGraph extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDone;
	private JTextField textTarefa2;
	private JTextField textTarefa3;
	private JTextField textDone1;
	private JTextField textDone2;
	private JTextField textTarefa1;
	private JTextField textTarefa4;
	private JTextField textTarefa5;
	private JTextField textTarefa6;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Tarefas.loadTarefas();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
	/**
	 * Create the frame.
	 */
	public RelogioGraph() {
		
		setTitle("Project: Bounty");
		/*Janela*/
		Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Bounty/resources/iconrelogio2.jpg"));
	    setIconImage(image);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**/

		/*Desenha Elementos Fixos
		 * e
		 *Adiciona Elementos que v�o actualizar*/
		desenhaElementos();
		desenhaPainelTarefas();

		JPanel ponteirosLisboa = desenhaPonteirosLisboa();
		JLabel relogioDigitalFuso = desenhaRelogioDigitalFuso();
		JLabel relogioDigitalLisboa = desenhaRelogioDigitalLisboa();
		JComboBox fusoSelector = fillFusoSelectorOptions();
		JPanel ponteirosFuso = desenhaPonteirosFuso(fusoSelector);
		contentPane.add(ponteirosLisboa);
		contentPane.add(relogioDigitalFuso);
		contentPane.add(relogioDigitalLisboa);
		contentPane.add(fusoSelector);
		contentPane.add(ponteirosFuso);

		/**/

		/**
		 * Actualiza Ponteiros
		 * e
		 * JLabels
		 */
		ActionListener updateClock = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//...Tarefas a executar...
				relogioDigitalLisboa.setText(BuscaHora.getRelogio());
				ponteirosLisboa.repaint();
				ponteirosFuso.repaint();
				String nomeDaCidade;
				nomeDaCidade = fusoSelector.getSelectedItem().toString();
				relogioDigitalFuso.setText(BuscaHora.getRelogioFuso(nomeDaCidade, FusosHorarios.fusosHorarios));
			}
		};
		Timer t = new Timer(1000,updateClock);
		t.start();
		/**/
		
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

	public void desenhaPainelTarefas(){
		/*Elementos da lista de tarefas*/
		JTabbedPane tabTarefas = new JTabbedPane(JTabbedPane.TOP);
		tabTarefas.setBounds(23, 249, 600, 187);
		contentPane.add(tabTarefas);

		JPanel panelTarefas = new JPanel();
		tabTarefas.addTab("Tarefas", null, panelTarefas, null);
		panelTarefas.setLayout(null);
		
		/*Conteudos panelTarefas*/
		//Bot�o Save
		JButton btnSave = new JButton("");
		btnSave.setToolTipText("Gravar para o Ficheiro");
		btnSave.setIcon(new ImageIcon(RelogioGraph.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		btnSave.setBounds(527, 38, 58, 23);
		panelTarefas.add(btnSave);	
		//Bot�o Load
		JButton btnLoad = new JButton("");
		btnLoad.setToolTipText("Carregar Tarefas Gravadas");
		btnLoad.setIcon(new ImageIcon(RelogioGraph.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Outdent.png")));
		btnLoad.setBounds(527, 72, 58, 23);
		panelTarefas.add(btnLoad);

		//Campos de Texto
		textTarefa1 = new JTextField();
		textTarefa2 = new JTextField();
		textTarefa3 = new JTextField();
		textTarefa4 = new JTextField();
		textTarefa5 = new JTextField();
		textTarefa6 = new JTextField();
		textTarefa1.setBounds(32, 11, 485, 20);
		panelTarefas.add(textTarefa1);
		textTarefa2.setBounds(32, 36, 484, 20);
		panelTarefas.add(textTarefa2);
		textTarefa3.setBounds(32, 61, 484, 20);
		panelTarefas.add(textTarefa3);	
		textTarefa4.setBounds(32, 86, 484, 20);
		panelTarefas.add(textTarefa4);
		textTarefa5.setBounds(32, 111, 484, 20);
		panelTarefas.add(textTarefa5);
		textTarefa6.setBounds(32, 136, 484, 20);
		panelTarefas.add(textTarefa6);
		
		//Checkboxes
		JCheckBox chbxValidar1 = new JCheckBox("");
		JCheckBox chbxValidar2 = new JCheckBox("");
		JCheckBox chbxValidar3 = new JCheckBox("");
		JCheckBox chbxValidar4 = new JCheckBox("");
		JCheckBox chbxValidar5 = new JCheckBox("");
		JCheckBox chbxValidar6 = new JCheckBox("");
		chbxValidar1.setBounds(7, 10, 21, 23);
		panelTarefas.add(chbxValidar1);	
		chbxValidar2.setBounds(7, 36, 21, 23);
		panelTarefas.add(chbxValidar2);
		chbxValidar3.setBounds(7, 60, 21, 23);
		panelTarefas.add(chbxValidar3);
		chbxValidar4.setBounds(7, 83, 21, 23);
		panelTarefas.add(chbxValidar4);
		chbxValidar5.setBounds(7, 108, 22, 23);
		panelTarefas.add(chbxValidar5);
		chbxValidar6.setBounds(7, 133, 21, 23);
		panelTarefas.add(chbxValidar6);
		
		JScrollPane tarefasConcluidas = new JScrollPane();
		tabTarefas.addTab("Concluido", null, tarefasConcluidas, null);
		
		JLabel areaTextoTarefasConcluidas = new JLabel();
		tarefasConcluidas.setViewportView(areaTextoTarefasConcluidas);
		areaTextoTarefasConcluidas.setText(fillTarefasDone());
	
		//First Load
		fillTextTarefasFromSave();

		
		//A��es
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saveTarefastoFile();
			}
		});
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fillTextTarefasFromSave();
			}
		});
		chbxValidar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TarefasConcluidas.adicionaTarefa(textTarefa1.getText());
				textTarefa1.setText("");
				saveTarefastoFile();
				chbxValidar1.setSelected(false);
			}
		});
		chbxValidar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TarefasConcluidas.adicionaTarefa(textTarefa2.getText());
				textTarefa2.setText("");
				saveTarefastoFile();
				chbxValidar2.setSelected(false);
			}
		});
		chbxValidar3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TarefasConcluidas.adicionaTarefa(textTarefa3.getText());
				textTarefa3.setText("");
				saveTarefastoFile();
				chbxValidar3.setSelected(false);
			}
		});
		chbxValidar4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TarefasConcluidas.adicionaTarefa(textTarefa4.getText());
				textTarefa4.setText("");
				saveTarefastoFile();
				chbxValidar4.setSelected(false);
			}
		});
		chbxValidar5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TarefasConcluidas.adicionaTarefa(textTarefa5.getText());
				textTarefa5.setText("");
				saveTarefastoFile();
				chbxValidar5.setSelected(false);
			}
		});
		chbxValidar6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TarefasConcluidas.adicionaTarefa(textTarefa6.getText());
				textTarefa6.setText("");
				saveTarefastoFile();
				chbxValidar6.setSelected(false);
			}
		});
		panelTarefas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				areaTextoTarefasConcluidas.setText(fillTarefasDone());
			}
		});
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


		JLabel hora3 = new JLabel("3");
		hora3.setBounds(85, 43, 12, 14);


		JLabel hora9 = new JLabel("9");
		hora9.setBounds(10, 43, 22, 14);


		JLabel hora6 = new JLabel("6");
		hora6.setBounds(48, 75, 12, 14);

		relogioAnalogPanel.setOpaque(false);
		relogioAnalogPanel.add(hora12);
		relogioAnalogPanel.add(hora3);
		relogioAnalogPanel.add(hora9);
		relogioAnalogPanel.add(hora6);
		contentPane.add(relogioAnalogPanel);
		adicionaBotaoSobre();

		JPanel relogioAnalogFuso = new JPanel(){
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
		relogioAnalogFuso.setBounds(307, 127, 101, 101);
		relogioAnalogFuso.setLayout(null);
		relogioAnalogFuso.setOpaque(false);

		JLabel hora12f = new JLabel("12");
		hora12f.setBounds(43, 8, 22, 14);


		JLabel hora3f = new JLabel("3");
		hora3f.setBounds(85, 43, 12, 14);


		JLabel hora9f = new JLabel("9");
		hora9f.setBounds(10, 43, 22, 14);


		JLabel hora6f = new JLabel("6");
		hora6f.setBounds(48, 75, 12, 14);

		relogioAnalogFuso.add(hora12f);
		relogioAnalogFuso.add(hora3f);
		relogioAnalogFuso.add(hora9f);
		relogioAnalogFuso.add(hora6f);
		contentPane.add(relogioAnalogFuso);
		
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


	public JPanel desenhaPonteirosFuso(JComboBox fusoSelector){
		JPanel ponteirosfuso = new JPanel(){
			@Override
			//Desenha os ponteiros
			protected void paintComponent(Graphics relogioAnalog) {
				super.paintComponent(relogioAnalog);

				Graphics2D g2d = (Graphics2D) relogioAnalog;
				int grau;

				/* Fun��o getCoord
				 * Ponteiros.getCoordPonteiro(graus, raio, centroX, centroY)
				 * */

				/*draw Horas*/
				grau = Ponteiros.getGrausFromHoraFuso(fusoSelector.getSelectedItem().toString(), FusosHorarios.fusosHorarios);

				g2d.drawLine(50, 50, Ponteiros.getCoordXfromGraus(grau, 20, 50), Ponteiros.getCoordYfromGraus(grau, 25, -50));

				/*draw Minutos*/
				grau = Ponteiros.getGrausFromMinuto();
				g2d.drawLine(50, 50,Ponteiros.getCoordXfromGraus(grau, 35, 50),(Ponteiros.getCoordYfromGraus(grau, 35, -50)));

				/*draw Segundos*/
				grau= Ponteiros.getGrausFromSegundo();
				g2d.drawLine(50, 50,Ponteiros.getCoordXfromGraus(grau, 40, 50),(Ponteiros.getCoordYfromGraus(grau, 40, -50)));

			}
		};
		ponteirosfuso.setBounds(307, 128, 100, 100);
		ponteirosfuso.setOpaque(false);
		return ponteirosfuso;
	}

	public JPanel desenhaPonteirosLisboa(){
		JPanel ponteirosLisboa = new JPanel(){
			@Override
			//Desenha os ponteiros
			protected void paintComponent(Graphics relogioAnalog) {
				super.paintComponent(relogioAnalog);

				Graphics2D g2d = (Graphics2D) relogioAnalog;
				int grau;

				/* Fun��o getCoord
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
	
	private String fillTarefasDone(){
		try {
			TarefasConcluidas.loadTarefas();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = "<html>";
		for (int i=0;i<TarefasConcluidas.tarefasConcluidas.size();i++){
			s += TarefasConcluidas.getTarefa(i) + "<br>";
		}
		s+="</html>";
		return s;
	}
	
	private void saveTarefastoFile(){
		Tarefas.adicionaTarefa(textTarefa1.getText(), 0);
		Tarefas.adicionaTarefa(textTarefa2.getText(), 1);
		Tarefas.adicionaTarefa(textTarefa3.getText(), 2);
		Tarefas.adicionaTarefa(textTarefa4.getText(), 3);
		Tarefas.adicionaTarefa(textTarefa5.getText(), 4);
		Tarefas.adicionaTarefa(textTarefa6.getText(), 5);
		try {
			Tarefas.gravarTarefas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			TarefasConcluidas.gravarTarefas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void fillTextTarefasFromSave(){
		try {
			Tarefas.loadTarefas();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textTarefa1.setText(Tarefas.getTarefaIndex(0));
		textTarefa2.setText(Tarefas.getTarefaIndex(1));
		textTarefa3.setText(Tarefas.getTarefaIndex(2));
		textTarefa4.setText(Tarefas.getTarefaIndex(3));
		textTarefa5.setText(Tarefas.getTarefaIndex(4));
		textTarefa6.setText(Tarefas.getTarefaIndex(5));
	
	}
}