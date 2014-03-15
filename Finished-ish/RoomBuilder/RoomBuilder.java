package RoomBuilder;

import GroupProject.Game;
import CharFactory.Character;

public abstract class RoomBuilder {
	
	protected Room room;
	protected Character character;
	protected Game game;
	protected int roomType;
	protected final int noFight = 1, fight = 2, weapon = 3, item = 4;
	
	protected RoomBuilder() {
		
	}
	
	public abstract Room makeRoom(Character character, Game game);
	
	
}
