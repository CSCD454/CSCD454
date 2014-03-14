package GroupProject;

import java.util.ArrayList;

import CharFactory.*;
import CharFactory.Character;

public class BuildMonsterState implements GameState {
	
	Game game;
	public ArrayList<CharFactory.Character> fightList = new ArrayList<CharFactory.Character>();
	
	public BuildMonsterState(Game gamePlay)
	{
		this.game = gamePlay;
	}
	
	public ArrayList<CharFactory.Character> Initialize()
	{
		return null;
	}
	
	public void Move(CharFactory.Character character)
	{ }
	
	public ArrayList<CharFactory.Character> BuildMonster()
	{		
		System.out.println("************BUILD MONSTER********");
		fightList = makeMonster();
		game.setState(game.getEncounterState());
		return fightList;
	}
	
	public void Encounter(ArrayList<CharFactory.Character> hero)
	{ }
	
	public ArrayList<CharFactory.Character> makeMonster() {		

		CharFactory.BadCharacterFactory monsterMaker = new CharFactory.BadCharacterFactory();
		Character m = monsterMaker.create();
		fightList.add(m);
		return fightList;
	}
	
	public void GameOver()
	{ }
}
