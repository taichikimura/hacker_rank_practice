package my.project.visitor;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Element {

	List<Employee> employeeList = new ArrayList<>();

	public void add(Employee employee) {
		employeeList.add(employee);
	}

	@Override
	public void accept(EmployeeVisitor visitor) {
		for (Employee employee : employeeList) {
			visitor.visit(employee);
		}
	}
}
