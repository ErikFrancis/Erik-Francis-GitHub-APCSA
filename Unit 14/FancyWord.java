//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class FancyWord
{
	private char[][] mat;
	private String word;
	
	public FancyWord()
	{

	}

   public FancyWord(String s)
	{
	   word = s;
	   mat = new char[s.length()][s.length()];
	}

   private void hourglass() {
	   for (int k = 0; k<word.length(); k++) {
		   mat[0][k] = word.charAt(k);
	   }
	   for (int i=0, k=0; k<word.length(); i++, k++) {
		   mat[i][k] = word.charAt(k);
	   }
	   for (int i=word.length()-1, k=0; k<word.length(); i--, k++) {
		   mat[i][k] = word.charAt(k);
	   }
	   for (int i=word.length()-1, k=0; k<word.length(); k++) {
		   mat[i][k] = word.charAt(k);
	   }
   }
   
   public String toString()
	{
	   hourglass();
	   String output="";
	   for (int i = 0; i<mat.length; i++) {
		   String line = "";
		   for (int k = 0; k<mat[i].length; k++) {
			   line += mat[i][k];
		   }
		   output += line+"\n";
	   }
		return output+"\n\n";
	}
}