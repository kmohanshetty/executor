package test.program.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
class Student{
	int id;
	String name;
	int age;
	
	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(age, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
public class Example {
	public static void main(String[] args) {
		List<Student> studentlist = new ArrayList<Student>();

		//Adding Students
		studentlist.add(new Student(111,"Jon",22));
		studentlist.add(new Student(222,"Steve",18));
		studentlist.add(new Student(333,"Lucy",22));
		studentlist.add(new Student(444,"Sansa",23));
		studentlist.add(new Student(555,"Maggie",18));

		//Fetching student names as List
		List<String> names = studentlist.stream()
				.map(n -> n.name)
				.collect(Collectors.toList());
		System.out.println("just names: "+names);
		
		
		Map<Integer, List<Student>> grouped = studentlist.stream().
				collect(Collectors.groupingBy(student -> student.age));
		
		System.out.println("grouped : "+grouped);
		Map<Integer, Set<Student>> sortedPlusGrouped = studentlist.stream().
				collect(Collectors.groupingBy(student -> student.age, TreeMap::new, Collectors.toSet()));
		
		System.out.println("sortedPlusGrouped: "+sortedPlusGrouped);
	}
}
