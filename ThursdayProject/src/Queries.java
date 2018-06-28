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
	private static CallableStatement stmt;
	private static ResultSet rs;

	
	// read stored procedure from file
	protected static void testQuery(Connection conn) 
		throws SQLException, FileNotFoundException, IOException{
		
		conn.setAutoCommit(false);
		BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
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
	public static void callFirstQuery() throws SQLException {
		try {
		conn = ConnectionDB.getConnection();
		conn.setAutoCommit(false);
		
		// preparing to call stored procedure
		stmt = conn.prepareCall("{call employeesPerDepartment()}");
		stmt.execute();
		rs = stmt.getResultSet();
		
		while(rs.next()) {
			
			String id = rs.getString("employee_id");
			String name = rs.getString("name");
			String salary = rs.getString("salary");
			String nInsurance = rs.getString("NIN");
			String account = rs.getString("account_no");
			String sortCode = rs.getString("sort_code");
			
			System.out.println("%s, %s, %s, %s, %s, %s");
		}
		
		conn.commit();
		stmt.close();
		}
		catch(SQLException e) {
			System.err.println("error occured");
		}
	}
	
	
	
		


}
