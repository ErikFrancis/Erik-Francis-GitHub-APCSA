//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

public class WordPrinter
{

	public String printWord(String word, int times)
	{
		String output = "";
		for (int i = 0; i < times; i++)
		{
			output = output + word + "\n";
		}
		return output;
	}
}