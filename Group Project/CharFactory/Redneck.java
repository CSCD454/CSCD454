package CharFactory;

public class Redneck extends CharacterClassDecorator {

	Character character;
	
	public Redneck(Character character, IWeaponBehavior weapon) {
		this.character = character;
		super.className = "Redneck";
		setWeapon(weapon);
		this.hp += 20;
	}
	
	@Override
	public int getHP() {
		return (character.getHP() + 1);
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
