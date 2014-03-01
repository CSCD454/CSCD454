package CharFactory;

public class BadCharacterFactory extends CharacterFactory{

	Character character;
	private int rClass, rRace, rWeapon;
	
	public BadCharacterFactory() {
		randClass();
		randRace();
		//randWeapon();
	}
	
	protected void randClass() {
		rClass = (int) (Math.random() * 5 + 1);
	}
	
	protected void randRace() {
		rRace = (int) (Math.random() * 3 + 1);
	}
	
	/* Not useing now, but might use to give characters a random weapon.
	protected void randWeapon() {
		rWeapon = (int) (Math.random() * 7 + 1);
	}
	*/
	
	public Character create() {
		//TODO: make a rand name generator.  Also might need to nest badcharacter inside race to see if male or female first
		// so can have appropriate name.
		character = new BadCharacter("Bad Billy Bob");
		
		character = race(character);
		character = makeClass(character);
		
		return character;
	}
	
	private Character race(Character character) {
		Character raceTemp = character;
		
		if(rRace == male) {
			character = new Male(character);
		}
		else if(rRace == female) {
			character = new Female(character);
		}
		else if(rRace == child) {
			character = new Child(character);
		}
		else {
			System.err.println("Random number generator is not working right and rolled a " + rRace);
		}
		
		return raceTemp;
	}
	
	private Character makeClass(Character character) {
		Character classTemp = character;
		AttackBehavior weapon;
		
		if(rClass == bartender) {
			weapon = new BottleWhiskey();
			classTemp = new Bartender(classTemp, weapon);
		}
		else if(rClass == redneck) {
			weapon = new Crossbow();
			classTemp = new Redneck(classTemp, weapon);
		}
		else if(rClass == student) {
			weapon = new Book();
			classTemp = new Student(classTemp, weapon);
		}
		else if(rClass == lawEnforcement) {
			weapon = new Pistol();
			classTemp = new LawEnforcement(classTemp, weapon);
		}
		else if(rClass == zombie) {
			weapon = new Bite();
			classTemp = new Zombie(classTemp, weapon);
		}
		else {
			System.err.println("Random number generator not working rolled: " + rClass);
		}
		
		return classTemp;
	}
}
