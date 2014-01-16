package Assign_2;

public class GoodGuys {
	private int[] goodGuys = new int[4];
	
	public GoodGuys(int hobbit, int elf, int dwarf, int human) {
		goodGuys[0] = hobbit;
		goodGuys[1] = elf;
		goodGuys[2] = dwarf;
		goodGuys[3] = human;
	}// end GoodGuys
	
	public void setGoodGuys(int hobbit, int elf, int dwarf, int human) {
		goodGuys[0] = hobbit;
		goodGuys[1] = elf;
		goodGuys[2] = dwarf;
		goodGuys[3] = human;
	}// end setGoodGuys
	
	public int[] getGoodGuys() {
		return goodGuys;
	}// end getGoodGuys
	
	@Override
	public String toString() {
		return goodGuys[0] + " hobbits, " + goodGuys[1] + " elfs, " + goodGuys[2] + " dwarves and " 
					+ goodGuys[3] + " humans in this army.";
	}// end toString
}
