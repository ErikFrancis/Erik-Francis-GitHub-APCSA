package Lab18d;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.System.*;

public class Lab18d
{

	public static void main( String args[] ) throws IOException
	{		
		ArrayList<Word> wordList = new ArrayList <Word> (); 
		ArrayList<Word> sortedList = new ArrayList <Word> (); 
		Scanner file = new Scanner(new File("F:\\Documents\\Eclipse\\Unit 12\\src\\Lab18d\\lab18d.dat"));
		int size = file.nextInt();
		file.nextLine();
		
		while (file.hasNext()) {
			Word temp = new Word(file.next());
			wordList.add(temp);
		}
		
		sortedList.add(wordList.get(0));
		for (int i = 1; i < wordList.size(); i++) {
			if (wordList.get(i).compareTo(sortedList.get(sortedList.size()-1))==1) {
				sortedList.add(wordList.get(i));
			}
			else {
				for (int j = 0; j < sortedList.size(); j++) {
					if (wordList.get(i).compareTo(sortedList.get(j))==-1) {
						sortedList.add(j, wordList.get(i));
						break;
					}
				}
			}
		}
		for (int i = 0; i < sortedList.size(); i++)
			System.out.println(sortedList.get(i));
	}
}