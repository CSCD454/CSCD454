package GroupProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import ItemFactory.Item;
import CharFactory.Character;

public class EncounterState implements GameState {
	
	Game game;
	CharacterWeapons.IWeaponBehavior weapon = null;
	
	public EncounterState(Game gamePlay)
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
		return null;
	}
	
	public void Encounter(ArrayList<Character> battleList)
	{	
		battleList = sortCharactersByInitiative(battleList);
		
		printMonsterAndHP(battleList);
				
		fight(battleList, 0);
	}
	
	private ArrayList<Character> sortCharactersByInitiative(ArrayList<Character> battleList)
	{
		Collections.sort(battleList, new Comparator<CharFactory.Character>() {
			@Override
			public int compare(Character character1, Character character2) {
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
	}//end sortCharactersByInitiative
	
	private void printMonsterAndHP(ArrayList<Character> battleList)
	{
		if (battleList.get(0).isGood == true)
		{
			System.out.print(" " + battleList.get(1).getName() + " the " + battleList.get(1).getCName() + " attacks!\n");
			System.out.println("Your current HP is " + battleList.get(0).getHP());
			getWeaponToUse(battleList.get(0));
		} 
		else
		{
			System.out.println(battleList.get(0).getCName() + " monster named " + battleList.get(0).getName() + "!");
			System.out.println("Your current HP is " + battleList.get(1).getHP());
			getWeaponToUse(battleList.get(1));
		}
	}//end printMonsterAndHP
	
	private void getWeaponToUse(Character character)
	{
		printWeapons(character);
		int weaponChoice = -1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("");
    	System.out.println("Which weapon would you like to use in the fight? ");
    	
    	//Need to validate this number, but how many weapons can we have
    	
		weaponChoice = scanner.nextInt();
		scanner.nextLine();
		weapon = character.getWeapons().get(weaponChoice);
	}// end getWeaponToUse
	
	private void fight(ArrayList<Character> fightList, int turn) 
	{
		if (fightList.get(turn).isGood == false)
		{
			monsterAttack(fightList, turn);
		}
		else
		{
			characterAction(fightList, turn);
		}
		
	}//end fight
	
	private void characterAction(ArrayList<Character> fightList, int turn)
	{
		int moveChoice = getUserAction();
		
		if(fightList.get(turn).getInfection() > 0)
		{
			System.out.println("You have a high fever.");	
			fightList.get(turn).setHP(fightList.get(turn).getHP() - fightList.get(turn).getInfection());
		}

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
	    	System.out.println("You are attacking!");
	    	characterAttack(fightList, turn);
	    }
	    else
	    {
	    	System.out.println("Invalid Choice");
	    	fight(fightList, turn);
	    }
	}//end characterAction
	
	private void characterAttack(ArrayList<Character> fightList, int turn)
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
					fightList.remove(y);
					game.setState(game.getMoveState());
					//System.out.println("turn " + turn + " fightList - " + fightList.get(turn));
					game.Move(fightList.get(0));
				}
				else
				{
					System.out.println("The monster now has an HP of " + fightList.get(y).getHP());
					determineWhoFightsNext(fightList, turn);
				}
			}
		}
	}// end characterAttack
	
	private void applyItemSelection(ArrayList<Character> fightList, int turn)
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
	}//end applyItemSelection
	
	private int getUserAction()
	{
		Scanner scanner = new Scanner(System.in);
		int moveChoice = 0;		
		System.out.println("");
		System.out.println("Choose to use an item (1) or attack (2): ");
		moveChoice = scanner.nextInt();
		scanner.nextLine();
		System.out.println("");
	    return moveChoice;
	}//end getUserAction
	
	private void monsterAttack(ArrayList<Character> fightList, int turn)
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
				
				if(fightList.get(turn).isZombie && x >=7)
				{
					fightList.get(y).setInfection(fightList.get(y).getInfection() + x);
				}

				
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
	}//end monsterAttack
	
	public void determineWhoFightsNext(ArrayList<Character> fightList, int turn)
	{
		int t = turn+1;
		if (t == fightList.size())
			fight(fightList, 0);
		else
			fight(fightList, t);
	}//end determineWhoFightsNext
	
	private void useItem(ArrayList<Character> fightList, int turn, int itemChoice)
	{
		Item tempItem = fightList.get(turn).getInventory().get(itemChoice);
    	System.out.println("You chose " + tempItem.getItemName() + " with a healing amount of " + tempItem.getHealAmount());
    	System.out.println(tempItem.getDescription());
    	int curHP = fightList.get(turn).getHP();
    	int tempHeal = tempItem.getHealAmount();

    	if(tempHeal + fightList.get(turn).getHP() > fightList.get(turn).getMaxHp()) {
    		fightList.get(turn).setHP(fightList.get(turn).getMaxHp());
    	}
    	else {
    		fightList.get(turn).setHP(curHP + tempHeal);
    	}
    	
    	fightList.get(turn).getInventory().remove(tempItem);
    	System.out.println("Your new HP is " + fightList.get(turn).getHP());
	}// end useItem
	
	private void printInventory(ArrayList<Character> fightList, int turn)
	{
		System.out.println("These are the items you have - ");
		for (int i = 0; i < fightList.get(turn).getInventory().size(); i++)
		{
			System.out.println("(" + i + ") " + fightList.get(turn).getInventory().get(i).getItemName());
		}
	}//end printInventory
	
	private void printWeapons(Character character)
	{
		System.out.println("These are the weapons you have - ");
		for (int i = 0; i < character.getWeapons().size(); i++)
		{
			System.out.print("(" + i + ") ");
			character.getWeapons().get(i).weaponName();
		}
	}//end printWeapons
	
	public void GameOver()
	{ }
}

