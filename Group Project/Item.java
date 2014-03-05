package GroupProject;

public abstract class Item {
	
	int healAmount;
	String itemName;
	String description;
	
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
