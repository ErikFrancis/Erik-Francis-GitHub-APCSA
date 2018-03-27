//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab21i
{
	public static void main( String args[] ) throws IOException
	{
		Scanner scanner = new Scanner(new File("F:\\Documents\\Eclipse\\Unit 14\\src\\lab21i.dat"));
		int size = scanner.nextInt();
		scanner.nextLine();
		String string = scanner.nextLine();
		Maze test = new Maze(size, string);
		System.out.println(test.toString() + "\n");
		
		size = scanner.nextInt();
		scanner.nextLine();
		string = scanner.nextLine();
		test = new Maze(size, string);
		System.out.println(test.toString() + "\n");
		
		size = scanner.nextInt();
		scanner.nextLine();
		string = scanner.nextLine();
		test = new Maze(size, string);
		System.out.println(test.toString() + "\n");
		
		size = scanner.nextInt();
		scanner.nextLine();
		string = scanner.nextLine();
		test = new Maze(size, string);
		System.out.println(test.toString() + "\n");
		
		size = scanner.nextInt();
		scanner.nextLine();
		string = scanner.nextLine();
		test = new Maze(size, string);
		System.out.println(test.toString() + "\n");

		size = scanner.nextInt();
		scanner.nextLine();
		string = scanner.nextLine();
		test = new Maze(size, string);
		System.out.println(test.toString() + "\n");
	}
}