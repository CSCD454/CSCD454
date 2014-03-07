package CharFactory;

public class LawEnforcement extends CharacterClassDecorator {

	Character character;
	
	public LawEnforcement(Character character, IWeaponBehavior weapon) {
		this.character = character;
		setClassName("Law Enforcement");
		setWeapon(weapon);
		setHP(this.character.getHP() + 15);
		setRName(this.character.getRaceName());
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
