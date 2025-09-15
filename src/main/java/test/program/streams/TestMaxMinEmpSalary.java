package test.program.streams;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestMaxMinEmpSalary {
	
	static List<Employee> employeeList = Arrays.asList(
	  new Employee("Tom Jones", 45, 15000.00),
      new Employee("Tom Jones", 45, 7000.00),
      new Employee("Ethan Hardy", 65, 8000.00),
      new Employee("Nancy Smith", 22, 10000.00),
      new Employee("Deborah Sprightly", 29, 9000.00));
	
	public static void main(String[] args) {
		Optional<Employee> maxSalaryEmp = 
	            employeeList.stream()
	            .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
	    System.out.println("Employee with max salary:"
	            + (maxSalaryEmp.isPresent()? maxSalaryEmp.get():"Not Applicable"));
	    
	    
	    Optional<Employee> minAgeEmp =    
	            employeeList.stream()
	            .collect(Collectors.minBy(Comparator.comparing(Employee::getAge)));
	    System.out.println("Employee with min age:"
	            + (minAgeEmp.isPresent()? minAgeEmp.get():"Not Applicable"));
	    
	}
}

class Employee {
	private String name;
	private Integer age;
	private Double salary;

	public Employee(String name, Integer age, Double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	//Getters and Setters of name, age & salary go here
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public String toString(){
		DecimalFormat dformat = new DecimalFormat(".##");
		return "Employee Name:"+this.name
				+ "  Age:"+this.age
				+ "  Salary:"+dformat.format(this.salary);
	}
	
	//Standard equals() and hashcode() implementations go here
	
}

