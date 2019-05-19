
public class Diretor extends Chefe {
	private Data dataProm;
	
	public Diretor(String n, int id, int dNasc, int mNasc, int aNasc, int dAdm, int mAdm, int aAdm, double salario,
			int depart, int diaProm, int mesProm, int anoProm) throws Exception {
		super(n, id, dNasc, mNasc, aNasc, dAdm, mAdm, aAdm, salario, depart);
		setDataProm(diaProm,mesProm,anoProm);
	}
	public Diretor() throws Exception {
		super();
		setDataProm();
	}
	
	public Data getDataProm() {
		return this.dataProm;
	}
	public void setDataProm(int dProm, int mProm, int aProm) throws Exception {
		this.dataProm = new Data(dProm, mProm, aProm);
	}
	public void setDataProm() throws Exception {
		this.dataProm = new Data();
	}
	
	public double emprestimoMax() {
		return super.emprestimoMax() * 1.5;
	}
	
	public String toString() {
		return super.toString() + "\nData de Promocao: " + this.dataProm;
	}
}
