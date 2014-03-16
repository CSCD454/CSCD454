package ItemFactory;

public abstract class Item {
	
	protected int healAmount;
	protected String itemName;
	protected String description;
	
	protected Item() {
		
	}
	
	public String getItemName()
	{
		return itemName;
	}//end getItemName
	
	public int getHealAmount()
	{
		return healAmount;
	}//end getHealAmount
	
	public String getDescription()
	{
		return description;
	}//end getDescription
}
