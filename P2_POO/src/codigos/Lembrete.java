package codigos;

/**
 * Classe Lembrete possui um campo para guardar a quantidade de minutos de antecedencia antes do alerta do lembrete, 
 * além dos campos de sua superclasse para complementar a informação sobre o lembrete 
 * <p>
 * Extende a Classe Abstrata ItemAgenda
 * <p>
 * A classe é auxiliada pela interface Comparable para que os itens lembretes possam ser ordenados de maneira fácil
 * através do método compareTo
 * <p>
 * 
 * @author Diogenes F.
 *
 */
public class Lembrete extends ItemAgenda implements Comparable<Lembrete> {
	/** Inteiro que representa a quantidade de minutos de antecedencia para alertar */
	public int min_antecedencia;
	/**
	 * Construtor que recebe 3 strings para representar o registro do item, a descricao e o periodo do evento, e a 
	 * quantidade de minutos de antecedencia para o alerta
	 * 
	 * @param _registro_item String que representa o registro do item
	 * @param _descricao String que representa a descricao do item
	 * @param _periodo Periodo do item
	 * @param _min_antecedencia Inteiro que representa a quantidade de minutos de antecedencia para o alerta
	 * @throws Exception Tratamento de erro para o parametro minutos de antecedencia
	 */
	public Lembrete(String _registro_item, String _descricao, Periodo _periodo, int _min_antecedencia) throws Exception {
		super.setRegistroItem(_registro_item);
		super.setDescricao(_descricao);
		super.setPeriodo(_periodo);
		this.setMinAntecedencia(_min_antecedencia);
	}
	/**
	 * Construtor que recebe 3 strings para representar o registro do item, a descricao e uma data inicial, uma data 
	 * final, um horario inicial e um final para representar o periodo, e a 
	 * quantidade de minutos de antecedencia para o alerta
	 * 
	 * @param _registro_item String que representa o registro do item
	 * @param _descricao String que representa a descricao do item
	 * @param _data_inicio Data de inicio
	 * @param _data_fim Data de término
	 * @param _horario_inicio Horario de inicio
	 * @param _horario_fim Horario de término
	 * @param _min_antecedencia Inteiro que representa a quantidade de minutos de antecedencia para o alerta
	 * @throws Exception Tratamento de erro para datas ou horarios invalidos
	 */
	public Lembrete(String _registro_item, String _descricao, Data _data_inicio, Data _data_fim, Horario _horario_inicio, 
			Horario _horario_fim, int _min_antecedencia) throws Exception {
		super.setRegistroItem(_registro_item);
		super.setDescricao(_descricao);
		super.setPeriodo(_data_inicio, _data_fim, _horario_inicio, _horario_fim);
		this.setMinAntecedencia(_min_antecedencia);
	}
	/**
	 * Acessa a quantidade de minutos de antecedencia para o alerta
	 * 
	 * @return Quantidade de minutos de antecedencia para o alerta
	 */
	public int getMinAntecedencia() {
		return this.min_antecedencia;
	}
	/**
	 * Método para alterar a quantidade de minutos de antecedencia para o alerta 
	 * 
	 * @param _min_antecedencia Inteiro que representa a quantidade de minutos de antecedencia para o alerta
	 * @throws Exception Tratamento de erro para tratar valores negativos
	 */
	public void setMinAntecedencia(int _min_antecedencia) throws Exception {
		if (_min_antecedencia >= 0) {
			this.min_antecedencia = _min_antecedencia;
		}
		else {
			throw new Exception("\nValor deve ser maior ou igual a zero\n");
		}
	}
	/**
	 * Método de implementação necessária através da interface Comparable, para que o conjunto tenha a informação 
	 * de qual parametro do lembrete ele deve comparar com os outros objetos dessa mesma classe para ordenar, 
	 * nesse caso, a quantidade de minutos de antecedencia
	 */
	public int compareTo(Lembrete _lembrete) {
		if (this.getMinAntecedencia() < _lembrete.getMinAntecedencia()) return -1;
		else if (this.getMinAntecedencia() > _lembrete.getMinAntecedencia()) return 1;
		else return 0;
	}
	/**
	 * Método toString sobreposto para informar todas as informações do objeto de lembrete em forma de String
	 * 
	 * @return String com todos os dados de lembrete
	 */
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append(super.toString());
		info.append("\nO lembrete vai ser acionado faltando: " + this.getMinAntecedencia() + " minutos\n");
		return info.toString();
	}

}
