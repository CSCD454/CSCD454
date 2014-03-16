package GroupProject;

import java.util.ArrayList;
import CharFactory.Character;

public class GameOverState implements GameState {
	
	Game game;
	public ArrayList<Character> heroList = new ArrayList<CharFactory.Character>();
	
	public GameOverState(Game gamePlay)
	{
		this.game = gamePlay;
	}
	
	public ArrayList<Object> Initialize()
	{ 
		return null;
	}
	
	public void Move(Character character)
	{
		System.out.println("GAME OVER MOVE");
	}
	
	public ArrayList<Character> BuildMonster()
	{
		System.out.println("GAME OVER");
		return null;
	}
	
	public void Encounter(ArrayList<Character> hero)
	{
		System.out.println("GAME OVER Encounter");
	}
	
	public void GameOver()
	{ 
		if((game.hero.get(0).getInfection() > 0 && game.map.checkWin(game.map.findLocation())))
		{
			System.out.println("After a long journey you finally reach your destination, the Stu Steiner Correctional Facility.");
			System.out.println("However after stepping inside your sickness worsens causing. you to pass out. After a few minutes you rise as a zomibe to stalk any other surviors who had a similar plan to your own");
			System.out.println("");	
			System.out.println("");
			System.out.println("YOU LOSE!");
		}
		
		else if(game.hero.get(0).getInfection() > 0)
		{
			System.out.println("You passout from your sickness. A few minutes later you rise again as a fresh zombie.");
			System.out.println("");	
			System.out.println("");
			System.out.println("YOU LOSE!");
		}
		
		else if(game.map.checkWin(game.map.findLocation()))
		{
			System.out.println("After a long journey you finally reach your destination, the Stu Steiner Correctional Facility.  Here you can hold out untill a cure if found......Hopefully");
			System.out.println("");	
			System.out.println("");
			System.out.println("YOU WIN!");
		}
		
		
		else{
			System.out.println("You collapse one the ground in a pool of your own blood as you feel the last bit of life leave your body.");	
			System.out.println("");	
			System.out.println("");
			System.out.println("YOU LOSE!");
		}
		System.exit(0);
	}
}
