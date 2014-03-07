package CharFactory;

import java.util.ArrayList;

public abstract class Character {
	
	IWeaponBehavior weapon;
	boolean isGood = false;
	private String name = "null";
	private String className = "Classless", raceName = "Raceless";
	private int hp = 100, init = 1;
	private ArrayList inventory = new ArrayList(10);	//Need to define arraylist type later
	
	public Character() {
		
	}
	
	public String getCName() {
		return this.className;
	}
	
	public void setCName(String name) {
		this.className = name;
	}
	
	public String getRaceName()	{
		return this.raceName;
	}
	
	public void setRName(String raceName) {
		this.raceName = raceName;
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
	
	public void setHP(int num) {
		this.hp = num;
	}
	
	public int getInit() {
		return this.init;
	}
	
	public ArrayList getInventory () {	//Define arraylist here too
		return this.inventory;
	}
	
	public void setWeapon(IWeaponBehavior weapon) {
		this.weapon = weapon;
	}
	
	public int attack() {
		return this.weapon.attack();
	}
}
