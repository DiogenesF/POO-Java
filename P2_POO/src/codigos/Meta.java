package codigos;

/**
 * Classe Meta possui um campo para guardar a prioridade da meta, além dos campos de sua superclasse para complementar a
 * informação sobre a meta 
 * <p>
 * Extende a Classe Abstrata ItemAgenda
 * <p>
 * A classe é auxiliada pela interface Comparable para que os itens metas possam ser ordenados de maneira fácil
 * através do método compareTo
 * <p>
 * 
 * @author Diogenes F.
 *
 */

public class Meta extends ItemAgenda implements Comparable<Meta> {
	/** Inteiro que representa a prioridade da meta */
	private int prioridade;
	
	/**
	 * Construtor que recebe 3 strings para representar o registro do item, a descricao e o periodo do evento, e a 
	 * prioridade da meta
	 * 
	 * @param _registro_item String que representa o registro do item
	 * @param _descricao String que representa a descricao do item
	 * @param _periodo Periodo do item
	 * @param _prioridade Inteiro que representa a prioridade da meta
	 * @throws Exception Tratamento de erro para valores negativos de prioridade
	 */
	public Meta(String _registro_item, String _descricao, Periodo _periodo, int _prioridade) throws Exception {
		super.setRegistroItem(_registro_item);
		super.setDescricao(_descricao);
		super.setPeriodo(_periodo);
		this.setPrioridade(_prioridade);
	}
	/**
	 * Construtor que recebe 3 strings para representar o registro do item, a descricao e uma data inicial, uma data 
	 * final, um horario inicial e um final para representar o periodo, e a 
	 * prioridade da meta
	 * 
	 * @param _registro_item String que representa o registro do item
	 * @param _descricao String que representa a descricao do item
	 * @param _data_inicio Data de inicio
	 * @param _data_fim Data de término
	 * @param _horario_inicio Horario de inicio
	 * @param _horario_fim Horario de término
	 * @param _prioridade Inteiro que representa a prioridade da meta
	 * @throws Exception Tratamento de erro para datas e horarios invalidos
	 */
	public Meta(String _registro_item, String _descricao, Data _data_inicio, Data _data_fim, Horario _horario_inicio, 
			Horario _horario_fim, int _prioridade) throws Exception {
		super.setRegistroItem(_registro_item);
		super.setPeriodo(_data_inicio, _data_fim, _horario_inicio, _horario_fim);
		super.setDescricao(_descricao);
		this.setPrioridade(_prioridade);
	}
	/**
	 * Acessa a prioridade da meta
	 * 
	 * @return Prioridade da meta
	 */
	public int getPrioridade() {
		return this.prioridade;
	}
	/**
	 * Método para alterar a prioridade da meta
	 * 
	 * @param _prioridade Inteiro que representa a prioridade da meta
	 * @throws Exception Tratamento de erro para tratar valores de prioridade negativos
	 */
	public void setPrioridade(int _prioridade) throws Exception {
		if (_prioridade < 1) {
			throw new Exception("\nO valor da prioridade deve ser maior do que zero\n");
		}
		else {
			this.prioridade = _prioridade;
		}
	}
	/**
	 * Método de implementação necessária através da interface Comparable, para que o conjunto tenha a informação 
	 * de qual parametro da meta ele deve comparar com os outros objetos dessa mesma classe para ordenar, 
	 * nesse caso, a prioridade
	 */
	public int compareTo(Meta _meta) {
		if (this.getPrioridade() < _meta.getPrioridade()) return -1;
		else if (this.getPrioridade() > _meta.getPrioridade()) return 1;
		else return 0;
	}
	/**
	 * Método toString sobreposto para informar todas as informações do objeto da meta em forma de String
	 * 
	 * @return String com todos os dados da meta
	 */
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append(super.toString());
		info.append("\nPrioridade da meta: " + this.getPrioridade() + "\n");
		return info.toString();
	}	
	
}
