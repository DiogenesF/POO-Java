
public class ContaPoupanca extends Conta {

	public ContaPoupanca(String _nome, int _CPF, double _saldo, int _senha) throws Exception {
		super(_nome,_CPF,_saldo,_senha);		//O construtor da classe abstrata eh utilizado
	}
	public ContaPoupanca(Cliente _cliente) {
		super(_cliente);
	}
	
	@Override
	public void depositar(double valor) throws Exception {
		double saldo = super.getCliente().getSaldo();
		if (valor <= 0) {
			throw new Exception("Valor invalido!");		//Para depositar o valor deve ser positivo
		}												//Apos alterar o saldo da conta do cliente, armazenamos nas operacoes
		else {											//do cliente atraves do metodo insere, essa nova operacao
			super.getCliente().setSaldo(saldo+valor);
			super.getCliente().insere(super.getCliente().getCPF(), Conta.getDataHoje() , valor, TipoOperacao.DEPOSITO);
		}
	}

	@Override
	public void sacar(double valor) throws Exception {
		double saldo = super.getCliente().getSaldo();
		if (valor <= 0) {
			throw new Exception("Valor invalido!");		//Para sacar o valor deve ser positivo e menor que o saldo.
		}
		else if (valor > saldo) {
			throw new Exception("Saldo insuficiente!");
		}
		else {
			super.getCliente().setSaldo(saldo-valor);	//Atualizando o saldo do cliente e armazenando a operacao
			super.getCliente().insere(super.getCliente().getCPF(), Conta.getDataHoje() , valor, TipoOperacao.SAQUE);
		}
	}

	@Override
	public void transferir(double valor, Conta conta_recebe) throws Exception {
		double saldo = super.getCliente().getSaldo();
		if (valor <= 0) {
			throw new Exception("Valor invalido!");		//Mesma ideia do de cima
		}
		else if (valor > saldo) {
			throw new Exception("Saldo insuficiente!");
		}
		else {		//Aqui alteramos tanto o saldo do cliente que fez quanto do cliente que recebeu a transferencia
			super.getCliente().setSaldo(saldo-valor);		//E armazenamos nas operacoes de cada cliente atraves do metodo insere
			conta_recebe.getCliente().setSaldo(valor+conta_recebe.getCliente().getSaldo());
			super.getCliente().insere(super.getCliente().getCPF(), Conta.getDataHoje() , valor, TipoOperacao.REALIZOU_TRANSFERENCIA);
			conta_recebe.getCliente().insere(conta_recebe.getCliente().getCPF(), Conta.getDataHoje(),
					valor, TipoOperacao.RECEBEU_TRANSFERENCIA);		
		}
	}
	
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Data de criacao: " + super.getDataCriacao()+"\n");
		info.append(super.getCliente());
		return info.toString();
	}
}
