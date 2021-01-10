package my.project.visitor;

public class EmployeeSalarySumVisitor implements EmployeeVisitor {

	double sum = 0;

	@Override
	public void visit(Employee employee) {
		sum += employee.getSalary();
	}

	public double getSum() {
		return sum;
	}
}
