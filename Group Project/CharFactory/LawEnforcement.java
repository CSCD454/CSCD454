package CharFactory;

public class LawEnforcement extends CharacterClassDecorator {

	Character character;
	
	public LawEnforcement(Character character, IWeaponBehavior weapon) {
		this.character = character;
		super.className = "Law Enforcement";
		setWeapon(weapon);
		this.hp += 15;
	}
	
	@Override
	public int getHP() {
		return (character.getHP() + 1);
	}

	@Override
	public int getInit() {
		return (character.getInit() + 3);
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
