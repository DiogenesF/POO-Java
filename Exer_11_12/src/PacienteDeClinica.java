
public class PacienteDeClinica extends Pessoa {
	private int planoDeSaude;

	public PacienteDeClinica(String n, int id, int d, int m, int a, int planoSaude) throws Exception {
		super(n, id, d, m, a);
		this.setPlanoDeSaude(planoSaude);
	}
	public PacienteDeClinica(String n, int id) throws Exception {
		super(n, id);
		this.setPlanoDeSaude(0);
	}
	public PacienteDeClinica() throws Exception {
		super();
		this.setPlanoDeSaude(0);
	}
	
	public int getPlanoDeSaude() {
		return this.planoDeSaude;
	}
	public void setPlanoDeSaude(int planoSaude) {
		this.planoDeSaude = planoSaude;
	}
	
	public String toString() {
		return super.toString() + "\nPlano de saude: " + this.planoDeSaude;
	}
	
}
