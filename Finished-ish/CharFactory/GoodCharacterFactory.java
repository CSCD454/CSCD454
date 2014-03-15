package CharFactory;

import CharacterWeapons.Book;
import CharacterWeapons.BottleWhiskey;
import CharacterWeapons.Crossbow;
import CharacterWeapons.IWeaponBehavior;
import CharacterWeapons.Pistol;
import CharacterWeapons.TvRemote;

public class GoodCharacterFactory extends CharacterFactory {

	Character character;
	private String name;
	private int rClass, rRace, rWeapon;
	
	public GoodCharacterFactory(String name) {
		super();
		this.name = name;
		randClass();
		randRace();
		//randWeapon();
	}
	
	protected void randClass() {
		rClass = (int) (Math.random() * 4 + 1);
	}//end randClass
	
	protected void randRace() {
		rRace = (int) (Math.random() * 3 + 1);
	}//end randRace
	
	/* Not useing now, but might use to give characters a random weapon.
	protected void randWeapon() {
		rWeapon = (int) (Math.random() * 7 + 1);
	}
	*/
	
	public Character create() {
		character = new GoodCharacter(name);
		
		character = race(character);
		character = makeClass(character);
		
		this.character.isGood = true;
		
		return character;
	}//end create
	
	private Character race(Character character) {
		Character raceTemp = character;
		
		if(rRace == male) {
			raceTemp = new Male(raceTemp);
		}
		else if(rRace == female) {
			raceTemp = new Female(raceTemp);
		}
		else if(rRace == child) {
			raceTemp = new Child(raceTemp);
		}
		else {
			System.err.println("Random number generator is not working right and rolled a " + this.rRace);
		}
		
		return raceTemp;
	}//end race
	
	private Character makeClass(Character character) {
		Character classTemp = character;
		IWeaponBehavior weapon;
		
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
		else if(rClass == couchPotatoe) {
			weapon = new TvRemote();
			classTemp = new CouchPotatoe(classTemp, weapon);
		}
		else {
			System.err.println("Random number generator not working rolled: " + this.rClass);
		}
		
		return classTemp;
	}//end makeClass
}
