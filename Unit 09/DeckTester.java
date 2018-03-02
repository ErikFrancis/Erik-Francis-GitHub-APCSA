/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String ranks[] = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
		String suits[] = {"spades", "hearts", "clubs", "diamonds"};
		int values[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
		Deck testDeck = new Deck(ranks, suits, values);
		System.out.println(testDeck);
		testDeck.deal();
		System.out.println(testDeck);
	}
}
