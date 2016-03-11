package Bounty;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SobrePopup extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SobrePopup frame = new SobrePopup();
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
	public SobrePopup() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 218, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUtilitarioBounty = new JLabel("Utilitario - Bounty");
		lblUtilitarioBounty.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		lblUtilitarioBounty.setHorizontalAlignment(SwingConstants.CENTER);
		lblUtilitarioBounty.setBounds(0, 0, 202, 65);
		contentPane.add(lblUtilitarioBounty);
		
		JLabel lblProgramaRealisadoPor = new JLabel("Programa realizado por:");
		lblProgramaRealisadoPor.setBounds(10, 65, 160, 14);
		contentPane.add(lblProgramaRealisadoPor);
		
		JLabel lblCarlosAmaral = new JLabel("Carlos Amaral");
		lblCarlosAmaral.setBounds(20, 90, 110, 14);
		contentPane.add(lblCarlosAmaral);
		
		JLabel lblPauloLeite = new JLabel("Paulo Leite");
		lblPauloLeite.setBounds(21, 106, 100, 14);
		contentPane.add(lblPauloLeite);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(58, 227, 89, 23);
		contentPane.add(btnFechar);
	}
}
