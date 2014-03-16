package CharFactory;

public abstract class CharacterClassDecorator extends Character {

	protected Character character;
	
	public abstract int getInit();
	
	public abstract String getName();
	
	public abstract int getInfection();
}
