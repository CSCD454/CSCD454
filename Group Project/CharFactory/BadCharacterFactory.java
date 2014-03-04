package CharFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BadCharacterFactory extends CharacterFactory{

	Character character;
	private int rClass, rRace, rWeapon;
	private ArrayList<String> names = new ArrayList<String>();
	private Random rg = new Random();
	
	public BadCharacterFactory() {
		randClass();
		randRace();
		//randWeapon();
		fillNames();
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
		
		character = new BadCharacter(randName());
		
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

	private Scanner readFile() throws FileNotFoundException {
		return new Scanner(new File("name.txt"));
	}
	
	private void fillNames() {
		Scanner reader = null;
		
		try {
			reader = readFile();
		}
		catch(FileNotFoundException e) {
			System.err.println("Couldn't open the file.");
		}
		
		while(reader.hasNextLine()) {
			names.add(reader.nextLine());
		}
	}

	private String randName() {
		int index = this.rg.nextInt(this.names.size());
		return this.names.get(index);
	}
}
