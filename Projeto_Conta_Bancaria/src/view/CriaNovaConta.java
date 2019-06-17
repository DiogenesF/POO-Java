package view;

import codigos.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;

public class CriaNovaConta {

	BancoDeDados bd = new BancoDeDados();
	
	private JFrame frame;
	private JTextField textCampoNome;
	private JTextField textCampoCPF;
	private JTextField textCampoSenha;
	private JLabel lblDataDeNascimento;
	private JTextField textCampoData;

	/**
	 * Launch the application.
	 */
	public static void TelaCriaNovaConta() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriaNovaConta window = new CriaNovaConta();
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
	public CriaNovaConta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		bd.conectar();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton rdbtnContaPoupanca = new JRadioButton("Conta Poupanca");
		rdbtnContaPoupanca.setBounds(135, 351, 155, 29);
		frame.getContentPane().add(rdbtnContaPoupanca);
		
		JRadioButton rdbtnContaCorrente = new JRadioButton("Conta Corrente");
		rdbtnContaCorrente.setBounds(135, 388, 155, 29);
		frame.getContentPane().add(rdbtnContaCorrente);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(51, 16, 69, 30);
		frame.getContentPane().add(lblNewLabel);
		
		textCampoNome = new JTextField();
		textCampoNome.setBounds(51, 51, 256, 26);
		frame.getContentPane().add(textCampoNome);
		textCampoNome.setColumns(10);
		
		JLabel lblSaldo = new JLabel("CPF: (apenas numeros)");
		lblSaldo.setBounds(51, 104, 177, 20);
		frame.getContentPane().add(lblSaldo);
		
		textCampoCPF = new JTextField();
		textCampoCPF.setBounds(51, 140, 256, 26);
		frame.getContentPane().add(textCampoCPF);
		textCampoCPF.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha: (A senha deve possuir 8 digitos)");
		lblSenha.setBounds(51, 194, 315, 20);
		frame.getContentPane().add(lblSenha);
		
		textCampoSenha = new JTextField();
		textCampoSenha.setBounds(51, 230, 256, 26);
		frame.getContentPane().add(textCampoSenha);
		textCampoSenha.setColumns(10);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	  //DEVEM COMECAR COMO TRUE PARA QUE NAO SEJA CRIADO CASO NAO SEJA
				boolean poupanca = true, corrente = true;     //MARCADO A CAIXINHA DAS CONTAS
				Data aux_data = null;
				try {
					aux_data = new Data(textCampoData.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Data invalida!!");
				}
				if (textCampoNome.getText().isEmpty() || textCampoCPF.getText().isEmpty() || textCampoSenha.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!!");
				}
				else if (textCampoData.getText().isEmpty() || textCampoData.getText().length() != 10) {
					JOptionPane.showMessageDialog(null, "Data invalida!!");
				}
				else if (textCampoCPF.getText().length() > 11) {
					JOptionPane.showMessageDialog(null, "O CPF deve possuir ate 11 digitos");
				}
				else if (textCampoSenha.getText().length() != 8) {
					JOptionPane.showMessageDialog(null, "A senha deve possuir 8 digitos");
				}
				else {
					if (rdbtnContaPoupanca.isSelected() && rdbtnContaCorrente.isSelected()) {
						poupanca = bd.verificaSeExiste(textCampoCPF.getText(), 1);  //Conta poupanca == 1
						corrente = bd.verificaSeExiste(textCampoCPF.getText(), 2);  //Conta corrente == 2
						if (poupanca == true) JOptionPane.showMessageDialog(null, "Uma conta poupanca ja existe para esse cpf");
						if (corrente == true) JOptionPane.showMessageDialog(null, "Uma conta corrente ja existe para esse cpf");
					}
					else if (rdbtnContaCorrente.isSelected()) {
						corrente = bd.verificaSeExiste(textCampoCPF.getText(), 2);  //Conta corrente == 2
						if (corrente == true) JOptionPane.showMessageDialog(null, "Uma conta corrente ja existe para esse cpf");
					}
					else if (rdbtnContaPoupanca.isSelected()) {
						poupanca = bd.verificaSeExiste(textCampoCPF.getText(), 1);  //Conta poupanca == 1
						if (poupanca == true) JOptionPane.showMessageDialog(null, "Uma conta poupanca ja existe para esse cpf");
					}
					else {
						JOptionPane.showMessageDialog(null, "Nenhuma conta foi selecionada!");
					}
					
					if (poupanca == false) {
						bd.inserirCliente(textCampoNome.getText(), textCampoCPF.getText(), aux_data.toStringSQLFormat());
						bd.inserirConta(textCampoCPF.getText(), 1, 0.0, textCampoSenha.getText(), Conta.getDataHoje().toStringSQLFormat());
						JOptionPane.showMessageDialog(null, "Conta poupanca criada!!");
						Inicio in = new Inicio();
						frame.dispose();
						in.main(null);
					}
					if (corrente == false) {
						bd.inserirCliente(textCampoNome.getText(), textCampoCPF.getText(), aux_data.toStringSQLFormat());
						bd.inserirConta(textCampoCPF.getText(), 2, 0, textCampoSenha.getText(), Conta.getDataHoje().toStringSQLFormat());
						JOptionPane.showMessageDialog(null, "Conta corrente criada!!");
						Inicio in = new Inicio();
						frame.dispose();
						in.main(null);
					}
				}
			}
		});
		btnCriar.setBounds(161, 429, 115, 50);
		frame.getContentPane().add(btnCriar);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento (dd/mm/aaaa)");
		lblDataDeNascimento.setBounds(51, 277, 256, 20);
		frame.getContentPane().add(lblDataDeNascimento);
		
		textCampoData = new JTextField();
		textCampoData.setBounds(51, 313, 256, 26);
		frame.getContentPane().add(textCampoData);
		textCampoData.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Inicio in = new Inicio();
				frame.dispose();
				in.main(null);
				
			}
		});
		btnVoltar.setBounds(161, 519, 115, 50);
		frame.getContentPane().add(btnVoltar);
		
	}
}
