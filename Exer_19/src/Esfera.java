
public class Esfera implements ObjetoTridimensional{
	private Ponto3D p;
	private double raio;
	
	public Esfera(double x, double y, double z, double r) throws Exception{
		this.p = new Ponto3D(x, y, z);
		this.setRaio(r);
	}
	
	public double getRaio() {
		return this.raio;
	}
	public Ponto3D getPonto() {
		return this.p;
	}
	public void setRaio(double r) {
		this.raio = r;
	}
	
	public Ponto3D centro() {
		return this.getPonto();
	}
	public double calculaSuperficie() {
		return (4 * Math.pow(Math.PI, 2));
	}
	public double calculaVolume() {
		return ((4/3) * Math.pow(this.getRaio(), 3));
	}
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append(this.p.toString());
		info.append(" - ");
		info.append(this.getRaio());
		return info.toString();
	}
}