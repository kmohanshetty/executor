package test.program.collections;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class SortWithComparableTest {
	
	@Test
	public void testSortedWithComparable(){
		JobCandidate jobCandidate1 = new JobCandidate("Mark Smith", "Male", 26);         
		JobCandidate jobCandidate2 = new JobCandidate("Sandy Hunt", "Female", 23);         
		JobCandidate jobCandidate3 = new JobCandidate("Betty Clark", "Female", 20);         
		JobCandidate jobCandidate4 = new JobCandidate("Andrew Styne", "Male", 24);
		
		ArrayList<JobCandidate> jobCandidateList = new ArrayList<>();         
	    jobCandidateList.add(jobCandidate1);         
	    jobCandidateList.add(jobCandidate2);         
	    jobCandidateList.add(jobCandidate3);         
	    jobCandidateList.add(jobCandidate4);
	    
	    JobCandidateSorter jobCandidateSorter = new JobCandidateSorter(jobCandidateList);
	    
	    System.out.println("Non sorted value: " + jobCandidateSorter.getSortedJobCandidateByAge());
	}
    
}


class JobCandidateSorter{
	ArrayList<JobCandidate> jobCandidates = new ArrayList<JobCandidate>();
	
	public JobCandidateSorter(ArrayList<JobCandidate> jobCandidates) {
		this.jobCandidates = jobCandidates;
	}
	
	public ArrayList<JobCandidate> getSortedJobCandidateByAge(){
		Collections.sort(jobCandidates);
		return jobCandidates;
	}
}

class JobCandidate implements Comparable<JobCandidate>{
	private String name;     
	private String gender;     
	private int age;
	
	public JobCandidate(String name, String gender, int age) {
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
		return "JobCandidate [name=" + name + ", gender=" + gender + ", age="
				+ age + "]";
	}

	@Override
	public int compareTo(JobCandidate candidate) {
		return (this.getAge() < candidate.getAge() ? -1:(this.getAge() == candidate.getAge() ? 0 : 1)); 
	}
}