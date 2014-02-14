package GroupProject;

public class Tester {

	public static void main(String[] args) {
		
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
	}

}
