package CharFactory;

import java.util.ArrayList;

import CharacterWeapons.IWeaponBehavior;

public abstract class Character {
	
	IWeaponBehavior weapon;
	public boolean isGood = false;
	public boolean isZombie =false;
	protected int infection = 0; 
	private String name = "null";
	private String className = "Classless", raceName = "Raceless";
	private int hp = 50, init = 1;
	private ArrayList<ItemFactory.Item> inventory = new ArrayList<ItemFactory.Item>(10);	
	private ArrayList<CharacterWeapons.IWeaponBehavior> weapons = new ArrayList<CharacterWeapons.IWeaponBehavior>(3);
	
	protected Character() {
		
	}
	
	public String getCName() {
		return this.className;
	}//end getCName
	
	public void setCName(String name) {
		this.className = name;
	}//end setCName
	
	public String getRaceName()	{
		return this.raceName;
	}//end getRaceName
	
	public void setRName(String raceName) {
		this.raceName = raceName;
	}//end setRName
	
	public void setName(String name) {
		this.name = name;
	}//end setName
	
	public String getName() {
		return this.name;
	}//end getName
	
	public int getHP() {
		return this.hp;
	}//end getHP
	
	public void setHP(int num) {
		this.hp = num;
	}//end setHP
	
	public int getInit() {
		return this.init;
	}//end getInit
	
	public ArrayList<ItemFactory.Item> getInventory () {
		return this.inventory;
	}//end getInventory
	
	public void setInventory(ItemFactory.Item item)
	{
		this.inventory.add(item);
	}//end setInventory
	
	public int attack(CharacterWeapons.IWeaponBehavior curWeapon) {
		this.weapon = curWeapon;
		return this.weapon.attack();
	}//end attack
	
	public ArrayList<CharacterWeapons.IWeaponBehavior> getWeapons()
	{
		return this.weapons;
	}//end getWeapons
	
	public void setWeapons(CharacterWeapons.IWeaponBehavior weapon)
	{
		this.weapons.add(weapon);
		//weapon.weaponName();	//was printing at monster creation as monster creation calls setweapon
	}//end setWeapons
	
	public int getInfection()
	{
		return this.infection;
	}
	
	public void setInfection(int infect)
	{
		this.infection = this.infection + infect;
	}
}
