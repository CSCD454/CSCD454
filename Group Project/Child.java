package GroupProject;

public class Child extends CharacterRace {
	Character character;
	private int hp = -25, init = 8, infection = 0;
	
	public Child(Character character) {
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
