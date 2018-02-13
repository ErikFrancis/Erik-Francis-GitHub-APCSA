//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class CharacterAnalyzer
{
	private char theChar;
	private int ascii;

	public CharacterAnalyzer()
	{

	}

	public CharacterAnalyzer(char c)
	{
		theChar = c;
	}

	public void setChar(char c)
	{
		theChar = c;
	}

	public char getChar()
	{
		return theChar;
	}

	public boolean isUpper( )
	{
		String upper = String.valueOf(theChar);
		if (upper == upper.toUpperCase())
		{
			return true;
		}
		
		return false;
	}

	public boolean isLower( )
	{
		String lower = String.valueOf(theChar);
		if (lower == lower.toLowerCase())
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isNumber( )
	{
		getASCII();
		if (ascii > 47 && ascii < 64)
		{
		return true;
		}

		return false;
	}	

	public int getASCII( )
	{
		ascii = (int)theChar;
		return ascii;
	}

	public String type()
	{
		if (isNumber() == true)
		{
			return " is a number.";
		}
		if (isLower() == true)
		{
			return " is a lowercase character.";
		}
		return " is an uppercase character.";
	}
	
	public String toString()
	{
		return getChar() + type() + " ASCII == " + getASCII() + "\n";	  
	}
}