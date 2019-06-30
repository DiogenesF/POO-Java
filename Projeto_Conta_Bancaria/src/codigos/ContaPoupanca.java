package codigos;
/**
 * Classe Conta Poupança é utilizada para a criação de uma Conta Poupança e em seguinte
 * podendo efetuar depositos, saques ou transferencias para uma conta a escolha do 
 * Usuario.
 * <p>
 * Extende a Classe Abstrata Conta onde permite a utilização dos métodos utilizando o super.
 * <p>
 * 
 * @author Arthur B. 
 * @author Ayrton S. C.
 * @author Diogenes F.
 * @author Luan S. F
 * @author Yuri C. P.
 * @version 1.0 (junho - 2019)
 */
public class ContaPoupanca extends Conta {
	/**
	 * Contrutor para a Conta Poupança que recebe como parametro o Noem, CPF, um Saldo, uma Senha,
	 * Data de nascimento, e o Tipo da Conta.
	 * OBS.:  É utilizado o super para a chamada do construtor da Classe Conta.
	 * 
	 * @param _nome Nome do Usuario
	 * @param _CPF CPF do Usuario
	 * @param _saldo Saldo do Usuario
	 * @param _senha Senha da Conta Corrente
	 * @param _data_nasc Data de Nascimento do Usuario
	 * @param _tipo_conta Tipo da Conta proposta pelo Usuario
	 * @throws Exception Tratamento para os valores da Data ou o tipo da Conta
	 */
	public ContaPoupanca(String _nome, String _CPF, double _saldo, String _senha, Data _data_nasc, int _tipo_conta) throws Exception {
		super(_nome,_CPF,_saldo,_senha, _data_nasc, _tipo_conta);		
	}
	/**
	 * Método para a Conta Poupança onde so recebe um objeto da classe Cliente e ainda é utilizado
	 * o super para acessar os métodos dessa clasee
	 * 
	 * @param _cliente Objeto cliente
	 */
	public ContaPoupanca(Cliente _cliente) {
		super(_cliente);
	}
	/**
	 * Método em que recebe o valor do saldo e caso esse valor não for
	 * um saldo negativo, é utilizando o metodo super para alterar o valor 
	 * do saldo ja existente, com o valor adicionado pelo Usuario, apos isso,
	 * é armazenado na Classe operações tambem utilizando o super para o acesso
	 * 
	 * @param valor Valor que o usuario informa para adicionr na conta
	 * @throws Exception Tratamento para quando os valores forem indevidos
	 */
	@Override
	public void depositar(double valor) throws Exception {
		double saldo = super.getCliente().getSaldo();
		if (valor <= 0) {
			throw new Exception("Valor invalido!");		
		}												
		else {											
			super.getCliente().setSaldo(saldo+valor);
			super.getCliente().insere(super.getCliente().getCPF(), Conta.getDataHoje() , valor, TipoOperacao.DEPOSITO, 1);
		}
	}
	/**
	 * Método em que é recebido um valor dado pelo Usuario para que ocorra
	 * a retirada da conta. É utilizando o super para fazer as alterações 
	 * nas operações do Cliente
	 * 
	 * @param valor Valor passado pelo usuario para ocorrer a retirada da conta
	 * @throws Exception Tratamento para valores indevidos
	 */
	@Override
	public void sacar(double valor) throws Exception {
		double saldo = super.getCliente().getSaldo();
		if (valor <= 0) {
			throw new Exception("Valor invalido!");		
		}
		//Para sacar o valor deve ser positivo e menor que o saldo.
		else if (valor > saldo) {
			throw new Exception("Saldo insuficiente!");
		}
		else {
			super.getCliente().setSaldo(saldo-valor);	
			super.getCliente().insere(super.getCliente().getCPF(), Conta.getDataHoje() , valor, TipoOperacao.SAQUE, 1);
		}
	}
	/**
	 * Método em que é recebido um valor do usuario e tambem uma determinada conta para
	 * que ocorra a transfrencia do valor informado. Mesmo modo, a utilização do super
	 * para o acesso as propriedades do Cliente é utilizada
	 * 
	 * @param valor Valor passado pelo usuario para a transferencia
	 * @param conta_recebe Conta que ira receber o valor que o usuario informou
	 * @throws Exception Tratamento para valores indevidos ou erro no acesso 
	 * as contas
	 */
	@Override
	public void transferir(double valor, Conta conta_recebe) throws Exception {
		double saldo = super.getCliente().getSaldo();
		if (valor <= 0) {
			throw new Exception("Valor invalido!");		
		}
		//Para sacar o valor deve ser positivo e menor que o saldo.
		else if (valor > saldo) {
			throw new Exception("Saldo insuficiente!");
		}
		//Aqui alteramos tanto o saldo do cliente que fez quanto do cliente que recebeu a transferencia
		//E armazenamos nas operacoes de cada cliente atraves do metodo insere
		else {		
			super.getCliente().setSaldo(saldo-valor);		
			conta_recebe.getCliente().setSaldo(valor+conta_recebe.getCliente().getSaldo());
			super.getCliente().insere(super.getCliente().getCPF(), Conta.getDataHoje() , valor, TipoOperacao.REALIZOU_TRANSFERENCIA, 1);
			conta_recebe.getCliente().insere(conta_recebe.getCliente().getCPF(), Conta.getDataHoje(),
					valor, TipoOperacao.RECEBEU_TRANSFERENCIA, 1);		
		}
	}
	/**
	 * Sobreposição do método toString para o retorno da Data da Criação da Conta,
	 * tipo que a Conta será (Conta Corrente ou Poupança) e a chamada do toString
	 * da Classe Cliente utilizando o super
	 * 
	 * @return retorna um tipo String com todos os dados
	 */
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Data de criacao: " + super.getDataCriacao()+"\n");
		info.append("Tipo da conta: " + super.getTipoConta()+"\n");
		info.append(super.getCliente());
		return info.toString();
	}
	/**
	 * Sobreposição do método toString para a exibição dos atributos das contas,
	 * onde é mostrado o CPF, Tipo da Conta, Data da criação e o Saldo
	 * 
	 * @return retora um tipo String com todos os dados
	 */
	public String toStringExibeContas() {
		StringBuilder info = new StringBuilder();
		info.append("CPF: " + super.getCliente().getCPF()+" - ");
		info.append("Tipo da Conta: " + super.getTipoConta()+" - ");
		info.append("Data de criacao: " + super.getDataCriacao()+" - ");
		info.append("Saldo: " + super.getCliente().getSaldo()+"\n");
		return info.toString();
	}
}
