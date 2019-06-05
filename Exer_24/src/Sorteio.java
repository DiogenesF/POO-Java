import java.io.Serializable;

/**
 * Usada para organizar cada sorteio, com data e uma agregacao de NumeroSorteados.
 * Assim, um objeto de Sorteio vai possuir uma data e uma certa quantidade de numeros sorteados correspondentes a essa data
 * 
 * <p>
 * Implementa a interface Serializable, para permitir que as suas instâncias possam
 * ser usadas numa serialização (por exemplo, gravação em disco)
 *
 * @author Diogenes Fiorezi
 */


public class Sorteio implements Serializable {
	/** dia da data referente ao sorteio */
	private int dia;
	/** mes da data referente ao sorteio */
	private int mes;
	/** ano da data referente ao sorteio */
	private int ano;
	/** valores sorteados */
	private NumeroSorteados sorteio_val;

	/**
  	 * construtor default que inicializa a data com o valor default 01/01/1900
  	 * e faz o sorteio com os parametros 'quantidade de numeros no sorteio', 'limite superior' e 'limite inferior'
  	 * respectivamente iguais a 4, 99 e 1
  	 *
  	 *@throws Exception para verificar se a data eh uma data valida
  	 */
	
	public Sorteio() throws Exception {
		this.setData(1,1,1900);
		this.setNumeroSorteado();
	}
	
	/**
  	 * construtor para inicializar valores nos campos
  	 *
  	 * @param d dia da data
  	 * @param m mes da data
  	 * @param a ano da data
  	 * @param sorteio_v numeros sorteados previamente
  	 * 
  	 * @throws Exception para verificar se a data eh uma data valida
  	 */
	
	public Sorteio (int d, int m, int a, NumeroSorteados sorteio_v) throws Exception {
		this.setData(d, m, a);
		this.setNumeroSorteado(sorteio_v);
	}
	
	/**
  	 * construtor para inicializar valores nos campos e inicializando o sorteio com parametros default
  	 * 'quantidade de numeros no sorteio', 'limite superior' e 'limite inferior'
  	 * respectivamente iguais a 4, 99 e 1
  	 *
  	 * @param d dia da data
  	 * @param m mes da data
  	 * @param a ano da data
  	 * 
  	 * @throws Exception para verificar se a data eh uma data valida
  	 */
	
	public Sorteio (int d, int m, int a) throws Exception {
		this.setData(d, m, a);
		this.setNumeroSorteado();
	}
	
	/**
  	 * construtor para inicializar valores nos campos
  	 *
  	 * @param d dia da data
  	 * @param m mes da data
  	 * @param a ano da data
  	 * @param qtdd quantidade de numeros a serem sorteados
  	 * @param faixa_i limite inferior
  	 * @param faixa_f limite superior
  	 * 
  	 * @throws Exception para verificar se a data eh uma data valida
  	 */
	
	public Sorteio (int d, int m, int a, int qtdd, int faixa_i, int faixa_f) throws Exception {
		this.setData(d,m,a);
		this.setNumeroSorteado(qtdd, faixa_i, faixa_f);
	}
	
	/**
  	 * retorna o dia da data
  	 *
  	 * @return dia
  	 */

