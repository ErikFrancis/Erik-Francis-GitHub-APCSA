//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Lab03d
{
	private double x1, y1, x2, y2;
	private Scanner keyboard;
	
	public static void main( String[] args )
   {
		Lab03d temp = new Lab03d();
		temp.getdata();
		temp.calculate();
	
	}
	
	public void getdata()
	{
		keyboard = new Scanner(System.in);
		System.out.print("Enter X1 :: ");
		x1 = keyboard.nextDouble();
		System.out.print("Enter Y1 :: ");
		y1 = keyboard.nextDouble();
		System.out.print("Enter X2 :: ");
		x2 = keyboard.nextDouble();
		System.out.print("Enter Y2 :: ");
		y2 = keyboard.nextDouble();
	}
	
	public void calculate()
	{
		Distance temp = new Distance();
		temp.setCoordinates(x1, y1, x2, y2);
		temp.calcDistance();
		System.out.println(temp.toString());
	}
}