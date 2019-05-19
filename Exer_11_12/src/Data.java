public class Data {
	private int dia, mes, ano;
	
	public Data(int d, int m, int a) throws Exception {
		setData(d,m,a);
	}
	public Data(int m, int a) throws Exception {
		setData(1,m,a);
	}
	public Data(int a) throws Exception {
		setData(1,1,a);
	}
	public Data() throws Exception {
		setData(1,1,1900);
	}
	
	public void setData(int d,int m,int a) throws Exception {
		if (Data.isDataValida(d, m, a)) {
			this.dia = d;
			this.mes = m;
			this.ano = a;
		}
		else {
			throw new Exception("Data invalida!!");
		}
	}
	
	public static boolean isDataValida(int dia, int mes, int ano) {
		if (ano < 1582 || dia > 31 || dia < 1 || mes < 1 || mes > 12) {
			return false;
		}
		if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			if (dia > 30) {
				return false;
			}
		}
		if (mes == 2) {
			if (Data.isBissexto(ano) == false && dia == 29 ) {
				return false;
			}
			if (dia > 29) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isBissexto(int a) {
		if ( (a % 4 == 0) && (a % 100 != 0)) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		StringBuilder dados = new StringBuilder();

		if (this.dia > 9 && this.mes > 9) {
			dados.append(this.dia);
			dados.append("/");
			dados.append(this.mes);
			dados.append("/");
			dados.append(this.ano);
			return dados.toString();
		}
		if (this.dia > 9) {
			dados.append(this.dia);
			dados.append("/0");
			dados.append(this.mes);
			dados.append("/");
			dados.append(this.ano);
			return dados.toString();
		}
		if (this.mes > 9) {
			dados.append("0");
			dados.append(this.dia);
			dados.append("/");
			dados.append(this.mes);
			dados.append("/");
			dados.append(this.ano);
			return dados.toString();
		}
		dados.append("0");
		dados.append(this.dia);
		dados.append("/0");
		dados.append(this.mes);
		dados.append("/");
		dados.append(this.ano);
		return dados.toString();
	}
	
}
