package codigos;

public class Operacoes {
	private String CPF_operacao;
	private Data data_operacao;			//Uma operacao sera armazenada com essas informacoes
	private double valor_operacao;
	private int tipo_conta;
	private TipoOperacao tipo_operacao;
	
	public Operacoes(String CPF_op, Data _data, double valor_op, TipoOperacao tipo_op, int _tipo_conta) {
		this.setCPFOperacao(CPF_op);
		this.setTipoOperacao(tipo_op);
		this.setValorOperacao(valor_op);
		this.tipo_conta = _tipo_conta;
		this.data_operacao = _data;
	}
	public Operacoes(String CPF_op, int d,int m, int a, double valor_op, TipoOperacao tipo_op, int _tipo_conta) throws Exception {
		this.setCPFOperacao(CPF_op);
		this.setTipoOperacao(tipo_op);
		this.setValorOperacao(valor_op);
		this.tipo_conta = _tipo_conta;
		this.data_operacao = new Data(d,m,a);
	}
	
	public String getCPFOperacao() {
		return this.CPF_operacao;
	}
	public double getValorOperacao() {
		return this.valor_operacao;
	}
	public TipoOperacao getTipoOperacao() {
		return this.tipo_operacao;
	}
	public Data getDataOperacao() {
		return this.data_operacao;
	}
	public int getTipoConta() {
		return this.tipo_conta;
	}
	public void setCPFOperacao(String CPF_op) {
		this.CPF_operacao = CPF_op;
	}
	public void setValorOperacao(double valor_op) {
		this.valor_operacao = valor_op;
	}
	public void setTipoOperacao(TipoOperacao tipo_op) {
		this.tipo_operacao = tipo_op;
	}
	
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("\n" + this.getDataOperacao());
		info.append(" " + this.getCPFOperacao());
		info.append(" " + this.getValorOperacao());
		info.append(" " + this.getTipoOperacao());
		return info.toString();
	}
}
