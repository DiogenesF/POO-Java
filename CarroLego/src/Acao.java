/**
 * Classe enumeração onde faz a caracterização das Ações feitas pelo carrinho
 * em numerações para a facilitação da implementação. 
 * <p>
 * 
 * @author Arthur B. 
 * @author Ayrton S. C.
 * @author Diogenes F.
 * @author Luan S. F
 * @author Yuri C. P.
 * @version 1.0 (julho - 2019)
 */
public enum Acao {
	/** Caracteristicas das ações sobre o carrinho.*/
	FRENTE(1), TRAS(2), ESQUERDA(3), DIREITA(4), GIRO180(5);

	/** Variavel para receber a ação.*/
	private int codigo;

	/**
	 * Método em que recebe um valor inteiro do usuario e é atribuido esse valor 
	 * para a opção codigo. 
	 * 
	 * @param c Valor da ação a ser efetuada
	 */
	private Acao (int c) {
		this.codigo = c;
	}

	/**
	 * Captura do codigo dada pelo usuario
	 * 
	 * @return Retorna o codigo passado
	 */
	public int getCodigo() {
		return this.codigo;
	}

}
