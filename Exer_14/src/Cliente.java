
public class Cliente extends Contato{
	public static final double RENDA_LIMITE = 2000;
	public static double rendaLimite = Cliente.RENDA_LIMITE;
	private int numeroCelular;
	private String endereco;
	private double rendaFamiliar;
	
	
	public Cliente(String nome, String em, int num, String ender, double renda) throws Exception {
		super(nome, em);
		this.setNumeroCelular(num);
		this.setEndereco(ender);
		this.setRendaFamiliar(renda);
	}
	public Cliente() throws Exception {      //sobrecarregamento do construtor
		super();
		this.setNumeroCelular(0);
		this.setEndereco("");
		this.setRendaFamiliar(0);
	}
	
	public int getNumeroCelular() {
		return this.numeroCelular;
	}
	public String getEndereco() {
		return this.endereco;
	}
	public double getRendaFamiliar() {
		return this.rendaFamiliar;
	}
	public double getRendaLimite() {
		return Cliente.rendaLimite;
	}
	public void setRendaLimite(double rendaL) {
		Cliente.rendaLimite = rendaL;
	}
	public void setNumeroCelular(int num) {
		this.numeroCelular = num;
	}
	public void setEndereco(String ender) {
		this.endereco = ender;
	}
	public void setRendaFamiliar(double renda) {
		this.rendaFamiliar = renda;
	}
	
	public String clienteCategoria() {
		if (this.getRendaFamiliar() > Cliente.rendaLimite) {
			return "Top";
		}
		return "Usual";
	}
	public static String clienteCategoria(Cliente client) {  //Sobrecarregamento do metodo clienteCategoria
		if (client.getRendaFamiliar() > Cliente.rendaLimite) {
			return "Top";
		}
		return "Usual";
	}
	public boolean equals(Cliente client) {          //sobreposicao do metodo equals
		if (super.equals(client) && this.getNumeroCelular() == client.getNumeroCelular() && this.getEndereco() == 
				client.getEndereco() && this.getRendaFamiliar() == client.getRendaFamiliar()) {
			return true;
		}
		return false;
	}
	public String toString() {                 //sobreposicao do metodo toString
		StringBuilder info = new StringBuilder();
		info.append(super.toString()+"\n");
		info.append("Numero de Celular: "+this.getNumeroCelular());
		info.append("\nEndereco: "+this.getEndereco());
		info.append("\nRenda familiar: "+this.getRendaFamiliar());
		return info.toString();
	}
}
