package CharFactory;

import CharacterWeapons.IWeaponBehavior;

public class CouchPotatoe extends CharacterClassDecorator {

	Character character;
	
	public CouchPotatoe(Character character, IWeaponBehavior weapon) {
		this.character = character;
		setCName("Couch Potatoe");
		setWeapon(weapon);
		setHP(this.character.getHP() + 2);
		setRName(this.character.getRaceName());
	}

	@Override
	public int getInit() {
		return (character.getInit() + 1);
	}

	@Override
	public String getName() {
		return character.getName();
	}

	@Override
	public int getInfection() {
		return -1;
	}
}
