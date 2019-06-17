package view;

import codigos.*;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import codigos.BancoDeDados;
import codigos.Conta;
import codigos.ContaCorrente;
import codigos.ContaPoupanca;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ListarOperacoes {

	private JFrame frame;
	BancoDeDados bd = new BancoDeDados();

	/**
	 * Launch the application.
	 */
	public static void TelaListarOperacoes() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarOperacoes window = new ListarOperacoes();
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
	public ListarOperacoes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		bd.conectar();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 763, 563);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textOperacoes = new JTextArea();
		textOperacoes.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textOperacoes.setBounds(44, 96, 647, 300);
		frame.getContentPane().add(textOperacoes);
		
		JLabel lblNewLabel = new JLabel("Operacoes da conta: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(44, 32, 241, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuOpcoes mnop = new MenuOpcoes();
				frame.dispose();
				mnop.TelaMenuOpcoes();
			}
		});
		btnVoltar.setBounds(302, 432, 139, 59);
		frame.getContentPane().add(btnVoltar);
		
		List<Operacoes> lista_contas = bd.listarOperacoes(MenuOpcoes.cpf, MenuOpcoes.tipo_conta);
		for (int i = 0; i < lista_contas.size();i++) {
			textOperacoes.append(lista_contas.get(i).toString());
		}
		
	}

}
