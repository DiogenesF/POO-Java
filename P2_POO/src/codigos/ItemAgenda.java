package codigos;


/**
 * Classe ItemAgenda abstrata para obrigar as subclasses a implementarem os métodos dessa classe
 * <p>
 * 
 * @author Diogenes F.
 *
 */
public abstract class ItemAgenda {
	/** Registro do item e descrição do item */
	private String registro_item, descricao;
	/** Periodo de tempo do item*/
	private Periodo periodo;
	
	/**
	 * Acessa o registro do item
	 * 
	 * @return Registro do item
	 */
	public String getRegistroItem() {
		return this.registro_item;
	}
	/**
	 * Acessa a descrição do item
	 * 
	 * @return Descrição do item
	 */
	public String getDescricao() {
		return this.descricao;
	}
	/**
	 * Acessa o periodo do item
	 * 
	 * @return Periodo do item
	 */
	public Periodo getPeriodo() {
		return this.periodo;
	}
	/**
	 * Altera o registro do item, recebendo uma nova string que representa essa informação
	 * 
	 * @param _registro_item String que representa o registro do item
	 */
	public void setRegistroItem(String _registro_item) {
		this.registro_item = _registro_item;
	}
	/**
	 * Altera a descrição do item, recebendo uma nova string que representa essa informação
	 * 
	 * @param _descricao String que representa a descrição do item
	 */
	public void setDescricao(String _descricao) {
		this.descricao = _descricao;
	}
	/**
	 * Altera o periodo do item, recebendo um novo periodo que representa essa informação
	 * 
	 * @param _periodo Periodo que representa o periodo do item
	 */
	public void setPeriodo(Periodo _periodo) {
		this.periodo = _periodo;
	}
	/**
	 * Altera o registro do item, recebendo uma data de inicio, data final, horario de inicio e horario final
	 * 
	 * @param _data_inicio Data de inicio
	 * @param _data_fim Data de término
	 * @param _horario_inicio Horario de inicio
	 * @param _horario_fim Horario de término
	 * 
	 */
	public void setPeriodo(Data _data_inicio, Data _data_fim, Horario _horario_inicio, Horario _horario_fim) {
		this.periodo = new Periodo(_data_inicio, _data_fim, _horario_inicio, _horario_fim);
	}
	/**
	 * Método para retornar as informações em formato de string
	 * 
	 * @return String que retorna todos os dados
	 */
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("\nRegistro do Item: " + this.getRegistroItem());
		info.append("\nDescricao: " + this.getDescricao());
		info.append("\nPeriodo: " + this.getPeriodo());
		return info.toString();
	}
	
}
