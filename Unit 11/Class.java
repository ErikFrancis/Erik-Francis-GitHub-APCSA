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

public class Class
{
	private String name;
	private ArrayList<Student> studentList;
	
	public Class()
	{
		name="";
		studentList=new ArrayList<Student>();
	}
	
	public Class(String classname, int stuCount)
	{
		studentList=new ArrayList<Student>(stuCount);
		name = classname;
	}
	
	public void addStudent(int stuNum, Student s)
	{
		studentList.add(stuNum, s);
	}
	
	public String getClassName()
	{
	   return name;	
	}
	
	public double getClassAverage()
	{
		double classAverage=0.0;
		for (int i = 0; i < studentList.size(); i++)
		{
			classAverage = classAverage + studentList.get(i).getAverage();
		}
		return classAverage/studentList.size();
	}
	
	public double getStudentAverage(int stuNum)
	{
		return studentList.get(stuNum).getAverage();
	}

	public double getStudentAverage(String stuName)
	{
		for (int i = 0; i < studentList.size(); i++)
		{
			if (stuName.equals(studentList.get(i).getName()))
			{
				return studentList.get(i).getAverage();
			}
		}
		return 0.0;
	}
	
	public String getStudentName(int stuNum)
	{
		return studentList.get(stuNum).getName();
	}
	
	public int getStudentNumber(String name)
	{
		int stuNum = 0;
		for (int i = 0; i < studentList.size(); i++)
		{
			if (getStudentName(i).equals(name))
			{
				stuNum = i;
			}
		}
		return stuNum;
	}

	public String getStudentWithHighestAverage()
	{
		String hName = studentList.get(0).getName();
		Student topstudent = studentList.get(0);
		for (int i = 1; i < studentList.size(); i++) 
		{
			if (studentList.get(i).compareTo(topstudent) >= 1)
			{
				topstudent = studentList.get(i);
				hName = studentList.get(i).getName();
			}
		}
		return hName;
	}

	public String getStudentWithLowestAverage()
	{
		String lName = studentList.get(0).getName();
		Student botstudent = studentList.get(0);
		for (int i = 1; i < studentList.size(); i++) 
		{
			if (studentList.get(i).compareTo(botstudent) <= -1)
			{
				botstudent = studentList.get(i);
				lName = studentList.get(i).getName();
			}
		}
		return lName;
	}
	
	public String getFailureList(double failingGrade)
	{
		String output="";
		for (int i = 0; i < studentList.size(); i++)
		{
			if (studentList.get(i).getAverage() < failingGrade)
			{
				output = output + " " + studentList.get(i).getName();
			}
		}
		return output;
	}
	
	public void sort()
	{
		ArrayList<Student> studentListcopy = new ArrayList<Student>();
		for (int i = 0; i < studentList.size(); i++)
		{
			studentListcopy.add(studentList.get(i));
		}
		ArrayList<Student> templist = new ArrayList<Student>();
		for (int i = 0; i < studentList.size(); i++)
		{
			Student botstudent = studentListcopy.get(0);
			int botstudentindex = 0;
			for (int j = 1; j < studentListcopy.size(); j++) 
			{
				if (studentListcopy.get(j).compareTo(botstudent) == -1)
				{
					botstudent = studentListcopy.get(j);
					botstudentindex = j;
				}
			}
			templist.add(botstudent);
			studentListcopy.remove(botstudentindex);
		}
		studentList = templist;
	}
	
	public String toString()
	{
		String output=""+getClassName()+"\n";
		Student tempstudent = new Student();
		for (int i = 0; i < studentList.size(); i++)
		{
			tempstudent = studentList.get(i);
			output = output + tempstudent.toString() + "\n";
		}
		output = output + "\nFailure List = " + getFailureList(65) + "\n";
		output = output + "Highest Average = " + getStudentWithHighestAverage() + "\n";
		output = output + "Lowest Average = " + getStudentWithLowestAverage() + "\n";
		output = output + "Class Average = " + getClassAverage() + "\n";
		
		return output;
	}  	
}