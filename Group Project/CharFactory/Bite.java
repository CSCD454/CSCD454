package CharFactory;

public class Bite implements AttackBehavior {

	@Override
	public void attack() {
		System.out.println("Attack and kill by biting.");
	}
}
