package GroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InitializeState implements GameState {
	
	Game game;
	public ArrayList<CharFactory.Character> heroList = new ArrayList<CharFactory.Character>();
	
	public InitializeState(Game gamePlay)
	{
		this.game = gamePlay;
		System.out.println("Game menu");
	}
	
	public ArrayList<CharFactory.Character> Initialize()
	{
		System.out.println("*** Welcome to The Walking Dead ***");	
		heroList = printGameMenu();
		System.out.println("***********************************");
		game.setState(game.getMoveState());
		return heroList;
	}
	
	public void Move()
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
		    CharFactory.GoodCharacterFactory heroFactory = new CharFactory.GoodCharacterFactory();
		    
		    heroList.add(heroFactory.create());
	    }
	    return heroList;
	}
	
	public void GameOver()
	{ }
}
