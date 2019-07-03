package codigos;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe Cliente utilizada para caracterizar cada usuario com o nome, senha, CPF,
 * um respectivo saldo em sua conta, uma data de nascimento.
 * <p>
 * Utiliza tambem operações com uma LinkdList, a fim de maximizar a eficiencia em acessar 
 * as operações de Saque, Depositos entre outros listados na Enumeração TipoOperação.
 * 
 * @author Arthur B. 
 * @author Ayrton S. C.
 * @author Diogenes F.
 * @author Luan S. F
 * @author Yuri C. P.
 * @version 1.0 (junho - 2019)
 */

public class Cliente {
	/** Nome do Usuario. */
	private String nome;
	/** CPF do Usuario. */
	private String CPF;			
	/** Valor do saldo inserido pelo usuario.*/
	private double saldo;		
	/** Senha para a conta do Usuario.*/
	private String senha;
	/** Data de Nascimento do Usuario.*/
	private Data data_nasc;
	private List<Operacoes> operacoes = new LinkedList<Operacoes>();
	
	/**
	 * Construtuor para iniciar com as variaveis de Nome, CPF, um respectivo Saldo, Senha, 
	 * uma Data de Nascimento.
	 * 
	 * @param _nome Nome do Usuario
	 * @param _CPF CPF inserido pelo Usuario
	 * @param _saldo Saldo respectivo a conta do Usuario
	 * @param _senha Senha do Usuario
	 * @param _data_nasc Data de Nascimento do Usuario
	 */
	public Cliente(String _nome, String _CPF, double _saldo, String _senha, Data _data_nasc) {
		this.setNome(_nome);
		this.setCPF(_CPF);
		this.setSaldo(_saldo);
		this.setSenha(_senha);
		this.setDataNasc(_data_nasc);
	}
	
	/**
	 * Captura o Nome do Usuario
	 * 
	 * @return nome do usuario
	 */
	public String getNome() {
		return this.nome;
	}
	/**
	 * Captura o CPF do Usuario
	 * 
	 * @return cpf do usuario
	 */
	public String getCPF() {
		return this.CPF;
	}
	/**
	 * Captura o saldo passado pelo Usuario
	 * 
	 * @return o saldo do usuario
	 */
	public double getSaldo() {
		return this.saldo;
	}
	/**
	 * Captura a senha passada pelo Usuario
	 * 
	 * @return a senha do usuario
	 */
	public String getSenha() {
		return this.senha;
	}
	/**
	 * Captura a Operação passada pelo Usuario
	 * 
	 * @return o valor da operação
	 */
	public List getOperacoes() {
		return this.operacoes;
	}
	/**
	 * Captura a data de nascimento passada pelo usuario
	 * 
	 * @return a data de nascimento
	 */
	public Data getDataNasc() {
		return this.data_nasc;
	}
	/**
	 * Modifica o nome recebendo uma String _nome
	 * 
	 * @param _nome Nome a ser modificado
	 */
	public void setNome(String _nome) {
		this.nome = _nome;
	}
	/**
	 * Modifica o CPF recebendo uma String _CPF
	 * 
	 * @param _CPF CPF a ser modificado
	 */
	public void setCPF(String _CPF) {
		this.CPF = _CPF;
	}
	/**
	 * Modifica o saldo recebendo um double _saldo
	 * 
	 * @param _saldo Saldo a ser modificado
	 */
	public void setSaldo(double _saldo) {
		this.saldo = _saldo;
	}
	/**
	 * Modifica a senha recebendo uma String _senha
	 * 
	 * @param _senha Senha a ser modificada
	 */
	public void setSenha(String _senha) {
		this.senha = _senha;
	}
	/**
	 * Modifica a data de nascimento recebendo um tipo Data _data_nasc
	 * 
	 * @param _data_nasc Data de Nascimento a ser modificada 
	 */
	public void setDataNasc(Data _data_nasc) {
		this.data_nasc = _data_nasc;
	}
	
	/**
	 * Método que TEM Q VER AQUI ocultado a crianção de uma nova operação
	 * 
	 * @param _CPF CPF passado pelo usuario
	 * @param _data Data de nascimento inserida pelo Usuario
	 * @param _valor Saldo a ser inserido na Operação
	 * @param _operacao Operação a ser efetuada
	 * @param _tipo_conta Tipo de conta a movimentada
	 */
	public void insere(String _CPF, Data _data, double _valor, TipoOperacao _operacao, int _tipo_conta) {
		Operacoes novo = new Operacoes(_CPF, _data, _valor, _operacao, _tipo_conta); 
		this.operacoes.add(novo);										
	}
	/**
	 * Sobreposição do método toString para retornar o Nome, CPF, Data de nascimento,
	 * Saldo, Operações da conta.
	 * 
	 *  @return retorna um tipo String com todos os dados 
	 */
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Nome: " + this.getNome());
		info.append("\nCPF: " + this.getCPF());
		info.append("\nData de nascimento: " + this.getDataNasc());
		info.append("\nSaldo: " + this.getSaldo());
		info.append("\nOperacoes do cliente: " + this.getOperacoes());
		return info.toString();
	}
}
