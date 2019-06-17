package codigos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class BancoDeDados {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/contabanco";
		String usuario = "root";
		String senha = "123456";
		try {
			this.connection = (Connection) DriverManager.getConnection(servidor, usuario, senha);
			this.statement = (Statement) this.connection.createStatement();			
		} catch (Exception e) {
			System.out.print("Erro: " + e.getMessage());
		}
	}
	public boolean isConectado() {
		if(this.connection != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void inserirCliente(String _nome, String _cpf, String _data_nasc) {
		try {
			String query = "INSERT INTO cliente (cpf, nome, dataNasc) VALUES ('" + _cpf + "' , '" + _nome + "' , '" + _data_nasc + "');";
			this.statement.executeUpdate(query);				
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void inserirConta(String _cpf, int tipo_conta, double _saldo, String senha, String data_criacao) {
		try {
			String query = "INSERT INTO conta (cpf, tipoConta, saldo,senha,dataCriacao) VALUES ('" + _cpf + "' , '" + tipo_conta + "' , '" + _saldo + "' , '" + senha + "' , '" + data_criacao + "');";
			this.statement.executeUpdate(query);				
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void inserirOperacao (String _cpf, String tipo_operacao, double valor, String data_operacao, int _tipo_conta) {
		try {
			String query = "INSERT INTO operacao (cpf, tipoOperacao, valor, dataOperacao, tipoConta) VALUES ('" + _cpf + "' , '" + tipo_operacao + "' , '" + valor + "' , '" + data_operacao + "' , '" + _tipo_conta + "' );";
			this.statement.executeUpdate(query);				
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void alteraSaldo(String _cpf, double _novo_saldo, int _tipo_conta) {
		try {
			String query = "UPDATE conta SET saldo = '" + _novo_saldo + "' WHERE cpf = '" + _cpf + "' AND tipoConta = '" + 
					_tipo_conta + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public List listarTodasContas() {
		List<Conta> lista = new LinkedList<Conta>();
		ContaPoupanca poupanca = null;
		ContaCorrente corrente = null;
		try {
			String query = "SELECT * FROM cliente CROSS JOIN conta WHERE cliente.cpf = conta.cpf;";
			this.resultSet = this.statement.executeQuery(query);
			this.statement = (Statement) this.connection.createStatement();
			
			while(this.resultSet.next()) {
				if (this.resultSet.getInt("tipoConta") == 1) {
					poupanca = new ContaPoupanca(this.resultSet.getString("nome"), this.resultSet.getString("cpf"), 
							this.resultSet.getDouble("saldo"), this.resultSet.getString("senha"), 
							new Data(Data.formatDataFromSQL(this.resultSet.getString("dataNasc"))),
							this.resultSet.getInt("tipoConta"));
					poupanca.setDataCriacao(new Data(Data.formatDataFromSQL(this.resultSet.getString("dataCriacao"))));
					lista.add(poupanca);
				}
				else {
					corrente = new ContaCorrente(this.resultSet.getString("nome"), this.resultSet.getString("cpf"), 
							this.resultSet.getDouble("saldo"), this.resultSet.getString("senha"), 
							new Data(Data.formatDataFromSQL(this.resultSet.getString("dataNasc"))),
							this.resultSet.getInt("tipoConta"));
					corrente.setDataCriacao( new Data(Data.formatDataFromSQL(this.resultSet.getString("dataCriacao"))) );
					lista.add(corrente);
				}
			}
			return lista;
		}catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
			return null;
		}
	}
	
	public List listarOperacoes(String _cpf, int _tipo_conta) {
		List<Operacoes> lista = new LinkedList<Operacoes>();
		
		try {
			String query = "SELECT * FROM operacao WHERE cpf = '" + _cpf + "' AND tipoConta = '" + _tipo_conta + "' ;";
			this.resultSet = this.statement.executeQuery(query);
			this.statement = (Statement) this.connection.createStatement();
			while (this.resultSet.next()) {
				if (this.resultSet.getInt("tipoConta") == _tipo_conta) {
					if (TipoOperacao.SAQUE.toString().equals(this.resultSet.getString("tipoOperacao"))) {
						lista.add(new Operacoes(_cpf, new Data(Data.formatDataFromSQL(this.resultSet.getString("dataOperacao"))),
								this.resultSet.getDouble("valor"), TipoOperacao.SAQUE, _tipo_conta));
					}
					if (TipoOperacao.DEPOSITO.toString().equals(this.resultSet.getString("tipoOperacao"))) {
						lista.add(new Operacoes(_cpf, new Data(Data.formatDataFromSQL(this.resultSet.getString("dataOperacao"))),
								this.resultSet.getDouble("valor"), TipoOperacao.DEPOSITO, _tipo_conta));
					}
					if (TipoOperacao.REALIZOU_TRANSFERENCIA.toString().equals(this.resultSet.getString("tipoOperacao"))) {
						lista.add(new Operacoes(_cpf, new Data(Data.formatDataFromSQL(this.resultSet.getString("dataOperacao"))),
								this.resultSet.getDouble("valor"), TipoOperacao.REALIZOU_TRANSFERENCIA, _tipo_conta));
					}
					if (TipoOperacao.RECEBEU_TRANSFERENCIA.toString().equals(this.resultSet.getString("tipoOperacao"))) {
						lista.add(new Operacoes(_cpf, new Data(Data.formatDataFromSQL(this.resultSet.getString("dataOperacao"))),
								this.resultSet.getDouble("valor"), TipoOperacao.RECEBEU_TRANSFERENCIA, _tipo_conta));
					}
				}
			}
			return lista;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public double consultaSaldo(String _cpf, int _tipo_conta) {
		try {
			String query = "SELECT saldo FROM conta WHERE cpf = '" + _cpf + "' AND tipoConta = '" + _tipo_conta + "' ;";
			this.resultSet = this.statement.executeQuery(query);
			this.statement = (Statement) this.connection.createStatement();
			this.resultSet.next();
			return this.resultSet.getDouble("saldo");
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	public boolean verificaSeExiste(String _cpf, int tipoDeConta) {
		try {
			String query = "SELECT cpf, tipoConta FROM conta";
			String comp_cpf;
			this.resultSet = this.statement.executeQuery(query);
			this.statement = (Statement) this.connection.createStatement();
			while(this.resultSet.next()) {
				comp_cpf = this.resultSet.getString("cpf");
				if (_cpf.equals(comp_cpf)) {
					if (tipoDeConta == this.resultSet.getInt("tipoConta")) {
						return true;
					}
				}
			}
			return false;
		}catch(Exception e){
			e.getMessage();
			return false;
		}
	}
	
	public boolean isDadosCorretos(String _cpf, String _senha, int _tipoConta) {
		try {
			String query = "SELECT cpf, senha FROM conta WHERE tipoConta = '" + _tipoConta + "' ";
			this.resultSet = this.statement.executeQuery(query);
			this.statement = (Statement) this.connection.createStatement();
			
			while (this.resultSet.next()) {
				if (this.resultSet.getString("cpf").equals(_cpf) && this.resultSet.getString("senha").equals(_senha)) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
	
	public Conta retornaInstancia(String _cpf, int _tipo_conta) {
		ContaPoupanca poupanca = null;
		ContaCorrente corrente = null;
		try {
			String query = "SELECT * FROM conta CROSS JOIN cliente WHERE tipoConta = '" + _tipo_conta + 
					"' AND conta.cpf = cliente.cpf;";
			this.resultSet = this.statement.executeQuery(query);
			this.statement = (Statement) this.connection.createStatement();
			
			while (this.resultSet.next()) {
				if (this.resultSet.getString("cpf").equals(_cpf)) {
					if (_tipo_conta == 1) {
						poupanca = new ContaPoupanca(this.resultSet.getString("nome"), _cpf, this.resultSet.getDouble("saldo"), 
								this.resultSet.getString("senha"), new Data(Data.formatDataFromSQL(this.resultSet.getString("dataNasc"))),
								_tipo_conta);
						poupanca.setDataCriacao(new Data(Data.formatDataFromSQL(this.resultSet.getString("dataCriacao"))));
						return poupanca;
					}
					else {
						corrente = new ContaCorrente(this.resultSet.getString("nome"), _cpf, this.resultSet.getDouble("saldo"), 
								this.resultSet.getString("senha"), new Data(Data.formatDataFromSQL(this.resultSet.getString("dataNasc"))),
								_tipo_conta);
						corrente.setDataCriacao(new Data(Data.formatDataFromSQL(this.resultSet.getString("dataCriacao"))));
						return corrente;
					}
				}
			}
			return null;
			
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	public void aplicaJuros(String _cpf) {
		try {
			String query = "UPDATE conta SET saldo = saldo * 1.01 WHERE tipoConta = 1 AND cpf = '" + _cpf + "';";
			this.statement.executeUpdate(query);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void desconectar() {
		try {
			this.connection.close();
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
}
