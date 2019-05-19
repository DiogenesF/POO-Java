import java.lang.Math;

public class Circulo {
	private Ponto p;
	private double raio;
	private double espessura;
	private boolean solido;
	
	public Circulo() {
		this.setPontoCirculo(0,0);
		this.setRaio(0);
		this.setEspessura(0);
		this.setSolido(false);
	}
	public Circulo(double a1, double a2, double r, double espe, boolean value) {
		this.setPontoCirculo(a1,a2);
		this.setRaio(r);
		this.setEspessura(espe);
		this.setSolido(value);
	}
	public Circulo(Coordenada a1, Coordenada a2, double r, double espe, boolean value) {
		this.setPontoCirculo(a1, a2);
		this.setRaio(r);
		this.setEspessura(espe);
		this.setSolido(value);
	}
	public Circulo(Ponto p, double r, double espe, boolean value) {
		this.setPontoCirculo(p);
		this.setRaio(r);
		this.setEspessura(espe);
		this.setSolido(value);
	}
	
	public Ponto getPontoCirculo() {
		return this.p;
	}
	public double getRaio() {
		return this.raio;
	}
	public double getEspessura() {
		return this.espessura;
	}
	public void setPontoCirculo(double a1, double a2) {
		this.p = new Ponto(a1,a2);
	}
	public void setPontoCirculo(Coordenada a1, Coordenada a2) {
		this.p = new Ponto(a1,a2);
	}
	public void setPontoCirculo(Ponto point) {
		this.p = point;
	}
	public void setRaio(double r) {
		this.raio = r;
	}
	public void setEspessura(double espe) {
		this.espessura = espe;
	}
	public void setSolido(boolean value) {
		this.solido = value;
	}
	public boolean isSolido() {
		return this.solido;
	}
	
	public double calculaArea() {
		return Math.PI*Math.pow(this.raio, 2);
	}
	public double calculaPerimetro() {
		return 2*Math.PI*this.raio;
	}
	public boolean equals(Circulo circ) {
		if (this.raio == circ.getRaio() && this.espessura == circ.getEspessura() && this.solido == 
				circ.isSolido()) {
			return true;
		}
		return false;
	}
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append("Coordenada: " + this.getPontoCirculo());
		dados.append("\nRaio: " + this.getRaio());
		return dados.toString();
	}
	
}