	public int getDia() {
		return this.dia;
	}
	/**
  	 * retorna o mes da data
  	 *
  	 * @return mes
  	 */
	public int getMes() {
		return this.mes;
	}
	/**
  	 * retorna o ano da data
  	 *
  	 * @return ano
  	 */
	public int getAno() {
		return this.ano;
	}
	/**
  	 * atribuicao da variavel ao seu campo
  	 *
  	 */
	public void setNumeroSorteado() {
		this.sorteio_val = new NumeroSorteados();
	}
	/**
  	 * atribuicao da variavel ao seu campo
  	 * 
  	 * @param sorteio_v Eh uma instancia da classe NumeroSorteados
  	 *
  	 */
	public void setNumeroSorteado(NumeroSorteados sorteio_v) {
		this.sorteio_val = sorteio_v;
	}
	/**
  	 * atribuicao da variavel ao seu campo
  	 * 
  	 * @param qtdd Eh a quantidade de numeros a serem sorteados
  	 *
  	 */
	public void setNumeroSorteado(int qtdd) {
		this.sorteio_val = new NumeroSorteados(qtdd);
	}
	/**
  	 * atribuicao da variavel ao seu campo
  	 * 
  	 * @param qtdd Eh a quantidade de numeros a serem sorteados
  	 * @param faixa_f Eh o limite superior dos valores dos numeros a serem gerados
  	 *
  	 */
	public void setNumeroSorteado(int qtdd, int faixa_f) {
		this.sorteio_val = new NumeroSorteados(qtdd, faixa_f);
	}
	/**
  	 * atribuicao da variavel ao seu campo
  	 * 
  	 * @param qtdd Eh a quantidade de numeros a serem sorteados
  	 * @param faixa_i Eh o limite inferior dos valores dos numeros a serem gerados
  	 * @param faixa_f Eh o limite superior dos valores dos numeros a serem gerados
  	 *
  	 */
	public void setNumeroSorteado(int qtdd, int faixa_i, int faixa_f) {
		this.sorteio_val = new NumeroSorteados(qtdd, faixa_i, faixa_f);
	}
	/**
  	 * atribuicao da variavel ao seu campo
  	 * 
  	 * @param d Eh o dia da data
  	 * @param m Eh o mes da data recebido em formato de string
  	 * @param a Eh o ano da data
  	 *
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
  	 * atribuicao da variavel ao seu campo
  	 * 
  	 * @param data Eh uma string que recebe a data no formato 'dd/mm/aaaa'
  	 *
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
  	 * atribuicao da variavel ao seu campo, o dia da data recebe valor default
  	 * 
  	 * @param m mes da data
  	 * @param a ano da data
  	 *
  	 */
	public void setData(int m, int a) throws Exception {
		int d = 01;
		this.setData(d,m,a);
	}
	/**
  	 * atribuicao da variavel ao seu campo
  	 * 
  	 * @param d Eh o dia da data
  	 * @param m Eh o mes da data
  	 * @param a Eh o ano da data
  	 *
  	 */
	public void setData(int d, int m, int a) throws Exception{
		if (Sorteio.isDataValida(d,m,a)) {
			this.dia = d;
			this.mes = m;
			this.ano = a;
		}
		else {
			throw new Exception("Data invalida");
		}
	}
	/**
  	 * metodo que analisa se a data eh valida ou nao
  	 * 
  	 * @param d Eh o dia da data
  	 * @param m Eh o mes da data
  	 * @param a Eh o ano da data
  	 * 
  	 * @return retorna verdadeiro se a data eh valida
  	 * @return retorna falso se a data eh invalida
  	 *
  	 */
	public static boolean isDataValida(int d, int m, int a) {
		if (a < 1582 || d > 31 || d < 1 || m < 1 || m > 12) {
			return false;
		}
		if (m == 4 || m == 6 || m == 9 || m == 11) {
			if (d > 30) {
				return false;
			}
		}
		if (m == 2) {
			if (Sorteio.isBissexto(a) == false && d == 29 ) {
				return false;
			}
			if (d > 29) {
				return false;
			}
		}
		return true;
	}
	/**
  	 * metodo que verifica se um certo ano eh bissexto
  	 * 
  	 * @param a ano da data
  	 * 
  	 * @return retorna verdadeiro se o ano eh bissexto
  	 * @return retorna falso se o ano nao for bissexto
  	 *
  	 */
	public static boolean isBissexto(int a) {
		if ( (a % 4 == 0) && (a % 100 != 0)) {
			return true;
		}
		return false;
	}
	
	/**
  	 * Método sobreposto para devolver os campos formatados em uma String
  	 *
  	 * @return retorna String com a data recebida e os valores sorteados
  	 */
	
	public String toString() {
		StringBuilder dados = new StringBuilder();

		if (this.dia > 9 && this.mes > 9) {
			dados.append(this.getDia());
			dados.append("/");
			dados.append(this.getMes());
			dados.append("/");
			dados.append(this.getAno());
			dados.append(" " + this.sorteio_val);
			return dados.toString();
		}
		if (this.dia > 9) {
			dados.append(this.getDia());
			dados.append("/0");
			dados.append(this.getMes());
			dados.append("/");
			dados.append(this.getAno());
			dados.append(" " + this.sorteio_val);
			return dados.toString();
		}
		if (this.mes > 9) {
			dados.append("0");
			dados.append(this.getDia());
			dados.append("/");
			dados.append(this.getMes());
			dados.append("/");
			dados.append(this.getAno());
			dados.append(" " + this.sorteio_val);
			return dados.toString();
		}
		dados.append("0");
		dados.append(this.getDia());
		dados.append("/0");
		dados.append(this.getMes());
		dados.append("/");
		dados.append(this.getAno());
		dados.append(" " + this.sorteio_val);
		return dados.toString();
	}

}
