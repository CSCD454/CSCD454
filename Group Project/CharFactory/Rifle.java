package CharFactory;

public class Rifle implements AttackBehavior {

	@Override
	public void attack() {
		System.out.println("Hit and kill with a rifle.");
	}
}
