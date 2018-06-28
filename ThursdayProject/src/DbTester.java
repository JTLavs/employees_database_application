import java.util.ArrayList;
import java.util.Scanner;

public class DbTester {
	
	public static Scanner sc = new Scanner(System.in);
	static ConnectionDB db = new ConnectionDB();
	
	public static void main(String args[]) {
		
		int ans;
		do {
		System.out.println("Choose an option: \n1.Insert Employee\n2.Insert Dept.\n3.Select employees from dept\n0.To exit the program");
		ans = sc.nextInt();
		
		sc.nextLine();
		
		switch(ans) {
			case 1 : insertEmp(); break;
			case 2 : insertDept(); break;
			case 3 : 
				System.out.println("Insert dept name");
				String deptName = sc.nextLine();
				selectEmpsFromDept(deptName);
				break;
			default: ;
		}
		
		}while(ans != 0);
		System.exit(0);
	}
		
	


	public static void insertEmp(){
			float comRate = 0;
			float totalSales = 0;
			boolean isSales = false;
			
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
			
			System.out.println("Is this Employee a Sales Employee? Y or N: ");
			String ans = sc.nextLine();
			if(ans.equals("Y")) {
				isSales = true;
				System.out.println("Please enter commission rate: ");
				comRate = sc.nextFloat();
				sc.nextLine();
				System.out.println("Please enter total sales: ");
				totalSales = sc.nextFloat();
				sc.nextLine();
			}
			
			db.insertEmployee(name, salary, NIN, sortCode, accNo, address, postcode, isSales, comRate, totalSales);
	}
	
	public static void insertDept() {
		System.out.println("Please enter Department name: ");
		String dept_name = sc.nextLine();
		
		db.insertDepartment(dept_name);
	}
	
	public static void selectEmpsFromDept(String name) {
		ArrayList<String> deptEm = db.selectEmployeesFromDept(name);
		System.out.println("Employees from " + name + " dept:");
		for(String e : deptEm) {
			System.out.println(e);
		}
	}

}
