package my.project.visitor;

public class FixedSalaryEmployee extends Employee {

	private double salary;

	public FixedSalaryEmployee(int id, String name, double salary) {
		super(id, name);
		this.salary = salary;
	}

	@Override
	public double getSalary() {
		return salary;
	}
}
