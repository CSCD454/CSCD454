package Assign_2;

import java.util.Observable;
import java.util.Observer;

public class BadGuy implements Observer {
	
	//Defeated defeated;
	private String name;
	
	public BadGuy(Observable eye, String name) {
		eye.addObserver(this);
		this.name = name;
	}// end BadGuy
	
	public void defeat(Observable eye) {
		eye.deleteObserver(this);
	}// end defeat

	@Override
	public void update(Observable observable, Object goodGuys) {
		if(observable instanceof EyeOfSauron) {
			//EyeOfSauron eye = (EyeOfSauron)observable;
			display(goodGuys);
		}
	}// end update
	
	public void display(Object goodGuys) {
		System.out.println(this.name + " sees " + goodGuys.toString());
	}// end display
}
