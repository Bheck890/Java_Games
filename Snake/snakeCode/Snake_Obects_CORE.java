package snakeCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import ScoreTrack.ScoreProxy;
import frames.Frame;


public class Snake_Obects_CORE extends JPanel implements ActionListener,KeyListener{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    private int moves = 0; // keeps track of how many moves you have done
    
    
    private int[] snakexlength = new int [750]; // Set max X / Max number of snake parts
    private int[] snakeylength = new int [750]; // Set max Y / Max number of snake parts
    
    // Direction
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private boolean over = false;
    private boolean stop = false;
    
    
    private boolean paint = true;
    
    //images context to pull
    private ImageIcon Head;
    private ImageIcon Body;
    
    private ImageIcon Fruit;
    private int FruitNum;
    
    
    
    private int restart;
    private int lengthofsnake = 3;
    
    private Timer timer; //sets the delay between (made for Regular intervals
    
    private int delay = 100;//100; // delay between every time it moves 
    
    
    public int Frame_25 = 21;
    private int FX;
    private int FY;
    
    public boolean selectD = true;
    public boolean easy = true;//true;
    public boolean medium = false;
    public boolean hard = false;
    
    private int size = 25; // sets the default size of the snake and fruit
    
    
 // Set so it gets the frame of the game and divides by 25 then -1 and sets as the length of the array depending on X or Y Array
    private int FX_pos[] = new int[Frame_25]; 
    private int FY_pos[] = new int[Frame_25];
    
    private Random random = new Random(); // Creates a random number with more options compared to Math.random....
    
    
    public int Score = 0;
    public String Level = "NONE";
    
    
    public void SnakeGame() {
    
    	System.out.println("BEGIN GAME");
    	setVisible(true);
    	addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    	
        
    	
    	// Sets possible areas for fruit to spawn depending on the size of the frame :)
    	FX_pos[0] = 50;
    	FY_pos[0] = 50;
    	for(int b = 1; b < FX_pos.length;b++)
    	{
    		
    		FX_pos[b] = FX_pos[b-1] + 25;
    	}
    	for(int b = 1; b < FY_pos.length;b++)
    	{
    		
    		FY_pos[b] = FY_pos[b-1] + 25;
    	}
    	paint = true;
    	
    	// DEBUG POSSIBLE AREAS FOR FRUIT shows X and Y
    	// Forgot For AS loop  ¯\_(ツ)_/¯
    	
    	/*
    	for(int c = 0;c < FX_pos.length;c++)
    	{
    		System.out.println("X");
    		System.out.print(FX_pos[c] + " ,");
    		
    		System.out.println("Y");
    		System.out.print(FY_pos[c] + " ,");
    	}
    	*/
    	
    	
    	
    	if(easy)
		{
    		delay = 150;
    		Level = "Easy";
		}
		if(medium)
		{
			delay = 100;
			Level = "Medium";
		}
		if(hard)
		{
			delay = 90;
			Level = "Hard";
		}
    	
		System.out.println("Level: " + Level);
		
		timer = new Timer(delay, this);
    	timer.start();
    	
    }

    public void Components(JFrame jf)
    {
    	
    	JLabel lblScore = new JLabel("Score");
		lblScore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblScore.setBounds(526, 11, 46, 14);
		jf.add(lblScore);
		jf.setVisible(true);
		
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLevel.setBounds(445, 11, 46, 14);
		jf.add(lblLevel);
		jf.setVisible(true);
		
		JLabel lblLevel2 = new JLabel(Level);
		lblLevel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLevel2.setBounds(450, 25, 46, 20);
		jf.add(lblLevel2);
		jf.setVisible(true);
		
    }
    
    
    
    
	@Override
	public void paintComponent(Graphics g) {   // this is where all the OBJECTS are being created and it is looped on the timer to loop ALLOT
		super.paintComponent(g);
    	//System.out.println("Paint");
    	
		if(paint) {
		
    	if(moves == 0) //START
    	{
    		snakexlength[2] = 50;
    		snakexlength[1] = 75;
    		snakexlength[0] = 100;
    		
    		snakeylength[2] = 100;
    		snakeylength[1] = 100;
    		snakeylength[0] = 100;
    		
    		
    		if(restart == 0)
    		{
    			FX = random.nextInt(Frame_25);
            	FY = random.nextInt(Frame_25); // put in here for when game starts it gets called once when snake gets created
    		}
			
        	
    	}
    	
    	if(moves == 0)
    	{
    		g.setColor(Color.BLACK);
			g.setFont(new Font("arial", Font.PLAIN,20));
			g.drawString("Press \"Q\" to pause and \"E\" to resume", 50, 200);
			/*
			g.drawString("Default is Easy", 100, 225);
			g.drawString("Move for Easy", 100, 250);
			g.drawString("Press 2 for Medium", 100, 275);
			g.drawString("Press 3 for Hard", 100, 300);
			//g.drawString("press space to restart", 150, 300);
			 */
    	}
    	else
    	{
    		
    	}
    	
    	// Creates Menu top
    	g.setColor(Color.GRAY);
		g.fillRect(10,10, 570, 40);
		
		//Create Score number
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN,20));
		g.drawString(""+Score, 550, 40); // the ""+score allows me to put a variable that is changing to display as it is being called on a loop
		
