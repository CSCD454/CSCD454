package RoomBuilder;

import CharFactory.Character;
import GroupProject.Game;

public class Builder extends RoomBuilder {

	public Builder() {
		super();
	}

	@Override
	public Room makeRoom(Character character, Game game) {
		this.character = character;
		this.game = game;
		
		this.roomType = getRoomType();
		
		makeRoom();
		
		return this.room;
	}//end makeRoom
	
	private int getRoomType() {
		return (int) (Math.random() * 4+ 1);
	}//end getRoomType
	
	private void makeRoom() {
		if(roomType == noFight) {
			room = new NoFightRoom(character, game);
		}
		else if( roomType == fight) {
			room = new FightRoom(character, game);
		}
		else if(roomType == weapon) {
			room = new FindWeaponRoom(character, game);
		}
		else {
			room = new FindItemRoom(character, game);
		}
	}//end makeRoom
}
