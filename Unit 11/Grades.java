//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.util.ArrayList;

public class Grades
{
	private ArrayList<Double> grades;

	
	public Grades()
	{

	}
	
	public Grades(String gradeList)
	{
		setGrades(gradeList);		
	}
	
	public void setGrades(String gradeList)
	{
	   	if (gradeList.equals(""))
	   	{
	   		grades = new ArrayList<Double>();
	   	} 
	   	else 
	   	{
		Scanner scan = new Scanner(gradeList);
	   	ArrayList<Double> tempgrades = new ArrayList<Double>();
	   	String tempstring = "";
	   	while (!tempstring.equals("-"))
	   	{
	   		tempstring = scan.next();
	   	}
	   	while (scan.hasNext())
	   		tempgrades.add(scan.nextDouble());
	   	grades = tempgrades;
	   	}
	}
	
	public void setGrade(int spot, double grade)
	{
		grades.set(spot, grade);
	}
	
	public ArrayList<Double> getGrades()
	{
		return grades;
	}
	
	public double getSum()
	{
		double sum=0.0;
		for (int i = 0; i < grades.size(); i++)
			sum = sum + grades.get(i);
		return sum;
	}
	
	public double getLowGrade()
	{
		double low = Double.MAX_VALUE;
		for (int i = 0; i < grades.size(); i++)
			if(grades.get(i) < low)
				low = grades.get(i);
		return low;
	}
	
	public double getHighGrade()
	{
		double high = Double.MIN_VALUE;
		for (int i = 0; i < grades.size(); i++)
			if(grades.get(i) > high)
				high = grades.get(i);
		return high;
	}
	
	public int getNumGrades()
	{
		return grades.size();
	}
	
	public String toString()
	{
		String output="";
		for (int i = 0 ; i < grades.size(); i++)
			output = output + grades.get(i) + " ";
		output = output + "\nsum = " + getSum() + "\nnum grades = " + getNumGrades() + "\nlow grade = " + getLowGrade() + "\nhigh grade = " + getHighGrade();
		return output;
	}	
}