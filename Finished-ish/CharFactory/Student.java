package CharFactory;

import CharacterWeapons.IWeaponBehavior;

public class Student extends CharacterClassDecorator {
	
	public Student(Character character, IWeaponBehavior weapon) {
		this.character = character;
		setCName("Student");
		setWeapons(weapon);
		setHP(this.character.getHP() + 3);
		setRName(this.character.getRaceName());	//For some reason the race name kept getting hidden.
		setMaxHP();
	}

	@Override
	public int getInit() {
		return (character.getInit() + 2);
	}//end getInit

	@Override
	public String getName() {
		return character.getName();
	}//end getName

	@Override
	public int getInfection() {
		return this.infection;
	}//end getInfection
}
