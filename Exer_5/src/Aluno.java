
public class Aluno {
   private String nome;
   private double nota1, nota2, media, pontos;
  
   
   static final public double DEFAULT_APROVACAO = 7.0;
   static final public double SUPERIOR_LIMITE = 10.0;
   static private double minimoAprovacao = Aluno.DEFAULT_APROVACAO;
   static private double limiteSuperior = Aluno.SUPERIOR_LIMITE;
 
   
   public static double getMinimoAprovacao() {
   	return Aluno.minimoAprovacao;
   }
   public static double getLimiteSuperior() {
	   return Aluno.limiteSuperior;
   }
   public static void setMinimoAprovacao(double _minimoAprovacao) {
   	Aluno.minimoAprovacao = _minimoAprovacao;
   } 
   public static void setLimiteSuperior(double _limiteSup) {
	   Aluno.limiteSuperior = _limiteSup;
   }
 
   
   static public boolean isAprovado(double _media) {
   	if(_media >= Aluno.minimoAprovacao)
      	   return true;
   	else
      	   return false;
   }
   
   public boolean isAprovado() {
   	return Aluno.isAprovado(this.media);
   }
   
   static public boolean verificarLimite (double nota) { //Esse metodo deve ser estatico pois a
	   if (nota > Aluno.limiteSuperior) {				//verificacao de validade de um limite
		   return false;                                //para a nota nao deve precisar de um
	   }												//objeto criado para poder ser feito,
	   return true;										//pode-se querer faze-lo antes de definir a
   }													//nota como o limite.
   
   
   
}
