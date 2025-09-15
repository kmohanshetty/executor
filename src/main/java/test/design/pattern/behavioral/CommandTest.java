package test.design.pattern.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Suppose you are building a home automation system.
   There is a programmable remote which can be used to turn on and off 
   various items in your home like lights, stereo, AC etc
 
 * But we need to keep in mind that turning on some devices like stereo 
   comprises of many steps like setting cd, volume etc
   
 * Also we can reassign a button to do something else.
 * 
 *  By using simple if-else we are coding to implementation rather than interface. Also there is tight coupling.
 *  
 *  So what we want to achieve is a design that provides loose coupling and remote control 
 *  should not have much information about a particular device
 */

interface Command {
	void execute();
}
class MouseCursor {
	private int x = 10;
	private int y = 10;
	
	public void move() {
		System.out.println("Old Position:"+x +":"+y);
		x++;
		y++;
		System.out.println("New Position:"+x +":"+y);
	}

	public void reset() {
		x = 10;
		y = 10;
		System.out.println("reset done:"+x +":"+y);
	}
}
class MoveCursor implements Command {
	private MouseCursor abcStock;

	public MoveCursor(MouseCursor abcStock) {
		this.abcStock = abcStock;
	}

	public void execute() {
		abcStock.move();
	}
}
class ResetCursor implements Command {
	private MouseCursor abcStock;

	public ResetCursor(MouseCursor abcStock) {
		this.abcStock = abcStock;
	}

	public void execute() {
		abcStock.reset();
	}
}
class MouseCommands {
	private List<Command> orderList = new ArrayList<Command>();

	public void takeOrder(Command order) {
		orderList.add(order);
	}

	public void placeOrders() {
		for (Command order : orderList) {
			order.execute();
		}
		orderList.clear();
	}
}


public class CommandTest {
	public static void main(String[] args) {
	    MouseCursor cursor = new MouseCursor();
	    MoveCursor moveCursor = new MoveCursor(cursor);
	    ResetCursor resetCursor = new ResetCursor(cursor);
	    MouseCommands commands= new MouseCommands();
	    commands.takeOrder(moveCursor);
	    commands.takeOrder(moveCursor);
	    commands.takeOrder(moveCursor);
	    commands.takeOrder(moveCursor);
	    commands.takeOrder(resetCursor);
	    
	    commands.placeOrders();
	}
}
