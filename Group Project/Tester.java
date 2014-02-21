package GroupProject;

import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		
		Character hero1 = new GoodCharacter("Buffy");
		Character monster1 = new BadCharacter("Moe");
		
		hero1 = new Male(hero1);
		
		AttackBehavior weapon = new AttackBat();
		
		hero1 = new Bartender(hero1, weapon);
		
		ArrayList<Character> hero = new ArrayList<Character>();
		
		hero.add(hero1);
		
		Encounter encounter = new Encounter(hero);
		
		encounter.makeMonster(2);
		
		//hero1.attack();
		
		
	}

}
