package codigos;

/**
 * Classe Data composta de um dia, mes e ano com métodos para a construção da data e métodos que verificam se
 *  a data é valida ou não
 * <p>
 * @author Diogenes F
 */

public class Data {
	/** Dia, mes e ano informados pelo Usuario. */
	private int dia,mes,ano;
	
	/**
	 * Construtor para atribuir uma data recebendo os parametros dia, mes e ano.
	 * 
	 * @param d Dia que o usuario escolheu
	 * @param m Mes que o usuario escolheu
	 * @param a Ano que o usuario escolheu
	 * @throws Exception Tratamento de erro para que a data seja uma data valida
	 */
	public Data(int d, int m, int a) throws Exception {
		this.setData(d, m, a);
	}
	
	/**
	 * Construtor para atribuir uma data recebendo uma string
	 * 
	 * @param _data String que representa uma data que o usuario digitou
	 * @throws Exception Tratamento de erro para a data
	 */
	public Data(String _data) throws Exception {
		this.setData(_data);
	}
	/**
	 * Método que acessa o dia da data
	 * 
	 * @return Dia da data
	 */
	public int getDia() {
		return this.dia;
	}
	/**
	 * Método que acessa o mes da data
	 * 
	 * @return Mes da data
	 */
	public int getMes() {
		return this.mes;
	}
	/**
	 * Método que acessa o ano da data
	 * 
	 * @return Ano da data
	 */
	public int getAno() {
		return this.ano;
	}
	/**
	 * Método set que recebe uma string que representa a data e separa o dia, mes e ano em pequenas strings e,
	 * após isso, transforma em valores inteiros
	 * 
	 * @param _data String que representa a data
	 * @throws Exception Tratamento de erro para verificar se a data é valida
	 */
	public void setData(String _data) throws Exception {
		int d = _data.indexOf("/");
		String day = _data.substring(0, d);
		int m = _data.indexOf("/", d+1);
		String month = _data.substring(d+1, m);
		String year = _data.substring(m+1);
		d = Integer.parseInt(day);
		m = Integer.parseInt(month);
		int a = Integer.parseInt(year);
		this.setData(d,m,a);
	}
	/**
	 * Método set que recebe 3 inteiros que representam  o dia, o mes e o ano da data
	 * 
	 * @param d Dia da data
	 * @param m Mes da data
	 * @param a Ano da data
	 * @throws Exception Tratamento de erro para verificar se a data é valida
	 */
	public void setData(int d, int m, int a) throws Exception{
		if (Data.isDataValida(d,m,a)) {
			this.dia = d;
			this.mes = m;
			this.ano = a;
		}
		else {
			throw new Exception("\nData invalida\n");
		}
	}
	/**
	 * Método estático que verifica se a data entrada pelo usuario é uma data válida
	 * 
	 * @param d Dia da data
	 * @param m Mes da data
	 * @param a Ano da data
	 * @return false Se a data for invalida
	 * @return true Se a data for valida
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
	/**
	 * Método estático que verifica se o ano passado pelo usuario é ou nao bissexto
	 * 
	 * @param a Ano passado pelo usuario
	 * @return false Se nao for bissexto
	 * @return true Se for bissexto
	 */
	public static boolean isBissexto(int a) {
		if ( (a % 4 == 0) && (a % 100 != 0)) {
			return true;
		}
		return false;
	}
	/**
	 * Método que vai comparar duas datas para verificar qual delas é maior 
	 * 
	 * @param data_1 Primeira data passada pelo usuario
	 * @param data_2 Segunda data passada pelo usuario
	 * @return -1 Se a primeira data for menor que a segunda
	 * @return 0 Se as datas forem iguais
	 * @return 1 Se a primeira data for maior que a segunda
	 */
	public static int compareTo(Data data_1, Data data_2) {   
		if (data_1.getAno() > data_2.getAno()) return 1;
		else { 
			if (data_1.getAno() < data_2.getAno()) return -1;
			else {
				if (data_1.getMes() > data_2.getMes()) return 1;
				else {
					if (data_1.getMes() < data_2.getMes()) return -1;
					else {
						if (data_1.getDia() > data_2.getDia()) return 1;
						else {
							if (data_1.getDia() < data_2.getDia()) return -1;
							else {
								return 0;
							}
						}
					}
				}
			}
		}
	}
	/**
	 * Método para retornar a data em forma de string, formatada para exibir a data com o formato dd/mm/aaaa
	 * 
	 * @return Data em formato de string
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
}
