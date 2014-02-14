package GroupProject;

public class Dog extends CharacterRace {
	Character character;
	private int hp = -20;
	private int infection = 4;
	
	public Dog(Character character) {
		this.character = character;
	}
	
	public int getHP() {
		return (character.getHP() + this.hp);
	}
	
	public String getName() {
		return this.character.getName();
	}
	
	public int getInfection() {
		return this.infection;
	}
	
	public void attack() {
		
	}
}
