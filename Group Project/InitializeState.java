package GroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InitializeState implements GameState {
	
	Game game;
	public ArrayList<Character> heroList = new ArrayList<Character>();
	
	public InitializeState(Game gamePlay)
	{
		this.game = gamePlay;
		System.out.println("Game menu");
	}
	
	public ArrayList<Character> Initialize()
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
		    AttackBehavior weapon = new AttackBat();
		    Character hero1 = new GoodCharacter(input);
		    hero1 = new Male(hero1);
		    hero1 = new Bartender(hero1, weapon);
		    
		    System.out.println(hero1.getClassName() + "      " + hero1.getName() + "      " + hero1.getHP() + "    " + hero1.getInit());
		    
		    heroList.add(hero1);
	    }
	    return heroList;
	}
	
	public void GameOver()
	{ }
}
