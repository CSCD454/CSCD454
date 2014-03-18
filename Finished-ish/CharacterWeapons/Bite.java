package CharacterWeapons;

import java.util.Random;

public class Bite implements IWeaponBehavior {

	public void weaponName()
	{
		System.out.println("Bite");
	}
	
	@Override
	public int attack() {
		Random rg = new Random();
		int attackRange;
		
		attackRange = rg.nextInt(10 - 5) + 5;
		
		System.out.println("Bite and deals " + attackRange + " points of damage.");
		return attackRange;
	}//end attack
}
