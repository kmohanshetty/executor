package test.program;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Emp {
    int empId;
    String name;
    Integer salary;

    public Emp(int empId, String name, Integer salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }
}

public class EmpSalSum {

	public static void main(String[] args) {
		List<Emp> employees = new ArrayList<>();

        Emp emp1 = new Emp(1, "name1", 1000);
        employees.add(emp1);
        Emp emp2 = new Emp(2, "name2", 1000);
        employees.add(emp2);
        Emp emp3 = new Emp(3, "name3", 1000);
        employees.add(emp3);

        // Calculate the sum of all salaries
        int totalSalary = employees.stream()
                                   .mapToInt(emp -> emp.salary)
                                   .sum();

        System.out.println("Total Salary: " + totalSalary);
        
        int searchEmpId = 2;

        // Find employees with the specified empId
        List<Emp> result = employees.stream()
                .filter(emp -> emp.empId == searchEmpId)
                .collect(Collectors.toList());

        result.forEach(emp -> System.out.println(emp.name + " with ID " + emp.empId));

	}

}

