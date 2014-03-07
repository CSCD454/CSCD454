package CharFactory;

public class Female extends CharacterRaceDecorator {
	Character character;
	
	public Female(Character character) {
		this.character = character;
		setRaceName("Female");
		//setHP(35);
	}
	
	public int getHP() {
		return (character.getHP() + 35);
	}
	
	public int getInit() {
		return (character.getInit() + 2);
	}
	
	public String getName() {
		return this.character.getName();
	}
	
	public int getInfection() {
		return 4;
	}
}
