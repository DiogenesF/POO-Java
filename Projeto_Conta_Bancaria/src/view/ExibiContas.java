package view;

import codigos.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExibiContas {

	private JFrame frame;
	BancoDeDados bd = new BancoDeDados();

	/**
	 * Launch the application.
	 */
	public static void TelaExibeContas() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExibiContas window = new ExibiContas();
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
	public ExibiContas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		bd.conectar();
		frame = new JFrame();
		frame.setBounds(100, 100, 910, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textContasExistentes = new JTextArea();
		textContasExistentes.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textContasExistentes.setBounds(15, 107, 858, 279);
		frame.getContentPane().add(textContasExistentes);
		
		JLabel lblContasExistentes = new JLabel("Contas Existentes:");
		lblContasExistentes.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblContasExistentes.setBounds(15, 32, 215, 39);
		frame.getContentPane().add(lblContasExistentes);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Inicio in = new Inicio();
				frame.dispose();
				in.main(null);
				
			}
		});
		btnVoltar.setBounds(346, 515, 150, 66);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblDataHoje = new JLabel("Data hoje: " + Conta.getDataHoje().toString());
		lblDataHoje.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataHoje.setBounds(323, 404, 259, 20);
		frame.getContentPane().add(lblDataHoje);
		
		List<Conta> lista_contas = bd.listarTodasContas();
		ContaPoupanca poupanca = null;
		ContaCorrente corrente = null;
		for (int i = 0; i < lista_contas.size();i++) {
			if (lista_contas.get(i).getTipoConta() == 1) {
				poupanca = (ContaPoupanca) lista_contas.get(i);
				textContasExistentes.append(poupanca.toStringExibeContas());
			}
			if (lista_contas.get(i).getTipoConta() == 2) {
				corrente = (ContaCorrente) lista_contas.get(i);
				textContasExistentes.append(corrente.toStringExibeContas());
			}
		}
		
		JButton btnProx = new JButton("Prox Dia");
		btnProx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Conta.incrementaDataHoje();
					for (int i = 0; i < lista_contas.size();i++) {
						if (lista_contas.get(i).getTipoConta() == 1) {    //Os juros estao rendendo de 3 em 3 dias
							for (int j = 1;j<10;j++) {
								if ((lista_contas.get(i).getDataCriacao().getDia()+3*j) == Conta.getDataHoje().getDia() ) {
									bd.aplicaJuros(lista_contas.get(i).getCliente().getCPF());
								}
							}
							
						}
						
					}
					
					frame.dispose();
					ExibiContas a = new ExibiContas();
					a.TelaExibeContas();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnProx.setBounds(688, 445, 113, 49);
		frame.getContentPane().add(btnProx);
		
		
	}
}
