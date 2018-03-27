//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab21g
{
	public static void main(String args[])
	{
		AtCounter myCounter = new AtCounter();
		myCounter.countAts(0, 0);
		System.out.println("0 0 has " + myCounter);
		myCounter.countAts(2, 5);
		System.out.println("2 5 has " + myCounter);
		myCounter.countAts(5, 0);
		System.out.println("5 0 has " + myCounter);
		myCounter.countAts(9, 9);
		System.out.println("9 9 has " + myCounter);
		myCounter.countAts(3, 9);
		System.out.println("3 9 has " + myCounter);

	}
}