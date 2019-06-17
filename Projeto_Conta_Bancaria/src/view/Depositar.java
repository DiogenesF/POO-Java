package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import codigos.BancoDeDados;
import codigos.Conta;
import codigos.ContaCorrente;
import codigos.ContaPoupanca;
import codigos.TipoOperacao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Depositar {

	private JFrame frame;
	private JTextField textValorDeposito;
	BancoDeDados bd = new BancoDeDados();

	/**
	 * Launch the application.
	 */
	public static void TelaDepositar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Depositar window = new Depositar();
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
	public Depositar() {
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
		
		JLabel lblValorDoSaque = new JLabel("Valor do deposito: ");
		lblValorDoSaque.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblValorDoSaque.setBounds(122, 123, 200, 20);
		frame.getContentPane().add(lblValorDoSaque);
		
		textValorDeposito = new JTextField();
		textValorDeposito.setBounds(122, 159, 160, 26);
		frame.getContentPane().add(textValorDeposito);
		textValorDeposito.setColumns(10);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (MenuOpcoes.tipo_conta == 1) {
					ContaPoupanca poupanca = null;
					poupanca = (ContaPoupanca) bd.retornaInstancia(MenuOpcoes.cpf, MenuOpcoes.tipo_conta);
					String valor_digitado = textValorDeposito.getText();
					double valor_na_conta = poupanca.getCliente().getSaldo();
					double valor_depositado = Double.parseDouble(valor_digitado);
					if (valor_depositado < 0) {
						JOptionPane.showMessageDialog(null, "O valor deve ser positivo!!");
					}
					else {
						bd.inserirOperacao(poupanca.getCliente().getCPF(), TipoOperacao.DEPOSITO.toString(), 
								valor_depositado, Conta.getDataHoje().toStringSQLFormat(), poupanca.getTipoConta());
						
						double novo_saldo = valor_na_conta + valor_depositado;
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
					String valor_digitado = textValorDeposito.getText();
					double valor_na_conta = corrente.getCliente().getSaldo();
					double valor_depositado = Double.parseDouble(valor_digitado);
					if (valor_depositado < 0) {
						JOptionPane.showMessageDialog(null, "O valor deve ser positivo!!");
					}
					else {
						bd.inserirOperacao(corrente.getCliente().getCPF(), TipoOperacao.DEPOSITO.toString(),
								valor_depositado, Conta.getDataHoje().toStringSQLFormat(), corrente.getTipoConta());
						
						double novo_saldo = valor_na_conta + valor_depositado;
						bd.alteraSaldo(corrente.getCliente().getCPF(), novo_saldo, corrente.getTipoConta());
						JOptionPane.showMessageDialog(null, "Operacao realizada com sucesso!!");
						MenuOpcoes mnop = new MenuOpcoes();
						frame.dispose();
						mnop.TelaMenuOpcoes();
					}
				}
				
			}
		});
		btnDepositar.setBounds(224, 242, 130, 59);
		frame.getContentPane().add(btnDepositar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuOpcoes mnop = new MenuOpcoes();
				frame.dispose();
				mnop.TelaMenuOpcoes();
				
			}
		});
		btnVoltar.setBounds(35, 242, 130, 59);
		frame.getContentPane().add(btnVoltar);
		
	}

}
