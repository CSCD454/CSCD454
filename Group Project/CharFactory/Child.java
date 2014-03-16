package CharFactory;

public class Child extends CharacterRaceDecorator {
	Character character;
	
	public Child(Character character) {
		this.character = character;
		setRName("Child");
		setHP(this.character.getHP() - 25);
	}
	
	@Override
	public int getInit() {
		return (character.getInit() + 3);
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
