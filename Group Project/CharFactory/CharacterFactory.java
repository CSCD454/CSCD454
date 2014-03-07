package CharFactory;


public abstract class CharacterFactory {

	protected final int bartender = 1, redneck = 2, student = 3, lawEnforcement = 4, couchPotatoe = 5, zombie = 6;
	protected final int male = 1, female = 2, child = 3;
	
	//Not using now.  Might use later if want to assign random weapons at creation time.
	//protected final int bat = 1, pistol = 2, rifle = 3, crossbow = 4, tvRemote = 5, bottleWhiskey = 6, books = 7;
	
	protected abstract void randClass();
	
	protected abstract void randRace();
	
	//Not using now.  Might use later if want to assign random weapons at creation time.
	//protected abstract void randWeapon();
	
	public abstract Character create();
}
