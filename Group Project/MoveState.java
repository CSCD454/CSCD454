package GroupProject;

import java.util.ArrayList;

public class MoveState implements GameState 
{
	Game game;
	
	public MoveState(Game gamePlay)
	{
		this.game = gamePlay;
		System.out.println("Move map");
	}
	
	public ArrayList<Character> Initialize()
	{
		return null;
	}
	
	public void Move()
	{
		System.out.println("Character Move");
		game.setState(game.getBuildMonsterState());
	}
	
	public ArrayList<Character> BuildMonster()
	{
		return null;
	}
	
	public void Encounter(ArrayList<Character> hero)
	{ }
	
	public void GameOver()
	{ }
}
