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
	/**
	 * This is a very simple games similar to that of Galaga. 

	 */
	private Ship ship;
	//private Alien alienOne;
	//private Alien alienTwo;
	//private Ammo ammoOne;
	private int clock = 0;


	private AlienHorde horde;
	private AlienHorde horde2;
	private AlienHorde horde3;
	private PowerUpList quickshots;
	private int quickshottime;
	private Bullets shipbullets;
	private Bullets alienbullets;


	private boolean[] keys;
	private BufferedImage back;

//	private int horde3top;
//	private int horde3bot;
	/**
	 * This instantiates game elements 
	 * 	
	 *  @param	ship	creates a player controlled ship
	 *  @param	clock	the clock is used for timing of certain programed actions such as alien movement and shooting.
	 *  @param	horde	first line of aliens
	 *  @param	horde2	second line of aliens
	 *  @param	horde3	bouncing aliens
	 *  @param	quickshottime	amount of time the powerup lasts
	 *  @param	shipbullets	players bullets
	 *  @param	alienbullets alien bullets
	 *  @see	paint
	 */
	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other instance variables
		//Ship, Alien
		ship = new Ship(300,300,30,50,3);
//		alienOne = new Alien(10,10,50,50,2);
//		alienTwo = new Alien(70,10,50,50,2);		
//		ammoOne = new Ammo(10,10,5);
		
		
		horde = new AlienHorde(7,10,10,75);
		horde2 = new AlienHorde(7,60,10,75);
		horde3 = new AlienHorde(7,200,10,50);
		quickshots = new PowerUpList(2,250,10,250);
		shipbullets = new Bullets(50);
		alienbullets = new Bullets(-1);
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

   /**
    * Game control method. Includes detection of keys, alien behavior, power-up behavior, collision detection, and game space cleanup.
    * 
    * @param	window	objects are painted onto a sheet that is then refreshed to the window in order to make the game run smoother and refresh at the same rate
    * @see		Alien, Ship, AlienHorde, PowerUp, Ammo, Bullets
    */
   
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
			System.out.println("X: " + (ship.getX()+5) + "Y: " + (ship.getY()-10));
			Ammo tempAmmo = new Ammo(ship.getX()+(ship.getWidth()/2)-5,ship.getY()-10,5);
			shipbullets.add(tempAmmo, clock);
		}
		
		// HORDE SHOOT
		if (clock%501==500)
		{
//			System.out.println("CLOCK: " + clock + "  horde length: " + horde.getLength());
			for (int i = 0; i<horde.getLength(); i = i+2)
			{
//				System.out.println("Alien: " + i + " " + (horde.getAlien(i).getX()+(horde.getAlien(i).getWidth()/2)-5) + ";" + (horde.getAlien(i).getY()+horde.getAlien(i).getHeight()+3));
				Ammo tempAmmo = new Ammo(horde.getAlien(i).getX()+(horde.getAlien(i).getWidth()/2)-5,horde.getAlien(i).getY()+horde.getAlien(i).getHeight()+3,2);
				alienbullets.add(tempAmmo, clock);
			}
		}
		if (clock%501==250)
		{
//			System.out.println("CLOCK: " + clock + "  horde length: " + horde.getLength());
			for (int i = 1; i<horde.getLength(); i = i+2)
			{
				System.out.println("Alien: " + i + " " + (horde.getAlien(i).getX()+(horde.getAlien(i).getWidth()/2)-5) + ";" + (horde.getAlien(i).getY()+horde.getAlien(i).getHeight()+3));
				Ammo tempAmmo = new Ammo(horde.getAlien(i).getX()+(horde.getAlien(i).getWidth()/2)-5,horde.getAlien(i).getY()+horde.getAlien(i).getHeight()+3,2);
				alienbullets.add(tempAmmo, clock);
			}
		}
		
		// HORDE2 SHOOT
		if (clock%501==500)
		{
//			System.out.println("CLOCK: " + clock + "  horde2 length: " + horde2.getLength());
			for (int i = 0; i<horde2.getLength(); i = i+2)
			{
//				System.out.println("Alien: " + i + " " + (horde2.getAlien(i).getX()+(horde2.getAlien(i).getWidth()/2)-5) + ";" + (horde2.getAlien(i).getY()+horde2.getAlien(i).getHeight()+3));
				Ammo tempAmmo = new Ammo(horde2.getAlien(i).getX()+(horde2.getAlien(i).getWidth()/2)-5,horde2.getAlien(i).getY()+horde2.getAlien(i).getHeight()+3,2);
				alienbullets.add(tempAmmo, clock);
			}
		}
		if (clock%501==400)
		{
//			System.out.println("CLOCK: " + clock + "  horde2 length: " + horde2.getLength());
			for (int i = 1; i<horde2.getLength(); i = i+2)
			{
//				System.out.println("Alien: " + i + " " + (horde2.getAlien(i).getX()+(horde2.getAlien(i).getWidth()/2)-5) + ";" + (horde2.getAlien(i).getY()+horde2.getAlien(i).getHeight()+3));
				Ammo tempAmmo = new Ammo(horde2.getAlien(i).getX()+(horde2.getAlien(i).getWidth()/2)-5,horde2.getAlien(i).getY()+horde2.getAlien(i).getHeight()+3,2);
				alienbullets.add(tempAmmo, clock);
			}
		}
		if (clock%999==998)
		{
//			System.out.println("CLOCK: " + clock + "  horde2 length: " + horde2.getLength());
			for (int i = 0; i<horde2.getLength(); i++)
			{
//				System.out.println("Alien: " + i + " " + (horde2.getAlien(i).getX()+(horde2.getAlien(i).getWidth()/2)-5) + ";" + (horde2.getAlien(i).getY()+horde2.getAlien(i).getHeight()+3));
				Ammo tempAmmo = new Ammo(horde2.getAlien(i).getX()+(horde2.getAlien(i).getWidth()/2)-5,horde2.getAlien(i).getY()+horde2.getAlien(i).getHeight()+3,2);
				alienbullets.add(tempAmmo, clock);
			}
		}
			
		// Move Aliens
		horde.setSpeed(2);
		horde2.setSpeed(1);
		horde3.setSpeed(1);
		
		horde.moveAllHorizontal((horde.getLength()*50) + 320 ,5);
		horde2.moveAllHorizontal((horde2.getLength()*50) + 320 ,5);
