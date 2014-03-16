package GroupProject;

import java.util.ArrayList;
import CharFactory.Character;

public class BuildMonsterState implements GameState {
	
	Game game;
	public ArrayList<Character> fightList = new ArrayList<Character>();
	
	public BuildMonsterState(Game gamePlay)
	{
		this.game = gamePlay;
	}
	
	public ArrayList<Object> Initialize()
	{
		return null;
	}
	
	public void Move(Character character)
	{ }
	
	public ArrayList<Character> BuildMonster()
	{		
		fightList = makeMonster();
		game.setState(game.getEncounterState());
		return fightList;
	}
	
	public void Encounter(ArrayList<Character> hero)
	{ }
	
	public ArrayList<Character> makeMonster() {		

		CharFactory.BadCharacterFactory monsterMaker = new CharFactory.BadCharacterFactory();
		Character m = monsterMaker.create();
		fightList.add(m);
		return fightList;
	}
	
	public void GameOver()
	{ }
}
