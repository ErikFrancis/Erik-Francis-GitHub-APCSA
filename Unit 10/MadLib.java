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

public class MadLib
{
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();
	private String filename;
	
	public MadLib()
	{
	}

	public MadLib(String file)
	{
		loadNouns();
		loadVerbs();
		loadAdjectives();
		filename = file;
	}

	public void loadNouns()
	{
		try{
			Scanner nounscanner = new Scanner(new File("F:\\Documents\\Eclipse\\Unit 10\\src\\nouns.dat"));
			while (nounscanner.hasNext())
			{
				nouns.add(nounscanner.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("nounloaderror");
		}	
		
	}
	
	public void loadVerbs()
	{
		try{
			Scanner verbscanner = new Scanner(new File("F:\\Documents\\Eclipse\\Unit 10\\src\\verbs.dat"));
			while (verbscanner.hasNext())
			{
				verbs.add(verbscanner.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("verbloaderror");
		}	
	}

	public void loadAdjectives()
	{
		try{
			Scanner adjectivescanner = new Scanner(new File("F:\\Documents\\Eclipse\\Unit 10\\src\\adjectives.dat"));
			while (adjectivescanner.hasNext())
			{
				adjectives.add(adjectivescanner.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("adjectiveloaderror");
		}	
	}

	public String getRandomVerb()
	{
		return verbs.get((int) Math.floor(Math.random()*(verbs.size()-1)));
	}
	
	public String getRandomNoun()
	{
		int rand = (int) Math.floor(Math.random()*(nouns.size()-1));
		return nouns.get(rand);
	}
	
	public String getRandomAdjective()
	{
		
		return adjectives.get((int) Math.floor(Math.random()*(adjectives.size()-1)));
	}		

	public String toString()
	{
		String holdingstring = "";
		String output = "";
		try{
			Scanner file = new Scanner(new File(filename));
			//# is noun @ is verb & adjective
			while (file.hasNext())
			{
				holdingstring = file.next();
				if (holdingstring.equals("#"))
					output = output + getRandomNoun() + " ";
				else if (holdingstring.equals("@"))
					output = output + getRandomVerb() + " ";
				else if (holdingstring.equals("&"))
					output = output + getRandomAdjective() + " ";
				else
					output = output + holdingstring + " ";
			}
		}
		catch(Exception e)
		{
			out.println("MadLibError");
		}
		return output + "\n\n";
	}
}