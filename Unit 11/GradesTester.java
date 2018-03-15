//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class GradesTester
{
   public static void main( String args[] )
   {
		Grades test = new Grades("5 - 90 85 95.5 77.5 88");
		System.out.println(test.toString() + "\n");
		
		Grades test2 = new Grades("9 - 10.0 70.0 90.0 92.5 85 95.5 77.5 88.0 100.0");
		System.out.println(test2.toString());
	}		
}