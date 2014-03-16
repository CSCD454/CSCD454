package CharFactory;

public class Male extends CharacterRaceDecorator {
	Character character;
	
	public Male(Character character) {
		this.character = character;
		setRName("Male");
		setHP(this.character.getHP() + 50);
	}
	
	@Override
	public int getInit() {
		return (character.getInit() + 1);
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
