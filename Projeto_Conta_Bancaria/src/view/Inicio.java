package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 544, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNovaConta = new JButton("Nova Conta");
		btnNovaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CriaNovaConta nwcnt = new CriaNovaConta();
				frame.dispose();
				nwcnt.TelaCriaNovaConta();
				
			}
		});
		btnNovaConta.setBounds(168, 55, 176, 61);
		frame.getContentPane().add(btnNovaConta);
		
		JButton btnAcessarConta = new JButton("Acessar Conta");
		btnAcessarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login lg = new Login();
				frame.dispose();
				lg.TelaLogin();
				
			}
		});
		btnAcessarConta.setBounds(168, 327, 176, 61);
		frame.getContentPane().add(btnAcessarConta);
		
		JButton btnExibirContas = new JButton("Exibir Contas");
		btnExibirContas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExibiContas excnt = new ExibiContas();
				frame.dispose();
				excnt.TelaExibeContas();
				
				
			}
		});
		btnExibirContas.setBounds(168, 191, 176, 61);
		frame.getContentPane().add(btnExibirContas);
	}
}
