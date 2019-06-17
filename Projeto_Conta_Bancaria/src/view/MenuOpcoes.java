package view;

import codigos.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuOpcoes {

	static String cpf;
	static int tipo_conta;
	
	private JFrame frame;
	BancoDeDados bd = new BancoDeDados();

	
	public static void setCPF(String _cpf) {
		MenuOpcoes.cpf = _cpf;
	}
	public static void setTipoConta(int _tipo_conta) {			
		MenuOpcoes.tipo_conta = _tipo_conta;
	}
	/**
	 * Launch the application.
	 */
	public static void TelaMenuOpcoes() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOpcoes window = new MenuOpcoes();
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
	public MenuOpcoes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		bd.conectar();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 568, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNomeConta = new JLabel("CPF do titular: " + MenuOpcoes.cpf);
		lblNomeConta.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNomeConta.setBounds(108, 16, 256, 20);
		frame.getContentPane().add(lblNomeConta);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Sacar sc = new Sacar();
				frame.dispose();
				sc.TelaSacar();
				
			}
		});
		btnSacar.setBounds(42, 115, 115, 44);
		frame.getContentPane().add(btnSacar);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Depositar dp = new Depositar();
				frame.dispose();
				dp.TelaDepositar();
				
			}
		});
		btnDepositar.setBounds(384, 115, 115, 44);
		frame.getContentPane().add(btnDepositar);
		
		JButton btnTransferir = new JButton("Transferir");
		btnTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Transferir tra = new Transferir();
				frame.dispose();
				tra.TelaTransferir();
				
			}
		});
		btnTransferir.setBounds(42, 230, 115, 44);
		frame.getContentPane().add(btnTransferir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Inicio in = new Inicio();
				frame.dispose();
				in.main(null);
				
			}
		});
		btnVoltar.setBounds(384, 349, 115, 44);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblTipoDaConta = new JLabel("Tipo da conta: " + MenuOpcoes.tipo_conta);
		lblTipoDaConta.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTipoDaConta.setBounds(108, 53, 256, 20);
		frame.getContentPane().add(lblTipoDaConta);
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double saldo = bd.consultaSaldo(MenuOpcoes.cpf, MenuOpcoes.tipo_conta);
				
				JOptionPane.showMessageDialog(null, "Seu saldo eh de: R$" + saldo);
				
			}
		});
		btnSaldo.setBounds(384, 230, 115, 44);
		frame.getContentPane().add(btnSaldo);
		
		JButton btnOperacoes = new JButton("Operacoes");
		btnOperacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListarOperacoes lstop = new ListarOperacoes();
				frame.dispose();
				lstop.TelaListarOperacoes();
				
			}
		});
		btnOperacoes.setBounds(42, 349, 115, 44);
		frame.getContentPane().add(btnOperacoes);
	}
}
