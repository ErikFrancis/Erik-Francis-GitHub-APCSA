//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

package Lab18b;
import static java.lang.System.*;

public class Monster implements Comparable
{
	private int myWeight;
	private int myHeight;
	private int myAge;

	public Monster()
	{
	}

	public Monster (int ht)
	{
		setHeight(ht);
	}

	public Monster (int ht, int wt)
	{
		setHeight(ht);
		setWeight(wt);
	}

	public Monster(int ht, int wt, int age)
	{
		setHeight(ht);
		setWeight(wt);
		setAge(age);
	}

	public void setHeight(int height)
	{
		myHeight = height;
	}

	public void setWeight(int weight)
	{
		myWeight = weight;
	}
	
	public void setAge(int age)
	{
		myAge = age;
	}
	
	public int getHeight()
	{
		return myHeight;
	}
	
	public int getWeight()
	{
		return myWeight;
	}
	
	public int getAge()
	{
		return myAge;
	}
	
	public Object clone()
	{
	   return new Monster(getHeight(), getWeight(), getAge());
	}

	@Override
	public boolean equals( Object obj )
	{
		Monster tempmonster = (Monster) obj;
		if (tempmonster.getAge()==getAge() && tempmonster.getHeight()==getHeight() && tempmonster.getWeight()==getWeight())
			return true;
		return false;
	}

	public int compareTo( Object obj )
	{
		Monster rhs = (Monster)obj;
		if (getHeight() > rhs.getHeight())
			return 1;
		else if (getHeight() < rhs.getHeight())
			return -1;
		else if (getHeight() == rhs.getHeight())
		{
			if (getWeight() > rhs.getWeight())
				return 1;
			else if (getWeight() < rhs.getWeight())
				return -1;
			else if (getWeight() == rhs.getWeight())
			{
				if (getAge() > rhs.getAge())
					return 1;
				else if (getAge() < rhs.getAge())
					return -1;
				else if (getAge() == rhs.getAge())
				{
					return 0;
				}
			}
		}
		return 0;
	}

	public String toString()
	{
		return (getHeight()+" "+getWeight()+" "+getAge());
	}
}