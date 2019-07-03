package codigos;

/**
 * Classe Abstrata Conta é utilizada para definir um juros para o tipo poupança,
 * um tipo de conta (poupança ou conta corrente), agrega a classe Cliente onde utiliza todas 
 * as caracteríscas do mesmo, uma Data de Criação de uma determinada conta, e uma data
 * programada para ser o inicio do programa.
 * 
 * <p>
 * @author Arthur B. 
 * @author Ayrton S. C.
 * @author Diogenes F.
 * @author Luan S. F
 * @author Yuri C. P.
 * @version 1.0 (junho - 2019)
 */
public abstract class Conta {
	/** Juros adotado para a poupança.*/
	private static double juros_poupanca = 1.0/100;
	/** Tipo de conta proposta pelo Usuario (Poupança ou Conta Corrente).*/
	private int tipo_conta;
	/** Classe Cliente onde caracteriza o Cliente. */
	private Cliente cliente;						
	/** Classe Data onde caracteria a data da criação da Conta. */
	private Data data_criacao;						
	/** Data utilizada para iniciar o programa. */
	private static Data data_hoje = new Data(1,1,2000); 
	
	/**
	 * Construtor que recebe como parametro, somente o tipo Cliente para a 
	 * criação da conta.
	 * OBS.: Quando esse contrutor é utilizado, a data utilizada será a data do dia atual. 
	 * 
	 * @param _cliente Objeto cliente
	 */
	public Conta(Cliente _cliente) {
		this.setCliente(_cliente);						
		this.data_criacao = Conta.getDataHoje();		
	}
	
	/**
	 * Contrutor completo onde recebe do Usuario o Nome, CPF, Saldo para a Conta,
	 * Senha, Data de Nascimento e o Tipo de Conta a ser criada.
	 * 
	 * @param _nome Nome do Usuario.
	 * @param _CPF CPF do Usuario.
	 * @param _saldo Valor do saldo.
	 * @param _senha Senha da conta do Usuario.
	 * @param _data_nasc Data de Nacimento do Usuario.
	 * @param _tipo_conta Tipo da Conta que o Usuario deseja.
	 */
	public Conta(String _nome, String _CPF, double _saldo, String _senha, Data _data_nasc, int _tipo_conta) {
		this.setCliente( _nome,  _CPF,  _saldo,  _senha, _data_nasc);
		this.data_criacao = Conta.getDataHoje();
		this.tipo_conta = _tipo_conta;
	}
	/**
	 * Captura a data do dia atual
	 * 
	 * @return data do dia atual
	 */
	public static Data getDataHoje() {
		return Conta.data_hoje;
	}
	/**
	 * Captura a data da criação da conta
	 * 
	 * @return a data da criação da conta
	 */
	public Data getDataCriacao() {
		return this.data_criacao;
	}
	/**
	 * Captura todas as caracteristicas do cliente da Classe Cliente
	 * 
	 * @return caracteristicas do Cliente
	 */
	public Cliente getCliente() {
		return this.cliente;
	}
	/**
	 * Captura o juros da poupança no modo statico
	 * 
	 * @return o valor do juros
	 */
	public static double getJurosPoupanca() {
		return Conta.getJurosPoupanca();
	}
	/**
	 * Captura o tipo da Conta informada pelo Usuario
	 * 
	 * @return o tipo da conta
	 */
	public int getTipoConta() {
		return this.tipo_conta;
	}
	/**
	 * Modifica o objeto cliente da Classe Cliente
	 * 
	 * @param _cliente cliente a ser mdificado
	 */
	public void setCliente(Cliente _cliente) {
		this.cliente = _cliente;
	}
	/**
	 * Sobreposição do método setCliente onde recebe os parametros soltos 
	 * da Classe Cliente
	 * 
	 * @param _nome Nome do Usuario
	 * @param _CPF CPF do Usuario
	 * @param _saldo Saldo passado pelo usuario
	 * @param _senha Senha do Usuario
	 * @param _data_nasc Data de Nascimento do Usuario
	 */
	public void setCliente(String _nome, String _CPF, double _saldo, String _senha, Data _data_nasc) {
		this.cliente = new Cliente( _nome,  _CPF,  _saldo,  _senha, _data_nasc);
	}
	
	/**
	 * Modifica a Data recebendo um data como parametro
	 * 
	 * @param _data Data a ser modificada
	 */
	public void setDataCriacao(Data _data) {
		this.data_criacao = _data;
	}
	
	/**
	 * Método que faz acontecer a passagem de dias
	 * 
	 * @throws Exception para caso a data não esteja nos parametros desejados
	 */
	public static void incrementaDataHoje() throws Exception {	
		if (Data.isDataValida(Conta.data_hoje.getDia()+1, Conta.data_hoje.getMes(), Conta.data_hoje.getAno())) {
			Conta.data_hoje = new Data(Conta.data_hoje.getDia()+1, Conta.data_hoje.getMes(), Conta.data_hoje.getAno());
		}
		else if (Data.isDataValida(1, Conta.data_hoje.getMes()+1, Conta.data_hoje.getAno())) {
			Conta.data_hoje = new Data(1, Conta.data_hoje.getMes()+1, Conta.data_hoje.getAno());
		}
		else if (Data.isDataValida(1, 1, Conta.data_hoje.getAno()+1)) {
			Conta.data_hoje = new Data(1, 1, Conta.data_hoje.getAno()+1);
		}
		else {
			throw new Exception("Data invalida!");
		}
	}
	/**
	 * Método Abstrato onde ocorre o deposito em que é passado como parametro
	 * o valor a ser depositado
	 * 
	 * @param valor Valor a ser depositado
	 * @throws Exception Tratamento para se o Valor passado for indevido
	 */
	abstract public void depositar(double valor) throws Exception;
	/**
	 * Método Abstrato onde ocorre o saque de um valor passado como parametro
	 * 
	 * @param valor Valor a ser sacado
	 * @throws Exception Tratamento para se o Valor passado for indevido
	 */
	abstract public void sacar(double valor) throws Exception;
	/**
	 * Método Abstrato onde ocorre a transferencia de um valor para uma 
	 * outra conta
	 * 
	 * @param valor Valor a ser transferido
	 * @param conta_receber Conta para qual foi transferida o valor passado
	 * @throws Exception Tratamento tanto para o valor quanto da conta a ser transferida
	 */
	abstract public void transferir(double valor, Conta conta_recebe) throws Exception;
}
