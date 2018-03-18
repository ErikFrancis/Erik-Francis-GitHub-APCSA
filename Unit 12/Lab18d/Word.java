//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

package Lab18d;
import static java.lang.System.*;
import java.util.ArrayList;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s )
	{
		word = s;
	}

	@Override
	public int compareTo( Word obj )
	{
		String rhs = obj.toString();
		if (word.length() > rhs.length()) {
			return 1;
		}
		else if (word.length() < rhs.length()) {
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