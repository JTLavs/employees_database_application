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
	private static String user = "johny";
	private static String password = "johnyPass";
	private static String host = "localhost"; // set properties file
	private static String database = "employees_database";
	
	protected static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + host+"/"+ database + "?useSSL=false", user, password);
			
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
					+ "VALUES(?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
			//System.out.println("NNumber: "+ nIN);
			s.setString(1, name);
			s.setDouble(2, salary);
			s.setString(3, nIN);
			s.setInt(4, accountNumber);
			s.setString(5, sortCode);
			
			int employeeNumber = s.executeUpdate();
			ResultSet rs = s.getGeneratedKeys();
			
			System.out.println(employeeNumber);
			
			String[] sAddress = address.split(",");
			
			PreparedStatement addressStmt = conn.prepareStatement("INSERT INTO employee_address (`employee_id`, `address_1`, `address_2`, "
					+ "`address_3`, `postcode`) "
					+ "VALUES(?,?,?,?,?);");
			
			if(rs.next())
				addressStmt.setInt(1, rs.getInt(1));
			
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
	
	
	public void insertDepartment(String name) {
		if (conn == null) {
			conn = getConnection();
		}
		try {
			PreparedStatement s = conn.prepareStatement("INSERT INTO department (`name`) "
					+ "VALUES(?);");
			s.setString(1, name);
	
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> selectEmployeesFromDept(String dept_name) {
		ArrayList<String> empDept = new ArrayList<String>();
		
		if (conn == null) {
			conn = getConnection();
		}
		
		try {
			PreparedStatement s = conn.prepareStatement("SELECT employee_id, employee.name FROM employee, department WHERE department.name = ?"
					+ "AND department.department_id = employee.dept_id;");
			s.setString(1, dept_name);
			ResultSet deptRows = s.executeQuery();
			
			while(deptRows.next()) {
				empDept.add(deptRows.getInt("employee_id") + " - " + deptRows.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empDept;
	}
	
	public void insertSalesEmployee(int employee_id, float comRate, float totalSales) {
		if (conn == null) {
			conn = getConnection();
		}
		try {
			PreparedStatement s = conn.prepareStatement("INSERT INTO sales_employee (`employee_id`, `commission_rate`, `total_sales` ) "
					+ "VALUES(?,?,?);");
			s.setInt(1, employee_id);
			s.setFloat(2, comRate);
			s.setFloat(3, totalSales);
			s.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}


		
