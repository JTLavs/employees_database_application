import java.util.ArrayList;
import java.util.Scanner;

public class DbTester {
	
	public static Scanner sc = new Scanner(System.in);;
	
	public static void main(String args[]) {
		
		System.out.println("Press y to show employees in the database");
		String response = sc.nextLine();
		ArrayList<Employee> employees = ConnectionDB.getEmployees();
		
		System.out.println("Insert name of employee: ");
		System.out.println("Insert ");
	}

}
