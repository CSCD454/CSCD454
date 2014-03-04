package GroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameOverState implements GameState {
	
	Game game;
	public ArrayList<CharFactory.Character> heroList = new ArrayList<CharFactory.Character>();
	
	public GameOverState(Game gamePlay)
	{
		this.game = gamePlay;
		System.out.println("Game Over");
	}
	
	public ArrayList<CharFactory.Character> Initialize()
	{ 
		return null;
	}
	
	public void Move()
	{
		System.out.println("GAME OVER MOVE");
	}
	
	public ArrayList<CharFactory.Character> BuildMonster()
	{
		System.out.println("GAME OVER BUILDMONSTER");
		return null;
	}
	
	public void Encounter(ArrayList<CharFactory.Character> hero)
	{
		System.out.println("GAME OVER Encounter");
	}
	
	public void GameOver()
	{ }
}
