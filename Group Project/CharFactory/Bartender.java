package CharFactory;

import CharacterWeapons.IWeaponBehavior;

public class Bartender extends CharacterClassDecorator {

	Character character;
	
	public Bartender(Character character, IWeaponBehavior weapon) {
		this.character = character;
		setCName("Bartender");
		setWeapons(weapon);
		setHP(this.character.getHP() + 5);
		setRName(this.character.getRaceName());	//For some reason the race name kept getting hidden.
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
