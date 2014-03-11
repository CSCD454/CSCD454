package GroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import CharFactory.*;

import ItemFactory.Item;
import ItemFactory.ItemFactory;

public class InitializeState implements GameState {
	
	Game game;
	public ArrayList<CharFactory.Character> heroList = new ArrayList<CharFactory.Character>();
	
	public InitializeState(Game gamePlay)
	{
		this.game = gamePlay;
	}

	public ArrayList<CharFactory.Character> Initialize()
	{
		System.out.println("*** Welcome to The Walking Dead ***");
		System.out.println(" ");
		heroList = printGameMenu();
		game.setState(game.getMoveState());
		return heroList;
	}
	
	public void Move(CharFactory.Character character)
	{
		System.out.println("Please choose your character. GameMenu Move");
	}
	
	public ArrayList<CharFactory.Character> BuildMonster()
	{
		System.out.println("Please choose your character. GameMenu BuildMonster");
		return null;
	}
	
	public void Encounter(ArrayList<CharFactory.Character> hero)
	{
		System.out.println("Please choose your character. GameMenu Encounter");
	}
	
	public ArrayList<CharFactory.Character> printGameMenu()
	{
		String input = "";
		int numChar = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many characters would you like?");
		numChar = scanner.nextInt();
		ItemFactory factory = new ItemFactory();
		Item water = factory.createItem("water");
	    for (int x = 1; x <= numChar; x++)
	    {
	    	System.out.println("Enter a name for character " + x + ": ");

	    	input = scanner.next();
		    CharFactory.GoodCharacterFactory heroFactory = new CharFactory.GoodCharacterFactory(input);
		    
		    CharFactory.Character hero = heroFactory.create();
			hero.setInventory(water);
			hero.setInventory(water);
		    heroList.add(hero);
	    }
	    
	    if (heroList.size() == 1)
	    	printInitialGameSetupOne();
	    else
	    	printInitialGameSetupMultiple();
	    
		System.out.println("You are in the woods needing to make it to the abandoned jail for safety with other survivors. ");
		System.out.println("There are buildings around with stray food from before the apocolypse.\nZombies are closing in due to a gun shot that just went off.");
		
	    return heroList; 
	}
	
	void printInitialGameSetupOne()
	{
		System.out.println("Hello " + heroList.get(0).getName() + ". You are a " + heroList.get(0).getCName() + 
				" with a health of " + heroList.get(0).getHP() + " and an initiative value of " + heroList.get(0).getInit() + ".");
		System.out.println("Your initial inventory is:");
		for (int i = 0; i < heroList.get(0).getInventory().size(); i++)
		{
			System.out.println(" - " + heroList.get(0).getInventory().get(i).itemName);
		}
	}
	
	void printInitialGameSetupMultiple()
	{
		System.out.println("Hello. Here is the list of characters in your party, their initiative values and their hitpoints.");
		for(int x = 0; x < heroList.size(); x++)
		{
			System.out.println(heroList.get(x).getName() + "     " + heroList.get(x).getCName() + 
					"     " + heroList.get(x).getHP() + "     " + heroList.get(x).getInit());
			System.out.println("Your initial inventory is:");
			for (int i = 0; i < heroList.get(0).getInventory().size(); i++)
			{
				System.out.println(" - " + heroList.get(x).getInventory().get(i).itemName);
			}
			System.out.println("");
		}
	}
	
	public void GameOver()
	{ }

}
