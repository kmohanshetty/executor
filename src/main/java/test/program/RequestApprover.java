package test.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/*
 * Assume there are n number of customers, we have our application that is running continuously , we have common THRESHOLD limit say 5, here 5 indicates 
 * we can have max 5 requests per customer, requirement is request can be made to our application anytime, it can max handle THRESHOLD request and reject remaining 
 * after elapse of one min during second min same request need to be picked and served where it was rejected.
 * 
 * from vinod (privately): 
 * first min                           second min
 * [0����������������������..58, 59,]       		[60, 61, 62�������..120]..........
 * R1, R2, R3,R4,R5  <R6 rejected> <R7rejected>     R8, R9, R10, R11, R12, <R13 rejected>
 * 
 * 
 * 
 * @author mohan_krishnamurthy
 *
 */

class Cust{
	List<Observer> observerList = new ArrayList<Observer>();
	int numOfReq = 0;
	String name = "";
	private boolean acceptRequest = true;
	int timeelapsed = 0;
	private int makereqcnt = 0;
	
	public int getNumOfReq() {
		return numOfReq;
	}
	public void setNumOfReq(int numOfReq) {
		this.numOfReq = numOfReq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Cust(int numOfReq, String name) {
		super();
		this.numOfReq = numOfReq;
		this.name = name;
	}
	public boolean isAcceptRequest() {
		return acceptRequest;
	}
	public void setAcceptRequest(boolean acceptRequest) {
		this.acceptRequest = acceptRequest;
	}
	public int getMakereqcnt() {
		return makereqcnt;
	}
	public void setMakereqcnt(int makereqcnt) {
		this.makereqcnt = makereqcnt;
	}

	public void attach(Observer observer){
		observerList.add(observer);    
	}

	public void notifyAllObservers(){
		for (Observer observer : observerList) {
			observer.update();
		}
	}   
}

abstract class Observer {
	Cust cust;
	abstract void update();
}

class RequestHandler extends TimerTask {
	private static int THRESHOLD = 5;
	List<Cust> custList = new ArrayList<Cust>();
	int timer = 0;

	@Override
	public void run() {
//		for(int i=0;i<THRESHOLD;i++){
			handleRequest();
		//}
	}
	
	public void handleRequest(){
		for(Cust cust : custList){
			for(int i = cust.numOfReq ;i < 10; i++){
				cust.setMakereqcnt(cust.getMakereqcnt()+1);
				makeRequest(cust, timer,i);
			}
			System.out.println(" timer: "+(timer++));
		}
	}
	
	public static void makeRequest(Cust cust, int timer,int i){
		if(cust.getMakereqcnt() <= THRESHOLD){
			System.out.println(cust.getName()+" "+i);
			cust.timeelapsed = timer;
		}else {
			System.out.println("reject for "+cust.getName());
		}
	}
	
}


public class RequestApprover {

	public static void main(String[] args) {
		Timer timer = new Timer();
		RequestHandler task = new RequestHandler();
		task.custList.add(new Cust(3,"cust1"));
		task.custList.add(new Cust(6,"cust2"));
		
		
		
		timer.schedule(task,1000,1000);
	}

}
