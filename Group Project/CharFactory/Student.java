package CharFactory;

public class Student extends CharacterClass {

	Character character;
	
	public Student(Character character, AttackBehavior weapon) {
		this.character = character;
		super.className = "Student";
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
}
