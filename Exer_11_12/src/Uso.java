import java.util.Random;

public class Uso {

	public static void main(String[] args) {
		
		Random gerador = new Random();
		int vet_ano[] = new int[50];
		int vet_mes[] = new int[50];
		int vet_dia[] = new int[50];
		int vet_salary[] = new int[50];
		int vet_depart[] = new int[50];
		int vet_id[] = new int[50];
		
		for (int j = 0;j<50;j++) {
			vet_ano[j] = gerador.nextInt(500) + 1600;
			vet_mes[j] = gerador.nextInt(11) + 1;
			vet_dia[j] = gerador.nextInt(27) + 1;
			vet_salary[j] = gerador.nextInt(5000);
			vet_depart[j] = gerador.nextInt(4) + 1;
			vet_id[j] = gerador.nextInt(150000);
		}
		
		Pessoa a = null;
		double taxa = 0;
		try {
			for (int i = 0;i<50;i++) {
				if (i % 5 == 0) {
					a = new Diretor(" " + i,vet_id[i],vet_dia[i],vet_mes[i],vet_ano[i],vet_dia[i],vet_mes[i],vet_ano[i],vet_salary[i],vet_depart[i],vet_dia[i],vet_mes[i],vet_ano[i]);
					taxa = 1.2;
					System.out.println("Diretor: ");
					System.out.println("Nome: " + a.getNome());
					((Diretor)a).reajustaSalario(taxa);
					System.out.println("Salario: "+((Diretor)a).getSalario());
					System.out.print("Emprestimo max: "+((Diretor)a).emprestimoMax());
					System.out.println("\n");
				}
				else if (i % 3 == 0) {
					a = new Chefe(" " + i,vet_id[i],vet_dia[i],vet_mes[i],vet_ano[i],vet_dia[i],vet_mes[i],vet_ano[i],vet_salary[i],vet_depart[i]);
					taxa = 1.5;
					System.out.println("Chefe: ");
					System.out.println("Nome: " + a.getNome());
					((Chefe)a).reajustaSalario(taxa);
					System.out.println("Salario: "+((Chefe)a).getSalario());
					System.out.print("Emprestimo max: "+((Chefe)a).emprestimoMax());
					System.out.println("\n");
				}
				else {
					a = new Funcionario(" " + i,vet_id[i],vet_dia[i],vet_mes[i],vet_ano[i],vet_dia[i],vet_mes[i],vet_ano[i],vet_salary[i]);
					taxa = 2;
					System.out.println("Funcionario: ");
					System.out.println("Nome: " + a.getNome());
					((Funcionario)a).reajustaSalario(taxa);
					System.out.println("Salario: "+((Funcionario)a).getSalario());
					System.out.print("Emprestimo max: "+((Funcionario)a).emprestimoMax());
					System.out.println("\n");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
