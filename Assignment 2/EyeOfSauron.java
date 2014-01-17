package Assign_2;

import java.util.Observable;
import java.util.Observer;

public class EyeOfSauron extends Observable {
	
	public EyeOfSauron() {}
	
	public void spottedGoodGuys(GoodGuys goodGuys) {
		setChanged();
		notifyObservers(goodGuys);
	}// end spottedGoodGuys
	
	public void setEnemies(GoodGuys goodGuys) {
		boolean seesArmy = false;

		for(int i = 0; i < goodGuys.getGoodGuys().length; i++) {
			if(goodGuys.getGoodGuys()[i] > 0) {
				seesArmy = true;
			}
		}
		if(seesArmy)
			spottedGoodGuys(goodGuys);
		else
			System.out.println("Sauron: Are you to afraid to stand against me.");
	}// end setEnemies
}
