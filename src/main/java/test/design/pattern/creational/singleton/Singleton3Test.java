package test.design.pattern.creational.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Singleton3Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Singleton3 instance1 = Singleton3.getInstance();
		//serialize this instance
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file.txt"));
		out.writeObject(instance1);
		out.close();
		
		//de-serialize instance now:
		ObjectInput in = new ObjectInputStream(new FileInputStream("file.txt"));
		Singleton3 instance2 = (Singleton3) in.readObject();
		in.close();
		
		System.out.println("instance1: "+instance1.hashCode());
		System.out.println("instance2: "+instance2.hashCode());
	}
}

class Singleton3 implements Serializable{
	private static final long serialVersionUID = 1L;
	private static Singleton3 instance = new Singleton3();
	
	private Singleton3() {
		// TODO Auto-generated constructor stub
	}
	
	public static Singleton3 getInstance(){
		return instance;
	}
}