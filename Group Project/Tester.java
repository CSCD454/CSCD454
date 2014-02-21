package GroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tester {

	public static void main(String[] args) {
		
		int random, winLocation;
		winLocation = (int )(Math.random() * 10 + 1);
		System.out.println("WIN LOCATION = " + winLocation);
		
		Character hero1 = new GoodCharacter("Buffy");
		Character hero2 = new GoodCharacter("jill");
		Character hero3 = new GoodCharacter("Henery");
		
		Character monster1 = new BadCharacter("blah");
		
		//the name is getting set back to nameless when the race is added
		hero1 = new Male(hero1);
		hero2 = new Female(hero2);
		hero3 = new Child(hero3);
		
		monster1 = new Bear(monster1);
		
		
		System.out.println(monster1.getName() + ": " + monster1.getHP() + ", " + hero2.getName() + ": " 
				+ hero2.getHP() + ", " + hero3.getName() + ": " + hero3.getHP());
		
		hero1 = new Bartender(hero1);
		monster1 = new Animal(monster1);
		
		System.out.println(hero1.getHP() + " hp, " + hero1.getInit() + " init, " + hero1.getName() + " " + hero1.getClassName());
		System.out.println(monster1.getHP() + " hp, " + monster1.getInit() + " init, " + monster1.getName() + " " + monster1.getClassName());
	    String direction = "";
		for (int i = 0; i < 5; i++)
		{
			System.out.print("Which direction would you like to move? (N S E W) : ");
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    try {
		         direction = br.readLine();
		    } catch (IOException ioe) {
		         System.out.println("IO error trying to read your name!");
		         System.exit(1);
		    }
		    random = (int )(Math.random() * 10 + 1);
		    System.out.println("You will move " + random + " rooms " + direction);
			
			if(random == winLocation)
			{
				System.out.println("You won the game!");
				return;
			}
		}
	}

}
