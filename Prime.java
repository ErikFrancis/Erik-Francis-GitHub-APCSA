//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.lang.Math;

public class Prime
{
	private int number;

	public Prime()
	{


	}

	public Prime(int num)
	{
		number = num;

	}

	public void setPrime(int num)
	{
		number = num;

	}

	public String isPrime()
	{

		for (int i = 2; i<number; i++)
		{
			if (number%i == 0)
				return " is not prime.";
		}

		return " is prime.";
	}
	


	public String toString()
	{
		String output= number + isPrime() + "\n";

		return output;
	}
}