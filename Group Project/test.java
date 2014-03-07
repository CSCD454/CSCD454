package GroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class test {

	public static void main(String[] args) {

	    ArrayList<CharFactory.Character> battleList, heroList;
	
		Game walkingDead = new Game();
		
		heroList = walkingDead.Initialize();
		//will need to change once we add in more characters
		CharFactory.Character character = heroList.get(0);
		walkingDead.Move(character);
	    battleList = walkingDead.BuildMonster();
	    if (battleList == null)
	    {
	    	walkingDead.GameOver();
	    }
	    else
	    {
	    	for(int i = 0; i < heroList.size(); i++) {
				battleList.add(heroList.get(i));
			}
			walkingDead.Encounter(battleList);
	    }
		
	}

}
