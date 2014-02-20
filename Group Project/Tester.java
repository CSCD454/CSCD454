package GroupProject;

public class Tester {

	public static void main(String[] args) {
		
		Character hero1 = new GoodCharacter("Buffy");
		Character monster1 = new BadCharacter("Moe");
		
		hero1 = new Male(hero1);
		monster1 = new Child(monster1);
		
		AttackBehavior weapon = new AttackBat();
		
		hero1 = new Bartender(hero1, weapon);
		monster1 = new Redneck(monster1);
		
		hero1.attack();
		
		
	}

}
