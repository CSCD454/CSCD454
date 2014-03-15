package GroupProject;

import java.util.ArrayList;
import java.util.Scanner;
import RoomBuilder.Builder;
import RoomBuilder.Room;
import RoomBuilder.RoomBuilder;
import CharFactory.Character;

public class MoveState implements GameState 
{
	Game game;
	
	public MoveState(Game gamePlay)
	{
		this.game = gamePlay;
	}
	
	public ArrayList<Object> Initialize()
	{
		return null;
	}
	
	public void Move(Character character)
	{
		printMoveOptions(character);
	}
	
	void printMoveOptions(Character character)
	{
		Scanner scanner = new Scanner(System.in);
		String direction = "";
		boolean valid = false;
		Room room = null;
		RoomBuilder makeRooms = new Builder();

		checkWin();
		do {
			direction = getDirection(scanner);

			valid = validMove(direction);

			valid = canMove(direction, character);
		}while(!valid);

		room = makeRooms.makeRoom(character, game);

		System.out.println(room.getDescription());

		room.add();

		room.roomDone();
	}//end printMoveOptions
	
	private String getDirection(Scanner scanner) {
		System.out.println("");
		System.out.print("Which direction would you like to move? (N S E W) : \n");
		game.map.printMap();
		return scanner.nextLine();
	}//end getDirection
	
	private boolean validMove(String direction) {
		String heading = direction;

		if(heading.equalsIgnoreCase("n") || heading.equalsIgnoreCase("s") || heading.equalsIgnoreCase("e")
				|| heading.equalsIgnoreCase("w")) {
			return true;
		}
		else {
			System.out.println("Not a valid move option. Pick another direction: ");
			return false;
		}
	}//end validMove

	private boolean canMove(String direction, Character character) {
		String heading = direction;
		boolean valid = false;

		if(heading.equalsIgnoreCase("n")) {
			valid = moveNorth();
		}
		else if(heading.equalsIgnoreCase("s")) {
			valid = moveSouth();
		}
		else if(heading.equalsIgnoreCase("e")) {
			valid = moveEast();
		}
		else if(heading.equalsIgnoreCase("w")) {
			valid = moveWest();
		}
		else {
			//Don't move
		}
		
		return valid;
	}//end canMove
	
	private boolean moveNorth() {
		int x;
		int[] location = new int[2];
		
		location = game.map.findLocation();
		
		x = location[0];
		if(x - 1 < 0) {
			System.out.println("Can't move in that direction, too many zombies.");
			return false;
		}
		
		location[0] = location[0] - 1;
		
		game.map.setMapLocation(location);
		
		return true;
	}//end moveNorth

	private boolean moveSouth() {
		int x;
		int[] location = new int[2];
		
		location = game.map.findLocation();
		
		x = location[0];
		if(x + 1 > game.map.getSize()) {
			System.out.println("Can't move in that direction, too many zombies.");
			return false;
		}
				
		location[0] = location[0] + 1;
		
		game.map.setMapLocation(location);
		
		return true;
	}//end moveSouth
	
	private boolean moveEast() {
		int x;
		int[] location = new int[2];
		
		location = game.map.findLocation();
		
		x = location[1];
		if(x + 1 > game.map.getSize()) {
			System.out.println("Can't move in that direction, too many zombies.");
			return false;
		}
		
		location[1] = location[1] + 1;
		
		game.map.setMapLocation(location);
		
		return true;
	}//end moveEast
	
	private boolean moveWest() {
		int x;
		int[] location = new int[2];
		
		location = game.map.findLocation();
		
		x = location[1];
		if(x - 1 < 0) {
			System.out.println("Can't move in that direction, too many zombies.");
			return false;
		}
				
		location[1] = location[1] - 1;
		
		game.map.setMapLocation(location);

		return true;
	}//end moveWest
	
	private void checkWin() {
		boolean win = game.map.checkWin(game.map.findLocation());
		
		if(win) {
			game.setState(game.getGameOverState());
			game.GameOver();
		}
	}//end checkWin

	public ArrayList<Character> BuildMonster()
	{
		return null;
	}
	
	public void Encounter(ArrayList<Character> hero)
	{ }
	
	public void GameOver()
	{ }
}
