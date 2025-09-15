package test.design.pattern.structural;

import java.util.ArrayList;
import java.util.List;
/*
 * Composite is a structural design pattern that lets you compose 
 * objects into tree structures and then work with these structures as if they were individual objects.
 * Collection of object is composite. They belong to same group or abstraction. 
 */
class Employee2 {
	private String name;
	private String title;
	private List<Employee2> subordinates;

	public Employee2(String name,String title) {
		this.name = name;
		this.title = title;
		subordinates = new ArrayList<Employee2>();
	}

	public void add(Employee2 e) {
		subordinates.add(e);
	}

	public void remove(Employee2 e) {
		subordinates.remove(e);
	}

	public List<Employee2> getSubordinates(){
		return subordinates;
	}

	public String toString(){
		return "Employee2 :[ Name : "+ name 
				+", dept : "+ title +subordinates +" ]";
	}   
}

public class CompositeTest {
	public static void main(String[] args) {
		Employee2 CEO = new Employee2("John","CEO");

		Employee2 headSales = new Employee2("Rob","Sales");

		Employee2 headMarketing = new Employee2("Mike","Marketing");

		Employee2 programmer1 = new Employee2("Lili","Programmer");
		Employee2 programmer2 = new Employee2("Bob","Programmer");

		Employee2 tester1 = new Employee2("Jack","Tester");
		Employee2 tester2 = new Employee2("Tom","Tester");

		CEO.add(headSales);
		CEO.add(headMarketing);

		headSales.add(tester1);
		headSales.add(tester2);

		headMarketing.add(programmer1);
		headMarketing.add(programmer2);

		//print all employees of the organization
		System.out.println(CEO); 
		for (Employee2 headEmployee2 : CEO.getSubordinates()) {
			System.out.println(headEmployee2);
			for (Employee2 employee : headEmployee2.getSubordinates()) {
				System.out.println(employee);
			}
		}    
	}
}
