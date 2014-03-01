package CharFactory;

public class Bartender extends CharacterClass {

	Character character;
	
	public Bartender(Character character, AttackBehavior weapon) {
		this.character = character;
		super.className = "Bartender";
		setWeapon(weapon);
	}
	
	@Override
	public int getHP() {
		return (character.getHP() + 1);
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
	
	public String getClassName() {
		return this.className;
	}
}
