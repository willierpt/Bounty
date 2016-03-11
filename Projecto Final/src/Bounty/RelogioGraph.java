package Bounty;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;


public class RelogioGraph extends JFrame {

	private JPanel contentPane;
	
	
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
		setResizable(false);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*Relogio Digital*/
		JLabel relogioDigital = new JLabel(BuscaHora.getRelogio());
		relogioDigital.setHorizontalAlignment(SwingConstants.CENTER);
		relogioDigital.setFont(new Font("Tahoma", Font.BOLD, 40));
		relogioDigital.setBounds(115, 11, 210, 100);

		contentPane.add(relogioDigital);

		/*Relogio Analogico*/
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

		relogioAnalogPanel.setBounds(170, 10, 101, 101);
		contentPane.add(relogioAnalogPanel);
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
		
		JPanel ponteiros = new JPanel(){
			@Override
			//Desenha os ponteiros
			protected void paintComponent(Graphics relogioAnalog) {
				super.paintComponent(relogioAnalog);

				Graphics2D g2d = (Graphics2D) relogioAnalog;
				int grau;
				//Ponteiros.getCoordPonteiro(graus, raio, centroX, centroY)

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
		ponteiros.setOpaque(false);
		ponteiros.setBounds(0, 0, 100, 100);
		relogioAnalogPanel.add(ponteiros);

		relogioAnalogPanel.setVisible(false);
		//butão para trocar de analogio para digital e vice versa
		JButton trocaRelogio = new JButton("");
		trocaRelogio.setIcon(new ImageIcon(RelogioGraph.class.getResource("/Bounty/resources/iconrelogio2.jpg")));
		
		trocaRelogio.setToolTipText("Trocar Entre Relogio Digital/Analogico");

		trocaRelogio.setBounds(335, 51, 89, 23);
		trocaRelogio.addMouseListener(new MouseAdapter() {
			boolean on = false;

			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (!on) {
					relogioAnalogPanel.setVisible(true);
					relogioDigital.setVisible(false);
					on = true;
				}
				else  {			    	
					relogioAnalogPanel.setVisible(false);
					relogioDigital.setVisible(true);
					on = false;
				}	

			}
		});
		trocaRelogio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(trocaRelogio);
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SobrePopup.main(null);
			}
		});
		btnSobre.setBounds(16, 11, 89, 23);
		contentPane.add(btnSobre);
		

		//actualiza o relogio //digital e analogico
		ActionListener updateClock = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//...Tarefas a executar...
				relogioDigital.setText(BuscaHora.getRelogio());
				ponteiros.repaint();
			}
		};
		Timer t = new Timer(1000,updateClock);
		t.start();






	}
}
