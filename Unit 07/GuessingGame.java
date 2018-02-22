//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class GuessingGame
{
	Scanner keyboard = new Scanner(System.in);
	private int upperBound, wrongcount, val;
	

	public GuessingGame()
	{

	}

	public void playGame()
	{
		int val = 0;
		wrongcount = 0;
		int x = 0;
		int guess;
		int numguess;
		String cont;
		boolean again = true;
		
		while (again == true)
		{
			System.out.println("Guessing Game - How many numbers? ");
			upperBound = keyboard.nextInt();
			val = 0;
			x = 0;
			while (val <1 || val > upperBound)
			{
				val = (int) Math.floor(10*Math.random());
			}
			while (x < 3)
			{
				System.out.println("Enter a number between 1 and " + upperBound);
				guess = keyboard.nextInt();
				if (guess < 1 || guess > upperBound)
				{
					System.out.println("Number out of range!");
				}
				else if (guess != val)
				{
					wrongcount++;
				}
				else if (guess == val)
				{
					numguess = wrongcount + 1;
					System.out.println("It took " + numguess + " guesses to guess " + val + ".");
					int percent = (int) Math.floor(100*wrongcount/(wrongcount+1));
					System.out.println("You guessed wrong " + percent + " percent of the time.\n");
					x = 4;
				}
			}
			System.out.print("Do you want to play again?");
			cont = keyboard.next();
			if (cont.equals("n"))
			{
				again = false;
			} 
			else
			{
				again = true;
			}
		}
	}

	public String toString()
	{
		String output= "This is a toStrig";
		return output;
	}
}