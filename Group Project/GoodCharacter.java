package GroupProject;

public class GoodCharacter extends Character {
	
	private int infection; 
	
	public GoodCharacter(String name) {
		super.setName(name);
	}
	
	public void attack() {
		//Attack interface goes here
	}
	
	public void infectionChance() {
		//TODO: not sure if this should be a method or just the chance of infection
	}
}
