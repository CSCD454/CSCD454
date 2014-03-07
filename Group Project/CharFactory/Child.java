package CharFactory;

public class Child extends CharacterRaceDecorator {
	Character character;
	
	public Child(Character character) {
		this.character = character;
		setRName("Child");
		setHP(this.character.getHP() - 25);
	}
	
	@Override
	public int getInit() {
		return (character.getInit() + 3);
	}
	
	@Override
	public String getName() {
		return this.character.getName();
	}
	
	@Override
	public int getInfection() {
		return 0;
	}
}
