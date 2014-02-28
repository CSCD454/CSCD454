package GroupProject;

import java.util.ArrayList;

public class Game {
	
	Game gamePlay;
	GameState move;
	GameState menu;
	GameState encounter;
	GameState zombie;
	GameState overgame;
	ArrayList<Character> hero;
	
	GameState state = menu;
	
	public Game()
	{	
		menu = new InitializeState(this);
		move = new MoveState(this);
		encounter = new EncounterState(this);
		zombie = new BuildMonsterState(this);
		overgame = new GameOverState(this);
		
		state = menu;
	}
	
	public void setState(GameState state)
	{
		this.state = state;
	}
	public ArrayList<Character> Initialize()
	{
		hero = state.Initialize();
		return hero;
	}
	public void Move()
	{
		state.Move();
	}
	
	public ArrayList<Character> BuildMonster()
	{
		hero = state.BuildMonster();
		return hero;
	}
	
	public void Encounter(ArrayList<Character> hero)
	{
		state.Encounter(hero);
	}
	
	public void GameOver()
	{ 
		state.GameOver();
	}
	
	public GameState getState() 
	{
		return state; 
	}
	 
	public GameState getMoveState() 
	{ 
		return move; 
	}
	
	public GameState getInitializeState() 
	{
		return menu; 
	}
	
	public GameState getBuildMonsterState() 
	{
		return zombie; 
	}
	
	public GameState getEncounterState() 
	{
		return encounter; 
	}
	
	public GameState getGameOverState()
	{
		return overgame;
	}
}
