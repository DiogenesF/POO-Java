import lejos.hardware.Button;
/**
 * Classe 'DG' onde é aplicado o uso para o carrinho fazer o que foi proposto
 * <p>
 * 
 * @author Arthur B. 
 * @author Ayrton S. C.
 * @author Diogenes F.
 * @author Luan S. F
 * @author Yuri C. P.
 * @version 1.0 (julho - 2019)
 */
public class DG {

	public static void main(String[] args){
		VeiculoSmart teste = new VeiculoSmart(false, true, true, true);
		//teste.fechaGarra();
		teste.segueLinhaAteBola();
		teste.voltaAoPontoDeOrigem();
		teste.stop();

	}
	
}