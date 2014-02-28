package GroupProject;

import java.util.ArrayList;

public class BuildMonsterState implements GameState {
	
	Game game;
	public ArrayList<Character> fightList = new ArrayList<Character>();
	
	public BuildMonsterState(Game gamePlay)
	{
		this.game = gamePlay;
		System.out.println("Build Monster");
	}
	
	public ArrayList<Character> Initialize()
	{
		return null;
	}
	
	public void Move()
	{ }
	
	public ArrayList<Character> BuildMonster()
	{		
		System.out.println("************BUILD MONSTER********");
		int random = (int )(Math.random() * 4 + 1);
		fightList = makeMonster(random);
		System.out.println(fightList.get(0).getName());
		game.setState(game.getEncounterState());
		return fightList;
	}
	
	public void Encounter(ArrayList<Character> hero)
	{ }
	
	public ArrayList<Character> makeMonster(int numOfMonsters) {
		int x = numOfMonsters;
		
		while(x > 0) {
			Character temp = new BadCharacter("monster" + x);
			temp = randRace(temp);
			temp = randClass(temp);
			System.out.println(temp.getName() + " " + temp.getHP() + " " + temp.getClassName() + " " + temp.getInit());
			fightList.add(temp);
			
			x--;
		}//end while
		return fightList;
	}
	
	private Character randRace(Character character) {
		if(character == null) {
			throw new NullPointerException();
		}
		Character temp = null;
		
		int randNum = (int) (Math.random() * 3 + 1);
		
		if(randNum == 1) {
			temp = new Male(character);
		}
		else if(randNum == 2) {
			temp = new Female(character);
		}
		else {
			temp = new Child(character);
		}
		
		return temp;
	}//end randRace
	
	private Character randClass(Character character) {
		if(character == null) {
			throw new NullPointerException();
		}
		
		Character temp = null;
		int randNum = (int) (Math.random() * 5 + 1);
		
		if(randNum == 1) {
			temp = new Bartender(character, null);	//Null is where the weapon should go.
		}
		else if(randNum == 2) {
			temp = new CouchPotatoe(character);
		}
		else if(randNum == 3) {
			temp = new LawEnforcement(character);
		}
		else if(randNum == 4) {
			temp = new Redneck(character);
		}
		else {
			temp = new Student(character);
		}
		
		return temp;
	}//end randClass

	public void GameOver()
	{ }
}
