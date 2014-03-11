package CharFactory;

import CharacterWeapons.IWeaponBehavior;

public class Bartender extends CharacterClassDecorator {

	Character character;
	
	public Bartender(Character character, IWeaponBehavior weapon) {
		this.character = character;
		setCName("Bartender");
		setWeapons(weapon);
		setHP(this.character.getHP() + 5);
		setRName(this.character.getRaceName());
	}

	@Override
	public int getInit() {
		return (character.getInit() + 2);
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
