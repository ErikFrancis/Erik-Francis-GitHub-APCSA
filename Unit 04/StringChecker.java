//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class StringChecker
{
	private String word;

	public StringChecker()
	{


	}

	public StringChecker(String s)
	{
		word = s;

	}

   public void setString(String s)
   {
   	word=s;
   }

	public boolean findLetter(char c)
	{
		int index = word.indexOf(c);
		if (index < 0) 
		{
			return false;
		}
		return true;
	}

	public boolean findSubString(String s)
	{
		int index = word.indexOf(s);
		if (index < 0) 
		{
			return false;
		}
		return true;

	}

 	public String toString()
 	{
 		return word + "\n\n";
	}
}