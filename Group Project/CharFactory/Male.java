package CharFactory;

public class Male extends CharacterRace {
	Character character;
	
	public Male(Character character) {
		this.character = character;
	}
	
	public int getHP() {
		return (character.getHP() + 50);
	}
	
	public int getInit() {
		return (character.getInit() + 1);
	}
	
	public String getName() {
		return this.character.getName();
	}
	
	public int getInfection() {
		return 4;
	}
}
