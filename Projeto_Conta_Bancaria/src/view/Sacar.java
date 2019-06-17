package view;

import codigos.*;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import codigos.ContaCorrente;
import codigos.ContaPoupanca;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sacar {

	private JFrame frame;
	private JTextField textValorSaque;
	BancoDeDados bd = new BancoDeDados();

	/**
	 * Launch the application.
	 */
	public static void TelaSacar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sacar window = new Sacar();
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
	public Sacar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		bd.conectar();
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNomeConta = new JLabel("CPF do titular: " + MenuOpcoes.cpf);
		lblNomeConta.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNomeConta.setBounds(64, 16, 256, 20);
		frame.getContentPane().add(lblNomeConta);
		
		JLabel lblNewLabel = new JLabel("Tipo da conta: " + MenuOpcoes.tipo_conta);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(64, 52, 256, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblValorDoSaque = new JLabel("Valor do saque: ");
		lblValorDoSaque.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblValorDoSaque.setBounds(132, 123, 169, 20);
		frame.getContentPane().add(lblValorDoSaque);
		
		textValorSaque = new JTextField();
		textValorSaque.setBounds(122, 159, 160, 26);
		frame.getContentPane().add(textValorSaque);
		textValorSaque.setColumns(10);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MenuOpcoes.tipo_conta == 1) {
					ContaPoupanca poupanca = null;
					poupanca = (ContaPoupanca) bd.retornaInstancia(MenuOpcoes.cpf, MenuOpcoes.tipo_conta);
					String valor_digitado = textValorSaque.getText();
					double valor_na_conta = poupanca.getCliente().getSaldo();
					double valor_sacado = Double.parseDouble(valor_digitado);
					if (valor_sacado > valor_na_conta) {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente!!");
					}
					else if (valor_sacado < 0) {
						JOptionPane.showMessageDialog(null, "O valor deve ser positivo!!");
					}
					else {
						bd.inserirOperacao(poupanca.getCliente().getCPF(), TipoOperacao.SAQUE.toString(), valor_sacado, 
								Conta.getDataHoje().toStringSQLFormat(), poupanca.getTipoConta());
						double novo_saldo = valor_na_conta - valor_sacado;
						bd.alteraSaldo(poupanca.getCliente().getCPF(), novo_saldo, poupanca.getTipoConta());
						JOptionPane.showMessageDialog(null, "Operacao realizada com sucesso!!");
						MenuOpcoes mnop = new MenuOpcoes();
						frame.dispose();
						mnop.TelaMenuOpcoes();
					}
				}
				else {
					ContaCorrente corrente = null;
					corrente = (ContaCorrente) bd.retornaInstancia(MenuOpcoes.cpf, MenuOpcoes.tipo_conta);
					String valor_digitado = textValorSaque.getText();
					double valor_na_conta = corrente.getCliente().getSaldo();
					double valor_sacado = Double.parseDouble(valor_digitado);
					if (valor_sacado > valor_na_conta) {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente!!");
					}
					else if (valor_sacado < 0) {
						JOptionPane.showMessageDialog(null, "O valor deve ser positivo!!");
					}
					else {
						bd.inserirOperacao(corrente.getCliente().getCPF(), TipoOperacao.SAQUE.toString(), valor_sacado, 
								Conta.getDataHoje().toStringSQLFormat(), corrente.getTipoConta());
						double novo_saldo = valor_na_conta - valor_sacado;
						bd.alteraSaldo(corrente.getCliente().getCPF(), novo_saldo, corrente.getTipoConta());
						JOptionPane.showMessageDialog(null, "Operacao realizada com sucesso!!");
						MenuOpcoes mnop = new MenuOpcoes();
						frame.dispose();
						mnop.TelaMenuOpcoes();
					}
				}
			}
		});
		btnSacar.setBounds(237, 242, 130, 59);
		frame.getContentPane().add(btnSacar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuOpcoes mnop = new MenuOpcoes();
				frame.dispose();
				mnop.TelaMenuOpcoes();
				
			}
		});
		btnVoltar.setBounds(42, 242, 130, 59);
		frame.getContentPane().add(btnVoltar);
		
	}
}
