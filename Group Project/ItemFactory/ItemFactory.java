package ItemFactory;


public class ItemFactory {
	
	public Item createItem(String type)
	{
		Item item = null;
		if (type.equals("firstaidkit"))
		{
			item = new FirstAidKit();
		}
		else if (type.equals("water"))
		{
			item = new Water();
		}
		else if (type.equals("food"))
		{
			item  = new Food();
		}
		else
		{
			System.out.println("That is not a valid item");
		}
		return item;
	}
		
}
