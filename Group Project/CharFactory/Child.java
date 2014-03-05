package CharFactory;

public class Child extends CharacterRaceDecorator {
	Character character;
	
	public Child(Character character) {
		this.character = character;
		setRaceName("Child");
		//setHP(-25);
	}
	
	public int getHP() {
		return (character.getHP() - 25);
	}
	
	public int getInit() {
		return (character.getInit() + 3);
	}
	
	public String getName() {
		return this.character.getName();
	}
	
	public int getInfection() {
		return 0;
	}
}
