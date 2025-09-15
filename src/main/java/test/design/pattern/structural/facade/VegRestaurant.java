package test.design.pattern.structural.facade;

public class VegRestaurant implements Hotel
{
	@Override
	public Menus getMenus()
	{
		VegMenu v = new VegMenu();
		return v;
	}
}

