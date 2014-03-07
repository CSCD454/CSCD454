package GroupProject;

import java.util.ArrayList;
import java.util.Scanner;

public class FightArena 
{

	public void Turn(ArrayList<CharFactory.Character> fightList, int tnum)
	{
		boolean control = true;
		System.out.println("What will " + fightList.get(tnum).getName() + " do?");
		int tar = 0;
		int choice;
		while(control)
		{
			if(fightList.get(tnum).isGood)
			{
				choice = fightMenu();
				if(choice ==1)
				{
					tar = selectTarget(fightList);
				}
			}
			else
			{
				choice = 1;
				tar = selectBad(fightList);
			}
			if (choice == 1)
			{
				int dam = fightList.get(tnum).attack();
				fightList.get(tar).setHP(fightList.get(tar).getHP() - dam);
				
				if(fightList.get(tar).getHP() <= 0)
				{
					//set char as dead
				}//end if
				
				control = false;
			}//end if
			
			else if(choice == 2)
			{
				useItems(fightList, tnum);
				control = false;
			}
			
		}//end while
		
	}
	
	private void useItems(ArrayList<CharFactory.Character> fightList, int tnum)
	{
		/* STUBBED FOR ITEM METHODS Other wise working
		ArrayList inv = fightList.get(tnum).getInventory();
		System.out.println("Select an item to use");
		for(int x = 0; x< fightList.size(); x++)
		{
			System.out.println(x+ ". " + inv.get(x).getName());
		}
		int choice = 0;
		Scanner kb = new Scanner(System.in);
		choice = kb.nextInt();
		inv.get(choice).useItem();
		*/
	}
	
	private int fightMenu()
	{
		System.out.println("1.Attack");
		System.out.println("2.Use Item");
		
		int choice = 0;
		Scanner kb = new Scanner(System.in);
		choice = kb.nextInt();
		return choice;
	}
	
	private int selectTarget(ArrayList<CharFactory.Character> fightList)
	{
		for (int x =0; x > fightList.size(); x++)
		{
			if(!fightList.get(x).isGood)
			{
				System.out.println(x +". " + fightList.get(x).getName());
			}
		}
		
		System.out.println("Select a target to attack");
		int choice = 0;
		Scanner kb = new Scanner(System.in);
		choice = kb.nextInt();
		return choice;
	}
	
	private int selectBad(ArrayList<CharFactory.Character> fightList)
	{
		boolean control = true;
		int tar = 0;
		while(control)
		{
			tar = (int) (Math.random()*fightList.size());
			if(fightList.get(tar).isGood)
			{
				control = false;
			}
		}
		return tar;
	}
	
}
