package my.project.visitor;

public class MixedSalaryEmployee extends Employee {

	private double baseSalary;
	private double salesVolume;
	private double commissionRate;

	public MixedSalaryEmployee(int id, String name, double baseSalary, double salesVolume, double commissionRate) {
		super(id, name);
		this.baseSalary = baseSalary;
		this.salesVolume = salesVolume;
		this.commissionRate = commissionRate;
	}

	@Override
	public double getSalary() {
		return baseSalary + (salesVolume * commissionRate);
	}
}
