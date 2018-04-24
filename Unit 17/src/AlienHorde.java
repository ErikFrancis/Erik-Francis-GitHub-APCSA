//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private ArrayList<Alien>[][] aliens;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Alien>(size);
		for (int i = 0; i<aliens.size(); i++) {
			Alien tempalien = new Alien((i*50),10,50,50,2);
			aliens.set(i, tempalien);
		}
	}

	public void add(Alien al)
	{
	}

	public void drawEmAll( Graphics window )
	{
	}

	public void moveEmAll()
	{
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
	}

	public String toString()
	{
		return "";
	}
}
