package my.project.visitor;

public abstract class Employee {

	protected int id;
	protected String name;

	public abstract double getSalary();
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
