//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Maze
{
   private int[][] maze;
   private boolean exitfound;
   
	public Maze()
	{


	}

	public Maze(int size, String line)
	{
		exitfound = false;
		Scanner scanner = new Scanner(line);
		
		maze = new int[size][size];
		for (int i = 0; i<size; i++) {
			for (int k = 0; k<size; k++) {
				maze[i][k] = scanner.nextInt();
			}
		}

	}

	public boolean hasExitPath(int r, int c)
	{
/*		System.out.println("------------------------");
		for (int i = 0; i < maze[0].length; i++) {
			String num = "";
			for (int k = 0; k < maze.length; k++) {
				if (i == r && k == c)
					System.out.print(num + "* ");
				else
					System.out.print(num + maze[i][k] + " ");
			}
			System.out.println();
		}
*/		
		int is1 = 0;
		if (maze[r][c] == 1) {
			is1 = 1;
			maze[r][c] = 0;
			if (c == maze.length-1 & is1 == 1) {
//				System.out.println("true");
				exitfound = true;
				return true;
			} else {
				if(r-1>=0){
//					System.out.println("r-1 : " + (r-1) +","+ + c + exitfound);
					hasExitPath(r-1, c);
				}
				if(c-1>=0){
//					System.out.println("c-1 : " + r +","+ + (c-1) + exitfound);
					hasExitPath(r, c-1);
				}

				if(r+1<maze.length){
//					System.out.println("r+1 : " + (r+1) +","+ + c + exitfound);
					hasExitPath(r+1, c);
				}
				if(c+1<maze[0].length){
//					System.out.println("c+1 : " + r +","+ + (c+1) + exitfound);
					hasExitPath(r, c+1);
				}
			}
		}
		return false;
	}

	public String getMaze() {
		String matrix = "";
		for (int i=0; i<maze.length; i++) {
			String line = "";
			for (int k=0; k<maze[i].length; k++) {
				line += maze[i][k] + " ";
			}
			matrix += line + "\n";
		}
		return matrix;
	}

	public String toString()
	{
		String output= getMaze();
		exitfound = false;
		hasExitPath(0,0);
		if (exitfound == true)
			output+= "exit found";
		else
			output+= "exit not found";
		
		
		
		return output;
	}
}