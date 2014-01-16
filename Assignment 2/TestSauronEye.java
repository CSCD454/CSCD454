package Assign_2;

public class TestSauronEye {
	
	public static void main(String[] args) {
		
		int hobbit;
		int elf;
		int dwarf;
		int human;
		GoodGuys goodGuys;
		
		hobbit = randomArmySize();
		elf = randomArmySize();
		dwarf = randomArmySize();
		human = randomArmySize();
		
		EyeOfSauron eye = new EyeOfSauron();
		BadGuy saruman = new BadGuy(eye, "Saruman");
		BadGuy angmar = new BadGuy(eye, "Angmar");
		
		goodGuys = new GoodGuys(hobbit, elf, dwarf, human);
		
		eye.setEnemies(goodGuys);
		
		saruman.defeat(eye);
		
		hobbit = randomArmySize();
		elf = randomArmySize();
		dwarf = randomArmySize();
		human = randomArmySize();

		goodGuys.setGoodGuys(hobbit, elf, dwarf, human);
		
		eye.setEnemies(goodGuys);
	}//end main
	
	private static int randomArmySize() {
		return (int) (Math.random() * 500 + 1);
	}//end randomArmySize
}
