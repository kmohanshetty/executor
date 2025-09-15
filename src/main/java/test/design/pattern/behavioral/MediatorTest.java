package test.design.pattern.behavioral;
/**
 * Mediator design pattern is one of the important and widely used behavioral design pattern
 * Mediator enables decoupling of objects by introducing a layer in between so that the interaction between objects happen via the layer.
 * If the objects interact with each other directly, the system components are tightly-coupled with each other that makes higher maintainability cost and not hard to extend.
 * Mediator pattern focuses on providing a mediator between objects for communication and help in implementing lose-coupling between objects
 * 
 * Air traffic controller is a great example of mediator pattern where the airport control room works as a mediator for communication between different flights
 * Mediator works as a router between objects and it can have it’s own logic to provide way of communication
 */
class Button {
	private Mediator mediator;

	// constructor, getters and setters
	public Button(Mediator mediator) {
		this.mediator = mediator; 
	}
	
	public void press() {
		mediator.press();
	}
}

class PowerSupplier {
	public void turnOn() {
		// implementation
	}

	public void turnOff() {
		// implementation
	}
}

class Mediator {
	private Fan fan;
	private PowerSupplier powerSupplier;

	// constructor, getters and setters

	public void press() {
		if (fan.isOn()) {
			fan.turnOff();
		} else {
			fan.turnOn();
		}
	}

	public void start() {
		powerSupplier.turnOn();
	}

	public void stop() {
		powerSupplier.turnOff();
	}
}

class Fan {
	private Mediator mediator;
	private boolean isOn = false;
	
	public Fan(Mediator mediator) {
		this.mediator = mediator; 
	}

	// constructor, getters and setters

	public void turnOn() {
		mediator.start();
		setOn(true);
	}

	public void turnOff() {
		setOn(false);
		mediator.stop();
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
}

public class MediatorTest {
	public static void main(String[] args) {
		Mediator mediator = new Mediator();
		Button button = new Button(mediator);
		button.press();
		Fan fan = new Fan(mediator);
		fan.turnOn();
		fan.turnOff();
	}
}
