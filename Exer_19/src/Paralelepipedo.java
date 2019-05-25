
public class Paralelepipedo implements ObjetoTridimensional{
	private Ponto3D pe, pd;
	  
	public Paralelepipedo(double x1, double y1, double z1, double x2, double y2, double z2) throws Exception{
		this.setParalelepipedo(new Ponto3D(x1, y1, z1), new Ponto3D(x2, y2, z2));
	}
	
	public Ponto3D getPe() {
		return this.pe;
	}
	public Ponto3D getPd() {
		return this.pd;
	}
	public double getLadoA() {
		return (Math.abs(this.pe.getX() - this.pd.getX()));
	}
	public double getLadoB() {
		return (Math.abs(this.pe.getY() - this.pd.getY()));
	}
	public double getLadoC() {
		return (Math.abs(this.pe.getZ() - this.pd.getZ()));
	}
	public void setParalelepipedo(Ponto3D p1, Ponto3D p2) {
		this.pe = p1;
		this.pd = p2;
	}
	
	public Ponto3D centro() throws Exception{
		Ponto3D c = new Ponto3D(this.getLadoA()/2, this.getLadoB()/2, this.getLadoC()/2);
		return c;
	}
	public double calculaSuperficie(){
		return (2 * (this.getLadoA() * this.getLadoB() + this.getLadoC() * this.getLadoB() + this.getLadoA() * this.getLadoC()));
	}
	public double calculaVolume() {
		return (this.getLadoA() * this.getLadoB() * this.getLadoC());
	}
	
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append(this.pe.toString());
		info.append(" - ");
		info.append(this.pd.toString());
		info.append(" - ");
		info.append("Lado A: ");
		info.append(this.getLadoA());
		info.append("Lado B: ");
		info.append(this.getLadoB());
		info.append("Lado C: ");
		info.append(this.getLadoC());
		return info.toString();
	}
}