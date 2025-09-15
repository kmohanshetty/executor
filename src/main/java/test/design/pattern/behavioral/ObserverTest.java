package test.design.pattern.behavioral;

import java.util.ArrayList;
import java.util.List;

class MyValue {
	private List<Observer> observers = new ArrayList<Observer>();
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}

	public void attach(Observer observer){
		observers.add(observer);    
	}

	public void notifyAllObservers(){
		for (Observer observer : observers) {
			observer.update();
		}
	}   
}

abstract class Observer {
	protected MyValue subject;
	public abstract void update();
}

class PrinterObserver extends Observer{
	public PrinterObserver(MyValue subject){
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Printer: " + subject.getState() ); 
	}
}

class EmailObserver extends Observer{

	public EmailObserver(MyValue subject){
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Email: "+ subject.getState() ); 
	}
}

class FileObserver extends Observer{

	public FileObserver(MyValue subject){
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("File: " + subject.getState()); 
	}
}

public class ObserverTest {
	public static void main(String[] args) {
		MyValue subject = new MyValue();

		new FileObserver(subject);
		new EmailObserver(subject);
		new PrinterObserver(subject);

		subject.setState(15);

		subject.setState(10);
	}
}
