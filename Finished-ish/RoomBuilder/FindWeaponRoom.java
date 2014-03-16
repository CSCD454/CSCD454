package RoomBuilder;

import java.util.Scanner;
import CharacterWeapons.*;
import GroupProject.Game;
import CharFactory.Character;

public class FindWeaponRoom extends Room {

	public FindWeaponRoom(Character character, Game game) {
		this.character = character;
		this.game = game;
		setDescription("weapon.txt");
	}
	
	public void add() {
		Scanner scanner = new Scanner(System.in);
		
		if (character.getWeapons().size() == 3)
		{
			System.out.println("You already have 3 weapons.");
			System.out.println("These are the weapons that you currently have:");
			printWeapons(character);
			System.out.println("Would you like to swap a weapon for the crossbow? (Y/N)");
			String response = "";
			response = scanner.nextLine();
			if (response.equalsIgnoreCase("y"))
			{
				System.out.println("Which weapon would you like to get rid of? ");
				int drop = scanner.nextInt();
				scanner.nextLine();
				character.getWeapons().remove(drop);
				CharacterWeapons.IWeaponBehavior w = parseWeapon();
				character.setWeapons(w);
			}
		}
		else
		{
			System.out.println("Would you like to pick it up? (Y/N) ");
			String response = "";
			response = scanner.nextLine();
			if (response.equalsIgnoreCase("y"))
			{
				CharacterWeapons.IWeaponBehavior w = parseWeapon();
				character.setWeapons(w);
			}
		}
	}//end add
	
	private void printWeapons(Character character)
	{
		System.out.println("These are the weapons you have - ");
		for (int i = 0; i < character.getWeapons().size(); i++)
		{
			System.out.print("(" + i + ") ");
			character.getWeapons().get(i).weaponName();
		}
	}//end printWeapons
	
	private IWeaponBehavior parseWeapon() {
		IWeaponBehavior w = null;
		String[] tokens = getDescription().split("[ .]+");
		
		for(String t : tokens) {
			if(t.equals("crossbow")) {
				w = new CharacterWeapons.Crossbow();
			}
			else if(t.equals("pistol")) {
				w = new CharacterWeapons.Pistol();
			}
			else if(t.equals("rifle")) {
				w = new CharacterWeapons.Rifle();
			}
			else if(t.equals("bat")) {
				w = new CharacterWeapons.Bat();
			}
			else {
				w = new CharacterWeapons.Book();
			}
		}//end forloop
		
		return w;
	}//end parseWeapon
	
	@Override
	public void roomDone() {
		game.Move(character);
	}// end roomDone

}
