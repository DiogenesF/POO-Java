package codigos;

/**
 * Classe Horario composta por hora, minuto e segundo com métodos para construção, acesso e validação do horario
 * <p>
 * 
 * @author Diogenes F.
 *
 */
public class Horario {
	/** Hora, minutos e segundos informados pelo usuario*/
	private int hora, min, seg;
	
	/**
	 * Construtor Horario em que recebe como paramento as horas, os minutos
	 * e os segundos.
	 * 
	 * @param _hora Hora do horario
	 * @param _minutos Minutos do horario
	 * @param _segundos Segundos do horario
	 * @throws Exception Tratamento de erro para verificar a validade do horario
	 */
	public Horario(int _hora, int _minutos, int _segundos) throws Exception {
		this.setHorario(_hora, _minutos, _segundos);
	}
	/**
	 * Construtor Horario sobrecarregado para receber apenas uma string representando o horario
	 * 
	 * @param _horario String que representa o horario
	 * @throws Exception Tratamento de erro para verificar a validade do horario
	 */
	public Horario(String _horario) throws Exception {
		this.setHorario(_horario);
	}
	/**
	 * Acessa a variavel que guarda a hora
	 * 
	 * @return hora do horario
	 */
	public int getHora() {
		return this.hora;
	}
	/**
	 * Acessa a variavel que guarda os minutos
	 * 
	 * @return minutos do horario
	 */
	public int getMinutos() {
		return this.min;
	}
	/**
	 * Acessa a variavel que guarda os segundos
	 * 
	 * @return segundos do horario
	 */
	public int getSegundos() {
		return this.seg;
	}
	/**
	 * Método set para alterar o horario, recebendo a hora, os minutos e os segundos
	 * 
	 * @param h Hora do horario
	 * @param m Minutos do horario
	 * @param s Segundos do horario
	 * @throws Exception Tratamento de erro para verificar a validade do horario
	 */
	public void setHorario(int h, int m, int s) throws Exception {
		if (Horario.isHorarioValida(h, m, s)) {
			this.hora = h;
			this.min = m;
			this.seg = s;
		}
		else {
			throw new Exception("\nHorario invalido!\n");
		}
	}
	/**
	 * Método set para alterar o horario, recebendo uma string que representa um horario
	 * 
	 * @param _horario String que representa o horario
	 * @throws Exception Tratamento de erro para verificar a validade do horario
	 */
	public void setHorario(String _horario) throws Exception {
		int h = _horario.indexOf(":");
		String hora = _horario.substring(0, h);
		int m = _horario.indexOf(":", h+1);
		String min = _horario.substring(h+1, m);
		String seg = _horario.substring(m+1);
		h = Integer.parseInt(hora);
		m = Integer.parseInt(min);
		int s = Integer.parseInt(seg);
		this.setHorario(h, m, s);
	}
	/**
	 * Método estatico para verificar a validade do horario que foi digitado pelo usuario
	 * 
	 * @param h Hora do horario
	 * @param m Minutos do horario
	 * @param s Segundos do horario
	 * @return false Se o horario for invalido
	 * @return true Se o horario for valido
	 */
	public static boolean isHorarioValida(int h, int m, int s) {
		if (h >= 0 && m >= 0 && s >= 0 && h < 24 && m < 60 && s < 60) {
			return true;
		}
		return false;
	}
	/**
	 * Método que vai comparar dois horarios para verificar qual deles é maior 
	 * 
	 * @param h1 Primeiro horario passado pelo usuario
	 * @param h2 Segundo horario passado pelo usuario
	 * @return -1 Se o primeiro horario for menor que o segundo
	 * @return 0 Se os horarios forem iguais
	 * @return 1 Se o primeiro horario for maior que o segundo
	 */
	public static int compareTo(Horario h1, Horario h2) {
		if (h1.getHora() > h2.getHora()) return 1;   
		else {
			if (h1.getHora() < h2.getHora()) return -1;
			else {
				if (h1.getMinutos() > h2.getMinutos()) return 1;
				else {
					if (h1.getMinutos() < h2.getMinutos()) return -1;
					else {
						if (h1.getSegundos() > h2.getSegundos()) return 1;
						else {
							if (h1.getSegundos() < h2.getSegundos()) return -1;
							else {
								return 0;
							}
						}
					}
				}
			}
		}
	}
	/**
	 * Método para retornar o horario em forma de string, formatado para exibir o horario com o formato hh/mm/ss
	 * 
	 * @return Horario em formato de string
	 */
	public String toString() {
		StringBuilder info = new StringBuilder();
		if (this.getHora() > 9 && this.getMinutos() > 9 && this.getSegundos() > 9) {
			info.append(this.getHora() + ":" + this.getMinutos() + ":" + this.getSegundos());
		}
		else if (this.getHora() > 9 && this.getMinutos() > 9) {
			info.append(this.getHora() + ":" + this.getMinutos() + ":0" + this.getSegundos());
		}
		else if (this.getHora() > 9 && this.getSegundos() > 9) {
			info.append(this.getHora() + ":0" + this.getMinutos() + ":" + this.getSegundos());
		}
		else if (this.getMinutos() > 9 && this.getSegundos() > 9) {
			info.append("0" + this.getHora() + ":" + this.getMinutos() + ":" + this.getSegundos());
		}
		else if (this.getHora() > 9) {
			info.append(this.getHora() + ":0" + this.getMinutos() + ":0" + this.getSegundos());
		}
		else if (this.getMinutos() > 9) {
			info.append("0" + this.getHora() + ":" + this.getMinutos() + ":0" + this.getSegundos());
		}
		else if (this.getSegundos() > 9) {
			info.append("0" + this.getHora() + ":0" + this.getMinutos() + ":" + this.getSegundos());
		}
		else {
			info.append("0" + this.getHora() + ":0" + this.getMinutos() + ":0" + this.getSegundos());
		}
		return info.toString();
	}
	
}
