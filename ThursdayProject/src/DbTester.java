import java.util.ArrayList;
import java.util.Scanner;

public class DbTester {
	
	public static Scanner sc = new Scanner(System.in);;
	
	public static void main(String args[]) {
		
		ConnectionDB db = new ConnectionDB();
		
		System.out.println("Do you want to insert and employee or dept? Press D for dept and E for employee");
		String ans = sc.nextLine();
		if(ans.contains("E")) {
		
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
		
	
		db.insertEmployee(name, salary, NIN, sortCode, accNo, address, postcode);
		
		} else if(ans.equals("D")) {
			
			System.out.println("Please enter Department name: ");
			String dept_name = sc.nextLine();
			
			db.insertDepartment(dept_name);
			
			
		} else {
			System.out.println("Incorrect input. Exited");
		}
		
	}

}
