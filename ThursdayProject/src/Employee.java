
public class Employee {
	
	private String name;
	private String address;
	private String NIN;
	private int accNo;
	private float salary;
	private int empNo;
	
	public float TAX_RATE = 0.25f;
	
	public Employee(String name, String address, String nIN, int accNo, float salary, int empNo) {
		super();
		this.name = name;
		this.address = address;
		NIN = nIN;
		this.accNo = accNo;
		this.salary = salary;
		this.empNo = empNo;
	}
	
	public float calcNetPay() {
		return salary - (salary * TAX_RATE);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNIN() {
		return NIN;
	}

	public void setNIN(String nIN) {
		NIN = nIN;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	
	
	
	

	

}
