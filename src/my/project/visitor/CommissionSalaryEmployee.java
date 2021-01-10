package my.project.visitor;

public class CommissionSalaryEmployee extends Employee {

	private double salesVolume;
	private double commissionRate;
	
	public CommissionSalaryEmployee(int id, String name, double salesVolume, double commissionRate) {
		super(id, name);
		this.salesVolume = salesVolume;
		this.commissionRate = commissionRate;
	}
	
	@Override
	public double getSalary() {
		return salesVolume * commissionRate;
	}
}
