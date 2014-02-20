package GroupProject;

public abstract class CharacterClass extends Character {

	public abstract int getHP();
	
	/*
	 * I just threw some random numbers in for the infection chance and init stat and really anything
	 * else that has a number.
	 */
	public abstract int getInit();
	
	public abstract String getName();
	
	public abstract int getInfection();
}
