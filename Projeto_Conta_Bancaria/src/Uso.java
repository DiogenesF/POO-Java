
public class Uso {

	public static void main(String[] args) {
		
		Conta a = null;
		Conta b = null;
		try {
			a = new ContaPoupanca("Dg", 1234, 1200, 2323);
			Conta.incrementaDataHoje();
			Conta.incrementaDataHoje();
			Conta.incrementaDataHoje();
			Conta.incrementaDataHoje();
			Conta.incrementaDataHoje();
			b = new ContaPoupanca("Ay", 1222, 1500, 3232);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			a.sacar(400);
			Conta.incrementaDataHoje();
			a.depositar(500);
			
			a.transferir(500, b);
			Conta.incrementaDataHoje();
			Conta.incrementaDataHoje();
			b.transferir(200, a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(a);
		System.out.println("\n");
		System.out.println(b);
		
	}

}
