import static java.lang.Character.toUpperCase;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Breakout extends Canvas implements KeyListener, Runnable{
	private Paddle paddle;
	private Ball ball;
	private boolean[] keys;
	private BufferedImage back;
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private ArrayList<Color> colors = new ArrayList<Color>();
	private int level=1;
	private int winat = 3;
	
	public Breakout(){
		//set up all variables related to the game
		ball=new Ball(300, 300, 10, 10);
		paddle=new Paddle(400,500,40,40,3);
		colors.add(Color.red);
		colors.add(Color.orange);
		colors.add(Color.yellow);
		colors.add(Color.green);
		colors.add(Color.blue);
		colors.add(Color.cyan);
		colors.add(Color.magenta);
		createBlocks(level);
		
		
		
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
		   if(blocks.size()==0 && level>=0){
			   level++;
			   ball.setXSpeed(ball.getXSpeed()+1);
			   ball.setYSpeed(ball.getYSpeed()+1);
			   if(level!=winat) {
				   createBlocks(level);
			   }
		   }
			//set up the double buffering to make the game animation nice and smooth
			Graphics2D twoDGraph = (Graphics2D)window;

			//take a snap shop of the current screen and same it as an image
			//that is the exact same width and height as the current screen
			if(back==null)
			   back = (BufferedImage)(createImage(getWidth(),getHeight()));

			//create a graphics reference to the back ground image
			//we will draw all changes on the background image
			Graphics graphToBack = back.createGraphics();
			graphToBack.setColor(Color.WHITE);
			graphToBack.fillRect(0, 0, 800, 800);
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("Level: " + level, 500, 100);
			graphToBack.setColor(Color.RED);
			Block rightWall = new Block(775, 0, 50, 600, Color.BLACK);
			Block leftWall = new Block(0, 0, 10, 600, Color.BLACK);
			Block topWall = new Block(0, 0, 800, 10, Color.BLACK);
			Block bottomWall = new Block(0, 551, 800, 10, Color.BLACK);
			topWall.draw(graphToBack);
			bottomWall.draw(graphToBack);
			rightWall.draw(graphToBack);
			leftWall.draw(graphToBack);
			
			if(level==winat || level==-1) {
				graphToBack.drawString("YOU WIN!", 250, 250);
				level=-1;
			}
			for(int i = 0; i<blocks.size(); i++){
				blocks.get(i).draw(graphToBack);
			}
			ball.moveAndDraw(graphToBack);
			paddle.draw(graphToBack);
			
			//see if ball hits left wall or right wall
			if(ball.didCollideRight(rightWall)){
				ball.setXSpeed(0-ball.getXSpeed());
			}
			else if(ball.didCollideLeft(leftWall)){
				ball.setXSpeed(0-ball.getXSpeed());
			}

			
			//see if the ball hits the top or bottom wall 
			if(ball.didCollideTop(topWall)){
				ball.setYSpeed(0-ball.getYSpeed());
			}
			else if(ball.didCollideBottom(bottomWall)){
				ball.setYSpeed(0-ball.getYSpeed());
			}

			//see if ball hits paddles
			if(ball.didCollideRight(paddle)){
				ball.setXSpeed(0-ball.getXSpeed());
			}
			else if(ball.didCollideLeft(paddle)){
				ball.setXSpeed(0-ball.getXSpeed());
			}
			else if(ball.didCollideTop(paddle)){
				ball.setYSpeed(0-ball.getYSpeed());
			}
			else if(ball.didCollideBottom(paddle)){
				ball.setYSpeed(0-ball.getYSpeed());
			}
			
			//see if ball hits the blocks
			for(int i = 0; i<blocks.size(); i++){
				if(ball.didCollideRight(blocks.get(i))){
					ball.setXSpeed(0-ball.getXSpeed());
					blocks.remove(i);
				}
				else if(ball.didCollideLeft(blocks.get(i))){
					ball.setXSpeed(0-ball.getXSpeed());
					blocks.remove(i);
				}
				else if(ball.didCollideTop(blocks.get(i))){
					ball.setYSpeed(0-ball.getYSpeed());
					blocks.remove(i);
				}
				else if(ball.didCollideBottom(blocks.get(i))){
					ball.setYSpeed(0-ball.getYSpeed());
					blocks.remove(i);
				}
			}
			
			
			//see if the paddles need to be moved
			ball.moveAndDraw(graphToBack);
			paddle.draw(graphToBack);
			
			if(keys[0] == true)
			{
				paddle.moveLeftAndDraw(graphToBack);
			}
			if(keys[1] == true)
			{
				paddle.moveRightAndDraw(graphToBack);
			}
			if(keys[2] == true)
			{
				paddle.moveDownAndDraw(graphToBack);
			}
			if(keys[3] == true)
			{
				paddle.moveUpAndDraw(graphToBack);
			}
			
			twoDGraph.drawImage(back, null, 0, 0);
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
		}

		public void keyTyped(KeyEvent e){}
		

		
		public void createBlocks(int level){
			int x = 10;
			int y = 10;
			int counter = 0;
			int h = 17;
			int v = 10;
			for (int z=0; z<2; z++) {
				for(int j=0; j<level; j++){
					for(int i = 0; i<h; i++){
						blocks.add(new Block(x, y, 45, 45, colors.get(counter)));
						counter++;
						if(counter==colors.size()){
							counter=0;
						}
						x+=45;
					}
					x=x-45;
					y=y+45;
					for(int i=0; i<v; i++){
						blocks.add(new Block(x, y, 45, 45, colors.get(counter)));
						counter++;
						if(counter==colors.size()){
							counter=0;
						}
						y+=45;
					}
					for(int i = 0; i<h; i++){
						blocks.add(new Block(x, y, 45, 45, colors.get(counter)));
						counter++;
						if(counter==colors.size()){
							counter=0;
						}
						x=x-45;
					}
					y=y-45;
					x=x+45;
					for(int i = 0; i<v; i++){
						blocks.add(new Block(x, y, 45, 45, colors.get(counter)));
						counter++;
						if(counter==colors.size()){
							counter=0;
						}
						y=y-45;
					}
				}
				h=h-2;
				v=v-2;
				x=55;
				y=55;
				counter=2;
			}
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