		//Create Level number
		//g.drawString(Level, 15, 41);
		
		
		
		// easy way to IDentify this is that the snake is a slowed down array that changes X and Y by 25 so when it hits 0 the main one has all ready changed creating a moving effect
		
		// Creates the Body of the snake
    	for(int a = 0; a< lengthofsnake;a++) //every part of the body needs a shape the for is an easy way to put it on all parts as it gets longer
    	{
    		//System.out.println(a); // to show the change of a to the of length	
    		Body = new ImageIcon(getClass().getResource("/snake/Bod.png"));
    		Body.paintIcon(this, g, snakexlength[a], snakeylength[a]);
    	}
    	
    	//snake eats fruit that changes
    	if((snakexlength[0] == FX_pos[FX]) &&(snakeylength[0] == FY_pos[FY]))
    	{
    		FruitNum = random.nextInt(3);
    		Score += 5;
    		lengthofsnake++;
    		
    		FX = random.nextInt(Frame_25);
        	FY = random.nextInt(Frame_25); // Generates new X and Y and Creates new Fruit somewhere else
        	
        	for(int e = 0; e< lengthofsnake;e++){
    			if((FX_pos[FX] == snakexlength[e]) &&(FY_pos[FY] == snakeylength[e]))
    			{
    				System.out.println("Fruit caught in snake = " + FX_pos[FX] + ", " + FY_pos[FY]);
    				FX = random.nextInt(Frame_25);
    	        	FY = random.nextInt(Frame_25);
    			}
        	}
        	//System.out.println("New X,Y of fruit = " + FX_pos[FX] + ", " + FY_pos[FY]);
    	}
    	//draws fruit first time
    	this.DrawFruit(g);
		
