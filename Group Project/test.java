package GroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class test {

public static void main(String[] args) {
	
		/*
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Game");
                MapStart map = new MapStart();
                frame.add(map);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    	*/
	    ArrayList<Character> battleList, heroList;
	
		Game walkingDead = new Game();
		
		heroList = walkingDead.Initialize();
		walkingDead.Move();
		battleList = walkingDead.BuildMonster();
		for(int i = 0; i < heroList.size(); i++) {
			battleList.add(heroList.get(i));
		}
		for(int i = 0; i < battleList.size(); i ++) {
			System.out.println(battleList.get(i).getClassName() + " " + battleList.get(i).getInit() + " " + battleList.get(i).getName());
		}
		walkingDead.Encounter(battleList);
		
		int random, winLocation;
		winLocation = (int )(Math.random() * 10 + 1);
		//System.out.println("WIN LOCATION = " + winLocation);
		
		Character hero1 = new GoodCharacter("Buffy");
		Character hero2 = new GoodCharacter("jill");
		Character hero3 = new GoodCharacter("Henery");
		
		Character monster1 = new BadCharacter("blah");
		
		//the name is getting set back to nameless when the race is added
		hero1 = new Male(hero1);
		hero2 = new Female(hero2);
		hero3 = new Child(hero3);
		
		//System.out.println(hero1.getHP() + "    " + hero1.getInit());
		
		//AttackBehavior weapon = new AttackBat();
		
		//hero1 = new Bartender(hero1, weapon);
		
		//System.out.println(hero1.getHP() + "    " + hero1.getInit());
		
		//ArrayList<Character> heroList = new ArrayList<Character>();
		
		//System.out.println(hero1.getHP() + " hp, " + hero1.getInit() + " init, " + hero1.getName() + " " + hero1.getClassName());
		//System.out.println(monster1.getHP() + " hp, " + monster1.getInit() + " init, " + monster1.getName() + " " + monster1.getClassName());
		
		//heroList.add(hero1);
		
		//Encounter encounter = new Encounter(heroList);
		
		//create random number of monsters
	    random = (int )(Math.random() * 3 + 1);
		//encounter.makeMonster(random);
		/*
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
		}*/
	}

}
