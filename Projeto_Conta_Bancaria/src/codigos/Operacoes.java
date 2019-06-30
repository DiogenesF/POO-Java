package codigos;
/**
 * Classe Operações utilizada para reter as caracteristicas das operações
 * feitas pelo Usuario ou que serão feitas.
 * <p>
 * 
 * @author Arthur B. 
 * @author Ayrton S. C.
 * @author Diogenes F.
 * @author Luan S. F
 * @author Yuri C. P.
 * @version 1.0 (junho - 2019)
 */
public class Operacoes {
	/** CPF do Usuario que esta fazendo a operação. */
	private String CPF_operacao;
	/** Data em que o Usuario esta fazendo a operação em que é utilizado a Classe Data. */
	private Data data_operacao;
	/** Valor da operação feita pelo Usuario. */
	private double valor_operacao;
	/** Tipo da conta em que o Usuario está utilizando. */
	private int tipo_conta;
	/** Tipo de operação feita pelo Usuario utilizando uma Enum Tipo Operação. */
	private TipoOperacao tipo_operacao;
	/**
	 * Contrutor Operações em que recebe de quem esta fazendo as operações (conta que esta operando),
	 * um CPF, uma Data, um Valor, o Tipo da Operação e o Tipo da Conta
	 * 
	 * @param CPF_op CPF do operante
	 * @param _data Data de quando ocorrer a operação
	 * @param valor_op Valor qu sera operado
	 * @param tipo_op Tipo da operação que será realizada
	 * @param _tipo_conta Tipo da conta que será a operação
	 */
	public Operacoes(String CPF_op, Data _data, double valor_op, TipoOperacao tipo_op, int _tipo_conta) {
		this.setCPFOperacao(CPF_op);
		this.setTipoOperacao(tipo_op);
		this.setValorOperacao(valor_op);
		this.tipo_conta = _tipo_conta;
		this.data_operacao = _data;
	}
	/**
	 * Construtor Operações que recebe de quem esta fazeno a operação (Conta que esta operando), 
	 * um CPF, Dia, Mês, Ano, Valor, Tipo de Operação e um tipo de conta
	 * 
	 * @param CPF_op CPF do operante
	 * @param d Dia da operação
	 * @param m Mês da operação
	 * @param a Ano da operação
	 * @param valor _op Valor a ser operado
	 * @param tipo_op Tipo de operação a ser feita
	 * @param _tipo_conta Tipo da Conta a ser operacionada
	 * @throws Exception Tratamento para algum tipo de erro
	 */
	public Operacoes(String CPF_op, int d,int m, int a, double valor_op, TipoOperacao tipo_op, int _tipo_conta) throws Exception {
		this.setCPFOperacao(CPF_op);
		this.setTipoOperacao(tipo_op);
		this.setValorOperacao(valor_op);
		this.tipo_conta = _tipo_conta;
		this.data_operacao = new Data(d,m,a);
	}
	/**
	 * Captura o CPF do operante
	 * 
	 * @return o CPF do operante
	 */
	public String getCPFOperacao() {
		return this.CPF_operacao;
	}
	/**
	 * Captura o Valor do operante
	 * 
	 * @return o Valor do operante
	 */
	public double getValorOperacao() {
		return this.valor_operacao;
	}
	/**
	 * Captura o Tipo da Operação
	 * 
	 * @return o Tipo da Operação
	 */
	public TipoOperacao getTipoOperacao() {
		return this.tipo_operacao;
	}
	/**
	 * Captura a Data da Operação
	 * 
	 * @return a Data da operação
	 */
	public Data getDataOperacao() {
		return this.data_operacao;
	}
	/**
	 * Captura o Tipo da Conta ~
	 * 
	 * @return o Tipo da Conta
	 */
	public int getTipoConta() {
		return this.tipo_conta;
	}
	/**
	 * Modifica o CPF do Operante 
	 * 
	 * @param CPF_op CPF do Operante
	 */
	public void setCPFOperacao(String CPF_op) {
		this.CPF_operacao = CPF_op;
	}
	/**
	 * Modifica o Valor a ser Operado
	 * 
	 * @param valor_op Valor qu foi Operado
	 */
	public void setValorOperacao(double valor_op) {
		this.valor_operacao = valor_op;
	}
	/**
	 * Modifica o Tipo da Operação 
	 * 
	 * @tipo_op Objeto do Tipo Operação
	 */
	public void setTipoOperacao(TipoOperacao tipo_op) {
		this.tipo_operacao = tipo_op;
	}
	/**
	 * Sobrecarregamento do método toString para retornar ao Usuario, a Data, CPF, Valor
	 * e o Tipo de Operação que foi feita
	 * 
	 * @return retorna um tipo de String com todos os dados
	 */
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("\n" + this.getDataOperacao());
		info.append(" " + this.getCPFOperacao());
		info.append(" " + this.getValorOperacao());
		info.append(" " + this.getTipoOperacao());
		return info.toString();
	}
}
