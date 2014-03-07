package GroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ItemFactory.Item;

public class EncounterState implements GameState {
	
	Game game;
	
	public EncounterState(Game gamePlay)
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
		return null;
	}
	
	public void Encounter(ArrayList<CharFactory.Character> battleList)
	{	
		System.out.println("");
		System.out.println("************FIGHT***********");
		System.out.println("");
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
		if (battleList.get(0).isGood == true)
		{
			System.out.println("You have encountered a " + battleList.get(1).getCName() + " monster named " + battleList.get(1).getName() + "!");
			System.out.println("Your current HP is " + battleList.get(0).getHP());
		} 
		else
		{
			System.out.println("You have encountered a " + battleList.get(0).getCName() + " monster named " + battleList.get(0).getName() + "!");
			System.out.println("Your current HP is " + battleList.get(1).getHP());
		}
		
		
		fight(battleList, 0);
	}
	
	private void fight(ArrayList<CharFactory.Character> fightList, int turn) 
	{
		int moveChoice = 0; //1 for item use, 2 for attack	
		if (fightList.get(turn).isGood == false)
		{
			System.out.println("The monster attacks.");
			int x = fightList.get(turn).attack();
			for (int y = 0; y < fightList.size(); y++)
			{
				if (fightList.get(y).isGood == true)
				{
					int temp = fightList.get(y).getHP();
					fightList.get(y).setHP(temp - x);
					System.out.println("Your new HP is " + fightList.get(y).getHP());
					if (fightList.get(y).getHP() <= 0)
					{
						game.setState(game.getGameOverState());
						game.GameOver();
					}
					else
					{
						int t = turn+1;
						if (t == fightList.size())
							fight(fightList, 0);
						else
							fight(fightList, t);
					}
				}
			}
		}
		else
		{
			String input = "";
			int itemChoice = -1;
			System.out.println("");
			System.out.println("Choose to use an item (1) or attack (2): ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    try {
		         input = br.readLine();
		         moveChoice = Integer.parseInt(input);
		    } catch (IOException ioe) {
		         System.out.println("IO error trying to read your name!");
		         System.exit(1);
		    }
		    System.out.println("");
		    if (moveChoice == 1)
		    {
		    	if (fightList.get(turn).getInventory().size() == 0)
		    	{
		    		System.out.println("You have no items");
		    	}
		    	else
		    	{
		    		System.out.println("");
			    	System.out.println("These are the items you have - ");
					for (int i = 0; i < fightList.get(turn).getInventory().size(); i++)
					{
						System.out.println("(" + i + ") " + fightList.get(turn).getInventory().get(i).itemName);
					}
					System.out.println("Which item would you like to use? ");
					br = new BufferedReader(new InputStreamReader(System.in));
				    try {
				         input = br.readLine();
				         itemChoice = Integer.parseInt(input);
				    } catch (IOException ioe) {
				         System.out.println("IO error trying to read your name!");
				         System.exit(1);
				    }
				    Item tempItem = fightList.get(turn).getInventory().get(itemChoice);
			    	System.out.println("You chose " + tempItem.getItemName() + " with a healing amount of " + tempItem.getHealAmount());
			    	System.out.println(tempItem.getDescription());
			    	int max = fightList.get(0).getHP();
			    	int tempHP = fightList.get(0).getHP();
			    	int tempHeal = tempItem.getHealAmount();
			    	if ((tempHP + tempHeal) > max)
			    		fightList.get(turn).setHP(max);
			    	else
			    		fightList.get(turn).setHP(tempHP + tempHeal);
			    	
			    	fightList.get(turn).getInventory().remove(tempItem);
			    	System.out.println("Your new HP is " + fightList.get(turn).getHP());
			    	System.out.println("");
			    	int t = turn+1;
					if (t == fightList.size())
						fight(fightList, 0);
					else
						fight(fightList, t);
		    	}
		    	
		    }
		    else if (moveChoice == 2)
		    {
		    	System.out.println("");
		    	System.out.println("You are attacking the monster!");
		    	int x = fightList.get(turn).attack();
		    	for (int y = 0; y < fightList.size(); y++)
				{
					if (fightList.get(y).isGood == false)
					{
						int temp = fightList.get(y).getHP();
						fightList.get(y).setHP(temp - x);
						if (fightList.get(y).getHP() <= 0)
						{
							System.out.println("You killed the monster!");
							game.setState(game.getMoveState());
							game.Move(fightList.get(turn));
						}
						else
						{
							System.out.println("The monster now has an HP of " + fightList.get(y).getHP());
							int t = turn+1;
							if (t == fightList.size())
								fight(fightList, 0);
							else
								fight(fightList, t);
						}
					}
				}
		    }
		    else
		    {
		    	System.out.println("Invalid Choice");
		    	fight(fightList, turn);
		    }
		}
		
	}//end fight
	
	public void GameOver()
	{ }
}

