package CharFactory;

public class Pistol implements AttackBehavior {

	@Override
	public void attack() {
		System.out.println("Hit and kill with a pistol.");
	}
}
