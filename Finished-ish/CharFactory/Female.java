package CharFactory;

public class Female extends CharacterRaceDecorator {
	
	public Female(Character character) {
		this.character = character;
		setRName("Female");
		setHP(this.character.getHP() + 25);
		//setMaxHP(this.character.getHP());
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
		return this.infection;
	}//end getInfection
}
