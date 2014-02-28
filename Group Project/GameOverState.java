package GroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameOverState implements GameState {
	
	Game game;
	public ArrayList<Character> heroList = new ArrayList<Character>();
	
	public GameOverState(Game gamePlay)
	{
		this.game = gamePlay;
		System.out.println("Game Over");
	}
	
	public ArrayList<Character> Initialize()
	{ 
		return null;
	}
	
	public void Move()
	{
		System.out.println("GAME OVER MOVE");
	}
	
	public ArrayList<Character> BuildMonster()
	{
		System.out.println("GAME OVER BUILDMONSTER");
		return null;
	}
	
	public void Encounter(ArrayList<Character> hero)
	{
		System.out.println("GAME OVER Encounter");
	}
	
	public void GameOver()
	{ }
}
