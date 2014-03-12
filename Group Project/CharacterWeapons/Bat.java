package CharacterWeapons;

import java.util.Random;

public class Bat implements IWeaponBehavior {

	public void weaponName()
	{
		System.out.println("Bat");
	}
	
	@Override
	public int attack() {
		Random rg = new Random();
		int attackRange;
		
		attackRange = rg.nextInt(9 - 5) + 5;
		
		System.out.println("Swings Bat and deals " + attackRange + " points of damage.");
		return attackRange;
	}
}
