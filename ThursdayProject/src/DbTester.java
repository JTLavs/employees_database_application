import java.util.ArrayList;
import java.util.Scanner;

public class DbTester {
	
	public static Scanner sc = new Scanner(System.in);;
	
	public static void main(String args[]) {
		
		System.out.println("Press y to show employees in the database");
		String response = sc.nextLine();
		ArrayList<Employee> employees = ConnectionDB.getEmployees();
		
		if(response.equals("y"))
			for(Employee e : employees) {
				System.out.println("Employee Name: "+e.getName()+"\nAddress: "+e.getAddress());
			}
		
		else
			System.out.println("Please connect to the DB");
	}

}
