//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package Lab18e;
import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s)
	{
		word = s;
	}

	private int numVowels()
	{
		String vowels = "AEIOUaeiou";
		int vowelCount=0;
		for (int i = 0; i < word.length(); i++) {
			for (int j = 0; j < vowels.length(); j++) {
				if (word.charAt(i) == vowels.charAt(j)) {
					vowelCount++;
				}
			}
		}
		return vowelCount;
	}

	public int compareTo(Word obj)
	{
		String rhs = obj.toString();
		if (numVowels() > obj.numVowels()) {
			return 1;
		}
		else if (numVowels() < obj.numVowels()) {
			return -1;
		}
		else {
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) > rhs.charAt(i)) {
					return 1;
				}
				else if (word.charAt(i) < rhs.charAt(i)) {
					return -1;
				}
			}
		}
		return 0;
	}

	public String toString()
	{
		return word;
	}
}