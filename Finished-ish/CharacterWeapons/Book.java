package CharacterWeapons;

import java.util.Random;

public class Book implements IWeaponBehavior {

	public void weaponName()
	{
		System.out.println("Book");
	}
	
	@Override
	public int attack() {
		Random rg = new Random();
		int attackRange;
		
		attackRange = rg.nextInt(10 - 5) + 10;
		
		System.out.println("Swings Book and deals " + attackRange + " points of damage.");
		return attackRange;
	}//end attack
}
