package CharacterWeapons;

import java.util.Random;

public class Crossbow implements IWeaponBehavior {

	@Override
	public int attack() {
		Random rg = new Random();
		int attackRange;
		
		attackRange = rg.nextInt(18 - 9) + 9;
		
		System.out.println("Shoots crossbow and deals " + attackRange + " points of damage.");
		return attackRange;
	}
}
