package principal;
import java.sql.Connection;
import connection.ConnectionFactory;

public class TesteConexao {
	public static void main(String[] args) {
		
		//Essa main ser� utilizada para verificar se a conex�o com o database ser� efetuada com sucesso.
		ConnectionFactory conexao = new ConnectionFactory(); //Objeto ConnectionFactory()
		Connection x = null; //Cria��o do objeto Connection que receber� o return do m�todo conectar() do connectionFactory()
		
		//Inicio do teste de conex�o
		try 
		{
			 //Caso o try seja feito
			 x = conexao.conectar(); //Chamada do m�todo
			 System.out.println("Conex�o estabelecida.");
		}//Fim try
		
		catch (Exception e) 
		{	
			//Caso o try n�o seja feito.
			e.printStackTrace(); //Impress�o da exception
			System.out.println("Ouve um erro na conex�o.");	
		}//Fim catch
		
		finally {
			//Para ambos os casos, � importante sempre efetuar o .close na conex�o.
			try 
			{
				//Try para efetuar o fechamento da conex�o
				x.close();
				System.out.println("Conex�o fechada.");
			}//Fim Try/finally
			
			catch(Exception e) 
			{
				//Caso ocorra um erro ao fechar a conex�o.
				e.printStackTrace(); //Impress�o da exception
				System.out.println("Erro ao fechar conex�o.");
			}//Fim catch/finally
		}//Fim finally
			
	}//Fim main

}//Fim class TesteConexao
