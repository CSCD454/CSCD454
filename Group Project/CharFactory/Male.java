package CharFactory;

public class Male extends CharacterRaceDecorator {
	Character character;
	
	public Male(Character character) {
		this.character = character;
		setRName("Male");
		setHP(this.character.getHP() + 50);
	}
	
	@Override
	public int getInit() {
		return (character.getInit() + 1);
	}
	
	@Override
	public String getName() {
		return this.character.getName();
	}
	
	@Override
	public int getInfection() {
		return 4;
	}
}