/*		if (clock%1000==0){
			horde3top = horde3.getAlien(0).getY()-2;
			horde3bot = horde3.getAlien(0).getY()+100;
		} */
		horde3.moveAllVertical(150, 400);
		horde3.moveAllHorizontal((horde3.getLength()*50) + 320 ,5);
		
		
		//Move PowerUps
		quickshots.setSpeed(2);
		quickshots.moveAllHorizontal(quickshots.getLength()*50+600, 5);
		
		if (clock%10 == 0) {
			horde.setSpeed(1);
			horde2.setSpeed(1);
		
			horde.moveDirection("DOWN");
			horde2.moveDirection("DOWN");
		}
		
		// Move Bullet
		shipbullets.moveDirection("UP");
		alienbullets.moveDirection("DOWN");

		//**********COLLISION DETECTION*******
		//HORDE
		for(int i=0; i<horde.getLength(); i++) {
			for (int j = 0; j<shipbullets.getLength(); j++)
			{
				if (shipbullets.getBullet(j).collide(horde.getAlien(i))) {
//					System.out.println("ALIEN HORDE REMOVE");
					horde.getAlien(i).remove();
					shipbullets.getBullet(j).remove();
				}
			}
			if (horde.getAlien(i).collide(ship)) {
				ship.remove();
//				System.out.println("SHIP REMOVE HORDE");
				horde.getAlien(i).remove();
			}
		}
		//HORDE2
		for(int i=0; i<horde2.getLength(); i++) {
			for (int j = 0; j<shipbullets.getLength(); j++)
			{
				if (shipbullets.getBullet(j).collide(horde2.getAlien(i))) {
//					System.out.println("ALIEN HORDE2 REMOVE");
					horde2.getAlien(i).remove();
					shipbullets.getBullet(j).remove();
				}
			}
			if (horde2.getAlien(i).collide(ship)) {
				ship.remove();
//				System.out.println("SHIP REMOVE HORDE2");
				horde2.getAlien(i).remove();
			}
		}
		
		//HORDE3
		for(int i=0; i<horde3.getLength(); i++) {
			for (int j = 0; j<shipbullets.getLength(); j++)
			{
				if (shipbullets.getBullet(j).collide(horde3.getAlien(i))) {
//					System.out.println("ALIEN HORDE3 REMOVE");
					horde3.getAlien(i).remove();
					shipbullets.getBullet(j).remove();
				}
			}
			if (horde3.getAlien(i).collide(ship)) {
				ship.remove();
//				System.out.println("SHIP REMOVE HORDE3");
				horde3.getAlien(i).remove();
			}
		}
		
		//HORDE BULLETS
		for (int i = 0; i<alienbullets.getLength(); i++)
		{
			if (alienbullets.getBullet(i).collide(ship)) {
//				System.out.println("SHIP REMOVE HORDE2 BULLETS");
				ship.remove();
				alienbullets.getBullet(i).remove();
			}
		}
		
		//POWERUP
		for(int i=0; i<quickshots.getLength(); i++) {

			for (int j = 0; j<shipbullets.getLength(); j++)
			{
				if (shipbullets.getBullet(j).collide(quickshots.getPowerUp(i))) {
//					System.out.println("ALIEN HORDE3 REMOVE");
					quickshots.getPowerUp(i).remove();
					shipbullets.getBullet(j).remove();
					quickshottime = 150;
					shipbullets.setShotdelay(10);
				}
			}
			if (quickshots.getPowerUp(i).collide(ship)) {
//				System.out.println("SHIP REMOVE HORDE3");
				quickshots.getPowerUp(i).remove();
				shipbullets.setShotdelay(10);
				quickshottime = 150;
			}
		}
		
		
		//SHIP
		for (int i = 0; i<shipbullets.getLength(); i++)
		{
			if (shipbullets.getBullet(i).collide(ship)) {
//				System.out.println("SHIP REMOVE SHIP");
				ship.remove();
				shipbullets.getBullet(i).remove();
			}
		}
		

		//POWERUPS
		if (quickshottime > 0){
			quickshottime--;
		}
		if (quickshottime == 0){
			shipbullets.setShotdelay(50);
		}

		
		// CLEAR DEAD ALIENS
		horde.removeDeadOnes();
		horde2.removeDeadOnes();
		horde3.removeDeadOnes();
		quickshots.removeDeadOnes();
		
		
		ship.draw(graphToBack);
//		alienOne.draw(graphToBack);
//		alienTwo.draw(graphToBack);
		shipbullets.drawAll(graphToBack);
		alienbullets.drawAll(graphToBack);
		horde.drawAll(graphToBack);
		horde2.drawAll(graphToBack);
		horde3.drawAll(graphToBack);
		quickshots.drawAll(graphToBack);
		twoDGraph.drawImage(back, null, 0, 0);
		
		// CLOCK
		if (clock > 1000) {
			clock = 0;
			shipbullets.setTimeofmostrecentshot(clock);
			alienbullets.setTimeofmostrecentshot(clock);
		} else {
			clock++;
		}
	}


	/**
	 * Key detection
	 */
	
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

	/**
	 * key detection
	 */
	
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

