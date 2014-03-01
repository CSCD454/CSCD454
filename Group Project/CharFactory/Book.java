package CharFactory;

public class Book implements AttackBehavior {

	@Override
	public void attack() {
		System.out.println("Hit and kill with a book");
	}
}
