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

public class LotteryTicket
{
private String nameOfBuyer;
private int[] numberList;

	private boolean search(int toFind)
	{
		for (int i = 0; i < numberList.length; i++)
		{
			if (numberList[i] == toFind)
			{
				return true;
			}
		}
		return false;
	}
	
	public LotteryTicket(String name)
	{
		nameOfBuyer = name;
		numberList = new int[10];
		int randval = 0;
		for (int i = 0; i < numberList.length; i++)
		{
			randval = -1;
			while (randval < 1 && !search(randval))
			{
				randval = (int) (50*Math.random());
			}
			System.out.println(randval);
			numberList[i] = randval;
		}
	}
	
	public double getPercentThatMatch(int[] winningNumbers)
	{
		int count = 0;
		double percent;
		for (int i = 0; i < winningNumbers.length; i++)
		{
			if (search(winningNumbers[i]))
			{
				count++;
			}
		}
		percent = (double) count/10;
		return percent;
	}
	
	public String getName()
	{
		return nameOfBuyer;
	}
}