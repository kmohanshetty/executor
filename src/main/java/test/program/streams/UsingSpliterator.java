package test.program.streams;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsingSpliterator {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		Person p1 = new Person("Julia", "Roberts", 23, new Date());
		Person p2 = new Person("Mathew", "Heyden", 33, new Date());
		Person p3 = new Person("Mutiah", "Murulitharan", 23, new Date());
		Person p4 = new Person("Sachin", "Tendulkar", 43, new Date());

		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		
		persons.spliterator()
	}

}

class Person{
	String firstName;
	String lastName;
	int age;
	Date dob;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String firstName, String lastName, int age, Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dob = dob;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
}