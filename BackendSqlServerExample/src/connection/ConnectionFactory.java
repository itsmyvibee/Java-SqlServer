package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection conectar() throws Exception{
		
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", 
				"system", "password");
		
	} 
	
}
