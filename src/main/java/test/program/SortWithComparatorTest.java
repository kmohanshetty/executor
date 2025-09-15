package test.program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortWithComparatorTest {
	JobCandidate2Sorter jobCandidate2Sorter  = new JobCandidate2Sorter();
	@Before
	public void setup(){
		JobCandidate2 jobCandidate1 = new JobCandidate2("Mark Smith", "Male", 26);      
		JobCandidate2 jobCandidate2 = new JobCandidate2("Sandy Hunt", "Female", 23);         
		JobCandidate2 jobCandidate3 = new JobCandidate2("Betty Clark", "Female", 20);         
		JobCandidate2 jobCandidate4 = new JobCandidate2("Andrew Styne", "Male", 24);      

		ArrayList<JobCandidate2> candidate2s = new ArrayList<JobCandidate2>();
		candidate2s.add(jobCandidate1);
		candidate2s.add(jobCandidate2);
		candidate2s.add(jobCandidate3);
		candidate2s.add(jobCandidate4);

		jobCandidate2Sorter.setCandidate2Sorter(candidate2s);
		System.out.println("setup called");
	}

	@Test     
	public void testGetSortedJobCandidateByAge() throws Exception {
		System.out.println("-----Sorted JobCandidate by age: Descending-----");
		ArrayList<JobCandidate2> sortedJobCandidate = jobCandidate2Sorter.getSortedJobCandidateByAge();         
		for (JobCandidate2 jobCandidate : sortedJobCandidate) {             
			System.out.println(jobCandidate);
		}     
	} 
	
	@Test     
	public void testGetSortedJobCandidateByName() throws Exception {         
		System.out.println("-----Sorted JobCandidate by name: Ascending-----");         
		ArrayList<JobCandidate2> sortedJobCandidate = jobCandidate2Sorter.getSortedJobCandidateByName();         
		for (JobCandidate2 jobCandidate : sortedJobCandidate) {             
			System.out.println(jobCandidate);         
		}       
	} 


}

class JobCandidate2Sorter {
	ArrayList<JobCandidate2> jobCandidate2s = new ArrayList<>();

	public JobCandidate2Sorter() {
		// TODO Auto-generated constructor stub
	}
	
	public void setCandidate2Sorter(ArrayList<JobCandidate2> jobCandidate2s) {
		this.jobCandidate2s = jobCandidate2s;
	}

	public ArrayList<JobCandidate2> getSortedJobCandidateByAge(){
		Collections.sort(jobCandidate2s, JobCandidate2.ageComparator);
		return jobCandidate2s;
	}

	public ArrayList<JobCandidate2> getSortedJobCandidateByName(){
		Collections.sort(jobCandidate2s, JobCandidate2.nameComparator);
		return jobCandidate2s;
	}
}


class JobCandidate2 {
	private String name;     
	private String gender;     
	private int age;

	public JobCandidate2(String name, String gender, int age) {
		this.name = name;         
		this.gender = gender;         
		this.age = age; 
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "JobCandidate2 [name=" + name + ", gender=" + gender + ", age="
				+ age + "]";
	}

	public static Comparator<JobCandidate2> ageComparator = new Comparator<JobCandidate2>() {
		@Override
		public int compare(JobCandidate2 jc1, JobCandidate2 jc2) {
			return (jc1.getAge() < jc2.getAge() ? -1 : (jc1.getAge() == jc2.getAge() ? 0 : 1));           
		}
	};

	public static Comparator<JobCandidate2> nameComparator = new Comparator<JobCandidate2>() {         
		@Override         
		public int compare(JobCandidate2 jc1, JobCandidate2 jc2) {             
			return (int) (jc1.getName().compareTo(jc2.getName()));         
		}     
	}; 
}