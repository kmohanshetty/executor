package test.design.pattern.behavioral;
/*
 * State design pattern is used when an Object changes its behavior based on its internal state.
 * If we have to change behavior of an object based on its state, we can have a state variable in the Object and 
   use if-else condition block to perform different actions based on the state
 * State pattern is used to provide a systematic and lose-coupled way to achieve this through 
   Context and State implementations.
 * 
 * Context: Defines an interface to client to interact. It maintains references to concrete state object which may be used to define current state of object.
   State: Defines interface for declaring what each concrete state should do.
   ConcreteState: Provides implementation for methods defined in State.
 */
interface State {
	public void doAction(Context context);
}

class StartState implements State {
	public void doAction(Context context) {
		System.out.println("In start state");
		context.setState(this);
	}

	public String toString() {
		return "Start State";
	}
}

class StopState implements State {

	public void doAction(Context context) {
		System.out.println("In stop state");
		context.setState(this);
	}

	public String toString() {
		return "Stop State";
	}
}

class PlayState implements State {
	public void doAction(Context context) {
		System.out.println("In play state");
		context.setState(this);  
	}
	public String toString() {
		return "Play State";
	}
}

class Context {
	private State state;

	public Context() {
		state = null;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}
}

public class StateTest {
	public static void main(String[] args) {
		Context context = new Context();

		StartState startState = new StartState();
		startState.doAction(context);

		System.out.println(context.getState().toString());

		PlayState playState = new PlayState();
		playState.doAction(context);
		System.out.println(context.getState().toString());

		StopState stopState = new StopState();
		stopState.doAction(context);

		System.out.println(context.getState().toString());
	}
}
