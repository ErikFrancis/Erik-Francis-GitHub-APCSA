//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class TriangleThree
{
   private int size, count;
   private String letter, line = "";


	public TriangleThree()
	{
	}

	public TriangleThree(int count, String let)
	{
		size = count;
		letter = let;
	}

	public void setTriangle(int count, String let)
	{
		size = count;
		letter = let;
	}

	public void maketriangle()
	{
		line = "";
		for (int i = 1; i <= size; i++)
		{
			int numspaces = size - i;
			int numcharacters = i;
			for (int x = 0; x<numspaces; x++)
			{
				line = line + " ";
			}
			for (int x =0; x<numcharacters; x++)
			{
				line = line + letter;
			}
			line = line + "\n";
		}
	}
	

	public String getLetter()
	{
		return "letter";
		
	}

	public String toString()
	{
		String output=line;
		return output+"\n";
	}
}