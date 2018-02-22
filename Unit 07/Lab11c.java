//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

public class Lab11c
{
   public static void main( String args[] )
   {
	   TriangleThree test = new TriangleThree();
	   test.setTriangle(3, "A");
	   test.maketriangle();
	   System.out.println(test.toString());

	   test.setTriangle(7, "X");
	   test.maketriangle();
	   System.out.println(test.toString());

	   test.setTriangle(1, "R");
	   test.maketriangle();
	   System.out.println(test.toString());

	   test.setTriangle(5, "T");
	   test.maketriangle();
	   System.out.println(test.toString());

	   test.setTriangle(4, "W");
	   test.maketriangle();
	   System.out.println(test.toString());
	   
	}
}