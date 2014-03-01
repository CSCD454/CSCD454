package CharFactory;

public class Crossbow implements AttackBehavior {

	@Override
	public void attack() {
		System.out.println("Hit and kill with a crossbow.");
	}
}
