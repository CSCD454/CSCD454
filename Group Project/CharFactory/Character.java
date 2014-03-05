package CharFactory;

import java.util.ArrayList;

public abstract class Character {
	
	IWeaponBehavior weapon;
	boolean isGood = false;
	private String name = "null";
	protected String className = "Classless";
	private String raceName = "Raceless";
	protected int hp = 100, init = 1, realHP;
	private ArrayList inventory = new ArrayList(10);	//Need to define arraylist type later
	
	public Character() {
		
	}
	
	public void setRealHP(int hp) {
		this.realHP = hp;
	}
	
	public int getRealHP() {
		return this.realHP;
	}
	
	public String getClassName() {
		return this.className;
	}
	
	public String getRaceName()	{
		return this.raceName;
	}
	
	public void setRaceName(String raceName) {
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
