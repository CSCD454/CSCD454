package GroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
			battleList.get(i).setRealHP(battleList.get(i).getHP());	
			//setting the realHp to the modified hp value so we can work with it
			
			System.out.println(battleList.get(i).getName() + " class is a " + battleList.get(i).getClassName() + 
					" initiative is " + battleList.get(i).getInit() + " " + " and HP are " + battleList.get(i).getRealHP()
					+ " and race is " + battleList.get(i).getRaceName());
			
			
		}//end for loop
		
		fight(battleList);
	}
	
	private void fight(ArrayList<CharFactory.Character> fightList) 
	{
		System.out.println("This is where they fight.");
		int moveChoice = 0; //1 for item use, 2 for attack
		ItemFactory factory = new ItemFactory();
		
		Item firstAid = factory.createItem("firstaidkit");
		if (fightList.get(0).getClassName() == "monster")
		{
			System.out.println("This is where the monster attacks");
			//update monster and character hp
			//character - monster weapon 
		}
		else
		{
			String input = "";
			System.out.println("This is where the character makes its move");
			System.out.println("This is the list of items and weapons you currently have.");
			//System.out.println("(1) Items -      (2) Weapons - " + fightList.get(0).weapon);
			System.out.println("Choose to use an item (1) or attack (2): ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    try {
		         input = br.readLine();
		         moveChoice = Integer.parseInt(input);
		    } catch (IOException ioe) {
		         System.out.println("IO error trying to read your name!");
		         System.exit(1);
		    }
		    if (moveChoice == 1)
		    {
		    	System.out.println("The character will use an item");
		    	System.out.println("The item is " + firstAid.getItemName() + " with a healing amount of " + firstAid.getHealAmount());
		    	System.out.println(firstAid.getDescription());
		    	//update the characters hp
		    	int temp = fightList.get(0).getHP();
		    	//need to update the characters hp
		    	//hp + first aid heal amount
		    }
		    else if (moveChoice == 2)
		    {
		    	System.out.println("The character will attack");
		    	fightList.get(0).attack();
		    	//update character and monster hp
		    	//monster hp - weapon
		    }
		    else
		    {
		    	System.out.println("Invalid Choice");
		    }
		}
		
		for(int i = 0; i < fightList.size(); i++) {
			int x = fightList.get(i).attack();
			System.out.println(x);
		}
		
		/*
		 if the monster is dead, set game state to move
		 if the character is dead, set game state to game over
		 else call encounter on the fight list again
		 */
		
	}//end fight
	
	public void GameOver()
	{ }
}

