package GroupProject;

public class Female extends CharacterRace {
	Character character;
	private int hp = 35;
	private int infection = 4;
	
	public Female(Character character) {
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
