//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Lab16e
{
	public static void main( String args[] ) throws IOException
	{
		Histogram test = new Histogram(new char[]{'a','b','c'},"F:\\Documents\\Eclipse\\Unit 10\\src\\lab16e1.dat");
		test.loadAndAnalyzeFile();
		out.println(test);

		test.newHistogram(new char[]{'d','e','a'},"F:\\Documents\\Eclipse\\Unit 10\\src\\lab16e2.dat");
		test.loadAndAnalyzeFile();
		out.println(test);
		
		test.newHistogram(new char[]{'x','a','r','g'},"F:\\Documents\\Eclipse\\Unit 10\\src\\lab16e3.dat");
		test.loadAndAnalyzeFile();
		out.println(test);
	}
}