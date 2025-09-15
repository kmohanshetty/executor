package test.program.lamda;

interface Sayable{  
    void say(int a);  
}  

public class MethodReference {

	public static void saySomething(int a){  
        System.out.println("Hello, this is static method.: "+a);  
    }
	
	public static void main(String[] args) {
		// Referring static method  
        Sayable sayable = MethodReference::saySomething;  
        // Calling interface method  
        sayable.say(1111);
	}
}
