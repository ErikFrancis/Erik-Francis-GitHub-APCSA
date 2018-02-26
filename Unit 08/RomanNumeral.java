//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class RomanNumeral
{
	private Integer number;
	private String roman;

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
													50,40,10,9,5,4,1};

	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
												  "L","XL","X","IX","V","IV","I"};

	public RomanNumeral(String str)
	{
	setRoman(str);

	}

	public RomanNumeral(Integer orig)
	{
	setNumber(orig);

	}

	public void setNumber(Integer num)
	{
	number = num;

	}

	public void setRoman(String rom)
	{
	roman = rom;

	}

	public Integer getNumber()
	{
		number = 0;
		int numchars = roman.length();
		int index = 0;
		int secondcharindex = 0;
		int firstcharindex = 0;
		String character = "";
		String character1 = "";
		String character2 = "";
		for (int i = 0; i < numchars; i++)
		{
			character1 = "" + roman.charAt(i);
			if (i < numchars - 1)
			{
				for (int j = 0; j < 13; j++)
				{
					if (LETTERS[j].equals("" + roman.charAt(i)))
					{
						firstcharindex = j;
					}
					if (LETTERS[j].equals("" + roman.charAt(i+1)))
					{
						secondcharindex = j;
					}
				}
				if(firstcharindex > secondcharindex)
				{
					character2 = "" + roman.charAt(i+1);
					i++;
				}
			} else
			{
				character2 = "";
			}
			character = character1 + character2;
			for (int j = 0; j < 13; j++)
			{
				if (character.equals(LETTERS[j]))
				{
					index = j;
				}
			}
			number = number + NUMBERS[index];
		}
		return number;
	}

	public String getRoman()
	{
		int tempnum = number;
		roman = "";
		for (int i = 0; i < 13; i++)
		{
			while (tempnum - NUMBERS[i]>= 0)
			{
				roman = roman + LETTERS[i];
				tempnum = tempnum - NUMBERS[i];
			}
		}
		return roman;
		
	}
	
	public String toString()
	{
		getRoman();
		return roman + "\n";
	}
}