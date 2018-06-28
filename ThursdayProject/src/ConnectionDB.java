import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


//ConnectionDB class is responsible
public class ConnectionDB {
	
	private static Connection conn = null;
	private static String user;
	private static String password;
	private static String host = "localhost"; // set properties file
	private static String database = "employees_database";
	
	private static int port;
	
	protected static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + host+"/"+ database, user, password);
			
			System.out.println("Successfully connected to the database");
	
		}
		catch(ClassNotFoundException e1){
			System.err.println("Could not load the driver.");	
		}
		catch(SQLException e2) {
			System.err.println("SQL exception occured");
		}
		return conn;
	}
}


		
