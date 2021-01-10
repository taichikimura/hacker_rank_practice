package my.project.visitor;

public class Main {

	public static void main(String[] args) {
		
		Employees employees = new Employees();
		employees.add(new FixedSalaryEmployee(1, "Alice", 1000));
		employees.add(new FixedSalaryEmployee(2, "Bob", 1200));
		employees.add(new CommissionSalaryEmployee(3, "Eve", 8000, 0.1));
		employees.add(new CommissionSalaryEmployee(4, "Foo", 9000, 0.07));
		employees.add(new MixedSalaryEmployee(5, "Bar", 400, 3000, 0.07));
		employees.add(new MixedSalaryEmployee(6, "Hoge", 500, 5000, 0.04));

		EmployeeSalarySumVisitor salarySumVisitor = new EmployeeSalarySumVisitor();
		employees.accept(salarySumVisitor);
		System.out.println("sum=" + salarySumVisitor.getSum());
		
		employees.accept(new EmployeeJsonPrintVisitor());
	}
}
