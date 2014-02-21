package GroupProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Encounter {

	ArrayList<Character> fightList = new ArrayList<Character>(), heroList;
	
	public Encounter() {
		
	}
	
	public Encounter(ArrayList<Character> hero) {
		this.heroList = hero;
	}
	
	public void makeMonster(int numOfMonsters) {
		int x = numOfMonsters;
		
		while(x > 0) {
			Character temp = new BadCharacter("monster" + x);
			temp = randRace(temp);
			temp = randClass(temp);
			//System.out.println(temp.getName() + " " + temp.getHP() + " " + temp.getClassName() + " " + temp.getInit());
			fightList.add(temp);
			
			x--;
		}//end while
		
		//Adding PC to arraylist so it can be sorted for fight turns.
		for(int i = 0; i < this.heroList.size(); i++) {
			fightList.add(this.heroList.get(i));
		}//end for loop
		
		Collections.sort(fightList, new Comparator<Character>() {
			@Override
			public int compare(Character character1, Character character2) {
				if(character1.getInit() > character2.getInit()) {
					return -1;
				}
				else if(character1.getInit() == character2.getInit()) {
					return 0;
				}
				else {
					return 1;
				}
			}
		});//end collections sort
		
		
		 //Test to make sure sorting in right order. 
		for(int i = 0; i < fightList.size(); i ++) {
			System.out.println(fightList.get(i).getClassName() + " " + fightList.get(i).getInit() + " " + fightList.get(i).getName());
		}//end for loop
		
		fight(fightList);
	}//end makeMonster
	
	private void fight(ArrayList<Character> fightList) {
		boolean alive = true;
		
		while(alive) {
			System.out.println("This is where they fight.");
			alive = false;
		}
	}//end fight
	
	private Character randRace(Character character) {
		if(character == null) {
			throw new NullPointerException();
		}
		Character temp = null;
		
		int randNum = (int) (Math.random() * 3 + 1);
		
		if(randNum == 1) {
			temp = new Male(character);
		}
		else if(randNum == 2) {
			temp = new Female(character);
		}
		else {
			temp = new Child(character);
		}
		
		return temp;
	}//end randRace
	
	private Character randClass(Character character) {
		if(character == null) {
			throw new NullPointerException();
		}
		
		Character temp = null;
		int randNum = (int) (Math.random() * 5 + 1);
		
		if(randNum == 1) {
			temp = new Bartender(character, null);	//Null is where the weapon should go.
		}
		else if(randNum == 2) {
			temp = new CouchPotatoe(character);
		}
		else if(randNum == 3) {
			temp = new LawEnforcement(character);
		}
		else if(randNum == 4) {
			temp = new Redneck(character);
		}
		else {
			temp = new Student(character);
		}
		
		return temp;
	}//end randClass
}
