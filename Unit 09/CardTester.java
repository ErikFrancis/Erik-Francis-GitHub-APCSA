/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card tenHearts = new Card("10", "Hearts", 10);
		System.out.println(tenHearts.pointValue());
		System.out.println(tenHearts.rank());
		System.out.println(tenHearts.suit());
		System.out.println(tenHearts.toString());
		System.out.println(tenHearts.matches(tenHearts));
		
		Card kingClubs = new Card("K", "Clubs", 13);
		System.out.println(kingClubs.pointValue());
		System.out.println(kingClubs.rank());
		System.out.println(kingClubs.suit());
		System.out.println(kingClubs.toString());
		System.out.println(kingClubs.matches(tenHearts));
		
		Card aceSpades = new Card("A", "Spades", 1);
		System.out.println(aceSpades.pointValue());
		System.out.println(aceSpades.rank());
		System.out.println(aceSpades.suit());
		System.out.println(aceSpades.toString());
		System.out.println(aceSpades.matches(tenHearts));
	}
}
