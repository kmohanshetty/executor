package test.program;

import java.util.HashSet;

public class EmpTest {

	public static void main(String[] args) {
		HashSet<EmployeeDtl> emps = new HashSet<EmployeeDtl>();
		EmployeeDtl employee1 = new EmployeeDtl("ravi",33,34000);
		EmployeeDtl employee2 = new EmployeeDtl("ravi",33,34000);
		//employee2.setMarried(true);
		emps.add(employee1);
		emps.add(employee2);
		System.out.println(emps);
	}

}

class Employee{
	private String name;
	private int age;
	private double salary;
	private boolean isMarried;
	
	public Employee() {
		
	}

	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (isMarried ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDtl other = (EmployeeDtl) obj;
		if (age != other.age)
			return false;
		if (isMarried != other.isMarried)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double
				.doubleToLongBits(other.salary))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary
				+ ", isMarried=" + isMarried + "]";
	}

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	
	
}