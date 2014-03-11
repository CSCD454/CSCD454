package CharFactory;

import CharacterWeapons.IWeaponBehavior;

public class Zombie extends CharacterClassDecorator {

	Character character;

	public Zombie(Character character, IWeaponBehavior weapon) {
		this.character = character;
		setCName("Zombie");
		setWeapons(weapon);
		setHP(this.character.getHP() - 10);
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
		return 0;	//Zombies can't get infected.
	}
}
