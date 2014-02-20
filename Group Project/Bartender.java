package GroupProject;

public class Bartender extends CharacterClass {

	Character character;
	private int hp = 1, init = 1, infection = -1;
	
	public Bartender(Character character, AttackBehavior weapon) {
		this.character = character;
		super.className = "Bartender";
		setWeapon(weapon);
	}
	
	@Override
	public int getHP() {
		return (character.getHP() + this.hp);
	}

	@Override
	public int getInit() {
		return (character.getInit() + this.init);
	}

	@Override
	public String getName() {
		return character.getName();
	}

	@Override
	public int getInfection() {
		return 0;	//Not exactly sure what to do here.
	}
	
	public String getClassName() {
		return this.className;
	}
}
