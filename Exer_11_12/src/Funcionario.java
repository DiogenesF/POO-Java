
public class Funcionario extends Pessoa {
	private Data dataAdmissao;
	private double salario;
	
	public Funcionario(String n, int id, int dNasc, int mNasc, int aNasc, int dAdm, int mAdm, 
			int aAdm, double salario) throws Exception {
		super(n,id,dNasc,mNasc,aNasc);
		setDataAdmissao(dAdm,mAdm,aAdm);
		setSalario(salario);
	}
	public Funcionario() throws Exception {
		super();
		setDataAdmissao();
		setSalario(0);
	}
	
	public double getSalario() {
		return this.salario;
	}
	public Data getDataAdmissao() {
		return this.dataAdmissao;
	}
	public void setDataAdmissao(int dAdm,int mAdm,int aAdm) throws Exception {
		this.dataAdmissao = new Data(dAdm,mAdm,aAdm);
	}
	public void setDataAdmissao() throws Exception {
		this.dataAdmissao = new Data();
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public void reajustaSalario(double taxa) { //Esse metodo ficara disponivel para as subclasses
		this.salario = this.salario*taxa;     //de funcionario e seu uso 
	}                                        //deve ser feito atraves de super.
	
	public double emprestimoMax() {
		return this.salario;
	}
	
	public String toString() {
		System.out.println(this.dataAdmissao);
		return super.toString() + "\nData de Admissao: " + this.dataAdmissao + "\nSalario: "
				+ this.salario;
	}
	

}
