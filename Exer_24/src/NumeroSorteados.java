import java.io.Serializable;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Usada como objeto de teste para compor as classes que encapsulam as coleções
 * TreeSet.
 * <p>
 * Oferece métodos de sortear numeros aleatorios sem repedições.
 * 
 * @author Diogenes Fiorezi
 */

public class NumeroSorteados implements Serializable {
	/** Quantidade de Numeros sorteados*/
	private int quantidade_num;
	/** Faixa de Inicio*/
	private int faixa_inicio;
	/** Faixa de Fim*/
	private int faixa_fim;
	
	/** Colecao do tipo Set para armazenar os valores sorteados de forma ordenada */
	private Set<Integer> sorteio_val;

	/**
	 * construtor para inicializar as variaveis com os valores default 
	 *
	 */
	public NumeroSorteados() {
		this.setQuantidade(4);
		this.setIntervaloInicio(1);
		this.setIntervaloFim(99);
		this.Gerador();
	}
	/**
	 * construtor para inicializar valores das faixas
	 *
	 * @param faixa_i valor inicial do intervalo
	 * @param faixa_f valor final do intervalo
	 */
	public NumeroSorteados(int faixa_i, int faixa_f) {
		this.setQuantidade(4);
		this.setIntervaloInicio(faixa_i);
		this.setIntervaloFim(faixa_f);
		this.Gerador();
	}
	
	/**
	 * construtor para inicializar as variaveis
	 *
	 * @param qtdd Quantidade minima de numeros sorteados recebido como parametros
	 * @param faixa_i Valor do inicio do intervalo recebido como parametro
	 * @param faixa_f Valor final do intervalo recebido como parametro
	 */
	
	public NumeroSorteados(int qtdd, int faixa_i, int faixa_f) {
		this.setQuantidade(qtdd);
		this.setIntervaloInicio(faixa_i);
		this.setIntervaloFim(faixa_f);
		this.Gerador();
	}
	/**
	 * construtor para inicializar valores da quantidade, as outras variaveis serao inicializadas com os valores default
	 *
	 * @param qtdd quantidade de numeros a serem sorteados 
	 */
	public NumeroSorteados(int qtdd) {
		this.setQuantidade(qtdd);
		this.setIntervaloInicio(1);
		this.setIntervaloFim(99);
		this.Gerador();
	}
	
	/**
	 * pega a quantidade de numeros sorteados
	 * 
	 * @return quantidade de numeros sorteados
	 */
	public int getQuantidade() {
		return this.quantidade_num;
	}
	/**
	 * pega o inicio do intervalo
	 * 
	 * @return inicio do intervalo
	 */
	public int getIntervaloInicio() {
		return this.faixa_inicio;
	}
	/**
	 * pega o fim do intervalo
	 * 
	 * @return fim do intervalo
	 */
	public int getIntervaloFim() {
		return this.faixa_fim;
	}
	/**
	 * pega os valores sorteados
	 * 
	 * @return valores sorteados
	 */
	public Set getSorteioVal() {
		return this.sorteio_val;
	}

	/**
	 * modificar a quantidade de numeros a serem gerados
	 * 
	 * @param qtdd quantidade de numeros que serao gerados
	 */
	public void setQuantidade(int qtdd) {
		this.quantidade_num = qtdd;
	}
	/** 
	 * modifica o intervalo inferior dos numeros gerados
	 * 
	 * @param inicio limite inferior 
	 * 
	 */
	public void setIntervaloInicio(int inicio) {
		this.faixa_inicio = inicio;
	}
	/** 
	 * modifica o intervalo superior dos numeros gerados
	 * 
	 * @param fim limite superior 
	 * 
	 */
	public void setIntervaloFim(int fim) {
		this.faixa_fim = fim;
	}

	/**
	 * Método para produzir numeros aleatorios utilizando o Random e a colecao
	 * TreeSet, pois essa colecao armazena os valores ja de forma ordenada e nao
	 * admite valores repetidos
	 * 
	 */
	public void Gerador() {
		int i = 0;
		int a;
		Random gerador = new Random();
		this.sorteio_val = new TreeSet<Integer>();
		while (i < this.quantidade_num) {
			a = gerador.nextInt(this.faixa_fim - this.faixa_inicio + 1) + this.faixa_inicio;
			if (this.sorteio_val.contains(a)) {
				continue;
			}
			else {
				this.sorteio_val.add(new Integer(a));
				i++;
			}
		}
	}
	
	/**
	 * Implementacao do método toString para retornar todo o conteúdo dos 
	 * numeros sorteados
	 * @return retorna uma String com todos os numeros gerados
	 */
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append(this.sorteio_val);
		return info.toString();
	}
}
