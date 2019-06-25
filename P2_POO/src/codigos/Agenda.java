package codigos;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Classe Agenda possui uma lista encadeada para armazenar todos os itens de agenda (Meta, Evento e Lembrete)
 * e também possui métodos específicos para gerar relatórios para o usuário.
 * <p>
 * 
 * 
 * @author Diogenes F.
 *
 */

public class Agenda {
	private List<ItemAgenda> itens_da_agenda;
	/**
	 * Construtor para instanciar a lista encadeada do tipo ItemAgenda
	 */
	public Agenda() {
		itens_da_agenda = new LinkedList<ItemAgenda>();
	}
	/**
	 * Método para acessar os itens da agenda
	 * 
	 * @return itens da agenda
	 */
	public List getItensDaAgenda() {
		return this.itens_da_agenda;
	}
	/**
	 * Metodo usado para inserir um novo item para os itens da agenda
	 *  
	 * @param _novo_item insere um novo item nos itens da agenda
	 */
	public void insereItem(ItemAgenda _novo_item) {
		this.itens_da_agenda.add(_novo_item);
	}
	/**
	 * Método que percorre os itens da agenda e armazena as metas em uma TreeSet para que 
	 * os valores ja sejam inseridos de forma que as prioridades estejam em ordem crescente (com o auxilio da 
	 * interface Comparable na classe Meta)
	 * 
	 * 
	 * @return conjunto com as metas ordenadas por prioridade
	 */
	public Set informaMetasPorPrioridade() {
		int i;
		Set<Meta> metas_ordenadas = new TreeSet<Meta>();
		for (i = 0; i < this.itens_da_agenda.size();i++) {
			if (this.itens_da_agenda.get(i).getClass().toString().equalsIgnoreCase("class codigos.Meta")) {
				metas_ordenadas.add((Meta) this.itens_da_agenda.get(i));
			}
		}
		return metas_ordenadas;
	}
	/**
	 * Método que percorre os itens da agenda e armazena os lembretes em uma TreeSet para que 
	 * os valores ja sejam inseridos de forma que os minutos de antecedencia estejam em ordem crescente (com o auxilio da 
	 * interface Comparable na classe Lembrete)
	 * 
	 * @return conjunto com os lembretes ordenados por minuto de antecedencia
	 */
	public Set informaLembretesPorMinDeAntecedencia() {
		int i;
		Set<Lembrete> lembretes_ordenados = new TreeSet<Lembrete>();
		for (i = 0; i < this.itens_da_agenda.size();i++) {
			if (this.itens_da_agenda.get(i).getClass().toString().equalsIgnoreCase("class codigos.Lembrete")) {
				lembretes_ordenados.add((Lembrete) this.itens_da_agenda.get(i));
			}
		}
		
		return lembretes_ordenados;
	}
	/**
	 * Método que percorre os itens da agenda e armazena os eventos em uma TreeSet para que 
	 * os valores ja sejam inseridos de forma que os locais ja estejam em ordem crescente lexicograficamente (com o 
	 * auxilio da interface Comparable na classe Evento)
	 * 
	 * @return conjunto com os eventos ordenados por local
	 */
	public Set informaEventosPorLocal() {
		int i;
		Set<Evento> eventos_ordenados = new TreeSet<Evento>();
		for (i = 0; i < this.itens_da_agenda.size();i++) {
			if (this.itens_da_agenda.get(i).getClass().toString().equalsIgnoreCase("class codigos.Evento")) {
				eventos_ordenados.add((Evento) this.itens_da_agenda.get(i));
			}
		}
		return eventos_ordenados;
	}
	/**
	 * Método que retorna todos os itens da agenda na ordem que o usuario os adicionou
	 * 
	 * @return todos os itens da agenda
	 */
	public List informaTodosOsItens() {
		return this.getItensDaAgenda();
	}
	/**
	 * Método que retorna os itens da agenda que estejam entre um intervalo de datas passadas pelo usuário
	 * 
	 * @param _inicial Data inicial passada pelo usuario
	 * @param _final Data final passada pelo usuario
	 * @return retorna os itens em que o inicio e fim esteja dentro das datas informadas
	 */
	public List informaItensNoIntervaloDeData(Data _inicial, Data _final) {
		int i;
		List<ItemAgenda> itens_entre_data_informada = new LinkedList<ItemAgenda>();
		for (i = 0; i < this.itens_da_agenda.size(); i++) {
			if (Data.compareTo(this.itens_da_agenda.get(i).getPeriodo().getDataInicio(), _inicial) != -1 && 
					Data.compareTo(this.itens_da_agenda.get(i).getPeriodo().getDataFim(), _final) != 1) {
				itens_entre_data_informada.add(this.itens_da_agenda.get(i));
			}
		}
		return itens_entre_data_informada;
	}
	/**
	 * Método que retorna todos os itens da agenda em forma de String
	 * 
	 * @return String com todos os itens da agenda
	 */
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append(this.itens_da_agenda);
		return info.toString();
	}
}
