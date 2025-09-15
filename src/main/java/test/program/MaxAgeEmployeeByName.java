package test.program;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

class EmployeeDtl {
    int empId;
    String name;
    int age;
    int week;
    
    public EmployeeDtl() {
		// TODO Auto-generated constructor stub
	}

    public EmployeeDtl(int empId, String name, int age, int week) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.week = week;
    }
    

    @Override
	public String toString() {
		return "EmployeeDtl [empId=" + empId + ", name=" + name + ", age=" + age + ", week=" + week + "]";
	}



	public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

	public int getWeek() {
		return week;
	}

}

public class MaxAgeEmployeeByName {
    public static void main(String[] args) {
    	List<EmployeeDtl> employees = Arrays.asList(
                new EmployeeDtl(1, "Alice", 30, 202507),
                new EmployeeDtl(2, "Bob", 28, 202508),
                new EmployeeDtl(3, "Alice", 35, 202511),
                new EmployeeDtl(4, "Charlie1", 25, 202518),
                new EmployeeDtl(4, "Charlie2", 25, 202528)
            );

            int targetWk = 202506;

            Optional<EmployeeDtl> nearestEmployee = employees.stream()
                .filter(e -> e.getWeek() <= targetWk)
                .max(Comparator.comparingInt(EmployeeDtl::getWeek));

            nearestEmployee.ifPresent(System.out::println);
            
            Optional<String> employeeName = employees.stream()
                    .filter(e -> e.getWeek() <= targetWk)
                    .max(Comparator.comparingInt(EmployeeDtl::getWeek))
                    .map(EmployeeDtl::getName);

                employeeName.ifPresent(name -> System.out.println("Employee Name: " + name));
    	Map<String, Set<EmployeeDtl>> emps = new HashMap<>();

    	Set<EmployeeDtl> employees2 = Set.of(
                new EmployeeDtl(1, "Alice", 30, 202507),
                new EmployeeDtl(2, "Bob", 28, 202508),
                new EmployeeDtl(3, "Alice", 35, 202511),
                new EmployeeDtl(4, "Charlie1", 25, 202518),
                new EmployeeDtl(5, "Charlie2", 25, 202528)
            );
    	emps.put("ABC", employees2);

        int targetWk2 = 202506;

        Optional<String> nearestEmployeeName = emps.values().stream()
            .flatMap(Set::stream)  // flatten all sets into a single stream of EmployeeDtl
            .filter(e -> e.getWeek() <= targetWk2)
//            .filter(e -> targetWk <= e.getWeek())
            .max(Comparator.comparingInt(EmployeeDtl::getWeek))
            .map(EmployeeDtl::getName);

        nearestEmployeeName.ifPresent(name -> System.out.println("Nearest employee: " + name));
    	
        List<EmployeeDtl> employeesNew = Arrays.asList(
                new EmployeeDtl(1, "Alice", 30, 202507),
                new EmployeeDtl(2, "Bob", 28, 202508),
                new EmployeeDtl(3, "Alice", 35, 202511),
                new EmployeeDtl(4, "Charlie1", 25, 202518),
                new EmployeeDtl(4, "Charlie2", 25, 202528)
            ); 
        Optional<EmployeeDtl> nearestEmployeee = employeesNew.stream()
                .filter(e -> e.getWeek() <= targetWk)
                .max(Comparator.comparingInt(EmployeeDtl::getWeek));

            nearestEmployeee.ifPresent(System.out::println);
        
    }
}

