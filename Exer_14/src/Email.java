
public class Email {
	private String email;
	
	public Email(String email) throws Exception {
		this.setEmail(email);
	}
	public Email() throws Exception {        //Sobrecarregamento do construtor
		this.setEmail(" ");
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) throws Exception {
		if (Email.isEmailValido(email)) {
			this.email = email;
		}
	}
	public static boolean isEmailValido(String email) throws Exception {
		if (email.indexOf("@") != -1) {
			return true;
		}
		throw new Exception ("Email invalido");
	}
	
	public boolean equals(Email em) {
		if (this.getEmail().equals(em.getEmail())) {
			return true;
		}
		return false;
	}
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Email: "+this.getEmail());
		return info.toString();
	}
}
