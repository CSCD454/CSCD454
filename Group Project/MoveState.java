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
		//int winLocation = (int )(Math.random() * 10 + 1);
		int winLocation = 0;
		int monsterLocation, random;
		String direction = "";
		System.out.println("");
		System.out.print("Which direction would you like to move? (N S E W) : ");
		Scanner scanner = new Scanner(System.in);
		direction = scanner.next();
		
		random = (int )(Math.random() * 8 + 1);
		//random = random + 3;
		monsterLocation = (int )(Math.random() * 8 + 1);
		//monsterLocation = random;
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
			else if (random == 6)
			{
				if (character.getWeapons().size() == 3)
				{
					System.out.println("You stumbled over a crossbow but you already have 3 weapons.");
					System.out.println("These are the weapons that you currently have:");
					printWeapons(character);
					System.out.println("Would you like to swap a weapon for the crossbow? (Y/N)");
					String response = "";
					response = scanner.next();
					if (response.equalsIgnoreCase("y"))
					{
						System.out.println("Which weapon would you like to get rid of? ");
						int drop = scanner.nextInt();
						scanner.nextLine();
						character.getWeapons().remove(drop);
						CharacterWeapons.IWeaponBehavior w = new CharacterWeapons.Crossbow();
						character.setWeapons(w);
					}
				}
				else
				{
					System.out.println("You stumbled over a crossbow. Would you like to pick it up? (Y/N) ");
					String response = "";
					response = scanner.next();
					if (response.equalsIgnoreCase("y"))
					{
						CharacterWeapons.IWeaponBehavior w = new CharacterWeapons.Crossbow();
						character.setWeapons(w);
					}
				}
			}
			else if (random == 7)
			{
				if (character.getWeapons().size() == 3)
				{
					System.out.println("You found a pistol but you already have 3 weapons.");
				}
				else
				{
					System.out.println("You just found a pistol. Would you like to pick it up? (Y/N) ");
					String response = "";
					response = scanner.next();
					if (response.equalsIgnoreCase("y"))
					{
						CharacterWeapons.IWeaponBehavior w = new CharacterWeapons.Pistol();
						character.setWeapons(w);
					}
				}
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
	
	private void printWeapons(CharFactory.Character character)
	{
		System.out.println("These are the weapons you have - ");
		for (int i = 0; i < character.getWeapons().size(); i++)
		{
			System.out.print("(" + i + ") ");
			character.getWeapons().get(i).weaponName();
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
