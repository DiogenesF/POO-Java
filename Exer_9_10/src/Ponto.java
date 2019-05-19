//CLASSE PONTO EH O EXERCICIO 9 E CLASSE RETANGULO EH O EXERCICIO 10

public class Ponto {
	private double x,y;
	private final static double LIM_SUPERIOR = 500;
	private final static double LIM_INFERIOR = 0;
	private static double lim_sup = Ponto.LIM_SUPERIOR;
	private static double lim_inf = Ponto.LIM_INFERIOR;
	
	public Ponto (double x, double y) throws Exception {
		this.setPonto(x,y);
	}
	public Ponto(String coordenada) throws Exception {
		double cord_x, cord_y;
		int aux_1, aux_2;
		
		aux_1 = coordenada.indexOf(1);
		cord_x = Double.parseDouble(coordenada.substring(aux_1,aux_1+1));
		aux_2 = coordenada.indexOf(3);
		cord_y = Double.parseDouble(coordenada.substring(aux_2,aux_2+1));
		this.setPonto(cord_x,cord_y);
	}
	public Ponto() throws Exception  {
		this(0,0);
	}
	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public static double getLimSup() {
		return Ponto.lim_sup;
	}
	public static double getLimInf() {
		return Ponto.lim_inf;
	}
	public static void setLimSup(double limite_sup) {
		Ponto.lim_sup = limite_sup;
	}
	public static void setLimInf(double limite_inf) {
		Ponto.lim_inf = limite_inf;
	}
	public void setX(double val_x) throws Exception {
		if (val_x > Ponto.lim_sup || val_x < Ponto.lim_inf) {
			throw new Exception("Error");
		}
		else {
			this.x = val_x;
		}
	}
	public void setY(double val_y) throws Exception {
		if (val_y > Ponto.lim_sup || val_y < Ponto.lim_inf) {
			throw new Exception("Error");
		}
		else {
			this.y = val_y;
		}
	}
	public void setPonto(double val_x, double val_y) throws Exception {
		this.setX(val_x);
		this.setY(val_y);
	}
	
	public boolean equals(Object objeto) {
		Ponto aux = (Ponto) objeto;
		if (this.x == aux.x && this.y == aux.y) {
			return true;
		}
		return false;
	}
	
	public Ponto clonar() throws Exception {
		Ponto u = new Ponto(this.getX(),this.getY());
		return u;
	}
	public Ponto criaSwap() throws Exception {
		Ponto u = new Ponto(this.getY(),this.getX());
		return u;
	}
	
	public boolean temEixoComum (Object objeto) {
		Ponto aux = (Ponto) objeto;
		if (this.getX() == aux.getX() || this.getY() == aux.getY()) {
			return true;
		}
		return false;
	}
	public double distancia(double x_1,double y_1,double x_2,double y_2) {
		return Math.sqrt( ((x_1-x_2) * (x_1-x_2)) +
				((y_1-y_2) * (y_1-y_2)));
	}
	public double distancia(Object objeto) {
		Ponto aux = (Ponto) objeto;
		return distancia(this.getX(),this.getY(),aux.getX(),aux.getY());
	}
	public double distancia(double val_x, double val_y) {
		return distancia(this.getX(),this.getY(),val_x,val_y);
	}
	public double distancia(Object objeto_1, Object objeto_2) {
		Ponto aux_1 = (Ponto) objeto_1;
		Ponto aux_2 = (Ponto) objeto_2;
		return distancia(aux_1.getX(),aux_1.getY(),aux_2.getX(),aux_2.getY());
	}
	public double distanciaDaOrigem() {
		return distancia(this.getX(),this.getY(),0,0);
	}
	public int compareTo(Object objeto) {
		Ponto aux = (Ponto) objeto;
		if (distancia(this.getX(),this.getY(),0,0) > distancia(aux.getX(),aux.getY(),0,0)) return 1;
		else if (distancia(this.getX(),this.getY()) < distancia(aux.getX(),aux.getY())) return -1;
		return 0;
	}
	public String toString() {
		StringBuilder ponto = new StringBuilder();
		ponto.append("("+this.getX()+","+this.getY()+")");
		return ponto.toString();
	}
	
	
	
}
