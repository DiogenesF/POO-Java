package view;

import codigos.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transferir {

	private JFrame frame;
	private JTextField textCPFTransferir;
	private JTextField textValor;
	BancoDeDados bd = new BancoDeDados();

	/**
	 * Launch the application.
	 */
	public static void TelaTransferir() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transferir window = new Transferir();
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
	public Transferir() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		bd.conectar();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 469, 638);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTipoDaConta = new JLabel("Tipo da conta: " + MenuOpcoes.tipo_conta);
		lblTipoDaConta.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTipoDaConta.setBounds(50, 63, 270, 20);
		frame.getContentPane().add(lblTipoDaConta);
		
		JLabel lblCpfDoTitular = new JLabel("CPF do titular: " + MenuOpcoes.cpf);
		lblCpfDoTitular.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCpfDoTitular.setBounds(50, 27, 292, 20);
		frame.getContentPane().add(lblCpfDoTitular);
		
		JLabel lblCpfDaConta = new JLabel("CPF da conta para transferir:");
		lblCpfDaConta.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCpfDaConta.setBounds(82, 116, 260, 20);
		frame.getContentPane().add(lblCpfDaConta);
		
		textCPFTransferir = new JTextField();
		textCPFTransferir.setBounds(114, 152, 228, 26);
		frame.getContentPane().add(textCPFTransferir);
		textCPFTransferir.setColumns(10);
		
		JRadioButton rdbtnPoupanca = new JRadioButton("Poupanca");
		rdbtnPoupanca.setBounds(124, 235, 118, 29);
		frame.getContentPane().add(rdbtnPoupanca);
		
		JRadioButton rdbtnCorrente = new JRadioButton("Corrente");
		rdbtnCorrente.setBounds(249, 235, 93, 29);
		frame.getContentPane().add(rdbtnCorrente);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnPoupanca);
		bg.add(rdbtnCorrente);
		
		JLabel lblValor = new JLabel("Valor: ");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblValor.setBounds(82, 339, 238, 20);
		frame.getContentPane().add(lblValor);
		
		textValor = new JTextField();
		textValor.setBounds(114, 375, 228, 26);
		frame.getContentPane().add(textValor);
		textValor.setColumns(10);
		
		JLabel lblTipoDaConta_1 = new JLabel("Tipo da conta: ");
		lblTipoDaConta_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTipoDaConta_1.setBounds(82, 203, 238, 20);
		frame.getContentPane().add(lblTipoDaConta_1);
		
		JButton btnTransferir = new JButton("Transferir");
		btnTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double valor_na_conta_atual, valor_na_conta_transferir, novo_saldo_conta_atual, novo_saldo_conta_transferir;
				String valor_digitado = textValor.getText();
				double valor_transferido = Double.parseDouble(valor_digitado);
				ContaPoupanca poupanca = null;
				ContaPoupanca poupanca_transferir = null;
				ContaCorrente corrente = null;
				ContaCorrente corrente_transferir = null;
				int tipo_conta_transferir = 0;
				String conta_p_transferir = textCPFTransferir.getText();
				if (rdbtnPoupanca.isSelected()) tipo_conta_transferir = 1;
				if (rdbtnCorrente.isSelected()) tipo_conta_transferir = 2;
				
				if (tipo_conta_transferir == 0) {
					JOptionPane.showMessageDialog(null, "Selecione uma conta!!");
				}
				else {
					if (bd.verificaSeExiste(conta_p_transferir, tipo_conta_transferir)) {
						if (tipo_conta_transferir == 1) {
							poupanca_transferir = (ContaPoupanca) bd.retornaInstancia(conta_p_transferir, tipo_conta_transferir);
							
							if (MenuOpcoes.tipo_conta == 1) { //conta poupanca (atual) p conta poupanca (escolhida)
								poupanca = (ContaPoupanca) bd.retornaInstancia(MenuOpcoes.cpf, 1);
								
								valor_na_conta_atual = poupanca.getCliente().getSaldo();
								if (valor_transferido > valor_na_conta_atual) {
									JOptionPane.showMessageDialog(null, "Saldo insuficiente!!");
									
									MenuOpcoes mnop = new MenuOpcoes();
									frame.dispose();
									mnop.TelaMenuOpcoes();
								}
								else if (valor_transferido < 0) {
									JOptionPane.showMessageDialog(null, "O valor deve ser positivo!!");
								}
								else {
									novo_saldo_conta_atual = valor_na_conta_atual - valor_transferido;
									bd.alteraSaldo(poupanca.getCliente().getCPF(), novo_saldo_conta_atual, poupanca.getTipoConta());
									bd.inserirOperacao(poupanca.getCliente().getCPF(), TipoOperacao.REALIZOU_TRANSFERENCIA.toString(), 
											valor_transferido, Conta.getDataHoje().toStringSQLFormat(), 
											poupanca.getTipoConta());
									
									valor_na_conta_transferir = poupanca_transferir.getCliente().getSaldo();
									novo_saldo_conta_transferir = valor_na_conta_transferir + valor_transferido;
									bd.alteraSaldo(poupanca_transferir.getCliente().getCPF(), novo_saldo_conta_transferir, 
											poupanca_transferir.getTipoConta());
									bd.inserirOperacao(poupanca_transferir.getCliente().getCPF(), 
											TipoOperacao.RECEBEU_TRANSFERENCIA.toString(), valor_transferido, 
											Conta.getDataHoje().toStringSQLFormat(), poupanca_transferir.getTipoConta());
									
									JOptionPane.showMessageDialog(null, "Transferencia realizada com sucesso!!");
									MenuOpcoes mnop = new MenuOpcoes();
									frame.dispose();
									mnop.TelaMenuOpcoes();
									
								}
							}
							else { //conta corrente (atual) p conta poupanca (escolhida)
								corrente = (ContaCorrente) bd.retornaInstancia(MenuOpcoes.cpf, 2);
								
								valor_na_conta_atual = corrente.getCliente().getSaldo();
								if (valor_transferido > valor_na_conta_atual) {
									JOptionPane.showMessageDialog(null, "Saldo insuficiente!!");
									
									MenuOpcoes mnop = new MenuOpcoes();
									frame.dispose();
									mnop.TelaMenuOpcoes();
								}
								else if (valor_transferido < 0) {
									JOptionPane.showMessageDialog(null, "O valor deve ser positivo!!");
								}
								else {
									novo_saldo_conta_atual = valor_na_conta_atual - valor_transferido;
									bd.alteraSaldo(corrente.getCliente().getCPF(), novo_saldo_conta_atual, corrente.getTipoConta());
									bd.inserirOperacao(corrente.getCliente().getCPF(), TipoOperacao.REALIZOU_TRANSFERENCIA.toString(), 
											valor_transferido, Conta.getDataHoje().toStringSQLFormat(), 
											corrente.getTipoConta());
									
									valor_na_conta_transferir = poupanca_transferir.getCliente().getSaldo();
									novo_saldo_conta_transferir=valor_na_conta_transferir+valor_transferido-(valor_transferido*0.005);
									bd.alteraSaldo(poupanca_transferir.getCliente().getCPF(), novo_saldo_conta_transferir, 
											poupanca_transferir.getTipoConta());
									bd.inserirOperacao(poupanca_transferir.getCliente().getCPF(), 
											TipoOperacao.RECEBEU_TRANSFERENCIA.toString(),valor_transferido-(valor_transferido*0.005), 
											Conta.getDataHoje().toStringSQLFormat(), poupanca_transferir.getTipoConta());
									
									JOptionPane.showMessageDialog(null, "Transferencia realizada com sucesso!!");
									MenuOpcoes mnop = new MenuOpcoes();
									frame.dispose();
									mnop.TelaMenuOpcoes();
								}
							}
						}
						else {
							corrente_transferir = (ContaCorrente) bd.retornaInstancia(conta_p_transferir, tipo_conta_transferir);
							
							if (MenuOpcoes.tipo_conta == 1) { //conta poupanca (atual) p conta corrente (escolhida)
								poupanca = (ContaPoupanca) bd.retornaInstancia(MenuOpcoes.cpf, 1);
								
								valor_na_conta_atual = poupanca.getCliente().getSaldo();
								if (valor_transferido > valor_na_conta_atual) {
									JOptionPane.showMessageDialog(null, "Saldo insuficiente!!");
									
									MenuOpcoes mnop = new MenuOpcoes();
									frame.dispose();
									mnop.TelaMenuOpcoes();
								}
								else if (valor_transferido < 0) {
									JOptionPane.showMessageDialog(null, "O valor deve ser positivo!!");
								}
								else {
									novo_saldo_conta_atual = valor_na_conta_atual - valor_transferido;
									bd.alteraSaldo(poupanca.getCliente().getCPF(), novo_saldo_conta_atual, poupanca.getTipoConta());
									bd.inserirOperacao(poupanca.getCliente().getCPF(), TipoOperacao.REALIZOU_TRANSFERENCIA.toString(), 
											valor_transferido, Conta.getDataHoje().toStringSQLFormat(), 
											poupanca.getTipoConta());
									
									valor_na_conta_transferir = corrente_transferir.getCliente().getSaldo();
									novo_saldo_conta_transferir=valor_na_conta_transferir+valor_transferido-(valor_transferido*0.005);
									bd.alteraSaldo(corrente_transferir.getCliente().getCPF(), novo_saldo_conta_transferir, 
											corrente_transferir.getTipoConta());
									bd.inserirOperacao(corrente_transferir.getCliente().getCPF(), 
											TipoOperacao.RECEBEU_TRANSFERENCIA.toString(),valor_transferido-(valor_transferido*0.005), 
											Conta.getDataHoje().toStringSQLFormat(), corrente_transferir.getTipoConta());
									
									JOptionPane.showMessageDialog(null, "Transferencia realizada com sucesso!!");
									MenuOpcoes mnop = new MenuOpcoes();
									frame.dispose();
									mnop.TelaMenuOpcoes();
								}
							}
							else {  //conta corrente (atual) p conta corrente (escolhida)
								corrente = (ContaCorrente) bd.retornaInstancia(MenuOpcoes.cpf, 2);
								
								valor_na_conta_atual = corrente.getCliente().getSaldo();
								if (valor_transferido > valor_na_conta_atual) {
									JOptionPane.showMessageDialog(null, "Saldo insuficiente!!");
									
									MenuOpcoes mnop = new MenuOpcoes();
									frame.dispose();
									mnop.TelaMenuOpcoes();
								}
								else if (valor_transferido < 0) {
									JOptionPane.showMessageDialog(null, "O valor deve ser positivo!!");
								}
								else {
									novo_saldo_conta_atual = valor_na_conta_atual - valor_transferido;
									bd.alteraSaldo(corrente.getCliente().getCPF(), novo_saldo_conta_atual, corrente.getTipoConta());
									bd.inserirOperacao(corrente.getCliente().getCPF(), TipoOperacao.REALIZOU_TRANSFERENCIA.toString(), 
											valor_transferido, Conta.getDataHoje().toStringSQLFormat(), corrente.getTipoConta());
									
									valor_na_conta_transferir = corrente_transferir.getCliente().getSaldo();
									novo_saldo_conta_transferir = valor_na_conta_transferir + valor_transferido;
									bd.alteraSaldo(corrente_transferir.getCliente().getCPF(), novo_saldo_conta_transferir, 
											corrente_transferir.getTipoConta());
									bd.inserirOperacao(corrente_transferir.getCliente().getCPF(), 
											TipoOperacao.RECEBEU_TRANSFERENCIA.toString(), valor_transferido, 
											Conta.getDataHoje().toStringSQLFormat(), corrente_transferir.getTipoConta());
									
									JOptionPane.showMessageDialog(null, "Transferencia realizada com sucesso!!");
									MenuOpcoes mnop = new MenuOpcoes();
									frame.dispose();
									mnop.TelaMenuOpcoes();
								}
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "A conta digitada nao existe!!");
					}
				}
				
			}
		});
		btnTransferir.setBounds(237, 473, 130, 59);
		frame.getContentPane().add(btnTransferir);
		
		JLabel lblObsUmaTaxa = new JLabel("Obs: Uma taxa de 0,5% eh cobrada do valor ao se fazer ");
		lblObsUmaTaxa.setBounds(15, 276, 417, 20);
		frame.getContentPane().add(lblObsUmaTaxa);
		
		JLabel lblTransferenciaParaConta = new JLabel("transferencia para tipo de conta diferente");
		lblTransferenciaParaConta.setBounds(50, 303, 382, 20);
		frame.getContentPane().add(lblTransferenciaParaConta);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuOpcoes mnop = new MenuOpcoes();
				frame.dispose();
				mnop.TelaMenuOpcoes();
				
			}
		});
		btnVoltar.setBounds(50, 473, 130, 59);
		frame.getContentPane().add(btnVoltar);
	}
}
