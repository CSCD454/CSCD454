package CharFactory;

public class CouchPotatoe extends CharacterClassDecorator {

	Character character;
	
	public CouchPotatoe(Character character, IWeaponBehavior weapon) {
		this.character = character;
		super.className = "Couch Potatoe";
		setWeapon(weapon);
		this.hp += 5;
	}
	
	@Override
	public int getHP() {
		return (character.getHP() + 1);
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
	
	public String getClassName() {
		return this.className;
	}
}
