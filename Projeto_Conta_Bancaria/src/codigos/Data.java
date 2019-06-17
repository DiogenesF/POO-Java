package codigos;

public class Data {
	private int dia,mes,ano;
	
	public Data(int d, int m, int a) {
		try {
			this.setData(d,m,a);  //Caso de algum erro ao setar a data, a mensagem de erro vai aparecer na tela
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public Data(String _data) throws Exception {
		this.setData(_data);
	}
	
	public int getDia() {
		return this.dia;
	}
	public int getMes() {
		return this.mes;
	}
	public int getAno() {
		return this.ano;
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
		this.setData(d,m,a);
	}
	public void setData(int d, int m, int a) throws Exception{
		if (Data.isDataValida(d,m,a)) {
			this.dia = d;
			this.mes = m;
			this.ano = a;
		}
		else {
			throw new Exception("Data invalida");
		}
	}
	
	public static boolean isDataValida(int d, int m, int a) {
		if (d > 31 || d < 1 || m < 1 || m > 12) {
			return false;
		}
		if (m == 4 || m == 6 || m == 9 || m == 11) {
			if (d > 30) {
				return false;
			}
		}
		if (m == 2) {
			if (Data.isBissexto(a) == false && d == 29 ) {
				return false;
			}
			if (d > 29) {
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

		if (this.getDia() > 9 && this.getMes() > 9) {
			dados.append(this.getDia());
			dados.append("/");
			dados.append(this.getMes());
			dados.append("/");
			dados.append(this.getAno());
			return dados.toString();
		}
		if (this.getDia() > 9) {
			dados.append(this.getDia());
			dados.append("/0");
			dados.append(this.getMes());
			dados.append("/");
			dados.append(this.getAno());
			return dados.toString();
		}
		if (this.getMes() > 9) {
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
	public String toStringSQLFormat() {
		StringBuilder dados = new StringBuilder();

		if (this.getDia() > 9 && this.getMes() > 9) {
			dados.append(this.getAno());
			dados.append("/");
			dados.append(this.getMes());
			dados.append("/");
			dados.append(this.getDia());
			return dados.toString();
		}
		if (this.getDia() > 9) {
			dados.append(this.getAno());
			dados.append("/0");
			dados.append(this.getMes());
			dados.append("/");
			dados.append(this.getDia());
			return dados.toString();
		}
		if (this.getMes() > 9) {
			dados.append(this.getAno());
			dados.append("/");
			dados.append(this.getMes());
			dados.append("/0");
			dados.append(this.getDia());
			return dados.toString();
		}
		dados.append(this.getAno());
		dados.append("/0");
		dados.append(this.getMes());
		dados.append("/0");
		dados.append(this.getDia());
		return dados.toString();
	}
	
	public static String formatDataFromSQL(String _data) {
		StringBuilder dados = new StringBuilder();
		
		int a = _data.indexOf("-");
		String year = _data.substring(0, a);
		int m = _data.indexOf("-", a+1);
		String month = _data.substring(a+1, m);
		String day = _data.substring(m+1);
		dados.append(day+"/");
		dados.append(month+"/");
		dados.append(year);
		return dados.toString();
	}
}

