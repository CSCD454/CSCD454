package GroupProject;

import java.util.ArrayList;

import CharFactory.*;

public class BuildMonsterState implements GameState {
	
	Game game;
	public ArrayList<CharFactory.Character> fightList = new ArrayList<CharFactory.Character>();
	
	public BuildMonsterState(Game gamePlay)
	{
		this.game = gamePlay;
		System.out.println("Build Monster");
	}
	
	public ArrayList<CharFactory.Character> Initialize()
	{
		return null;
	}
	
	public void Move()
	{ }
	
	public ArrayList<CharFactory.Character> BuildMonster()
	{		
		System.out.println("************BUILD MONSTER********");
		fightList = makeMonster();
		System.out.println(fightList.get(0).getName());
		game.setState(game.getEncounterState());
		return fightList;
	}
	
	public void Encounter(ArrayList<CharFactory.Character> hero)
	{ }
	
	public ArrayList<CharFactory.Character> makeMonster() {		

		CharFactory.BadCharacterFactory monsterMaker = new CharFactory.BadCharacterFactory();
		fightList.add(monsterMaker.create());
		return fightList;
	}
	
	public void GameOver()
	{ }
}
