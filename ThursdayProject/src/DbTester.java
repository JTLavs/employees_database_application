import java.util.ArrayList;
import java.util.Scanner;

public class DbTester {
	
	public static Scanner sc = new Scanner(System.in);;
	
	public static void main(String args[]) {
		
		System.out.println("Press y to show employees in the database");
		String response = sc.nextLine();
		ArrayList<Employee> employees = ConnectionDB.getEmployees();
		
		System.out.println("Insert name of employee: ");
		String name = sc.nextLine();
		System.out.println("Insert salary of employee: ");
		float salary = sc.nextFloat();
		System.out.println("Insert National Insurance Number of employee: ");
		sc.nextLine();
		String NIN = sc.nextLine();
		System.out.println("Insert sort code of employee: ");
		String sortCode = sc.nextLine();
		System.out.println("Insert Account Number of employee: ");
		int accNo = sc.nextInt();
		System.out.println("Insert address of employee (eg: Number Street, Town, County): ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.println("Insert postcode of employee: ");
		String postcode = sc.nextLine();
		
		ConnectionDB db = new ConnectionDB();
		db.insertEmployee(name, salary, NIN, sortCode, accNo, address, postcode);
		
		
	}

}
