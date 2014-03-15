package RoomBuilder;

import GroupProject.Game;
import CharFactory.Character;

public class FightRoom extends Room {

	public FightRoom(Character character, Game game) {
		this.character = character;
		this.game = game;
		setDescription("fight.txt");
		
	}

	@Override
	public void add() {
		// Nothing to add here		
	}//end add
	
	@Override
	public void roomDone() {
		game.setState(game.getBuildMonsterState());
	}//end roomDone

}
