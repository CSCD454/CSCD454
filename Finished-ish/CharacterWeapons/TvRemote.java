package CharacterWeapons;

import java.util.Random;

public class TvRemote implements IWeaponBehavior {

	public void weaponName()
	{
		System.out.println("TV Remote");
	}
	
	@Override
	public int attack() {
		Random rg = new Random();
		int attackRange;
		
		attackRange = rg.nextInt(10 - 5) + 5;
		
		System.out.println("Swings TV remote and deals " + attackRange + " points of damage.");
		return attackRange;
	}//end attack
}
