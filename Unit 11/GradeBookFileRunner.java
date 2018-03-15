//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.io.File;

public class GradeBookFileRunner
{	
	public static void main( String args[] ) throws Exception
	{
		
		
		out.println("Welcome to the Class Stats program!\n\n");
		String classname = "";
		int stuNum = 0;
		String tempstudentname = "";
		String tempstudentgrades = "";
		Class test = new Class();
		
		Scanner file = new Scanner(new File("F:\\Documents\\Eclipse\\Unit 11\\src\\gradebook.dat"));
		classname = file.nextLine();
		System.out.println(classname);
		stuNum = file.nextInt();
		file.nextLine();
		test = new Class(classname, stuNum);
		Student tempstudent = new Student();
		int i = 0;
		while(file.hasNext())
		{
			tempstudentname = file.nextLine();
			tempstudentgrades = file.nextLine();
			tempstudent = new Student(tempstudentname, tempstudentgrades);
			test.addStudent(i, tempstudent);
			System.out.println(tempstudent);
			i++;
		}
		

		test.sort();
		System.out.println("\n\n" + test);
		
		out.println("\n*********CLASS NUMBER TWO*********\n\n");
		classname = "";
		stuNum = 0;
		tempstudentname = "";
		tempstudentgrades = "";
		Class test2 = new Class();
		
		file = new Scanner(new File("F:\\Documents\\Eclipse\\Unit 11\\src\\gradebook.dat"));
		classname = file.nextLine();
		System.out.println(classname);
		stuNum = file.nextInt();
		file.nextLine();
		test2 = new Class(classname, stuNum);
		tempstudent = new Student();
		i = 0;
		while(file.hasNext())
		{
			tempstudentname = file.nextLine();
			tempstudentgrades = file.nextLine();
			tempstudent = new Student(tempstudentname, tempstudentgrades);
			test2.addStudent(i, tempstudent);
			System.out.println(tempstudent);
			i++;
		}
		

		test2.sort();
		System.out.println("\n\n" + test2);
		
		
		ArrayList<Class> classList = new ArrayList<Class>();
		classList.add(test);
		classList.add(test2);
		System.out.println("\n\n*********CLASSLIST*********\n\n" + classList);
		
	}		
	
}