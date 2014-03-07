package CharacterWeapons;

import java.util.Random;

public class Rifle implements IWeaponBehavior {

	@Override
	public int attack() {
		Random rg = new Random();
		int attackRange;
		
		attackRange = rg.nextInt(30 - 15) + 15;
		
		System.out.println("Shoots rifle and deals " + attackRange + " points of damage.");
		return attackRange;
	}
}
