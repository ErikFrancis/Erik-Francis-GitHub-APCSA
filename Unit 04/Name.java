//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Name
{
	private String name;

	public Name()
	{
		

	}

	public Name(String s)
	{
		name = s;

	}

   public void setName(String s)
   {
	   name = s;

   }

	public String getFirst()
	{
		int index = name.indexOf(" ");
		String firstname = name.substring(0,index);
		return firstname;
	}

	public String getLast()
	{
		int index = name.indexOf(" ");
		String lastname = name.substring(index+1, name.length());
		return lastname;
	}

 	public String toString()
 	{
 		return name + "\n\n";
	}
}