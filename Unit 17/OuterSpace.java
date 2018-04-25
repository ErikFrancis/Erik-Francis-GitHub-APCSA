//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	//private Alien alienOne;
	//private Alien alienTwo;
	//private Ammo ammoOne;
	private int clock = 0;


	private AlienHorde horde;
	private AlienHorde horde2;
	private Bullets bullets;


	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other instance variables
		//Ship, Alien
		ship = new Ship(200,200,50,50,5);
//		alienOne = new Alien(10,10,50,50,2);
//		alienTwo = new Alien(70,10,50,50,2);		
//		ammoOne = new Ammo(10,10,5);
		
		
		horde = new AlienHorde(8,10,10,50);
		horde2 = new AlienHorde(8,60,10,50);
		bullets = new Bullets();
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		
		
		//add code to move Ship, Alien, etc.
		
		//Move Ship
		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
		if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
		if(keys[2] == true)
		{
			ship.move("UP");
		}
		if(keys[3] == true)
		{
			ship.move("DOWN");
		}
		
		// Launch Bullet
		if(keys[4] == true)
		{
			System.out.println("shoot");
			System.out.println("X: " + (ship.getX()+5) + "Y: " + (ship.getY()-3));
			Ammo tempAmmo = new Ammo(ship.getX()+(ship.getWidth()/2)-5,ship.getY()-3,5);
			bullets.add(tempAmmo, clock);
		}
		
		// Move Aliens
		horde.setSpeed(2);
		horde2.setSpeed(1);
		
		horde.moveAll();
		horde2.moveAll();
		
		if (clock%10 == 0) {
			horde.setSpeed(1);
			horde2.setSpeed(1);
		
			horde.moveDirection("DOWN");
			horde2.moveDirection("DOWN");
		}
		
		// Move Bullet
		bullets.moveDirection("UP");

		//**********COLLISION DETECTION*******
		//HORDE
		for(int i=0; i<horde.getLength(); i++) {
			for (int j = 0; j<bullets.getLength(); j++)
			{
				if (bullets.getBullet(j).collide(horde.getAlien(i))) {
					horde.getAlien(i).remove();
					bullets.getBullet(j).remove();
				}
			}
			if (horde.getAlien(i).collide(ship)) {
				ship.remove();
				horde.getAlien(i).remove();
			}
		}
		//HORDE2
		for(int i=0; i<horde2.getLength(); i++) {
			for (int j = 0; j<bullets.getLength(); j++)
			{
				if (bullets.getBullet(j).collide(horde2.getAlien(i))) {
					horde2.getAlien(i).remove();
					bullets.getBullet(j).remove();
				}
			}
			if (horde2.getAlien(i).collide(ship)) {
				ship.remove();
				horde2.getAlien(i).remove();
			}
		}
		
		//SHIP
		for (int i = 0; i<bullets.getLength(); i++)
		{
			if (bullets.getBullet(i).collide(ship)) {
				ship.remove();
				bullets.getBullet(i).remove();
			}
		}
		


		
		
		ship.draw(graphToBack);
//		alienOne.draw(graphToBack);
//		alienTwo.draw(graphToBack);
		bullets.drawAll(graphToBack);
		horde.drawAll(graphToBack);
		horde2.drawAll(graphToBack);
		twoDGraph.drawImage(back, null, 0, 0);
		
		// CLOCK
		if (clock > 1000) {
			clock = 0;
			bullets.setTimeofmostrecentshot(clock);
		} else {
			clock++;
		}
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}
	
	
	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

