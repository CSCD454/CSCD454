package GroupProject;

import java.util.ArrayList;

public abstract class Character {
	
	AttackBehavior weapon;
	private String name = "null";
	protected String className = "Classless";
	private int hp = 100, init = 1;
	private ArrayList inventory = new ArrayList(10);	//Need to define arraylist type later
	
	public Character() {
		
	}
	
	public String getClassName() {
		return this.className;
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
	
	public int getInit() {
		return this.init;
	}
	
	public ArrayList getInventory () {	//Define arraylist here too
		return this.inventory;
	}
	
	public void setWeapon(AttackBehavior weapon) {
		this.weapon = weapon;
	}
	
	public void attack() {
		this.weapon.attack();
	}
}
