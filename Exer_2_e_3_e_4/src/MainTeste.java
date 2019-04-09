import java.util.Scanner;


public class MainTeste {

	public static void main(String[] args) {
		int dia_1, mes_1, ano_1,dia_2,mes_2,ano_2;
		int k = 0;
		String result, result2;
		
		DataCalendario a = null;
		try {
			a = new DataCalendario();
			a.setData(28,11,1998);
		} catch (Exception e) {
			System.out.println("Erro");
		}
		String asd = a.incrementa();
		System.out.println(asd);
		

		
		/*DataCalendario t = null;
		while(k < 3) {
			try {
				System.out.println("Entre com o dia_1: ");
				dia_1 = new Scanner(System.in).nextInt();
				System.out.println("Entre com o mes_1: ");
				mes_1 = new Scanner(System.in).nextInt();
				System.out.println("Entre com o ano_1: ");
				ano_1 = new Scanner(System.in).nextInt();
				t = new DataCalendario();
				t.setData(dia_1,mes_1,ano_1);
				break;
			} catch (Exception e) {
				System.out.println("Data invalida");
				k++;
			}
		}
		if (k == 3) {
			System.out.println("Muitas tentativas invalidas. Data definida como 01/01/1900");
			try {
				t.setData(01,01,1900);
			} catch (Exception e) {
				System.out.println("Data invalida");
			}
		}
		
		boolean a;
		k = 0;
		DataCalendario u = null;
		while(k < 3) {
			try {
				System.out.println("Entre com o dia_2: ");
				dia_2 = new Scanner(System.in).nextInt();
				System.out.println("Entre com o mes_2: ");
				mes_2 = new Scanner(System.in).nextInt();
				System.out.println("Entre com o ano_2: ");
				ano_2 = new Scanner(System.in).nextInt();
				u = new DataCalendario();
				u.setData(dia_2,mes_2,ano_2);
				break;
			} catch (Exception e) {
				System.out.println("Data invalida");
				k++;
			}
		}
		if (k == 3) {
			System.out.println("Muitas tentativas invalidas. Data definida como 01/01/1900");
			try {
				u.setData(01,01,1900);
			} catch (Exception e) {
				System.out.println("Data invalida");
			}
		}
		
		a = t.equals(u);
		System.out.println(a);
		
		result = t.toString(t.getDia(),t.getMes(),t.getAno());
		System.out.println(result);
		result2 = u.toString(u.getDia(),u.getMes(),u.getAno());
		System.out.println(result2);*/
		
		/*if (t.isDataValida(29,02,2008)) System.out.println("Data valida");
		else System.out.println("Data invalida");
		
		if (t.isDataValida(30,02,2008)) System.out.println("Data valida");
		else System.out.println("Data invalida");
		
		if (t.isDataValida(29,02,2009)) System.out.println("Data valida");
		else System.out.println("Data invalida");
		
		if (t.isDataValida(31,04,2009)) System.out.println("Data valida"); 
		else System.out.println("Data invalida");
		
		if (t.isDataValida(31,03,2009)) System.out.println("Data valida");
		else System.out.println("Data invalida");
		
		if (t.isDataValida(32,12,2009)) System.out.println("Data valida");
		else System.out.println("Data invalida");
		
		if (t.isDataValida(31,13,2009)) System.out.println("Data valida");
		else System.out.println("Data invalida");
		
		if (t.isDataValida(31,12,1581)) System.out.println("Data valida");
		else System.out.println("Data invalida");*/
		
	}

}
