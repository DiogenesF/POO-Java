
public class Chefe extends Funcionario {
	private int departamento;
	
	public Chefe(String n, int id, int dNasc, int mNasc, int aNasc, int dAdm, int mAdm, 
			int aAdm, double salario, int depart) throws Exception {
		super(n, id, dNasc, mNasc, aNasc, dAdm, mAdm, aAdm, salario);
		this.setDepartamento(depart);
	}
	public Chefe() throws Exception {
		super();
		this.setDepartamento(0);
	}
	
	public double getDepartamento() {
		return this.departamento;
	}
	public void setDepartamento(int depart) {
		this.departamento = depart;
	}
	
	public double emprestimoMax() {
		return super.emprestimoMax() * 2;
	}
	
	public String toString() {
		return super.toString() + "\nDepartamento: " + this.departamento;
	}

}
