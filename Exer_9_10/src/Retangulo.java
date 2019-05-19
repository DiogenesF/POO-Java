
public class Retangulo extends Ponto {
	private Ponto esq_sup,dir_inf;
	
	public Retangulo(double x_esq, double y_sup, double x_dir, double y_inf) throws Exception {
		this.setRetangulo(x_esq,y_sup,x_dir,y_inf);
	}
	public Retangulo (Object objeto_1, Object objeto_2) throws Exception{
		Ponto aux = (Ponto) objeto_1;
		Ponto aux_2 = (Ponto) objeto_2;
		this.setRetangulo(aux, aux_2);
	}
	public Retangulo () throws Exception{
		this.setRetangulo(0,0,0,0);
	}
	
	public Ponto getPontoEsqSup() {
		return esq_sup;
	}
	public Ponto getPontoDirInf() {
		return dir_inf;
	}
	public void setRetangulo(double x_esq, double y_sup, double x_dir, double y_inf) throws Exception {
		this.esq_sup = new Ponto(x_esq,y_sup);
		this.dir_inf = new Ponto(x_dir,y_inf);
	}
	public void setRetangulo(Ponto p1, Ponto p2) {
		this.esq_sup = p1;
		this.dir_inf = p2;
	}
	
	public String toString() {
		return esq_sup.toString() + "-" + dir_inf.toString(); 
	}
	public double calculaArea() {
		return (dir_inf.getX() - esq_sup.getX()) * ((esq_sup.getY() - dir_inf.getY()));
	}
	public double calculaPerimetro() {
		return (dir_inf.getX() - esq_sup.getX())*2 + (esq_sup.getY() - dir_inf.getY())*2;
	}
	
	public boolean equals() {
		if ( esq_sup.equals(dir_inf) ) return true;
		return false;
	}
	
	public boolean equalsArea(Object objeto) {
		Retangulo aux = (Retangulo) objeto;
		if (aux.calculaArea() == this.calculaArea()) return true;
		return false;
	}
	public int compareTo(Object objeto) {
		Retangulo aux = (Retangulo) objeto;
		if (this.equalsArea(aux)) return 0;
		if (this.calculaArea() > aux.calculaArea()) return 1;
		return -1;
	}
	
	
}
