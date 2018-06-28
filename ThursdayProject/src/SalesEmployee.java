
public class SalesEmployee extends Employee {
	
	private float commissionRate;
	private float salesTotal;

	public SalesEmployee(String name, String address, String nIN, int accNo, float salary, int empNo, float commissionRate, float salesTotal) {
		super(name, address, nIN, accNo, salary, empNo);
		this.commissionRate = commissionRate;
		this.salesTotal = salesTotal;
	}
	
	@Override
	public float calcNetPay() {
		return super.calcNetPay() + (commissionRate * salesTotal);
	}

	public float getCommissonRate() {
		return commissionRate;
	}

	public void setCommissonRate(float commissonRate) {
		this.commissionRate = commissonRate;
	}

	public double getSalesTotal() {
		return salesTotal;
	}

	public void setSalesTotal(float salesTotal) {
		this.salesTotal = salesTotal;
	}
	
	

}
