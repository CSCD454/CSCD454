package CharFactory;

public class Zombie extends CharacterClass {

	Character character;

	public Zombie(Character character, AttackBehavior weapon) {
		this.character = character;
		super.className = "Zombie";
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
		return 0;	//Zombies can't get infected.
	}

	public String getClassName() {
		return this.className;
	}
}