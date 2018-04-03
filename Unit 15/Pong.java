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

public class Pong extends Canvas implements KeyListener, Runnable
{
	private SpeedUpBall ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int countl, countr;


	public Pong()
	{
		//set up game variables
		ball = new SpeedUpBall(300,300,10,10,Color.blue,1,2);
		leftPaddle = new Paddle(110,100,20,50, Color.GREEN,6);
		rightPaddle = new Paddle(480,100,20,50, Color.RED,6);
		countl = 0;
		countr = 0;
		keys = new boolean[4];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
		
		
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and save it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);


		//see if ball hits left wall or right wall
		if(!(ball.getX()>=100 && ball.getX()<=500))
		{
			//ball.setXSpeed(-ball.getXSpeed());
			if (ball.getXSpeed()<0) {
				countl++;
				//System.out.println(countl);
				graphToBack.setColor(Color.WHITE);
				graphToBack.fillRect(300, 540, 500, 25);
				graphToBack.setColor(Color.RED);
				graphToBack.drawString("Left Score: "+countl, 300, 550);
			} else if(ball.getXSpeed()>0) {
				countr++;
				//System.out.println(countr);
				graphToBack.setColor(Color.WHITE);
				graphToBack.fillRect(300, 510, 500, 25);
				graphToBack.setColor(Color.RED);
				graphToBack.drawString("Right Score: "+countr, 300, 520);
			}
			ball.setXSpeed(1);
			ball.setYSpeed(1);
			ball = new SpeedUpBall(300,300,10,10,Color.blue,2,2);
		}

		
		//see if the ball hits the top or bottom wall 

		if(!(ball.getY()>=10 && ball.getY()<=450))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}


		//see if the ball hits the left paddle
		if (ball.didCollideLeft(leftPaddle)) {
			ball.setXSpeed(-ball.getXSpeed());
			System.out.println("left" + ball.getX() + " : " + leftPaddle.getX());
		}

		
		
		//see if the ball hits the right paddle
		if (ball.didCollideRight(rightPaddle)) {
			ball.setXSpeed(-ball.getXSpeed());
			System.out.println("right" + ball.getX() + " : " + rightPaddle.getX());
		}

		
		

		//see if the paddles need to be moved
		if(keys[0] == true)
		{
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			leftPaddle.moveDownAndDraw(graphToBack);

		}
		if(keys[2] == true)
		{
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[3] == true)
		{
			rightPaddle.moveDownAndDraw(graphToBack);
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'S' : keys[0]=true; break;
			case 'W' : keys[1]=true; break;
			case 'K' : keys[2]=true; break;
			case 'I' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'S' : keys[0]=false; break;
			case 'W' : keys[1]=false; break;
			case 'K' : keys[2]=false; break;
			case 'I' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e)
	{
		
	}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}