import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Utiliza a colecao LinkedList para colocar cada sorteio gerado
 * na classe Sorteio em uma posicao da lista
 *
 * @author Diogenes Fiorezi
*/

public class ConjuntoSorteio implements Serializable {
	/**	Lista que vai armazenar instancias da classe Sorteio */
	private List<Sorteio> valores_sorteios;
	/** Contem uma instancia da classe sorteio */
	private Sorteio aux;
	
	/** Quantidade de sorteios que vao acontecer */
	private int num_sorteios;
	
	/** Construtor que aloca na memoria um espaco para a lista encadeada */
	public ConjuntoSorteio() {
		valores_sorteios = new LinkedList<Sorteio>();
	}
	
	/**
	 * Insere em uma lista encadeada o resultado de um sorteio
	 *
	 * @param sorteio objeto que possui a Data e os numeros sortedos
	 * @param num_sort quantidade de sorteios realizados
	 * 
	 * @throws Exception para verificar se a data eh valida
	 */
	public void insere(Sorteio sorteio, int num_sort) throws Exception {
		this.valores_sorteios.add(sorteio);
		for (int i = 1;i<num_sort;i++) {
			if (Sorteio.isDataValida(sorteio.getDia()+1, sorteio.getMes(), sorteio.getAno())) {
				this.valores_sorteios.add(new Sorteio(sorteio.getDia()+1, sorteio.getMes(), sorteio.getAno()));
				sorteio = new Sorteio(sorteio.getDia()+1, sorteio.getMes(), sorteio.getAno());
			}
			else if (Sorteio.isDataValida(1, sorteio.getMes()+1, sorteio.getAno())) {
				this.valores_sorteios.add(new Sorteio(1, sorteio.getMes()+1, sorteio.getAno()));
				sorteio = new Sorteio(1, sorteio.getMes()+1, sorteio.getAno());
			}
			else if (Sorteio.isDataValida(1, 1, sorteio.getAno()+1)) {
				this.valores_sorteios.add(new Sorteio(1, 1, sorteio.getAno() + 1));
				sorteio = new Sorteio(1, 1, sorteio.getAno()+1);
			}
			else {
				throw new Exception("Data invalida");
			}
		}
	}
	
	/**
	 * Insere em uma lista encadeada o resultado de um sorteio
	 *
	 * @param sorteio_v objeto que possui os numeros que foram sorteados
	 * @param num_sort quantidade de sorteios realizados
	 * @param d dia da data
	 * @param m mes da data
	 * @param a ano da data
	 * 
	 * @throws Exception para verificar se a data eh valida
	 */
	
	public void insere(int d, int m, int a, NumeroSorteados sorteio_v, int num_sort) throws Exception {
		this.valores_sorteios.add(new Sorteio(d,m,a,sorteio_v));
		aux = new Sorteio(d,m,a,sorteio_v);
		for (int i = 1;i<num_sort;i++) {
			if (Sorteio.isDataValida(aux.getDia()+1, aux.getMes(), aux.getAno())) {
				this.valores_sorteios.add(new Sorteio(aux.getDia()+1, aux.getMes(), aux.getAno()));
				aux = new Sorteio(aux.getDia()+1, aux.getMes(), aux.getAno());
			}
			else if (Sorteio.isDataValida(1, aux.getMes()+1, aux.getAno())) {
				this.valores_sorteios.add(new Sorteio(1, aux.getMes()+1, aux.getAno()));
				aux = new Sorteio(1, aux.getMes()+1, aux.getAno());
			}
			else if (Sorteio.isDataValida(1, 1, aux.getAno()+1)) {
				this.valores_sorteios.add(new Sorteio(1, 1, aux.getAno() + 1));
				aux = new Sorteio(1, 1, aux.getAno()+1);
			}
			else {
				throw new Exception("Data invalida");
			}
		}
	}
	
	/**
	 * Insere em uma lista encadeada o resultado de um sorteio
	 *
	 * @param qtdd quantidade de valores a serem sorteados em cada sorteio
	 * @param num_sort quantidade de sorteios realizados
	 * @param faixa_i limite inferior dos valores a serem sorteados
	 * @param faixa_f limite superior dos valores a serem sorteados
	 * @param d dia da data
	 * @param m mes da data
	 * @param a ano da data
	 * 
	 * @throws Exception para verificar se a data eh valida
	 */
	
	public void insere(int d, int m, int a, int qtdd, int faixa_i, int faixa_f, int num_sort) throws Exception {
		aux = new Sorteio(d,m,a,qtdd,faixa_i,faixa_f);
		this.valores_sorteios.add(aux);
		for (int i = 1;i<num_sort;i++) {
			if (Sorteio.isDataValida(aux.getDia()+1, aux.getMes(), aux.getAno())) {
				aux = new Sorteio(aux.getDia()+1, aux.getMes(), aux.getAno(),qtdd,faixa_i,faixa_f);
				this.valores_sorteios.add(aux);
			}
			else if (Sorteio.isDataValida(1, aux.getMes()+1, aux.getAno())) {
				aux = new Sorteio(1, aux.getMes()+1, aux.getAno(),qtdd,faixa_i,faixa_f);
				this.valores_sorteios.add(aux);
			}
			else if (Sorteio.isDataValida(1, 1, aux.getAno()+1)) {
				aux = new Sorteio(1, 1, aux.getAno()+1,qtdd,faixa_i,faixa_f);
				this.valores_sorteios.add(aux);
			}
			else {
				throw new Exception("Data invalida");
			}
		}
	}
	
	/**
	 * Sobreposição do método toString para retornar todo o conteúdo do Conjunto Sorteio
	 * separados por quebras de linha
	 * @return retorna uma String com todos os dados
	 */
	
	public String toString() {
		StringBuilder info = new StringBuilder();
		for (int i = 0; i < this.valores_sorteios.size();i++) {
			info.append(this.valores_sorteios.get(i) + "\n");
		}
		return info.toString();
	}
}
