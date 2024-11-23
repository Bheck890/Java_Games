package snakeCode;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class AI_Snake_BackGround extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    
    
    private int[] snakexlength = new int [750]; // Set max X
    private int[] snakeylength = new int [750]; // Set max Y
    
    // Direction
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    
    private boolean paint = true;
    
    private boolean Hit_End = true; 
    private boolean yn = true;
    
    
    private ImageIcon Head;
    private ImageIcon Body;
    
    private ImageIcon Fruit;
    private int FruitNum;
    
    
    private int lengthofsnake = 1;
    
    private Timer timer; //sets the delay between (made for Regular intervals
    
    private int delay = 100;//100; // delay between every time it moves 
    
    public static JPanel jp = new JPanel();
    public int Frame_25 = 21;
    private int FX;
    private int FY;
    
    // Set so it gets the frame of the game and divides by 25 then -1 and sets as the length of the array depending on X or Y Array
    private int FX_pos[] = new int[Frame_25]; 
    private int FY_pos[] = new int[Frame_25];
       
    private Random random = new Random(); // Creates a random number with more options compared to Math.random....
    Snake_Obects_CORE AI = new Snake_Obects_CORE();
	
	
    
	
	public void Snake_AI() {
		//setVisible(true);
        //setFocusable(true);
        //setFocusTraversalKeysEnabled(false);
    	
        
        
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
    	
    	timer = new Timer(delay, this);
    	timer.start();
    	direction(1);
    	
    	snakexlength[0] = -75;
    	snakeylength[0] = -75;
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(paint) {
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
    		
    		if(yn) //Flips from top/left to bottom/right
    		{
    			yn = false;
    		}
    		else
    		{
    			yn = true;
    		}
    		
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
        	System.out.println("New X,Y of fruit = " + FX_pos[FX] + ", " + FY_pos[FY]);
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
		}
		else {
			System.out.println("Empty Snake");
		}
		
		
	}
	
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
	
	
	public void direction(int dir) {
		/*
		 * 1 = right
		 * 2 = left
		 * 3 = up
		 * 4 = down
		 */
		if(dir == 1)
		{
			//System.out.println("Right");
			//moves++;
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
		
		if(dir == 2)
		{
			//System.out.println("Left");
			//moves++;
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
		if(dir == 3)
		{
			//System.out.println("Up");
			//moves++;
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
		if(dir == 4)
		{
			//System.out.println("Up");
			//moves++;
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
	public void actionPerformed(ActionEvent arg0) {

		
		// TODO Auto-generated method stub
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
					snakexlength[r] = snakexlength[r] + 25; // Moves to the right 25 in action for the head
				}
				else
				{
					snakexlength[r] = snakexlength[r-1]; // moves the snake variable to the other parts of the body
				}
				if(snakexlength[r] > 575) // IF HIT EDGE
				{
					//snakexlength[r] = 0;
					Hit_End = true;
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
					snakexlength[r] = snakexlength[r] - 25; // Moves to the right 25 in action for the head
				}
				else
				{
					snakexlength[r] = snakexlength[r-1]; // moves the snake variable to the other parts of the body
				}
				if(snakexlength[r] < 0) // If hit EDGE
				{
					//snakexlength[r] = 575;
					Hit_End = true;
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
					snakeylength[r] = snakeylength[r] - 25; // Moves to the right 25 in action for the head
				}
				else
				{
					snakeylength[r] = snakeylength[r-1]; // moves the snake variable to the other parts of the body
				}
				if(snakeylength[r] < 0) // If hit EDGE
				{
					//snakeylength[r] = 575;
					Hit_End = true;
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
					snakeylength[r] = snakeylength[r] + 25; // Moves to the right 25 in action for the head
				}
				else
				{
					snakeylength[r] = snakeylength[r-1]; // moves the snake variable to the other parts of the body
				}
				if(snakeylength[r] > 575) // If hit EDGE
				{ 
					//snakeylength[r] = 0;
					Hit_End = true;
				}
				repaint(); //calls paint method to change the look of the snake on the screen to move
					
			}
		}
		
		
		if(Hit_End)
		{
			if(yn)
			{
				int f = random.nextInt(2);
				if(f == 0)
				{
					snakexlength[0] = FX_pos[random.nextInt(Frame_25)];
					snakeylength[0] = 0;
					lengthofsnake = random.nextInt(4) + 4;
					direction(4);
					delay = random.nextInt(2000) + 50;
					//System.out.println("x: delay: " + delay + " Length: " + lengthofsnake);
					Hit_End = false;
				}
				else
				{
					snakeylength[0] = FX_pos[random.nextInt(Frame_25)];
					snakexlength[0] = 0;
					lengthofsnake = random.nextInt(4) + 4;
					direction(1);
					delay = random.nextInt(2000) + 50;
					//System.out.println("y: delay: " + delay + " Length: " + lengthofsnake);
					Hit_End = false;
				}
			
			}
			else
			{
				int f = random.nextInt(2);
				if(f == 0)
				{
					snakexlength[0] = FX_pos[random.nextInt(Frame_25)];
					snakeylength[0] = 580;
					lengthofsnake = random.nextInt(4) + 4;
					direction(3);
					delay = random.nextInt(2000) + 50;
					//System.out.println("x: delay: " + delay + " Length: " + lengthofsnake);
					Hit_End = false;
				}
				else
				{
					snakeylength[0] = FX_pos[random.nextInt(Frame_25)];
					snakexlength[0] = 580;
					lengthofsnake = random.nextInt(4) + 4;
					direction(2);
					delay = random.nextInt(2000) + 50;
					//System.out.println("y: delay: " + delay + " Length: " + lengthofsnake);
					Hit_End = false;
				}
			}
		}
		
		
		
		
	 }
	
	
	public void stop() {
		System.out.println("AI _ RESET BACK");
		timer.stop();
		paint = false;
		repaint();
		jp.removeAll();
		
	}



}



