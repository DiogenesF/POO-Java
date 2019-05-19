
public class LivroDeBiblioteca extends Livro implements ItemDeBiblioteca {
	private boolean statusEmprestado;
	private String localizacao;
	private String descricao;
	
	public LivroDeBiblioteca(String title, String autor, int numPags, int anoEd, boolean status, 
			String local, String desc) {
		super(title, autor, numPags, anoEd);
		this.setStatusEmprestado(status);
		this.setLocalizacao(local);
		this.setDescricao(desc);
	}
	
	public boolean getStatusEmprestado() {
		return this.statusEmprestado;
	}
	public String getLocalizacao() {
		return this.localizacao;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public void setStatusEmprestado(boolean status) {
		this.statusEmprestado = status;
	}
	public void setLocalizacao(String local) {
		this.localizacao = local;
	}
	public void setDescricao(String desc) {
		this.descricao = desc;
	}

	@Override
	public boolean isEmprestado() {
		return this.getStatusEmprestado();
	}
	@Override
	public void empresta() {
		if (this.isEmprestado() == false) {
			this.setStatusEmprestado(true);
		}
	}
	@Override
	public void devolve() {
		this.setStatusEmprestado(false);
	}
	@Override
	public String localiza() {
		return this.getLocalizacao();
	}

	@Override
	public String apresentaDescricao() {
		return this.getDescricao();
	}
	
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append(super.toString());
		info.append("\nO livro esta emprestado ?: "+this.isEmprestado());
		info.append("\nLocalizacao: "+this.getLocalizacao());
		info.append("\nDescricao: "+this.getDescricao());
		return info.toString();
	}
	
}
