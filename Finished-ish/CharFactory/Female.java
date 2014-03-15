package CharFactory;

public class Female extends CharacterRaceDecorator {
	Character character;
	
	public Female(Character character) {
		this.character = character;
		setRName("Female");
		setHP(this.character.getHP() + 35);
	}
	
	@Override
	public int getInit() {
		return (character.getInit() + 2);
	}//end getInit
	
	@Override
	public String getName() {
		return this.character.getName();
	}//end getName
	
	@Override
	public int getInfection() {
		return 4;
	}//end getInfection
}
