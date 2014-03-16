package CharFactory;

import CharacterWeapons.IWeaponBehavior;

public class Zombie extends CharacterClassDecorator {

	public Zombie(Character character, IWeaponBehavior weapon) {
		this.character = character;
		setCName("Zombie");
		setWeapons(weapon);
		setHP(this.character.getHP() - 10);
		setRName(this.character.getRaceName());	//For some reason the race name kept getting hidden.
		setMaxHP();
		isZombie = true;
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
		return 0;	//Zombies can't get infected.
	}//end getName
}
