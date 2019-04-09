

public class Data {
	//EXER_6
	//O metodo isDataValida DEVE ser estatico, pois nao eh necessario que haja uma instancia
	//criada para que o usuario queira verificar a validade de uma data.
	
	//O mesmo acontece com o isAnoBissexto, ela DEVE ser estatica. O usuario pode querer
	//saber se um ano eh bissexto, e ele deve conseguir isso sem necessitar de ter um objeto
	//da classe.
	
	//Seria util versoes sobrecarregadas dos dois metodos acima sem argumentos, pois apos ter
	//objetos criados dessa classe, poderiamos utilizar esse metodo sem passar argumentos,
	//pois ele ja teria acesso aos dados daquele objeto. Assim, nao precisariamos nos preocupar
	//com a passagem de parametros.
	
	//EXER_7
	//O metodo compareTo nao deve ser estatico, pois nao faz sentido possuir um metodo que compara
	//algo se voce nao possuir um objeto que possa usar esse metodo.
	//Para torna-lo estatico, seria necessario que ele possuisse um valor padrao para que os
	//parametros fossem comparados com esse padrao.
	
	private int dia, mes,ano;

	public Data (int d, int m, int a) {
		dia = d;
		mes = m;
		ano = a;
	}

	public int getDia() {
		return dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public int getAno() {
		return ano;
	}
	
	public int compareTo(Object objeto) {
		Data aux = (Data) objeto;
		if (this.ano > aux.ano) return 1;
		else if (this.ano < aux.ano) return -1;
		else {
			if (this.mes > aux.mes) return 1;
			else if (this.mes < aux.mes) return -1;
			else {
				if (this.dia > aux.dia) return 1;
				else if (this.dia < aux.dia) return -1;
				else {
					return 0;
				}
			}
		}
	}
	
	public static boolean isBissexto(int a) {
		if ( (a % 4 == 0) && (a % 100 != 0)) {
			return true;
		}
		return false;
	}
	
	public static boolean isDataValida(int dia, int mes, int ano) throws Exception {
		if (ano < 1582 || dia > 31 || dia < 1 || mes < 1 || mes > 12) {
			throw new Exception ("Data invalida");
		}
		if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			if (dia > 30) {
				throw new Exception ("Data invalida");
			}
		}
		if (mes == 2) {
			if (Data.isBissexto(ano) == false && dia == 29 ) {
				throw new Exception ("Data invalida");
			}
			if (dia > 29) {
				throw new Exception ("Data invalida");
			}
		}
		return true;
	}
	
	public static Data verificaECriaData(int dia, int mes, int ano) {
		
		try {
			if (Data.isDataValida(dia, mes, ano)) {
				return new Data(dia, mes, ano);
			}
			return null;
		} catch (Exception e) {
			return null;
		}
		
		
		
	}
	
	
}
