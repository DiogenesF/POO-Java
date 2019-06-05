import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Oferece métodos estáticos de gravação e leitura de objetos no disco
 * através de serialização.
 *
  * @author Diogenes Fiorezi
 */


public abstract class Arquivo {
	
	/**
  	 * Realiza gravação de um objeto no disco
  	 * @param _nomeArquivo nome do arquivo que será criado na gravação
  	 * @param _objeto instância que será gravada no arquivo
  	 * @exception IOException problemas na criação do arquivo ou gravação
  	 */
	
	static public void grava(String _nomeArquivo, Object _objeto) throws IOException {
		ObjectOutputStream buffer = new ObjectOutputStream(new FileOutputStream(_nomeArquivo));
		buffer.writeObject(_objeto);
		buffer.close();
	}
	
	/**
  	 * Realiza leitura de um objeto no arquivo
  	 * @param _nomeArquivo nome do arquivo a ser lido
  	 * @return retorna uma instância da classe Object lida do arquivo
  	 * @exception IOException problemas na leitura do arquivo
  	 * @exception ClassNotFoundException problemas na conversão do objeto lido
  	 */

	static public Object le(String _nomeArquivo) throws IOException, ClassNotFoundException  {
		ObjectInputStream buffer = new ObjectInputStream(new FileInputStream(_nomeArquivo));
		Object _objeto = buffer.readObject(); 
		buffer.close();
		return _objeto;
	}
}
