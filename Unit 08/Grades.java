//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.lang.System;
import java.lang.Math;
import java.util.Scanner;

public class Grades
{
	private double[] grades;
	
	Scanner keyboard = new Scanner(System.in);

	public Grades()
	{
	}


	public void setGrades()
	{
	int numgrades;
	System.out.println("How many grades do you want to input?: ");
	numgrades = keyboard.nextInt();
	grades = new double[numgrades];
	int gradenumber;
	for (int i = 0; i < numgrades; i++)
	{
		gradenumber = i+1;
		System.out.println("Grade " + i + "::");
		grades[i] = keyboard.nextDouble();
	}
	}

	private double getSum()
	{
		double sum=0.0;
		for (int i = 0; i < grades.length; i++)
		{
			sum += grades[i];
		}
		return sum;
	}

	public double getAverage()
	{
		double average=0.0;
		average = getSum()/grades.length;
		return average;
	}

	private String orderGrades()
	{
		double c;
		for (int j = 0; j < grades.length; j++)
		{
			for (int i = 0; i < grades.length - 1; i++)
			{
				if (grades[i] > grades[i+1])
				{
					c = grades[i+1];
					grades[i+1] = grades[i];
					grades[i] = c;
				}
			}
		}
		String output = "";
		for (int k = 0; k < grades.length; k++)
		{
			output = output + " " + grades[k];
		}
		return output;
	}
	
	public String toString()
	{
		setGrades();
		return orderGrades() + "\naverage = " + getAverage();
	}



}