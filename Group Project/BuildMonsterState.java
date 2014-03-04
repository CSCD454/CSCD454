package GroupProject;

import java.util.ArrayList;

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
		int random = (int )(Math.random() * 4 + 1);
		fightList = makeMonster(random);
		System.out.println(fightList.get(0).getName());
		game.setState(game.getEncounterState());
		return fightList;
	}
	
	public void Encounter(ArrayList<CharFactory.Character> hero)
	{ }
	
	public ArrayList<CharFactory.Character> makeMonster(int numOfMonsters) {
		int x = numOfMonsters;
		
		while(x > 0) {
			CharFactory.BadCharacterFactory monsterMaker = new CharFactory.BadCharacterFactory();
			fightList.add(monsterMaker.create());
			
			x--;
		}//end while
		return fightList;
	}

	public void GameOver()
	{ }
}
