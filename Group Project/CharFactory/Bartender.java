package CharFactory;

public class Bartender extends CharacterClassDecorator {

	Character character;
	
	public Bartender(Character character, IWeaponBehavior weapon) {
		this.character = character;
		super.className = "Bartender";
		setWeapon(weapon);
		this.hp += 5;
	}
	
	@Override
	public int getHP() {
		return (character.getHP() + 1);	//HP are not modifying right and can't assign a race name
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
