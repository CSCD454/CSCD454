package CharFactory;

public abstract class CharacterRaceDecorator extends Character {

	protected Character character;
	
	public abstract int getInit();
	
	public abstract String getName();
	
	public abstract int getInfection();
}
