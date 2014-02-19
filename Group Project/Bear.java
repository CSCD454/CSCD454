package GroupProject;

public class Bear extends CharacterRace {
	Character character;
	private int hp = 80, init = 4, infection = 4;
	
	public Bear(Character character) {
		this.character = character;
	}
	
	public int getHP() {
		return (character.getHP() + this.hp);
	}
	
	public int getInit() {
		return (character.getInit() + this.init);
	}
	
	public String getName() {
		return this.character.getName();
	}
	
	public int getInfection() {
		return this.infection;
	}
}
