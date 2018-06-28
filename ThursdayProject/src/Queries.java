

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Queries {

	private static Connection conn;
	private static CallableStatement cstmt;
	private static ResultSet rs;

	
	// read stored procedure from file
	protected static void testQuery(Connection conn) 
		throws SQLException, FileNotFoundException, IOException{
		
		conn.setAutoCommit(false);
		BufferedReader reader = new BufferedReader(new FileReader("test.sql"));
		StringBuilder sb = new StringBuilder();
		String ln = reader.readLine();
		
		while (ln != null) {
			sb.append(ln);
			sb.append(System.lineSeparator());
			ln = reader.readLine();
		}
		
		String query = sb.toString();
		//System.out.println(query);
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.execute();
		conn.commit();
		System.out.println("stored procedure created");
	}
	
	// call  stored procedure
	public static void callFirstQuery(String q) {
		
		conn = ConnectionDB.getConnection();
		
	}
	
	
	
	
		


}
