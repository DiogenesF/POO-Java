import java.util.LinkedList;
import java.util.List;

public class Cliente {
	private String nome;
	private int CPF;			//O cliente possui essas informacoes, e a senha que sera utilizada quando implementarmos o banco
	private double saldo;		//de dados. As operacoes realizadas por este cliente sao armazenadas em uma linkedlist.
	private int senha;			
	private List<Operacoes> operacoes = new LinkedList<Operacoes>();
	
	public Cliente(String _nome, int _CPF, double _saldo, int _senha) {
		this.setNome(_nome);
		this.setCPF(_CPF);
		this.setSaldo(_saldo);
		this.setSenha(_senha);
	}
	
	public String getNome() {
		return this.nome;
	}
	public int getCPF() {
		return this.CPF;
	}
	public double getSaldo() {
		return this.saldo;
	}
	public int getSenha() {
		return this.senha;
	}
	public List getOperacoes() {
		return this.operacoes;
	}
	public void setNome(String _nome) {
		this.nome = _nome;
	}
	public void setCPF(int _CPF) {
		this.CPF = _CPF;
	}
	public void setSaldo(double _saldo) {
		this.saldo = _saldo;
	}
	public void setSenha(int _senha) {
		this.senha = _senha;
	}
	
	public void insere(int _CPF, Data _data, double _valor, TipoOperacao _operacao) {
		Operacoes novo = new Operacoes(_CPF, _data, _valor, _operacao); //Quando uma nova operacao eh realizada, esse metodo eh 
		this.operacoes.add(novo);										//chamado, e ele adiciona a nova operacao a linkedlist.
	}
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Nome: " + this.getNome());
		info.append("\nCPF: " + this.getCPF());
		info.append("\nSaldo: " + this.getSaldo());
		info.append("\nOperacoes da conta: " + this.getOperacoes());
		return info.toString();
	}
}
