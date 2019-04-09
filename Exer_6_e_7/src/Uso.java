
import java.util.Scanner;

public class Uso {

	public static void main(String[] args) {
		int dia_1,mes_1,ano_1;
		Data t = null;
		Data u = null;
		u = Data.verificaECriaData(20, 10, 2000);
		
		while (t == null) {
			System.out.println("Entre com o dia_1: ");
			dia_1 = new Scanner(System.in).nextInt();
			System.out.println("Entre com o mes_1: ");
			mes_1 = new Scanner(System.in).nextInt();
			System.out.println("Entre com o ano_1: ");
			ano_1 = new Scanner(System.in).nextInt();
			t = Data.verificaECriaData(dia_1, mes_1, ano_1);
			if (t == null) System.out.println("Data invalida. Tente novamente: ");
		}
		
		System.out.println(t.getDia()+"/"+t.getMes()+"/"+t.getAno());
		
		int i = t.compareTo(u);
		System.out.println(i);
		
	}
	
	


}
