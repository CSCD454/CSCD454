package GroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import ItemFactory.Item;
import ItemFactory.ItemFactory;

public class MoveState implements GameState 
{
	Game game;
	
	public MoveState(Game gamePlay)
	{
		this.game = gamePlay;
	}
	
	public ArrayList<CharFactory.Character> Initialize()
	{
		return null;
	}
	
	public void Move(CharFactory.Character character)
	{
		printMoveOptions(character);
	}
	
	void printMoveOptions(CharFactory.Character character)
	{
		int winLocation = (int )(Math.random() * 7 + 1);
		int monsterLocation, random;
		String direction = "";
		System.out.print("Which direction would you like to move? (N S E W) : ");
		Scanner scanner = new Scanner(System.in);
		direction = scanner.next();
		
		random = (int )(Math.random() * 6 + 1);
		monsterLocation = (int )(Math.random() * 5 + 1);
		if (monsterLocation == random)
		{
			game.setState(game.getBuildMonsterState());
			//moving = false;
		} 
		else if (random == winLocation)
		{
			System.out.println("You have reached the jail.");
			//moving = false;
			game.setState(game.getGameOverState());
		}
		else
		{
			ItemFactory factory = new ItemFactory();
			if (random == 1)
			{
				System.out.println("You moved through the woods and still cannot locate the jail.");
			} 
			else if (random == 2)
			{
				System.out.println("You're moving through the woods and hear sounds in the distance...");
			}
			else if (random == 3)
			{
				System.out.println("You are running now and fell into a stream, losing 3 hitpoints.");				
			}
			else if (random == 4)
			{
				System.out.println("You found a first aid kit!.");
				Item firstAid = factory.createItem("firstaidkit");
				character.setInventory(firstAid);
			}
			else if (random == 5)
			{
				System.out.println("You just tripped over a fallen tree and lost 5 hitpoints.");
			}
			else
			{
				System.out.println("You stumbled upon some food and added it to your inventory");
				Item food = factory.createItem("food");
				character.setInventory(food);
			}
			game.Move(character);
		}
	}
	
	public ArrayList<CharFactory.Character> BuildMonster()
	{
		return null;
	}
	
	public void Encounter(ArrayList<CharFactory.Character> hero)
	{ }
	
	public void GameOver()
	{ }
}
