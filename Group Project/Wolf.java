package GroupProject;

public class Wolf extends CharacterRace {
	Character character;
	private int hp = -20, init = 6, infection = 4;
	
	public Wolf(Character character) {
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
