package GroupProject;

public class ItemFactory {
	
	public Item createItem(String type)
	{
		Item item = null;
		if (type.equals("firstaidkit"))
		{
			item = new FirstAidKit();
		}
		return item;
	}
		
}
