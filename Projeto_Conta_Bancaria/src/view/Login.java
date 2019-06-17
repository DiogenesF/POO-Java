package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import codigos.BancoDeDados;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Login {

	private JFrame frame;
	BancoDeDados bd = new BancoDeDados();
	private JTextField textCPF;
	private JTextField textSenha;
	private JRadioButton rdbtnPoupanca;
	private JRadioButton rdbtnCorrente;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */
	public static void TelaLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		bd.conectar();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEntreComO = new JLabel("Entre com o cpf: ");
		lblEntreComO.setBounds(34, 16, 223, 20);
		frame.getContentPane().add(lblEntreComO);
		
		textCPF = new JTextField();
		textCPF.setBounds(34, 52, 255, 26);
		frame.getContentPane().add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblEntreComA = new JLabel("Entre com a senha:");
		lblEntreComA.setBounds(34, 116, 192, 20);
		frame.getContentPane().add(lblEntreComA);
		
		textSenha = new JTextField();
		textSenha.setBounds(34, 146, 255, 26);
		frame.getContentPane().add(textSenha);
		textSenha.setColumns(10);
		
		rdbtnPoupanca = new JRadioButton("Poupanca");
		rdbtnPoupanca.setBounds(71, 184, 115, 29);
		frame.getContentPane().add(rdbtnPoupanca);
		
		rdbtnCorrente = new JRadioButton("Corrente");
		rdbtnCorrente.setBounds(233, 184, 115, 29);
		frame.getContentPane().add(rdbtnCorrente);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnPoupanca);
		bg.add(rdbtnCorrente);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnPoupanca.isSelected()) {
					String cpf = textCPF.getText();
					String senha = textSenha.getText();
					if (bd.isDadosCorretos(cpf, senha, 1)) {
						MenuOpcoes mnop = new MenuOpcoes();
						MenuOpcoes.cpf = cpf;
						mnop.setTipoConta(1);
						frame.dispose();
						mnop.TelaMenuOpcoes();
					}
					else {
						JOptionPane.showMessageDialog(null, "Dados invalidos!!");
					}
				}
				else if (rdbtnCorrente.isSelected()) {
					String cpf = textCPF.getText();
					String senha = textSenha.getText();
					
					if (bd.isDadosCorretos(cpf, senha, 2)) {
						MenuOpcoes mnop = new MenuOpcoes();
						mnop.setCPF(cpf);					
						mnop.setTipoConta(2);					
						frame.dispose();
						mnop.TelaMenuOpcoes();
					}
					else {
						JOptionPane.showMessageDialog(null, "Dados invalidos!!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione uma conta!!");
				}
			}
		});
		btnEntrar.setBounds(233, 237, 115, 43);
		frame.getContentPane().add(btnEntrar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Inicio in = new Inicio();
				frame.dispose();
				in.main(null);
				
			}
		});
		btnVoltar.setBounds(54, 237, 115, 43);
		frame.getContentPane().add(btnVoltar);
		
		
	}
}
