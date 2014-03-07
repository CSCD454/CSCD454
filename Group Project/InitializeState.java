package GroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		
		System.out.println("How many characters would you like?");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    try {
	         input = br.readLine();
	         numChar = Integer.parseInt(input);
	    } catch (IOException ioe) {
	         System.out.println("IO error trying to read your name!");
	         System.exit(1);
	    }
	    for (int x = 0; x < numChar; x++)
	    {
	    	System.out.println("Enter a name for first character: ");
			br = new BufferedReader(new InputStreamReader(System.in));
		    try {
		         input = br.readLine();
		    } catch (IOException ioe) {
		         System.out.println("IO error trying to read your name!");
		         System.exit(1);
		    }
		    CharFactory.GoodCharacterFactory heroFactory = new CharFactory.GoodCharacterFactory(input);
		    
		    CharFactory.Character hero1 = heroFactory.create();
		    ItemFactory factory = new ItemFactory();
			Item water = factory.createItem("water");
			hero1.setInventory(water);
			hero1.setInventory(water);
		    heroList.add(hero1);
	    }
	    printInitialGameSetup();
	    return heroList; 
	}
	
	void printInitialGameSetup()
	{
		System.out.println("Hello " + heroList.get(0).getName() + ". You are a " + heroList.get(0).getCName() + 
				" with a health of " + heroList.get(0).getHP() + " and an initiative value of " + heroList.get(0).getInit() + ".");
		System.out.println("Your initial inventory is:");
		for (int i = 0; i < heroList.get(0).getInventory().size(); i++)
		{
			System.out.println(" - " + heroList.get(0).getInventory().get(i).itemName);
		}
		System.out.println("You are in the woods needing to make it to the abandoned jail for safety with other survivors. ");
		System.out.println("There are buildings around with stray food from before the apocolypse.\nZombies are closing in due to a gun shot that just went off.");
	}
	
	public void GameOver()
	{ }

}
