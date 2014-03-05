package GroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MoveState implements GameState 
{
	Game game;
	
	public MoveState(Game gamePlay)
	{
		this.game = gamePlay;
		System.out.println("Move map");
	}
	
	public ArrayList<CharFactory.Character> Initialize()
	{
		return null;
	}
	
	public void Move()
	{
		System.out.println("Character Move");
		printMoveOptions();
	}
	
	void printMoveOptions()
	{
		int winLocation = (int )(Math.random() * 7 + 1);
		int monsterLocation, random;
		String direction = "";
		boolean moving = true;
		System.out.print("Which direction would you like to move? (N S E W) : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			direction = br.readLine();
		} catch (IOException ioe) {
		    System.out.println("IO error trying to read your name!");
		    System.exit(1);
		}
		//random = (int )(Math.random() * 5 + 1);
		monsterLocation = (int )(Math.random() * 5 + 1);
		random = monsterLocation;
		System.out.println("ME - " + random + "   MONSTER -" + monsterLocation + "   WIN -" + winLocation);
		if (monsterLocation == random)
		{
			game.setState(game.getBuildMonsterState());
			moving = false;
		} 
		else if (random == winLocation)
		{
			System.out.println("You have reached the jail.");
			moving = false;
			game.setState(game.getGameOverState());
		}
		else
		{
			System.out.println("You will move " + random + " steps " + direction);
			game.Move();
		}
	}
	
	public ArrayList<CharFactory.Character> BuildMonster()
	{
		return null;
	}
	
	public void Encounter(ArrayList<CharFactory.Character> hero)
	{ }
	
	public void GameOver()
	{ }
}
