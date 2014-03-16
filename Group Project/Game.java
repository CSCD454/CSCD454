package GroupProject;

import java.util.ArrayList;
import RoomBuilder.MapMaker;
import CharFactory.Character;

public class Game {
	
	Game gamePlay;
	GameState move;
	GameState menu;
	GameState encounter;
	GameState zombie;
	GameState overgame;
	protected ArrayList<Character> hero;
	protected MapMaker map;
	public ArrayList<Object> initReturn;
	
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
		initReturn = state.Initialize();
		
		map = (MapMaker) initReturn.get(0);
		hero = (ArrayList<Character>) initReturn.get(1);
		
		return hero;
	}//end Initialize
	public void Move(Character character)
	{
		state.Move(character);
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
