package codigos;

/**
 * Classe Evento possui um campo para guardar o local do evento, além dos campos de sua superclasse para complementar a
 * informação sobre o evento 
 * <p>
 * Extende a Classe Abstrata ItemAgenda
 * <p>
 * A classe é auxiliada pela interface Comparable para que os itens eventos possam ser ordenados de maneira fácil
 * através do método compareTo
 * <p>
 * 
 * @author Diogenes F
 *
 */

public class Evento extends ItemAgenda implements Comparable<Evento>{
	/** String que representa o local do evento */
	private String local;
	/**
	 * Construtor que recebe 3 strings para representar o registro do item, a descricao e o local, e o periodo do evento
	 * 
	 * @param _registro_item String que representa o registro do item
	 * @param _descricao String que representa a descricao do evento
	 * @param _periodo Periodo do evento
	 * @param _local String que representa o local do evento
	 */
	public Evento(String _registro_item, String _descricao, Periodo _periodo, String _local) {
		super.setRegistroItem(_registro_item);
		super.setDescricao(_descricao);
		super.setPeriodo(_periodo);
		this.setLocal(_local);
	}
	/**
	 * Construtor que recebe 3 strings para representar o registro do item, a descricao e o local, e uma data de inicio e 
	 * de final, e um horario de inicio e de final, que representarão o periodo do evento
	 * 
	 * @param _registro_item String que representa o registro do item
	 * @param _descricao String que representa a descricao do evento
	 * @param _data_inicio Data de inicio do evento
	 * @param _data_fim Data do fim do evento
	 * @param _horario_inicio Horario do inicio do evento
	 * @param _horario_fim Horario do fim do evento
	 * @param _local String que representa o local do evento
	 */
	public Evento(String _registro_item, String _descricao, Data _data_inicio, Data _data_fim, Horario _horario_inicio, 
			Horario _horario_fim, String _local) {
		super.setRegistroItem(_registro_item);
		super.setDescricao(_descricao);
		super.setPeriodo(_data_inicio, _data_fim, _horario_inicio, _horario_fim);
		this.setLocal(_local);
	}
	/**
	 * Acessa o local do evento
	 * 
	 * @return Local do evento
	 */
	public String getLocal() {
		return this.local;
	}
	/**
	 * Método para alterar o local do evento 
	 * 
	 * @param _local String que representa o local
	 */
	public void setLocal(String _local) {
		this.local = _local;
	}
	/**
	 * Método de implementação necessária através da interface Comparable, para que o conjunto tenha a informação 
	 * de qual parametro do evento ele deve comparar com os outros objetos dessa mesma classe para ordenar, nesse caso, o local
	 */
	public int compareTo(Evento _evento) {
		return this.getLocal().compareTo(_evento.getLocal());
	}
	/**
	 * Método toString sobreposto para informar todas as informações do objeto de evento em forma de String
	 * 
	 * @return String com todos os dados de evento
	 */
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append(super.toString());
		info.append("\nLocal do Evento: " + this.getLocal() + "\n");
		return info.toString();
	}
	
}
