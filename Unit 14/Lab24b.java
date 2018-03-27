//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab24b
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File ("F:\\Documents\\Eclipse\\Unit 14\\src\\lab24b.dat"));
		int size = file.nextInt();
		file.nextLine();
		FancyWord test = new FancyWord();
		for(int i = 0; i<size; i++)
		{
			String word = file.next();
			test = new FancyWord(word);
			System.out.println(test);		
			file.nextLine();
	   }
	}
}