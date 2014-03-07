package CharFactory;

public class Student extends CharacterClassDecorator {

	Character character;
	
	public Student(Character character, IWeaponBehavior weapon) {
		this.character = character;
		super.className = "Student";
		setWeapon(weapon);
		this.hp += 3;
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