    	//Draws head of snake
    	Head = new ImageIcon(getClass().getResource("/snake/H_R.png"));
		Head.paintIcon(this, g, snakexlength[0], snakeylength[0]);
    	//Draws Head of snake depend on direction
		for(int e = 0; e < lengthofsnake;e++)
		{
			if(e==0 && right)
			{
				Head = new ImageIcon(getClass().getResource("/snake/H_R.png"));
				Head.paintIcon(this, g, snakexlength[e], snakeylength[e]);
			}
			if(e==0 && left)
			{
				Head = new ImageIcon(getClass().getResource("/snake/H_L.png"));
				Head.paintIcon(this, g, snakexlength[e], snakeylength[e]);
			}
			if(e==0 && up)
			{
				Head = new ImageIcon(getClass().getResource("/snake/H_U.png"));
				Head.paintIcon(this, g, snakexlength[e], snakeylength[e]);
			}
			if(e==0 && down)
			{
				Head = new ImageIcon(getClass().getResource("/snake/H_D.png"));
				Head.paintIcon(this, g, snakexlength[e], snakeylength[e]);
			}
		}
		//calls when it is game over
		for(int d = 1; d< lengthofsnake;d++) // Game Over
		{
			if((snakexlength[d] == snakexlength[0]) &&(snakeylength[d] == snakeylength[0]))
			{
				System.out.println("Snake Hit Himself1");
				timer.stop();
				//timer.restart();
				
				over = true;
				stop = true;
				System.out.println("STOP " + paint);
				if(over)
				{
					
					this.GO(g);
				}
				stop();
			}
		}
		
		}
		else
		{
			System.out.println("Paint called second time");
		}
    	
    }
	
	// reuse code for drawing the different fruits
	private void DrawFruit(Graphics g) {
		
		if(FruitNum == 0)
		{
			Fruit = new ImageIcon(getClass().getResource("/snake/fruit/Tomato.png")); //strawberry
			Fruit.paintIcon(this, g, FX_pos[FX],FY_pos[FY]);
		}
		if(FruitNum == 1)
		{
			Fruit = new ImageIcon(getClass().getResource("/snake/fruit/Orange.png")); //orange
			Fruit.paintIcon(this, g, FX_pos[FX],FY_pos[FY]);
		}
		if(FruitNum == 2)
		{
			Fruit = new ImageIcon(getClass().getResource("/snake/fruit/Blueberry.png")); //blueberry
			Fruit.paintIcon(this, g, FX_pos[FX],FY_pos[FY]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) { 
		// Action performed on the TImer delay Interval
		//System.out.println("Action On Timer"); //debug to show
		//
		timer.start();
		
		
		if(right)
		{
			
			for(int r = lengthofsnake - 1; r>=0 ;r--)
			{
				snakeylength[r+1] = snakeylength[r]; // moves y variable across the array to the next body shift
			}
			for(int r = lengthofsnake; r>=0 ;r--)
			{
				if(r == 0 )
				{
					snakexlength[r] = snakexlength[r] + size; // Moves to the right 25 in action for the head
				}
				else
				{
					snakexlength[r] = snakexlength[r-1]; // moves the snake variable to the other parts of the body
				}
				if(snakexlength[r] > 575) // IF HIT EDGE
				{// Depend on difficulty ends the game
					if(easy)
					{
						snakexlength[r] = 0;
					}
					if(medium)
					{
						snakexlength[r] = 0;
					}
					if(hard)
					{
						this.stop();
					}
					
					
				}
				repaint(); //calls paint method to change the look of the snake on the screen to move
				
			}
		}
		if(left)
		{
			for(int r = lengthofsnake - 1; r>=0 ;r--)
			{
				snakeylength[r+1] = snakeylength[r]; // moves y variable across the array to the next body shift
			}
			for(int r = lengthofsnake; r>=0 ;r--)
			{
				if(r == 0 )
				{
					snakexlength[r] = snakexlength[r] - size; // Moves to the right 25 in action for the head
				}
				else
				{
					snakexlength[r] = snakexlength[r-1]; // moves the snake variable to the other parts of the body
				}
				if(snakexlength[r] < 0) // If hit EDGE
				{// Depend on difficulty ends the game
					if(easy)
					{
						snakexlength[r] = 575;
					}
					if(medium)
					{
						snakexlength[r] = 575;
					}
					if(hard)
					{
						this.stop();
					}
					
					
				}
				repaint(); //calls paint method to change the look of the snake on the screen to move
				
			}
		}
		if(up)
		{
			for(int r = lengthofsnake - 1; r>=0 ;r--)
			{
				snakexlength[r+1] = snakexlength[r]; // moves y variable across the array to the next body shift
			}
			for(int r = lengthofsnake; r>=0 ;r--)
			{
				if(r == 0 )
				{
					snakeylength[r] = snakeylength[r] - size; // Moves to the right 25 in action for the head
				}
				else
				{
					snakeylength[r] = snakeylength[r-1]; // moves the snake variable to the other parts of the body
				}
				if(snakeylength[r] < 50) // If hit EDGE
				{// Depend on difficulty ends the game
					if(easy)
					{
						snakeylength[r] = 550;
					}
					if(medium)
					{
						this.stop();
					}
					if(hard)
					{
						this.stop();
					}
					
					
				}
				repaint(); //calls paint method to change the look of the snake on the screen to move
					
			}
		}
		if(down)
		{
			for(int r = lengthofsnake - 1; r>=0 ;r--)
			{
				snakexlength[r+1] = snakexlength[r]; // moves y variable across the array to the next body shift
			}
			for(int r = lengthofsnake; r>=0 ;r--)
			{
				if(r == 0 )
				{
					snakeylength[r] = snakeylength[r] + size; // Moves to the right 25 in action for the head
				}
				else
				{
					snakeylength[r] = snakeylength[r-1]; // moves the snake variable to the other parts of the body
				}
				if(snakeylength[r] > 555) // If hit EDGE
				{ // Depend on difficulty ends the game
					if(easy)
					{
						snakeylength[r] = 50;
					}
					if(medium)
					{
						this.stop();
					}
					if(hard)
					{
						this.stop();
					}
					
					
				}
				repaint(); //calls paint method to change the look of the snake on the screen to move
					
			}
		}
		
		// Level Up Here
		  // change the delay time to faster
		  // change the rules to not escape the box
		  // make the box smaller
		  // 
		/*
		for(int d = 1; d< lengthofsnake;d++) // Game Over
		{
			if((snakexlength[d] == snakexlength[0]) &&(snakeylength[d] == snakeylength[0]))
			{
				System.out.println("Snake Hit Himself2");
				stop = true;
				
				//((Timer)evt.getSource()).stop();
				//timer.removeActionListener(this);
				//timer.stop();
				
				//stop();
			}
		}
		*/
		
		///*
		if(stop){
			System.out.println("Stop action");
			((Timer)evt.getSource()).stop();
			
			((Timer)evt.getSource()).stop();
			timer.stop();
			stop();
			
			
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// CONTROLS ************************
		//System.out.println("Press");
		/*
		if((e.getKeyCode() == KeyEvent.VK_SPACE))
		{
			if(over)
			{
				System.out.println("GAME RESTART");
				Score = 0;
				moves = 0;
				lengthofsnake = 3;
				restart++;
				
				over = false;
				repaint();
				timer.start();
				
				FX = random.nextInt(Frame_25);
            	FY = random.nextInt(Frame_25);
			}
			
		}
		*/			
		
		if((e.getKeyCode() == KeyEvent.VK_2))
		{
			System.out.println("2");
			if(selectD && moves < 1)
			{
				System.out.println("Med");
				easy = false;
				medium = true;
				hard = false;
				selectD = false;
						
			}
		}
		if((e.getKeyCode() == KeyEvent.VK_3))
		{
			System.out.println("3");
			if(selectD && moves < 1)
			{
				System.out.println("Hrd");
				easy = false;
				medium = false;
				hard = true;
				selectD = false;
			}
		}
		
		
		
		if((e.getKeyCode() == KeyEvent.VK_Q))
		{
			timer.stop();
		}
		if((e.getKeyCode() == KeyEvent.VK_E))
		{
			timer.start();
		}
		
		
		if((e.getKeyCode() == KeyEvent.VK_RIGHT) || (e.getKeyCode() == KeyEvent.VK_D))
		{
			//System.out.println("Right");
			moves++;
			right = true;
			if(!left) // can not turn right while going left it would turn into it's self
			{
				right = true;
			}
			else
			{
				right = false;
				left = true;
			}
			up = false;
			down = false;
		}
		
		if((e.getKeyCode() == KeyEvent.VK_LEFT) || (e.getKeyCode() == KeyEvent.VK_A))
		{
			//System.out.println("Left");
			moves++;
			left = true;
			if(!right) // can not turn Left while going right it would turn into it's self
			{
				left = true;
			}
			else
			{
				left = false;
				right = true;
			}
			up = false;
			down = false;
		}
		if((e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_W))
		{
			//System.out.println("Up");
			moves++;
			up = true;
			if(!down) // can not turn down while going up it would turn into it's self
			{
				up = true;
			}
			else
			{
				up = false;
				down = true;
			}
			right = false;
			left = false;
		}
		if((e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_S))
		{
			//System.out.println("Down");
			moves++;
			down = true;
			if(!up) // can not turn up while going down it would turn into it's self
			{
				down = true;
			}
			else
			{
				down = false;
				up = true;
			}
			right = false;
			left = false;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("Released");
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("Typed");
	}
	
	
	public static void OutStop() {
		System.out.println("Stop From Static");
		Frame.jf2.getContentPane().setVisible(false);
		Frame.jf2.dispose();
		Frame.jf2.getContentPane().removeAll();
	}
	
	public void stop() {
		System.out.println("RESET BACK6");
		setVisible(false);
		timer.stop();
		removeAll();
		paint = false;
		
		setBackground(Color.cyan);
		ScoreProxy.SnakeOver(Score,Level);
		
		
		//setVisible(false);
	}
	
	public void GO(Graphics g)
	{
		//over = true;
		
		g.setColor(Color.RED);
		g.setFont(new Font("arial", Font.PLAIN,30));
		g.drawString("Game Over", 150, 150); // Display game over
		g.setColor(Color.BLACK);
		g.drawString("press space to restart", 150, 300); // Display game over
		timer.stop();
	}
	
	
}
