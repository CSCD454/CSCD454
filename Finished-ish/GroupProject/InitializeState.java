package GroupProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import CharFactory.Character;
import ItemFactory.Item;
import ItemFactory.ItemFactory;

public class InitializeState implements GameState {
	
	Game game;
	public ArrayList<Character> heroList = new ArrayList<Character>();
	private ArrayList<Object> temp = new ArrayList<Object>();
	private int size = 5;
	
	public InitializeState(Game gamePlay)
	{
		this.game = gamePlay;
	}

	public ArrayList<Object> Initialize()
	{	
		RoomBuilder.MapMaker map = new RoomBuilder.MapMaker();
		
		System.out.println("*** Welcome to The Walking Dead ***");
		System.out.println(" ");
		
		map.makeMap(size);	//Should we make an easy, medium, hard or just set size?
		
		temp.add(map);
		
		heroList = printGameMenu();
		
		temp.add(heroList);
		
		game.setState(game.getMoveState());
		return temp;
	}//end Initialize
	
	public void Move(Character character)
	{
		System.out.println("Please choose your character. GameMenu Move");
	}
	
	public ArrayList<Character> BuildMonster()
	{
		System.out.println("Please choose your character. GameMenu BuildMonster");
		return null;
	}
	
	public void Encounter(ArrayList<Character> hero)
	{
		System.out.println("Please choose your character. GameMenu Encounter");
	}
	
	public ArrayList<Character> printGameMenu()
	{
		Scanner scanner = new Scanner(System.in);
		String input = "";
		
		ItemFactory factory = new ItemFactory();
		Item water = factory.createItem("water");
	    	System.out.println("Enter a name for your character: ");
	    	input = scanner.next();
	    	
		    CharFactory.GoodCharacterFactory heroFactory = new CharFactory.GoodCharacterFactory(input);
		    
		    Character hero = heroFactory.create();
			hero.setInventory(water);
			hero.setInventory(water);
		    heroList.add(hero);
		    
	    	printInitialGameSetupOne();
	    
		System.out.println("You are in the woods needing to make it to the abandoned jail for safety with other survivors. ");
		System.out.println("There are buildings around with stray food from before the apocolypse.\nZombies are closing in due to a gun shot that just went off.");
		
	    return heroList; 
	}//end printGameMenu
	
	private void printInitialGameSetupOne()
	{
		System.out.println("Hello " + heroList.get(0).getName() + ". You are a " + heroList.get(0).getRaceName() + " " + 
				heroList.get(0).getCName() + " with a health of " + heroList.get(0).getHP() + " and an initiative value of " 
				+ heroList.get(0).getInit() + ".");
		System.out.println("Your initial inventory is:");
		for (int i = 0; i < heroList.get(0).getInventory().size(); i++)
		{
			System.out.println(" - " + heroList.get(0).getInventory().get(i).getItemName());
		}
	}//end printInitialGameSetupOne
	
	public void GameOver()
	{ }
	
}
