package test.program;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeLeaveTest {
	
	public static void main(String[] args) {
		Integer someVal = null;
		
		if(args == null ) {
			someVal = null;
		}else {
			someVal = 1001;
		}
		
		List<EmployeeLeave> leaves = List.of(
		        new EmployeeLeave(1001, "ABC", 202504, 0),
		        new EmployeeLeave(someVal, "JAAA", 202505, 30),
		        new EmployeeLeave(1001, "ABC", 202505, 10),
		        new EmployeeLeave(1001, "ABC", 202506, 0),
		        new EmployeeLeave(1002, "DEF", 202504, 0),
		        new EmployeeLeave(1007, null, 202505, 30),
		        new EmployeeLeave(1002, "DEF", 202505, 0),
		        new EmployeeLeave(1002, "DEF", 202506, 0),
		        new EmployeeLeave(1003, "DEF", 202505, 0),
		        new EmployeeLeave(1003, "DEF", 202506, 0),
		        new EmployeeLeave(1004, "GHI", 202504, 122),
		        new EmployeeLeave(1005, "JKL", 202504, 0),
		        new EmployeeLeave(1005, "JKL", 202505, 0),
		        new EmployeeLeave(1005, "JKL", 202505, 30),
		        new EmployeeLeave(1006, "MNO", 202504, 30),
		        new EmployeeLeave(1006, "MNO", 202505, 0),
		        new EmployeeLeave(1006, "MNO", 202506, 0),
		        new EmployeeLeave(1006, "MNO", 202507, 0)
		    );

		    int currentMonth = 202503;
		
//	    firstWay(leaves, currentMonth);
//	    secondWay(leaves, currentMonth);
	    secondWay3(leaves, currentMonth);
	    
	}

	private static void secondWay(List<EmployeeLeave> leaves, int currentMonth) {
		 // Find employees with 0 leaves for all months > currentMonth
	    Set<Integer> qualifyingEmpNos = leaves.stream()
    		.filter(e -> e.getEmpNo() != null)
	        .collect(Collectors.groupingBy(EmployeeLeave::getEmpNo))
	        .entrySet().stream()
	        .filter(entry -> entry.getValue().stream()
	            .filter(e -> e.getMonNo() > currentMonth)
	            .allMatch(e -> e.getLeavesCnt() == 0)
	        )
	        .map(Map.Entry::getKey)
	        .collect(Collectors.toSet());
	    
		List<EmployeeLeave> result = leaves.stream()
				.filter(e -> e.getEmpNo() != null)
			    .filter(e -> qualifyingEmpNos.contains(e.getEmpNo()))
			    .collect(Collectors.groupingBy(EmployeeLeave::getEmpNo,
			             Collectors.collectingAndThen(
			                 Collectors.minBy(Comparator.comparingInt(EmployeeLeave::getMonNo)),
			                 Optional::get)))
			    .values().stream()
			    .collect(Collectors.toList());
		 result.forEach(System.out::println);
	}
	
	private static void secondWay3(List<EmployeeLeave> leaves, int currentMonth) {
	    Set<Integer> qualifyingEmpNos = leaves.stream()
	        .filter(e -> e.getEmpNo() != null)
	        .collect(Collectors.groupingBy(EmployeeLeave::getEmpNo))
	        .entrySet().stream()
	        .filter(entry -> entry.getValue().stream()
	            .filter(e -> e.getMonNo() > currentMonth)
	            .allMatch(e -> e.getLeavesCnt() == 0)
	        )
	        .map(Map.Entry::getKey)
	        .collect(Collectors.toSet());

	    List<EmployeeLeave> result = leaves.stream()
	        .filter(e -> e.getEmpNo() != null)
	        .filter(e -> qualifyingEmpNos.contains(e.getEmpNo()))
	        .sorted(Comparator.comparing(EmployeeLeave::getEmpNo)
	                .thenComparing(EmployeeLeave::getMonNo))
	        .collect(Collectors.toList());

	    result.forEach(System.out::println);
	}

	
	private static void firstWay(List<EmployeeLeave> leaves, int currentMonth) {
	    // Find employees with 0 leaves for all months > currentMonth
	    Set<Integer> qualifyingEmpNos = leaves.stream()
	        .collect(Collectors.groupingBy(EmployeeLeave::getEmpNo))
	        .entrySet().stream()
	        .filter(entry -> entry.getValue().stream()
	            .filter(e -> e.getMonNo() > currentMonth)
	            .allMatch(e -> e.getLeavesCnt() == 0)
	        )
	        .map(Map.Entry::getKey)
	        .collect(Collectors.toSet());

	    // Now fetch all records for those employees
	    List<EmployeeLeave> result = leaves.stream()
	        .filter(e -> qualifyingEmpNos.contains(e.getEmpNo()))
	        .collect(Collectors.toList());

	    result.forEach(System.out::println);
	}

}

class EmployeeLeave {
	Integer empNo;
    String empName;
    int monNo;
    int leavesCnt;
 
    public EmployeeLeave() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeLeave(int empNo, String empName, int monNo, int leavesCnt) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.monNo = monNo;
		this.leavesCnt = leavesCnt;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public int getMonNo() {
		return monNo;
	}

	public int getLeavesCnt() {
		return leavesCnt;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setMonNo(Integer monNo) {
		this.monNo = monNo;
	}

	public void setLeavesCnt(int leavesCnt) {
		this.leavesCnt = leavesCnt;
	}

	@Override
	public String toString() {
		return "EmployeeLeave [empNo=" + empNo + ", empName=" + empName + ", monNo=" + monNo + ", leavesCnt="
				+ leavesCnt + "]";
	}
    
}
