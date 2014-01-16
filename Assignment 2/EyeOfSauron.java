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
		boolean largeArmy = false;
		
		for(int i = 0; i < goodGuys.getGoodGuys().length; i++) {
			if(goodGuys.getGoodGuys()[i] > 0) {
				seesArmy = true;
				if(goodGuys.getGoodGuys()[i] > 400)
					largeArmy = true;
			}
		}
		if(seesArmy && !largeArmy) {
			System.out.println("Sauron: You can never hope to defeat me with such a small army.");
			spottedGoodGuys(goodGuys);
		}
		else if(seesArmy && largeArmy)
			spottedGoodGuys(goodGuys);
		else
			System.out.println("Hahahaha we win suckers.");
	}// end setEnemies
}
