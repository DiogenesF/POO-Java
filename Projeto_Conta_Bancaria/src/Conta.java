//PERGUNTAR AO PROFESSOR COMO FAZER PARA QUE OS JUROS DA CONTA POUPANCA RENDA PARA
//TODAS AS INSTANCIAS DE CONTA POUPANCA CRIADAS. VOCE PODE DETERMINAR QUE OS JUROS SERAO DE 1%, MAS EH NECESSARIO
//QUE O SALDO DE CADA OBJETO DA CLASSE CONTA POUPANCA REALIZE O AJUSTE DE FORMA AUTOMATICA NO DIA 5 DE CADA MES,
//OU SEJA, QUANDO CHAMARMOS O METODO incrementaDataHoje, podemos fazer: if (Conta.data_hoje.getDia == 5) 'ai aqui deveriamos
//arrumar um jeito de alterar o saldo de todas as contas poupancas para saldo = saldo * 1.1'

public abstract class Conta {
	private Cliente cliente;						//Classe do tipo Conta (abstrata), possui o cliente da conta (contem os dados)
	private Data data_criacao;						//do cliente. Armazena a data de criacao da conta e possui um campo estatico
	private static Data data_hoje = new Data(1,1,2000); //para indicar a data de hoje, decidi adotar a data 1/1/2000 para facilitar
														// os testes apenas.
	public Conta(Cliente _cliente) {
		this.setCliente(_cliente);						//Quando o construtor eh chamado ele preenche o campo Cliente e atribui a
		this.data_criacao = Conta.getDataHoje();		//data de criacao a data de hoje
	}
	public Conta(String _nome, int _CPF, double _saldo, int _senha) {
		this.setCliente( _nome,  _CPF,  _saldo,  _senha);
		this.data_criacao = Conta.getDataHoje();
	}
	
	
	public static Data getDataHoje() {
		return Conta.data_hoje;
	}
	public Data getDataCriacao() {
		return this.data_criacao;
	}
	public Cliente getCliente() {
		return this.cliente;
	}
	public void setCliente(Cliente _cliente) {
		this.cliente = _cliente;
	}
	public void setCliente(String _nome, int _CPF, double _saldo, int _senha) {
		this.cliente = new Cliente( _nome,  _CPF,  _saldo,  _senha);
	}
	
	public static void incrementaDataHoje() throws Exception {	//Metodo para fazer os dias (da data de hoje) passarem
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
	
	abstract public void depositar(double valor) throws Exception;
	abstract public void sacar(double valor) throws Exception;
	abstract public void transferir(double valor, Conta conta_recebe) throws Exception;
}
