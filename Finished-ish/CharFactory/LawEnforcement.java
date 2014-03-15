package CharFactory;

import CharacterWeapons.IWeaponBehavior;

public class LawEnforcement extends CharacterClassDecorator {

	Character character;
	
	public LawEnforcement(Character character, IWeaponBehavior weapon) {
		this.character = character;
		setCName("Law Enforcement");
		setWeapons(weapon);
		setHP(this.character.getHP() + 15);
		setRName(this.character.getRaceName());	//For some reason the race name kept getting hidden.
	}

	@Override
	public int getInit() {
		return (character.getInit() + 3);
	}//end getInit

	@Override
	public String getName() {
		return character.getName();
	}//end getName

	@Override
	public int getInfection() {
		return -1;
	}//end getInfection
}
