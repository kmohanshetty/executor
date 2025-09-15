package test.design.pattern.creational.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class OvercomeSerializeTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Singleton4 instance1 = Singleton4.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file1.txt"));
		out.writeObject(instance1);
		out.close();
		
		ObjectInput in = new ObjectInputStream(new FileInputStream("file1.txt"));
		Singleton4 instance2 = (Singleton4) in.readObject();
		in.close();
		
		System.out.println("instance1:"+instance1.hashCode());
		System.out.println("instance2:"+instance2.hashCode());
	}

}

class Singleton4 implements Serializable{
	private static final long serialVersionUID = 1L;
	private static Singleton4 instance = new Singleton4();
	
	private Singleton4() {
		// TODO Auto-generated constructor stub
	}

	public static Singleton4 getInstance() {
		return instance;
	}
	
	protected Object readResolve(){
		return instance;
	}
}