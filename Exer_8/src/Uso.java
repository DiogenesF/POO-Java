import java.util.Scanner;

public class Uso {

	public static void main(String[] args) {
		String nome_1,nome_2;
		double saldo_1,saldo_2;
		
		ContaBancaria correntista_1 = null;
		ContaBancaria correntista_2 = null;
		try {
			correntista_1 = new ContaBancaria();
		} catch (Exception e) {
			System.out.println("Error!");
		}
		try {
			correntista_2 = new ContaBancaria();
		} catch (Exception e) {
			System.out.println("Error!");
		}
		
		System.out.println("Entre com o nome 1: ");
		nome_1 = new Scanner(System.in).next();
		correntista_1.setNome(nome_1);
		System.out.println("Entre com o saldo 1: ");
		while (true) {	
			try {
				saldo_1 = new Scanner(System.in).nextInt();
				correntista_1.setSaldo(saldo_1);
				break;
			} catch (Exception e) {
				System.out.println("Saldo deve ser positivo!\n");
				System.out.println("Entre com o saldo 1: ");
			}
		}
		
		System.out.println("Entre com o nome 2: ");
		nome_2 = new Scanner(System.in).next();
		correntista_2.setNome(nome_2);
		System.out.println("Entre com o saldo 2: ");
		while (true) {	
			try {
				saldo_2 = new Scanner(System.in).nextInt();
				correntista_2.setSaldo(saldo_2);
				break;
			} catch (Exception e) {
				System.out.println("Saldo deve ser positivo!\n");
				System.out.println("Entre com o saldo 2: ");
			}
		}
		
		System.out.println("Escolha um dos dois correntistas para ajustar o saldo com os juros!");
		System.out.println("Entre com 1 para o correntista 1 ou 2 para o correntista 2: ");
		
		int choice = new Scanner(System.in).nextInt();
		while (true) {
			if (choice == 1) {
				System.out.println("Saldo anterior: ");
				System.out.println(correntista_1.getSaldo());
				correntista_1.correcaoSaldo();
				System.out.println("\nNovo saldo: ");
				System.out.println(correntista_1.getSaldo());
				break;
			}
			else if (choice == 2) {
				System.out.println("Saldo anterior: ");
				System.out.println(correntista_2.getSaldo());
				correntista_2.correcaoSaldo();
				System.out.println("\nNovo saldo: ");
				System.out.println(correntista_2.getSaldo());
				break;
			}
			else {
				System.out.println("Escolha invalida!! Tente novamente: ");
				choice = new Scanner(System.in).nextInt();
			}
		}
		
		//System.out.println(correntista_1.compareTo(correntista_2));
		//System.out.println(correntista_1.equals(correntista_2));
		//System.out.println("\nConta 1: "+correntista_1.toString());
		//System.out.println("\nConta 2: "+correntista_2.toString());
	}

}
