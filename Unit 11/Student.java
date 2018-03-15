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

public class Student implements Comparable
{
	private String myName;
	private Grades myGrades = new Grades();

	
	public Student()
	{
		setName("");
		setGrades("");
	}
	
	public Student(String name, String gradeList)
	{
		setName(name);
		setGrades(gradeList);
	}
	
	public void setName(String name)
	{
		myName = name;
	}	
	
	public void setGrades(String gradeList)
	{
		myGrades.setGrades(gradeList);
	}
	
	public void setGrade(int spot, double grade)
	{
		myGrades.setGrade(spot,grade);
	}

	public String getName()
	{
		return myName;
	}
	
	public int getNumGrades()
	{
		return myGrades.getNumGrades();
	}

	public double getSum()
	{
		return myGrades.getSum();
	}
	
	public double getAverage()
	{
		return getSum()/getNumGrades();
	}

	public double getAverageMinusLow()
	{
		return (getSum()-getLowGrade())/(getNumGrades()-1);
	}
	
	public double getHighGrade()
	{
		return myGrades.getHighGrade();		
	}
	
	public double getLowGrade()
	{
		return myGrades.getLowGrade();	
	}
	

	
	public boolean equal(Student s)
	{
		Student other = s;
		if (getAverage() == other.getAverage())
			return true;
		return false;
	}
	
	public String toString()
	{
		ArrayList <Double> tempgradelist = myGrades.getGrades();
		String output = getName() + " = "; // + "\nsum = " + getSum() + "\naverage = " + getAverage() + "\naverage - low = " + getAverageMinusLow() + "\nlow grade = " + getLowGrade() + "\nhigh grade = " + getHighGrade();
		for (int i = 0; i < tempgradelist.size(); i++)
		{
			output = output + tempgradelist.get(i) + " ";
		}
		output = output + "\t\t" + ((double) (Math.round(getAverage()*100))/100);
		return output;
	}

	@Override
	public int compareTo(Object s) {
		Student other = (Student) s;
		if(getAverage() > other.getAverage())
			return 1;
		else if(getAverage() < other.getAverage())
			return -1;
		return 0;
	}
}