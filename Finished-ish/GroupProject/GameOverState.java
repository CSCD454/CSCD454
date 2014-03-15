package GroupProject;

import java.util.ArrayList;
import CharFactory.Character;

public class GameOverState implements GameState {
	
	Game game;
	public ArrayList<Character> heroList = new ArrayList<CharFactory.Character>();
	
	public GameOverState(Game gamePlay)
	{
		this.game = gamePlay;
	}
	
	public ArrayList<Object> Initialize()
	{ 
		return null;
	}
	
	public void Move(Character character)
	{
		System.out.println("GAME OVER MOVE");
	}
	
	public ArrayList<Character> BuildMonster()
	{
		System.out.println("GAME OVER");
		return null;
	}
	
	public void Encounter(ArrayList<Character> hero)
	{
		System.out.println("GAME OVER Encounter");
	}
	
	public void GameOver()
	{ 
		System.out.println("****************Game is over!!!!****************");
		System.exit(0);
	}
}
