package GroupProject;

import java.util.ArrayList;

public abstract class Character {
	
	protected String name = "null";
	private int hp = 100;
	private ArrayList inventory = new ArrayList(10);	//Need to define arraylist type later
	
	public Character() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public ArrayList getInventory () {	//Define arraylist here too
		return this.inventory;
	}
	
	abstract void attack();
}
