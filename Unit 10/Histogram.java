//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.lang.System.*;

public class Histogram
{
	private ArrayList<Integer> count = new ArrayList<Integer>();
	private ArrayList<Character> letters = new ArrayList<Character>();
	private String fileName;

	public Histogram()
	{
	}

	public Histogram(char[] values, String fName)
	{
		letters.clear();
		count.clear();
		for (int i = 0; i<values.length; i++)
		{
			letters.add(values[i]);
		}
		fileName = fName;
	}
	
	public void newHistogram(char[] values, String fName)
	{
		letters.clear();
		count.clear();
		for (int i = 0; i<values.length; i++)
		{
			letters.add(values[i]);
		}
		fileName = fName;
	}
	
	public void loadAndAnalyzeFile() throws IOException
	{
		Scanner file = new Scanner(new File(fileName));
		String holdstring = "";
		count.clear();
		for (int i = 0; i<letters.size(); i++)
		{
			count.add(0);
		}

		while (file.hasNext())
		{
			holdstring = holdstring + file.next();
		}
//		System.out.println("Holdstring : " + holdstring);
		for (int j = 0; j<holdstring.length(); j++)
		{
			for(int i = 0; i<letters.size(); i++)
			{
				if(holdstring.charAt(j) == (letters.get(i)))
				{
					count.set(i, count.get(i)+1);
				}
			}
		}
	}

	public char mostFrequent()
	{
		int max = 0;
		for (int i = 0; i<count.size(); i++)
		{
			if (count.get(i)>max)
			{
				max = count.get(i);
			}
		}
		return letters.get(count.indexOf(max));
	}

	public char leastFrequent()
	{
		int min = count.get(0);
		for (int i = 0; i<count.size(); i++)
		{
			if (count.get(i)<min)
			{
				min = count.get(i);
			}
		}
		return letters.get(count.indexOf(min));
	}

	public String toString()
	{
	   return "search letters = " + letters + "\n" + "Letter occuring most : " + mostFrequent() + "\nLetter occuring least : " + leastFrequent() + "\n\n\n" + fileName + "\n" + letters  + "\n" + count + "\n\n\n";
	}
}