package CharFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import CharacterWeapons.Bite;
import CharacterWeapons.Book;
import CharacterWeapons.BottleWhiskey;
import CharacterWeapons.Crossbow;
import CharacterWeapons.IWeaponBehavior;
import CharacterWeapons.Pistol;
import CharacterWeapons.TvRemote;

public class BadCharacterFactory extends CharacterFactory{

	private ArrayList<String> names = new ArrayList<String>();
	private Random rg = new Random();
	
	public BadCharacterFactory() {
		super();
		randClass();
		randRace();
		//randWeapon();
		fillNames();
	}
	
	protected void randClass() {
		rClass = (int) (Math.random() * 6 + 1);
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
		
		character = new BadCharacter(randName());
		
		character = race(character);
		character = makeClass(character);
		
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
			System.err.println("Random number generator is not working right and rolled a " + rRace);
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
		else if(rClass == zombie){
			weapon = new Bite();
			classTemp = new Zombie(classTemp, weapon);
		}
		else {
			System.out.println("Random number isn't working right so giving you a zombie");
			weapon = new Bite();
			classTemp = new Zombie(classTemp, weapon);
		}
		
		return classTemp;
	}//end makeClass

	private Scanner readFile() throws FileNotFoundException {
		return new Scanner(new File("name.txt"));
	}//end readFile
	
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
		reader.close();
	}//end fillNames

	private String randName() {
		int index = this.rg.nextInt(this.names.size());
		return this.names.get(index);
	}//end randName
}
