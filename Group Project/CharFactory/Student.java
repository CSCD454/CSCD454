package CharFactory;

public class Student extends CharacterClassDecorator {

	Character character;
	
	public Student(Character character, IWeaponBehavior weapon) {
		this.character = character;
		setCName("Student");
		setWeapon(weapon);
		setHP(this.character.getHP() + 3);
		setRName(this.character.getRaceName());
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
