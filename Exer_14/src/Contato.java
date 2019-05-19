//O CODIGO EM COMENTARIO EH O CODIGO COM O USO DE AGREGACAO AO INVES DE HERANCA

public class Contato extends Email {
	//private Email email;
	private String nome;
	
	public Contato(String name, String email) throws Exception {
		super(email);
		this.setNome(name);
	}
	public Contato() throws Exception {  //Sobrecarregamento do construtor
		super();
		this.setNome("");
	}
	//public Contato(String name, Email em) {
	//	this.setNome(name);
	//	this.setEmail(em);
	//}
	//public Contato(String name, String em) throws Exception {
	//	this.setNome(name);
	//	this.setEmail(em);
	//}
	//public Contato () throws Exception {
	//	this.setNome("");
	//	this.setEmail("");
	//}
	
	public String getNome() {
		return this.nome;
	}
	//public Email getEmail() {
	//	return this.email;
	//}
	public void setNome (String name) {
		this.nome = name;
	}
	//public void setEmail(Email em) {
	//	this.email = em;
	//}
	//public void setEmail(String em) throws Exception {
	//	this.email = new Email(em);
	//}
	
	public boolean equals(Contato cont) {   //sobreposicao do metodo equals
		if (super.equals(cont) && this.getNome().equals(cont.getNome())) {
			return true;
		}
		return false;
	}
	public String toString() {                  //sobreposicao do metodo toString
		StringBuilder info = new StringBuilder();
		info.append("Nome: "+this.getNome()+"\n");
		info.append(super.toString());
		return info.toString();
	}
	//public String toString() {
	//	StringBuilder info = new StringBuilder();
	//	info.append("Nome: "+this.getNome()+"\n");
	//	info.append("\nEmail: "+this.getEmail());
	//	return info.toString();
	//}
}
