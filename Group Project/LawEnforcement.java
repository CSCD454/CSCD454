package GroupProject;

public class LawEnforcement extends CharacterClass {

	Character character;
	private int hp = 1, init = 1, infection = -1;
	
	public LawEnforcement(Character character) {
		this.character = character;
		super.className = "Law Enforcement";
	}
	
	@Override
	public int getHP() {
		return (character.getHP() + this.hp);
	}

	@Override
	public int getInit() {
		return (character.getInit() + this.init);
	}

	@Override
	public String getName() {
		return character.getName();
	}

	@Override
	public int getInfection() {
		return 0;	//Not exactly sure what to do here.
	}
	
	public String getClassName() {
		return this.className;
	}
	
	@Override
	public void attack() {
		//TODO: put attack interface here.
	}
}
