package CharFactory;

import CharacterWeapons.IWeaponBehavior;

public class CouchPotatoe extends CharacterClassDecorator {

	Character character;
	
	public CouchPotatoe(Character character, IWeaponBehavior weapon) {
		this.character = character;
		setCName("Couch Potatoe");
		setWeapons(weapon);
		setHP(this.character.getHP() + 2);
		setRName(this.character.getRaceName());	//For some reason the race name kept getting hidden.
	}

	@Override
	public int getInit() {
		return (character.getInit() + 1);
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
