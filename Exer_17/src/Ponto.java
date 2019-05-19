
public class Ponto {
	private Coordenada c1, c2;
	
	public Ponto() {
		this.setPonto(0,0);
	}
	public Ponto(double a1) {
		this.setPonto(a1,0);
	}
	public Ponto(double a1, double a2) {
		this.setPonto(a1,a2);
	}
	public Ponto(Coordenada c1, Coordenada c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	
	public Coordenada getC1() {
		return this.c1;
	}
	public Coordenada getC2() { 
		return this.c2;
	}
	public void setPonto(double a1, double a2) {
		this.c1 = new Coordenada(a1);
		this.c2 = new Coordenada(a2);
	}
	public void setPonto(Coordenada a1, Coordenada a2) {
		this.c1 = a1;
		this.c2 = a2;
	}
	
	public boolean equals(Ponto point) {
		if (this.c1 == point.getC1() && this.c2 == point.getC2()) {
			return true;
		}
		return false;
	}
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append("Ponto: ("+c1+","+c2+")");
		return dados.toString();
	}
}
