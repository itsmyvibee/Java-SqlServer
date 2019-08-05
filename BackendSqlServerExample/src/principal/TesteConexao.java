package principal;
import java.sql.Connection;
import connection.ConnectionFactory;

public class TesteConexao {
	public static void main(String[] args) {
		
		//Essa main será utilizada para verificar se a conexão com o database será efetuada com sucesso.
		ConnectionFactory conexao = new ConnectionFactory(); //Objeto ConnectionFactory()
		Connection x = null; //Criação do objeto Connection que receberá o return do método conectar() do connectionFactory()
		
		//Inicio do teste de conexão
		try 
		{
			 //Caso o try seja feito
			 x = conexao.conectar(); //Chamada do método
			 System.out.println("Conexão estabelecida.");
		}//Fim try
		
		catch (Exception e) 
		{	
			//Caso o try não seja feito.
			e.printStackTrace(); //Impressão da exception
			System.out.println("Ouve um erro na conexão.");	
		}//Fim catch
		
		finally {
			//Para ambos os casos, é importante sempre efetuar o .close na conexão.
			try 
			{
				//Try para efetuar o fechamento da conexão
				x.close();
				System.out.println("Conexão fechada.");
			}//Fim Try/finally
			
			catch(Exception e) 
			{
				//Caso ocorra um erro ao fechar a conexão.
				e.printStackTrace(); //Impressão da exception
				System.out.println("Erro ao fechar conexão.");
			}//Fim catch/finally
		}//Fim finally
			
	}//Fim main

}//Fim class TesteConexao
