//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
		number = num;

	}

	public void setNum(int num)
	{
		number = num;

	}
	
	private boolean asqbsqcsq(int a, int b, int c)
	{
		int val1 = a*a + b*b;
		int val2 = c*c;
		if (val1 == val2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private boolean evenodd(int a, int b, int c)
	{
		if (a%2==1 && b%2==0 && c%2==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private boolean greatestCommonFactor(int a, int b, int c)
	{
		int gcd = 1;
		int max = Math.max(a, b);
		max = Math.max(max, c);
		for (int i = 1; i < max; i++)
		{
			if (a%i==0 && b%i==0 && c%i==0)
			{
				gcd = i;
			}
		}
		if (gcd!=1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	private String calculate()
	{
		int testa, testb, testc;
		String output = "";
		for (int i = 1; i<=number; i++)
		{
			testa = i;
			for (int j = 1; j<=number; j++)
			{
				testb = j;
				for (int k = 1; k<=number; k++)
				{
					testc = k;
					if (asqbsqcsq(testa, testb, testc)==true && evenodd(testa, testb, testc)==true && greatestCommonFactor(testa, testb, testc)==true)
						output = output + testa + " " + testb + " " + testc + "\n";
				}
			}
		}
		return output;
	}
	
	public String toString()
	{
		String output=calculate();

		return output;
	}
}