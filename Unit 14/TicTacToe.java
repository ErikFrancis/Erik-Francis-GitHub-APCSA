//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;
	
	public TicTacToe()
	{
	}

	public TicTacToe(String game)
	{
		mat = new char[3][3];
		int index = 0;
		for (int i = 0; i<mat.length; i++) {
			for (int k = 0; k<mat.length; k++) {
				mat[i][k] = game.charAt(index);
				index++;
			}
		}
	}

	public String getWinner()
	{
		String winner = "cat's game - no winner!";
		String pieces = "XO";
		for (int z = 0; z<2; z++) {
			char player = pieces.charAt(z);
			for (int i = 0; i<mat.length; i++) {
				int count = 0;
				for (int k = 0; k<mat[i].length; k++) {
					if (mat[i][k] == player) {
						count++;
					}
				}
				if (count == 3) {
					winner = player+" wins horizontally!";
				}
			}
			for (int k = 0; k<mat.length; k++) {
				int count = 0;
				for (int i = 0; i<mat.length; i++) {
					if (mat[i][k] == player) {
						count++;
					}
				}
				if (count == 3) {
					winner = player+" wins vertically!";
				}
			}

			int count = 0;
			for (int i = 0, k = 0; i<mat.length; i++, k++) {
				if (mat[i][k] == player) {
					count++;
				}
			}
			if (count == 3) {
				winner = player+" wins diagonally!";
			}
			
			count = 0;
			for (int i = mat.length-1, k = 0; k<mat.length; i--, k++) {
				if (mat[i][k] == player) {
					count++;
				}
			}
			if (count == 3) {
				winner = player+" wins diagonally!";
			}
		}
		return winner;
	}

	public String toString()
	{
		String output="";
		for (int i = 0; i<mat.length; i++) {
			String line = "";
			for (int k = 0; k<mat[i].length; k++) {
				line += mat[i][k] + " ";
			}
			output += line +"\n";
		}
		output += getWinner();
		return output+"\n\n";
	}
}