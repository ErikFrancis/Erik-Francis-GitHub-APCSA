//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class Lab05d
{
	private static Scanner keyboard;

	public static void main ( String[] args )
	{
		keyboard = new Scanner(System.in);
		int x = 1;
		
		while (x > 0)
		{
		out.print("Enter a letter :: ");
		char letter = keyboard.next().charAt(0);
		CharacterAnalyzer test = new CharacterAnalyzer(letter);
		out.println(test.toString());   //A
		}
		//add more test cases
		
		
		
		
		
		
		
		

	}
}