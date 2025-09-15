package test.design.pattern.behavioral;

abstract class Software {
	abstract void initialize();
	abstract void start();
	abstract void end();
	//template method
	public final void play(){
		//initialize
		initialize();
		//start
		start();
		//end
		end();
	}
}

class Browser extends Software {
	@Override
	void end() {
		System.out.println("Browser Finished!");
	}

	@Override
	void initialize() {
		System.out.println("Browser Initialized!.");
	}

	@Override
	void start() {
		System.out.println("Browser Started.");
	}
}
class Editor extends Software {

	@Override
	void end() {
		System.out.println("Editor Finished!");
	}

	@Override
	void initialize() {
		System.out.println("Editor Initialized!");
	}

	@Override
	void start() {
		System.out.println("Editor Started!");
	}
}

public class TemplateTest {

	public static void main(String[] args) {
		Software s1 = new Browser();
		s1.play();
		s1 = new Editor();
		s1.play();    
	}

}
