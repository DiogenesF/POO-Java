public class Pessoa{
	private String nome;
	private int identidade;
	private Data dataNascimento;
	
	public Pessoa(String n, int id, int d, int m, int a) throws Exception {
		this.setData(d,m,a);
		this.setNome(n);
		this.setId(id);
	}
	public Pessoa(String n, int id) throws Exception {
		this.setData();
		setNome(n);
		setId(id);
	}
	public Pessoa() throws Exception {
		this.setData();
		setNome("");
		setId(0);
	}
	
	public String getNome() {
		return this.nome;
	}
	public int getId () {
		return this.identidade;
	}
	public Data getData() {
		return this.dataNascimento;
	}
	public void setNome(String n) {
		this.nome = n;
	}
	public void setId(int id) {
		this.identidade = id;
	}
	public void setData(int d, int m, int a) throws Exception {
		this.dataNascimento = new Data(d,m,a);
	}
	public void setData() throws Exception {
		this.dataNascimento = new Data();
	}
	
	public double emprestimoMax() {
		return 1000;
	}
	
	public String toString() {
		StringBuilder dado = new StringBuilder();
		dado.append("Nome: " + this.nome);
		dado.append("\nIdentidade: " + this.identidade);
		dado.append("\nData de Nascimento: " + this.dataNascimento);
		return dado.toString();
	}
	
}
