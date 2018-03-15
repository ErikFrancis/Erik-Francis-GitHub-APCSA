//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class GradeBookRunner
{
   public static void main( String args[] )
   {
		out.println("Welcome to the Class Stats program!");
		
		Scanner keyboard = new Scanner(System.in);
		out.print("\n\nWhat is the name of this class? ");
		String className = keyboard.nextLine();
		out.print("\n\nHow many students are in this class? ");
		int numStudents = keyboard.nextInt();
		keyboard.nextLine();
		
		Class myClass = new Class(className, numStudents);
		
		int counter = 1; 
		while(counter<=numStudents){
			out.println("Enter the name of student " + counter + ":");
			Scanner keyboard2 = new Scanner (System.in);
			String studentName = keyboard2.nextLine();
			out.println("Enter the grades for " + studentName);
			out.println("use the format --> ( 2 - 100 100)");
			Scanner keyboard3 = new Scanner (System.in);
			String grades = keyboard3.nextLine();
			myClass.addStudent(counter - 1, new Student(studentName, grades));
			counter++;
		}
		
		System.out.println(myClass);

	}		
}