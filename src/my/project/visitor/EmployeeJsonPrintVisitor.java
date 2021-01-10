package my.project.visitor;

public class EmployeeJsonPrintVisitor implements EmployeeVisitor {

	@Override
	public void visit(Employee employee) {
		System.out.println(getJsonString(employee));
	}

	private String getJsonString(Employee employee) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(getNumField("id", employee.getId()));
		sb.append(", ");
		sb.append(getStrField("name", employee.getName()));
		sb.append(", ");
		sb.append(getNumField("salary", employee.getSalary()));
		sb.append(", ");
		sb.append(getStrField("class", employee.getClass().getSimpleName()));
		sb.append("}");
		return sb.toString();
	}

	private String getNumField(String field, double value) {
		return String.format("\"%s\":%.2f", field, value);
	}

	private String getNumField(String field, int value) {
		return String.format("\"%s\":%d", field, value);
	}

	private String getStrField(String field, String value) {
		return String.format("\"%s\":\"%s\"", field, value);
	}
}
