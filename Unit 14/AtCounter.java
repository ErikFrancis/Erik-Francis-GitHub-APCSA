//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class AtCounter
{
   private char[][] atMat;
   private int atCount;
   
	public AtCounter()
	{
		atCount=0;
		atMat = new char[][]{{'@','-','@','-','-','@','-','@','@','@'},
									{'@','@','@','-','@','@','-','@','-','@'},
									{'-','-','-','-','-','-','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','-','@'},
									{'-','@','-','@','-','@','-','@','-','@'},
									{'@','@','@','@','@','@','-','@','@','@'},
									{'-','@','-','@','-','@','-','-','-','@'},
									{'-','@','@','@','-','@','-','-','-','-'},
									{'-','@','-','@','-','@','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','@','@'}};
	}

	public int countAts(int r, int c)
	{
//		System.out.println("******");
//		System.out.println(r + " " + c + " : " + atMat[r][c]);
		if (atMat[r][c] == '@') {
//			System.out.println("add 1");
			atCount += 1;
		}
/*		for (int i = 0; i < atMat[0].length; i++) {
			String num = "";
			for (int k = 0; k < atMat.length; k++) {
				if (i == r && k == c)
					System.out.print(num + "* ");
				else
					System.out.print(num + atMat[i][k] + " ");
			}
			System.out.println();
		}
*/
		if(atMat[r][c] == '-'){
			return 0;
		}
		atMat[r][c] = '-';
		if(r-1>=0){
//			System.out.println("r-1 : " + (r-1) +","+ + c);
			atMat[r][c] = '-';
			countAts(r-1, c);
		}
		if(c-1>=0){
//			System.out.println("c-1 : " + r +","+ + (c-1));
			atMat[r][c] = '-';
			countAts(r, c-1);
		}

		if(r+1<atMat[0].length){
//			System.out.println("r+1 : " + (r+1) +","+ + c);
			atMat[r][c] = '-';
			countAts(r+1, c);
		}
		if(c+1<atMat.length){
//			System.out.println("c+1 : " + r +","+ + (c+1));
			atMat[r][c] = '-';
			countAts(r, c+1);
		}

		return 0;
	}

	public int getAtCount()
	{
		return atCount;
	}

	public String toString()
	{
		String output="";
		output+= getAtCount()+" @s connected.";
		atCount = 0;
		return output;
	}
}