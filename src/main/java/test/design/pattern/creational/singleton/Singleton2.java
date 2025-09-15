package test.design.pattern.creational.singleton;

import java.lang.reflect.Constructor;

public class Singleton2 {
	// public instance initialized when loading the class
	public static Singleton2 instance = new Singleton2();

	private Singleton2() {
		// private constructor
		if(instance != null){
			System.out.println("cannot create new instance.");
		}
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Singleton2 instance1 = Singleton2.instance;
		Singleton2 instance2 = null;
		try	{
			Constructor[] constructors = 
					Singleton2.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instance2 = (Singleton2) constructor.newInstance();
				break;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("instance1.hashCode():- " + instance1.hashCode());
		System.out.println("instance2.hashCode():- " + instance2.hashCode());
	}
}
