package CharFactory;

import java.util.ArrayList;

import CharacterWeapons.IWeaponBehavior;

public abstract class Character {
	
	IWeaponBehavior weapon;
	public boolean isGood = false;
	private String name = "null";
	private String className = "Classless", raceName = "Raceless";
	private int hp = 100, init = 1;
	private ArrayList<ItemFactory.Item> inventory = new ArrayList<ItemFactory.Item>(10);	
	private ArrayList<CharacterWeapons.IWeaponBehavior> weapons = new ArrayList<CharacterWeapons.IWeaponBehavior>(3);
	
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
	
	public ArrayList<ItemFactory.Item> getInventory () {	//Define arraylist here too
		return this.inventory;
	}
	
	public void setInventory(ItemFactory.Item item)
	{
		this.inventory.add(item);
	}
	
	public int attack(CharacterWeapons.IWeaponBehavior curWeapon) {
		this.weapon = curWeapon;
		return this.weapon.attack();
	}
	
	public ArrayList<CharacterWeapons.IWeaponBehavior> getWeapons()
	{
		return this.weapons;
	}
	
	public void setWeapons(CharacterWeapons.IWeaponBehavior weapon)
	{
		this.weapons.add(weapon);
		weapon.weaponName();
	}
}
