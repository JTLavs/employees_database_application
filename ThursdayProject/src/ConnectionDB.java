import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.Connection;


//ConnectionDB class is responsible
public class ConnectionDB {
	
	private static Connection conn = null;
	private static String user = "james";
	private static String password = "password";
	private static String host = "localhost"; // set properties file
	private static String database = "employees_database";
	
	protected static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + host+"/"+ database, user, password);
			
			System.out.println("Successfully connected to the database");
	
		}
		catch(ClassNotFoundException e1){
			e1.printStackTrace();	
		}
		catch(SQLException e2) {
			System.err.println("SQL exception occured");
		}
		return conn;
	}
	
	public static ArrayList<Employee> getEmployees() {

		if (conn == null) {
			conn = getConnection();
		}
		ArrayList<Employee> emps = new ArrayList<Employee>();
		try {
			Statement s = conn.createStatement();
			ResultSet rows = s.executeQuery(
					"SELECT employee_id AS `number`, CONCAT_WS(' ', address_1, address_2, address_3, postcode) AS `address`, "
					+ "name, salary, NIN, CONCAT_WS(' ', account_no, sort_code) AS `account_number` "
					+ "FROM employee JOIN employee_address USING (employee_id)");
			while (rows.next()) {
				emps.add(new Employee(
						 rows.getString("name"), 
						 rows.getString("address"), 
						 rows.getString("NIN"), 
						 rows.getInt("account_number"),
						 rows.getFloat("salary"), 
						 rows.getInt("number")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return emps;

	}
	
	public void insertEmployee(String name, float salary, String nIN, String sortCode, int accountNumber, String address, String postcode) {
		if (conn == null) {
			conn = getConnection();
		}
		try {
			PreparedStatement s = conn.prepareStatement("INSERT INTO employee (`name`, `salary`, `NIN`, `account_no`, `sort_code`) "
					+ "VALUES(?,?,?,?,?);");
			System.out.println("NNumber: "+ nIN);
			s.setString(1, name);
			s.setDouble(2, salary);
			s.setString(3, nIN);
			s.setInt(4, accountNumber);
			s.setString(5, sortCode);
			
			int employeeNumber = s.executeUpdate();
			String[] sAddress = address.split(",");
			
			PreparedStatement addressStmt = conn.prepareStatement("INSERT INTO employee_address (`employee_id`, `address_1`, `address_2`, "
					+ "`address_3`, `postcode`) "
					+ "VALUES(?,?,?,?,?);");
			
			
			addressStmt.setInt(1, employeeNumber);
			addressStmt.setString(2, sAddress[0]);
			addressStmt.setString(3, sAddress[1]);
			addressStmt.setString(4, sAddress[2]);
			addressStmt.setString(5, postcode);
			addressStmt.executeUpdate();
			
			System.out.println("Employee inserted");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}


		
