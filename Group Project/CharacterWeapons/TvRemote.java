package CharacterWeapons;

import java.util.Random;

public class TvRemote implements IWeaponBehavior {

	@Override
	public int attack() {
		Random rg = new Random();
		int attackRange;
		
		attackRange = rg.nextInt(9 - 3) + 3;
		
		System.out.println("Swings TV remote and deals " + attackRange + " points of damage.");
		return attackRange;
	}
}
