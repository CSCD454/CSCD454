package ItemFactory;

public abstract class Item {
	
	protected int healAmount;
	public String itemName;
	public String description;
	
	public String getItemName()
	{
		return itemName;
	}
	
	public int getHealAmount()
	{
		return healAmount;
	}
	
	public String getDescription()
	{
		return description;
	}
}
