import java.util.Random;
import java.util.Scanner;

public class Uso {

	public static void main(String[] args) {
		double x,y;
		
		Ponto a = null;
		Ponto b = null;
		try {
			a = new Ponto();
			a.setPonto(3.0, 1.0);
			b = new Ponto();
			b.setPonto(3, 1);
		} catch (Exception e) {
			System.out.println("erro");
		}
		
		try {
			Retangulo c = new Retangulo(a,b);
			System.out.println(c.getPontoEsqSup());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Retangulo d = null;
		Retangulo c = null;
		try {
			c = new Retangulo(a,b);
			d = new Retangulo(1,4,4,1);
		} catch (Exception e) {
		}
		System.out.println(d.toString());
		System.out.println(c.calculaArea());
		System.out.println(d.calculaArea());
		System.out.println(c.compareTo(d));
		
		
		double vet_x[] = new double[100];
		double vet_y[] = new double[100];
		Random gerador = new Random();
		
		Ponto u = null;
		while (true) {
			try {
				System.out.println("Entre com a coordenada x: \n");
				x = new Scanner(System.in).nextDouble();
				System.out.println("Entre com a coordenada y: \n");
				y = new Scanner(System.in).nextDouble();
				u = new Ponto();
				u.setPonto(x, y);
				break;
			} catch (Exception e) {
				System.out.println("Limite invalido!");
			}
		}
		
		for (int i = 0;i<100;i++) {
			vet_x[i] = gerador.nextDouble() * 10;
			vet_y[i] = gerador.nextDouble() * 10;
		}
		
		for (int i=0;i<100;i++) {
			System.out.println("\nDistancia entre o ponto "+(i+1)+"");
			System.out.println(u.distancia(vet_x[i],vet_y[i]));
			
		}
	}

}
