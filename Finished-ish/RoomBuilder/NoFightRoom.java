package RoomBuilder;

import GroupProject.Game;
import CharFactory.Character;

public class NoFightRoom extends Room {

	public NoFightRoom(Character character, Game game) {
		this.character = character;
		this.game = game;
		setDescription("nofight.txt");
	}

	@Override
	public void add() {
		// Nothing to add here
	}//end add

	@Override
	public void roomDone() {
		game.Move(character);
	}//end roomDone
}
