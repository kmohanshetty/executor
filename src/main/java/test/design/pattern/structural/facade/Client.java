package test.design.pattern.structural.facade;

public class Client {

	public static void main(String[] args) {
		HotelKeeper keeper = new HotelKeeper();

		VegMenu v = keeper.getVegMenu();
		NonVegMenu nv = keeper.getNonVegMenu();
		Both both = keeper.getVegNonMenu();

		v.printMenus();
		nv.printMenus();
		both.printMenus();
	}

}
