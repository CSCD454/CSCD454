package GroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import ItemFactory.Item;
import ItemFactory.ItemFactory;

public class EncounterState implements GameState {
	
	Game game;
	CharacterWeapons.IWeaponBehavior weapon = null;
	
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
		
		battleList = sortCharactersByInitiative(battleList);
		
		printMonsterAndHP(battleList);
				
		fight(battleList, 0);
	}
	
	private ArrayList<CharFactory.Character> sortCharactersByInitiative(ArrayList<CharFactory.Character> battleList)
	{
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
		return battleList;
	}
	
	private void printMonsterAndHP(ArrayList<CharFactory.Character> battleList)
	{
		if (battleList.get(0).isGood == true)
		{
			System.out.println("You have encountered a " + battleList.get(1).getCName() + " monster named " + battleList.get(1).getName() + "!");
			System.out.println("Your current HP is " + battleList.get(0).getHP());
			getWeaponToUse(battleList.get(0));
		} 
		else
		{
			System.out.println("You have encountered a " + battleList.get(0).getCName() + " monster named " + battleList.get(0).getName() + "!");
			System.out.println("Your current HP is " + battleList.get(1).getHP());
			getWeaponToUse(battleList.get(1));
		}
	}
	
	private void getWeaponToUse(CharFactory.Character character)
	{
		printWeapons(character);
		int weaponChoice = -1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("");
    	System.out.println("Which weapon would you like to use in the fight? ");
		weaponChoice = scanner.nextInt();
		scanner.nextLine();
		weapon = character.getWeapons().get(weaponChoice);
	}
	
	private void fight(ArrayList<CharFactory.Character> fightList, int turn) 
	{
		int moveChoice = 0; //1 for item use, 2 for attack	
		if (fightList.get(turn).isGood == false)
		{
			monsterAttack(fightList, turn);
		}
		else
		{
			characterAction(fightList, turn, moveChoice);
		}
		
	}//end fight
	
	private void characterAction(ArrayList<CharFactory.Character> fightList, int turn, int moveChoice)
	{
		moveChoice = getUserAction();
	    if (moveChoice == 1)
	    {
	    	if (fightList.get(turn).getInventory().size() == 0)
	    	{
	    		System.out.println("You have no items");
	    		determineWhoFightsNext(fightList, turn);
	    	}
	    	else
	    	{
	    		applyItemSelection(fightList, turn);
	    	}
	    }
	    else if (moveChoice == 2)
	    {
	    	System.out.println("");
	    	System.out.println("You are attacking the monster!");
	    	characterAttack(fightList, turn);
	    }
	    else
	    {
	    	System.out.println("Invalid Choice");
	    	fight(fightList, turn);
	    }
	}
	
	private void characterAttack(ArrayList<CharFactory.Character> fightList, int turn)
	{
		int x = fightList.get(turn).attack(weapon);
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
					determineWhoFightsNext(fightList, turn);
				}
			}
		}
	}
	
	private void applyItemSelection(ArrayList<CharFactory.Character> fightList, int turn)
	{
		int itemChoice = -1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("");
    	printInventory(fightList, turn);
		System.out.println("Which item would you like to use? ");
		itemChoice = scanner.nextInt();
		scanner.nextLine();
	    useItem(fightList, turn, itemChoice);
    	System.out.println("");
    	determineWhoFightsNext(fightList, turn);
    	//scanner.close();
	}
	
	private int getUserAction()
	{
		int moveChoice = 0;
		System.out.println("");
		System.out.println("Choose to use an item (1) or attack (2): ");
		Scanner scanner = new Scanner(System.in);
		moveChoice = scanner.nextInt();
		scanner.nextLine();
	    System.out.println("");
	    //scanner.close();
	    return moveChoice;
	}
	
	private void monsterAttack(ArrayList<CharFactory.Character> fightList, int turn)
	{
		System.out.println("The monster attacks.");
		CharacterWeapons.IWeaponBehavior w = fightList.get(turn).getWeapons().get(0);
		int x = fightList.get(turn).attack(w);
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
					determineWhoFightsNext(fightList, turn);
				}
			}
		}
	}
	
	public void determineWhoFightsNext(ArrayList<CharFactory.Character> fightList, int turn)
	{
		int t = turn+1;
		if (t == fightList.size())
			fight(fightList, 0);
		else
			fight(fightList, t);
	}
	
	private void useItem(ArrayList<CharFactory.Character> fightList, int turn, int itemChoice)
	{
		Item tempItem = fightList.get(turn).getInventory().get(itemChoice);
    	System.out.println("You chose " + tempItem.getItemName() + " with a healing amount of " + tempItem.getHealAmount());
    	System.out.println(tempItem.getDescription());
    	int max = fightList.get(turn).getHP();
    	int tempHP = fightList.get(turn).getHP();
    	int tempHeal = tempItem.getHealAmount();
    	if ((tempHP + tempHeal) > max)
    		fightList.get(turn).setHP(max);
    	else
    		fightList.get(turn).setHP(tempHP + tempHeal);
    	
    	fightList.get(turn).getInventory().remove(tempItem);
    	System.out.println("Your new HP is " + fightList.get(turn).getHP());
	}
	
	private void printInventory(ArrayList<CharFactory.Character> fightList, int turn)
	{
		System.out.println("These are the items you have - ");
		for (int i = 0; i < fightList.get(turn).getInventory().size(); i++)
		{
			System.out.println("(" + i + ") " + fightList.get(turn).getInventory().get(i).itemName);
		}
	}
	
	private void printWeapons(CharFactory.Character character)
	{
		System.out.println("These are the weapons you have - ");
		for (int i = 0; i < character.getWeapons().size(); i++)
		{
			System.out.print("(" + i + ") ");
			character.getWeapons().get(i).weaponName();
		}
	}
	
	public void GameOver()
	{ }
}

