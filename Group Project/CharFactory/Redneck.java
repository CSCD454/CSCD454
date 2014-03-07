package CharFactory;

public class Redneck extends CharacterClassDecorator {

	Character character;
	
	public Redneck(Character character, IWeaponBehavior weapon) {
		this.character = character;
		setClassName("Redneck");
		setWeapon(weapon);
		setHP(this.character.getHP() + 20);
		setRName(this.character.getRaceName());
	}

	@Override
	public int getInit() {
		return (character.getInit() + 4);
	}

	@Override
	public String getName() {
		return character.getName();
	}

	@Override
	public int getInfection() {
		return -1;
	}
	
	public String getClassName() {
		return this.className;
	}
}
