package codigos;


public abstract class Conta {
	private static double juros_poupanca = 1.0/100;
	private int tipo_conta;
	private Cliente cliente;						//Classe do tipo Conta (abstrata), possui o cliente da conta (contem os dados)
	private Data data_criacao;						//do cliente. Armazena a data de criacao da conta e possui um campo estatico
	private static Data data_hoje = new Data(1,1,2000); //para indicar a data de hoje, decidi adotar a data 1/1/2000 para facilitar
														// os testes apenas.
	public Conta(Cliente _cliente) {
		this.setCliente(_cliente);						//Quando o construtor eh chamado ele preenche o campo Cliente e atribui a
		this.data_criacao = Conta.getDataHoje();		//data de criacao a data de hoje
	}
	public Conta(String _nome, String _CPF, double _saldo, String _senha, Data _data_nasc, int _tipo_conta) {
		this.setCliente( _nome,  _CPF,  _saldo,  _senha, _data_nasc);
		this.data_criacao = Conta.getDataHoje();
		this.tipo_conta = _tipo_conta;
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
	public static double getJurosPoupanca() {
		return Conta.getJurosPoupanca();
	}
	public int getTipoConta() {
		return this.tipo_conta;
	}
	public void setCliente(Cliente _cliente) {
		this.cliente = _cliente;
	}
	public void setCliente(String _nome, String _CPF, double _saldo, String _senha, Data _data_nasc) {
		this.cliente = new Cliente( _nome,  _CPF,  _saldo,  _senha, _data_nasc);
	}
	public void setDataCriacao(Data _data) {
		this.data_criacao = _data;
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
