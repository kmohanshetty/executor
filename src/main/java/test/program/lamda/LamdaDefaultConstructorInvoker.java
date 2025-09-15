package test.program.lamda;

@FunctionalInterface
interface MyConstructorInvoker {
    MyClass2 createMyInstance();
}

@FunctionalInterface
interface MyConstructorInvoker2 {
    MyClass2 createMyInstance(int n);
}

class MyClass2 {
	int n;
    // Your class implementation
    public MyClass2() {
        System.out.println("default constructor called");
    }
    
    public MyClass2(int n) {
    	this.n = n;
        System.out.println("parametrized constructor called n: "+n);
    }
    
    public int getN() {
    	return n;
    }
}


public class LamdaDefaultConstructorInvoker {
	public static void main(String[] args) {
		MyConstructorInvoker invoker = MyClass2::new;

	    MyClass2 instance = invoker.createMyInstance();
	    System.out.println(instance.getN());
	    
	    MyConstructorInvoker2 invoker2 = MyClass2::new;
	    MyClass2 instance2 = invoker2.createMyInstance(2);
	    System.out.println(instance2.getN());
	    
	    Runnable obj = MyClass2::new;
	    obj.run();
	    
	}
}
