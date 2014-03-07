package GroupProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EncounterState implements GameState {
	
	Game game;
	
	public EncounterState(Game gamePlay)
	{
		this.game = gamePlay;
		System.out.println("Encounter State");
	}
	
	public ArrayList<CharFactory.Character> Initialize()
	{
		return null;
	}
	
	public void Move()
	{ }
	
	public ArrayList<CharFactory.Character> BuildMonster()
	{ 
		return null;
	}
	
	public void Encounter(ArrayList<CharFactory.Character> battleList)
	{	
		System.out.println("************FIGHT********");
		
		Collections.sort(battleList, new Comparator<CharFactory.Character>() {
			@Override
			public int compare(CharFactory.Character character1, CharFactory.Character character2) {
				if(character1.getInit() > character2.getInit()) {
					return -1;
				}
				else if(character1.getInit() == character2.getInit()) {
					return 0;
				}
				else {
					return 1;
				}
			}
		});//end collections sort
		
		for(int i = 0; i < battleList.size(); i ++) {
			
			System.out.println(battleList.get(i).getName() + " class is a " + battleList.get(i).getClassName() + 
					" initiative is " + battleList.get(i).getInit() + " " + " and HP are " + battleList.get(i).getHP()
					+ " and race is " + battleList.get(i).getRaceName());
			
			
		}//end for loop
		
		fight(battleList);
		
		//if character is still alive state
			game.setState(game.getMoveState());
		//else character state is dead, game over
	}
	
	private void fight(ArrayList<CharFactory.Character> fightList) {
		boolean alive = true;
		
		while(alive) {
			for(int i = 0; i < fightList.size(); i++) {
				int x = fightList.get(i).attack();
				System.out.println(x);
			}
			System.out.println("This is where they fight.");
			alive = false;
		}
	}//end fight
	
	public void GameOver()
	{ }
}

