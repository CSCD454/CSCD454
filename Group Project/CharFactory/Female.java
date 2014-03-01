package CharFactory;

public class Female extends CharacterRace {
	Character character;
	
	public Female(Character character) {
		this.character = character;
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
