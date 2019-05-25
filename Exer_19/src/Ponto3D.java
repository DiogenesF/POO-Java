
public class Ponto3D extends Ponto{
	private double z;
	
	public Ponto3D(double x,double y,double z) throws Exception{
		super(x, y);
		this.setZ(z);
	}
	
	public double getZ() {
		return this.z;
	}
	public void setZ(double z) throws Exception{
		if(super.isLimiteValido(z)) 	
			this.z = z;
		else
			throw new Exception ("Valor de z fora dos limites");
	}
	
	public Ponto clonar() throws Exception {
		return new Ponto3D(super.getX(), super.getY(), this.getZ());
	}
	public Ponto criaSwap() throws Exception {
		return new Ponto3D(super.getY(), super.getX(), this.getZ());
	}
	public boolean temEixoComum(Ponto3D ponto){
		return super.getX() == ponto.getX() || super.getY() == ponto.getY() || this.getZ() == ponto.getZ();
	}
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("(");
		info.append(super.getX());
		info.append(",");
		info.append(super.getY());
		info.append(",");
		info.append(this.getZ());
		info.append(")");
		return info.toString();
	}
}