package codigos;
/**
 * Classe Data utilizada para auxiliar a criação das datas da Conta Poupança e Corrente
 * <p>
 * 
 * @author Arthur B. 
 * @author Ayrton S. C.
 * @author Diogenes F.
 * @author Luan S. F
 * @author Yuri C. P.
 * @version 1.0 (junho - 2019)
 */
public class Data {
	/** Dia informado pelo Usuario. */
	private int dia;
	/** Mês informado pelo Usuario. */
	private int mes;
	/** Ano informado pelo Usuario. */
	private int ano;
	/**
	 * Contrutor para iniciar a Data com as variaveis Dia, Mês e Ano.
	 * 
	 * @param d Dia passado pelo Usuario
	 * @param m Mês passado pelo Usuario
	 * @param a Ano passado pelo Usuario
	 */
	public Data(int d, int m, int a) {
		try {
			this.setData(d,m,a);  
		} catch (Exception e) {
			e.getMessage();
		}
	}
	/**
	 * Contrutor para iniciar a Data com uma variavel do tipo
	 * String.
	 * 
	 * @param _data Data em formato String passado pelo Usuario
	 * @throws Exception Tratamento para a Data passada
	 */
	public Data(String _data) throws Exception {
		this.setData(_data);
	}
	/**
	 * Captura o Dia passado pelo Usuario
	 * 
	 * @return o dia do Usuario
	 */
	public int getDia() {
		return this.dia;
	}
	/**
	 * Captura o Mês passado pelo Usuario
	 * 
	 * @return o mes do Usuario
	 */
	public int getMes() {
		return this.mes;
	}
	/**
	 * Captura o Ano passado pelo Usuario
	 * 
	 * @return o ano do Usuario
	 */
	public int getAno() {
		return this.ano;
	}
	/**
	 * Modifica o mês passado como String e retorna o mês referente em Integer
	 * 
	 * @param d Dia passado pelo Usuario
	 * @param m Mês em String passado pelo Usuario
	 * @param a Ano passado pelo Usuario
	 * @throws Exception Tratamento para os valores e Strings passados pelo Usuario
	 */
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
	/**
	 * Modifica a String data separando todas as partes(dia, mês, ano), 
	 * em Strings proprias e logo apos, atribuido cada String
	 * em um Integer
	 * 
	 * @param data Data em String passada pelo Usuario
	 * @throws Exception Tratamento para a data descrita errada
	 */
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
	/**
	 * Modifica a Data tendo como entrada somente o mês e ano. Já
	 * o dia é atribuido com o valor de 01
	 * 
	 * @param m Mês passado pelo Usuario
	 * @param a Ano passado pelo Usuario
	 * @throws Exception tratamento para os valores do mês e do ano
	 */
	public void setData(int m, int a) throws Exception {
		int d = 01;
		this.setData(d,m,a);
	}
	/**
	 * Modifica a Data recebendo o Dia, Mês e Ano 
	 * 
	 * @param d Dia passado pelo Usuario
	 * @param m Mês passado pelo Usuario
	 * @param a Ano passado pelo Usuario
	 * @throws Exception Tratamento dos valores atribuidos a Data
	 */
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
	/**
	 * Método boleano em que retorna se a data é ou não valida
	 * para ser utilizada 
	 * 
	 * @param d Dia passado pelo Usuario
	 * @param m Mês passado pelo Usuario
	 * @param a Ano passado pelo Usuario
	 * @return false Para quando a Data não for valida
	 * @return true Para quando a data for valida
	 */
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
	/**
	 * Sobreposição do método toString para retornar a Data ao Usuario
	 * tendo uma organização de colocar do seguinte formato: dd/mm/aaaa
	 * 
	 * @return retorna um tipo String com todos os dados 
	 */
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
	/**
	 * Sobreposição do método toString para retornar a Data ao Usuario
	 * tendo uma organização de colocar do seguinte formato: aaaa/mm/dd
	 * e ainda sendo proposital para o Banco de Dados SQL
	 * 
	 * @return retorna um tipo String com todos os dados 
	 */
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
	/**
	 * Sobreposição do método toString onde é tratado uma Data em formato String 
	 * e tem um retorno para um toString mais completo para ser informado 
	 * ao Usuario os valores do Dia, Mês e Ano
	 * 
	 * @param _data Data informada ao Banco de Dados em String
	 * @return retorna uma StringBuilder para uma outra toString mais completa
	 */
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
