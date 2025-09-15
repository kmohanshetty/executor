package test.design.pattern.structural.facade;

public class VegNonBothRestaurant implements Hotel
{
	@Override
	public Menus getMenus()
	{
		Both b = new Both();
		return b;
	}
}

