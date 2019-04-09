
public class DataCalendario {
	private int dia, mes, ano;

	public DataCalendario() throws Exception {
		this.setData(1,1,1900);
	}

	public DataCalendario (int d, String m,int a) throws Exception {
		this.setData(d, m, a);
	}

	public DataCalendario (String data) throws Exception {
		this.setData(data);
	}

	public DataCalendario (int d, int m, int a) throws Exception {
		this.setData(d,m,a);
	}

	public DataCalendario(int m, int a) throws Exception {
		this.setData(1,m,a);
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


	public String toString(int d, int m, int a) {
		StringBuilder dados = new StringBuilder();

		if (d > 9 && m > 9) {
			dados.append(this.getDia());
			dados.append("/");
			dados.append(this.getMes());
			dados.append("/");
			dados.append(this.getAno());
			return dados.toString();
		}
		if (d > 9) {
			dados.append(this.getDia());
			dados.append("/0");
			dados.append(this.getMes());
			dados.append("/");
			dados.append(this.getAno());
			return dados.toString();
		}
		if (m > 9) {
			dados.append("0");
			dados.append(this.getDia());
			dados.append("/");
			dados.append(this.getMes());
			dados.append("/");
			dados.append(this.getAno());
			return dados.toString();
		}
		dados.append("0");
		dados.append(this.getDia());
		dados.append("/0");
		dados.append(this.getMes());
		dados.append("/");
		dados.append(this.getAno());
		return dados.toString();
	}

	public static boolean isBissexto(int a) {
		if ( (a % 4 == 0) && (a % 100 != 0)) {
			return true;
		}
		return false;
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
			if (DataCalendario.isBissexto(ano) == false && dia == 29 ) {
				return false;
			}
			if (dia > 29) {
				return false;
			}
		}
		return true;
	}


	public void setData(int d, String m, int a) throws Exception {
		int month = 0;
		if (m.equals("janeiro")) month = 1;
		if (m.equals("fevereiro")) month = 2;
		if (m.equals("marco")) month = 3;
		if (m.equals("abril")) month = 4;
		if (m.equals("maio")) month = 5;
		if (m.equals("junho")) month = 6;
		if (m.equals("julho")) month = 7;
		if (m.equals("agosto")) month = 8;
		if (m.equals("setembro")) month = 9;
		if (m.equals("outubro")) month = 10;
		if (m.equals("novembro")) month = 11;
		if (m.equals("dezembro")) month = 12;
		this.setData(d,month,a);
	}

	public void setData(String data) throws Exception {
		int d = data.indexOf("/");
		String day = data.substring(0, d);
		int m = data.indexOf("/", d+1);
		String month = data.substring(d+1, m);
		String year = data.substring(m+1);
		d = Integer.parseInt(day);
		m = Integer.parseInt(month);
		int a = Integer.parseInt(year);
		this.setData(d,m,a);
	}

	public void setData(int m, int a) throws Exception {
		int d = 01;
		setData(d,m,a);
	}

	public void setData(int d, int m, int a) throws Exception{
		if (DataCalendario.isDataValida(d,m,a)) {
			dia = d;
			mes = m;
			ano = a;
		}
		else {
			throw new Exception("Data invalida");
		}
	}

	public boolean equals(Object objeto) {
		DataCalendario aux = (DataCalendario) objeto;
		if (this.toString(this.getDia(),this.getMes(),this.getAno())
				.equals(aux.toString(aux.getDia(),aux.getMes(),aux.getAno()))) {
			return true;
		}
		return false;
	}

	public String incrementa() {
		try {
			this.setData(this.getDia()+1,this.getMes(),this.getAno());
			return toString(this.getDia(),this.getMes(),this.getAno());
		} catch (Exception e) {
			try {
				this.setData(1,this.getMes()+1,this.getAno());
				return toString(this.getDia(),this.getMes(),this.getAno());
			} catch (Exception f){
				try {
					this.setData(1,1,this.getAno()+1);
					return toString(this.getDia(),this.getMes(),this.getAno());
				} catch (Exception g) {
					System.out.println("Erro");
				}
			}
		}
		return toString(this.getDia(),this.getMes(),this.getAno());
	}
			
		
	public String incrementa(int qntd_dias) {
		String result = null;
		for (int i = 0;i<qntd_dias;i++) {
			result = incrementa();
		}
		return result;
	}

}
