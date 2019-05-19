
public class Livro {
	private String titulo, autor;
	private int numeroPags, anoEdicao;
	
	public Livro(String title, String autor, int numPags, int anoEd) {
		this.setTitulo(title);
		this.setAutor(autor);
		this.setNumeroPags(numPags);
		this.setAnoEdicao(anoEd);
	}
	
	public String getTitulo() {
		return this.getTitulo();
	}
	public String getAutor() {
		return this.getAutor();
	}
	public int getNumeroPags() {
		return this.numeroPags;
	}
	public int getAnoEdicao() {
		return this.anoEdicao;
	}
	public void setTitulo(String title) {
		this.titulo = title;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setNumeroPags(int numPags) {
		this.numeroPags = numPags;
	}
	public void setAnoEdicao(int anoEd) {
		this.anoEdicao = anoEd;
	}
	
	
	public String toString() {
		StringBuilder info = new StringBuilder();
		
		info.append("Titulo: "+this.getTitulo());
		info.append("\nAutor: "+this.getAutor());
		info.append("\nNumero de Paginas: "+this.getNumeroPags());
		info.append("\nAno de edicao: "+this.getAnoEdicao());
		return info.toString();
	}
}
