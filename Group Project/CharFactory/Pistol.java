package CharFactory;

import java.util.Random;

public class Pistol implements IWeaponBehavior {

	@Override
	public int attack() {
		Random rg = new Random();
		int attackRange;
		
		attackRange = rg.nextInt(20 - 10) + 10;
		
		System.out.println("Shoots pistol and deals " + attackRange + " points of damage.");
		return attackRange;
	}
}
