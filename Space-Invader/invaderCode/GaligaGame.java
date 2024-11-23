package invaderCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import ScoreTrack.ScoreProxy;
import frames.Frame;
import invaderObjects.*;




@SuppressWarnings("serial")
public class GaligaGame extends JPanel implements KeyListener, ActionListener{
	
	
	/*
	 * TODO
	 * Rename this to Space Invaders ^
	 * Life variable on alien ships 5 life ^
	 * Levels that get faster and more laser frequency ^
	 * power ups: life, more laser, to fire, faster lasers, ....
	 * Add Images and Window Graphics (images, Background, Game over High score, ETC
	 * 
	 * #Space Invaders
	 * 
	 * then create Galaga from this code
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * set game over screen
	 * add graphics
	 * 
	*/
	
	public boolean leftPressed = false;
	public boolean rightPressed = false;
	public boolean firePressed = false;
	
	int dir_AE = 0; //direction for alien ships goes left or right
	
	
	int Left = 20; //Max Left X Barrier
	int Right = 550; // Max right X Barrier
	
	//Game Integers
	int Score = 0;
	int level = 1;
	int wave = 1;
	int life = 5;
	
	//Alien Ints
	int RandomAlienFire = 998;
	int fast = 0;
	
	//Alien ammount
	int ARShips = 10;
	int ALLShips = 0;
	int A1Ships = 0;
	int A2Ships = 0;
	int A3Ships = 0;
	int A4Ships = 0;
	
	
	
	int currentLZ = 0; //number of lasers on screen
	int s = 0; // used to create positions of the laser traveling
	
	int[] PathUp = new int[50];
	int[] next = new int[100];
	int num = 35; //middle number that is 240 in next int array
	
	
	
	//blue orange yellow red
	ArrayList<Lazer> LZ2 = new ArrayList<Lazer>(); //Alien Laser
	ArrayList<Lazer> LZ3 = new ArrayList<Lazer>(); //Player Laser
	
	ArrayList<Ship> ShipLife = new ArrayList<Ship>(); //Ship life spots
	ArrayList<AlienShip> AShip = new ArrayList<AlienShip>(); //Easy Aliens //blue
	
	Ship S = new Ship(285,450); // new ship and with start cords
	Timer timer; //Ship
	Timer timer2; // Aliens
	Timer timer3; // Alien Lasers
	Timer timer4; // Player Lasers
	
	//KeyInputHandler KH = new KeyInputHandler();
	
	public void Start()
	{
		System.out.println("Game is Called");
		setFocusable(true);
		addKeyListener(this);
		setFocusTraversalKeysEnabled(false);
		
		setCords();
		createLazerPath();
		DrawAliens();
		DrawLifeShips();
		
		JLabel lblVersion = new JLabel("Score: ");
		lblVersion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVersion.setForeground(Color.BLACK);
		lblVersion.setBounds(450, 15, 224, 19);
		Frame.jf3.add(lblVersion);
		
		JLabel lblVersion2 = new JLabel("Wave: ");
		lblVersion2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVersion2.setForeground(Color.BLACK);
		lblVersion2.setBounds(350, 15, 224, 19);
		Frame.jf3.add(lblVersion2);
		
		
		timer = new Timer(75, this); //Player Ship
		timer.start();
		
		timer2 = new Timer(700, this::timerTwoMethod); //Aliens
		timer2.start();
		
		timer3 = new Timer(400, this::timerThreeMethod); //Lasers
		timer3.start();
		
		timer4 = new Timer(100, this::timerFourMethod); //Player Lasers
		timer4.start();
	}
	
	public void NextWave()
	{
		// New wave
		wave++;
		fast = 0;
		timer2.setDelay(((timer2.getDelay())-150));
		//Increse Frequency of lasers
		RandomAlienFire = RandomAlienFire - 2;
		
		//remove all lazers
		LZ2.clear();
		LZ3.clear();
		currentLZ = 0;
		
		//Add life with 8 lives being max
		if(!(life == 8))
		{
			life++;
			DrawLifeShips();
		}
		
		//New Ships for new wave
		A1Ships = 0;
		A2Ships = 0;
		A3Ships = 0;
		A4Ships = 0;
		DrawAliens();
		
		
	}
	
	public void setCords()
	{
		next[0] = Left; // set farthest left
		for(int i = 1; i < next.length; i++)
		{
			next[i] = next[i-1] + 8; // moving speed (by pixel)
			//System.out.println((i) + ": " + next[i]);
			if(next[i] == Right) //stops the array from geting bigger
			{
				i = next.length;
			}
		}
	}
	
	private void createLazerPath()
	{
		for(int i = 415; i >= 15; i= i - 20) //Laser Speed
		{
			PathUp[s] = i;
			//System.out.println(s);
			s++;
		}
		//System.out.println(s);
	}
	
	private void DrawLifeShips()
	{
		ShipLife.clear();
		int x = 30;
		for(int i = 0; i<life;i++)
		{
			ShipLife.add(new Ship(x,530)); //30 is how far from left side
			x= x + 45; //Seperate space between ships
		}
		
	}
	
	
	private void DrawAliens()//200.150,100,50
	{
		
		int x = 12; // Start Number for Alien Ships on next array
		int y = 205; // 205,250
		int ychange = 35; //35,50
		for(int i = 0; i < ARShips;i++)
		{
			
			//System.out.println(next[x]);
			AShip.add(new AlienShip(next[x] ,y,1)); // 50 is the start y 
			x = x + 5; //the Space away
			//ALLShips++;
			A1Ships++;
			ALLShips++;
		}
		
		x = 12;
		y = y - ychange;
		for(int i = 0; i < ARShips;i++)
		{
			
			//System.out.println(next[x]);
			AShip.add(new AlienShip(next[x] ,170,2)); // 50 is the start y 
			x = x + 5; //the Space away
			//ALLShips++;
			A2Ships++;
			ALLShips++;
		}
		
		x = 12;
		y = y - ychange;
		for(int i = 0; i < ARShips;i++)
		{
			
			//System.out.println(next[x]);
			AShip.add(new AlienShip(next[x] ,135,3)); // 50 is the start y 
			x = x + 5; //the Space away
			//ALLShips++;
			A3Ships++;
			ALLShips++;
		}
		
		x = 12;
		y = y - ychange;
		for(int i = 0; i < ARShips;i++)
		{
			
			//System.out.println(next[x]);
			AShip.add(new AlienShip(next[x] ,100,4)); // 50 is the start y 
			x = x + 5; //the Space away
			//ALLShips++;
			A4Ships++;
			ALLShips++;
		}
		
		
	}
	
	
	 private void timerTwoMethod(ActionEvent e) // Alien Ship Move
	 {
		//Alien Ships Move
			
			//timer.setDelay(500);
			// by (pixels)
		 	
			//ALL Movement for Easy Ships
			for(int i = 0; i < AShip.size(); i++)
	    	{
				
				//Down and shift
				if((AShip.get(i).getx() > 532) && (dir_AE == 0)) // alien go right
				{
					//System.out.println("R");
					dir_AE = 1;
					AShipDown();
				}
				else if((AShip.get(i).getx() < 50) && (dir_AE == 1)) //alien go left
				{
					//System.out.println("L");
					dir_AE = 0;
					AShipDown();
				}
	    	}
			
			//Move Right and Left
			if(dir_AE == 1)
			{
				AShipSide(1); //left
			}
			else if(dir_AE == 0) 
			{
				AShipSide(0); //right
			}
			if(timer2.getDelay() >= 150)
			{
				for(int i = 0; i < AShip.size(); i++)
		    	{
					if((AShip.get(i).gety() > 245) && (fast == 0))
					{
						System.out.println("Faster1");
						timer2.setDelay(((timer2.getDelay())-150));
						fast++;
					}
					if((AShip.get(i).gety() > 325) && (fast == 1))
					{
						System.out.println("Faster2");
						timer2.setDelay(((timer2.getDelay())-150));
						fast++;
					}
					if((AShip.get(i).gety() > 400) && (fast == 2))
					{
						System.out.println("Faster3");
						timer2.setDelay(((timer2.getDelay())-150));
						fast++;
					}
		    	}
				
			}
			else {}
			
			
	 }
		
	 public void AShipDown()
		{
			int A_Down = 15; //move down after a side
			for(AlienShip AE: AShip)
			{
				AE.sety(AE.gety() + A_Down);
			}
				
		}
			
			
			
		public void AShipSide(int S)
		{
			int A_Speed = 8; //move across the screen 
			
			if(S == 0) //Right
			{
				for(int a = 0; a < AShip.size(); a++)
				{
					AShip.get(a).setx(AShip.get(a).getx() + A_Speed);
				}
			}
			
			if(S == 1) //Left
			{
				for(int a = 0; a < AShip.size(); a++)
				{
						AShip.get(a).setx(AShip.get(a).getx() - A_Speed);
				}
			}
				
		}
		
	 
	
	
		
	
	private void timerThreeMethod(ActionEvent e) // Alien Lasers
	{
		//FIRE DA LASERS
		Laser_Level();
		
		for(Lazer LZ: LZ2)
		{
			LZ.sety(LZ.gety() + 20);
		}
				
		//remove the bullet if hit a y point
		for(int i = 0; i < LZ2.size(); i++)
	    {
			if(LZ2.get(i).gety() >= 480)
			{
				LZ2.remove(i);
			}
		}
				

				
		//remove the bullet if hit players Ship
		try
		{
			for(int i = 0; i < LZ2.size(); i++) //laser call info
		  	{
				if(LZ2.get(i).getx() >= S.getx()-15) //if in left side of ship
				{ //x left
					if(LZ2.get(i).getx() <= S.getx()+15) //if in right side of ship
					{ //x right
						if(LZ2.get(i).gety() >= S.gety()-20) //if in the bottom of the ship  
						{//y bottom
							if(LZ2.get(i).gety() <= S.gety()+20) //if in the top of the ship  
							{ //y top
								// you have been shot at
								ShipLife.remove(life-1);
								LZ2.remove(i);
								life--;
								System.out.println("Shot at" + life);
							}
						}
					}
				}
			}
		}
		catch(IndexOutOfBoundsException obj1)
		{
			System.out.println("Alien Hit Error");
		}
				
				
		// empty out the array
		if(LZ2.isEmpty())
		{
			LZ2.clear();
		}
	}
	
	public void Laser_Level()
	{
		
		for(int i = 0; i <= A1Ships; i++) //1/Low freqency
		{
			fireLaser(i,RandomAlienFire,1);
		}
		
		for(int i = 0; i < A2Ships; i++) //2/low-Medium freqency
		{
			int A2 = A1Ships + i;;
			fireLaser(A2,RandomAlienFire-2,2);
		}
		
		for(int i = 0; i < A3Ships; i++) //3/high-Hedium freqency
		{
			int A3 = A1Ships + A2Ships + i;;
			fireLaser(A3,RandomAlienFire-4,3);
		}
		
		for(int i = 0; i < A4Ships; i++) //4/Highfreqency
		{
			int A4 = A1Ships + A2Ships + A3Ships + i;;
			fireLaser(A4,RandomAlienFire-6,4);
		}
	}
	
	public void fireLaser(int AlienID, int Chance,int l)
	{
		int rand = (int) (Math.random()*1000);
		if(rand > Chance)
		{
			//System.out.println(l + " Shot Fired");
			LZ2.add(new Lazer(AShip.get(AlienID).getx(),AShip.get(AlienID).gety(),1));
		}
	}
	
		
	private void timerFourMethod(ActionEvent e) //Player Lasers
	{
		
		for(Lazer LZ: LZ3)
		{
			LZ.sety(PathUp[LZ.Pos]);
			LZ.setPost(LZ.Pos + 1);
		}
			
		//remove the bullet if hit top y point
		for(int i = 0; i < currentLZ; i++)
		{
			if(LZ3.get(i).gety() <= 25)
			{
				LZ3.remove(i);
				currentLZ--;
			}
        }
			

		boolean debug1 = false;	
		//remove the bullet if hit a Ship
		try
		{
			for(int i = 0; i < currentLZ; i++) //laser call info
	       	{
					
				// Easy ships
				for(int a = 0; a < AShip.size(); a++) // all alien ship call info
				{ 
					if(LZ3.get(i).getx() >= AShip.get(a).getx()-AShip.get(a).sizeHalf) //if in left side of ship
					{ //x left
						if(LZ3.get(i).getx() <= AShip.get(a).getx()+AShip.get(a).sizeHalf) //if in right side of ship
						{ //x right
							if(LZ3.get(i).gety() >= AShip.get(a).gety()-AShip.get(a).sizeHalf) //if in the bottom of the ship  
							{//y bottom
								if(LZ3.get(i).gety() <= AShip.get(a).gety()+AShip.get(a).sizeHalf) //if in the top of the ship  
								{ //y top
									//System.out.println("Shot");
									LaserScore(AShip.get(a));
									
									AShip.remove(a);
									removeLevelShip(AShip.get(a));
									ALLShips--;
									
									LZ3.remove(i);
									currentLZ--;
									debug1 = true;
									//System.out.println(ALLShips); //tells how many ships are left
								}
							}
						}
					}
				}
	        }
		}
		catch(IndexOutOfBoundsException obj1)
		{
			System.out.println("one bullet hit");
			
			if(!debug1)
			{
				currentLZ--;
				ALLShips--;
				//System.out.println("one hit on " + ALLShips); //removes the ships and catches the error to subtract the lazer
			}
			debug1 = false;
		}
			
			
		// empty out the array
		if(LZ3.isEmpty() || currentLZ == 0 )
		{
			LZ3.clear();
			currentLZ = 0;
		}
	}
	
	public void LaserScore(AlienShip AS)
	{
		if(AS.getL() == 1)
		{
			Score = Score + 15;
		}
		if(AS.getL() == 2)
		{
			Score = Score + 20;
		}
		if(AS.getL() == 3)
		{
			Score = Score + 35;
		}
		if(AS.getL() == 4)
		{
			Score = Score + 50;
		}
	}
	
	public void removeLevelShip(AlienShip AS)
	{
		if(AS.getL() == 1)
		{
			A1Ships--;
		}
		if(AS.getL() == 2)
		{
			A2Ships--;
		}
		if(AS.getL() == 3)
		{
			A3Ships--;
		}
		if(AS.getL() == 4)
		{
			A4Ships--;
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {  //User Ship Movement
		// TODO Auto-generated method stub
		//timer.start();
		//System.out.println("Test");
		Frame.jf3.setBackground(Color.BLACK);
		
		if((leftPressed) && (!rightPressed)){
			left();
		}
		else if((rightPressed) && (!leftPressed)) {
			right(); 
		}
		if(firePressed)
		{
			tryToFire();
		}
		repaint();
	}
	
	
	
	// paint to screen 
	
	public void paintComponent(Graphics g) // Repaint / Render
	{
		super.paintComponent(g);
		Frame.jf3.setBackground(Color.BLACK);
		
		//top menu
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(10, 8, 575, 30);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("arial", Font.PLAIN,17));
		g.drawString(""+Score, 500, 30);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("arial", Font.PLAIN,17));
		g.drawString(""+wave, 400, 30);
		
		
		//Boundaries
		/*
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(Left, 450, 25, 40);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(Right, 450, 25, 40);
		*/
		
		Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        
        S.paintComponent(g2d);
        
        
       	for(int i = 0; i < LZ3.size(); i++) //players Laser
        {
        	LZ3.get(i).paintComponent(g);
        	//System.out.println(LZ3.get(i).gety()); // get the y of each bullet
        }
        
        
        for(int i = 0; i < LZ2.size(); i++) //Alien laser
    	{
    		LZ2.get(i).paintComponent(g);
    		//System.out.println(LZ3.get(i).gety()); // get the y of each bullet
    	}
        
        for(int i = 0; i < ShipLife.size(); i++) //Ship life ships
    	{
        	ShipLife.get(i).paintComponent(g);
    		//System.out.println(LZ3.get(i).gety()); // get the y of each bullet
    	}
        
        for(int i = 0; i < AShip.size(); i++) //Alien Ships
    	{
        	AShip.get(i).paintComponent(g);
        	if(AShip.get(i).gety() >= S.gety()-30)
            {
            	GO(g); //GameOver
            }
    	} 
        
        if(ALLShips == 0)
        {
        	NextWave();
        	//Win(g); // you win // here until Create Difficulty rise
        	//System.out.println(ALLShips);
        }
        if(ShipLife.size() == 0)
        {
        	GO(g); // you win // here until Create Difficulty rise
        	//System.out.println(ALLShips);
        }
        
        
        
	}
	
	
	
	
	// Keyboard Controls
	
	public void tryToFire() {
        for(int i = 0; i <= currentLZ; i++)
        {
        	if((currentLZ == 0) || (LZ3.get(LZ3.size()-1).gety() < 393))//(When the next bullet can launch)
        	{
        		//System.out.println("Bullet created");
        		LZ3.add(new Lazer(S.getx()+8,S.gety()-30,0));
        		currentLZ++;
        	}
        	else
        	{
        		//System.out.println("No Bullet");
        	}
        }
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			//Fire Lazer
			firePressed = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			leftPressed = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			rightPressed = true;

		}
		
		
		//repaint();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//KH.keyReleased(e);
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			firePressed = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			leftPressed = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			rightPressed = false;
		}
	}
	
	
	
	public void left()
	{
		timer.setDelay(100);
		if(num > 1)
		{
			num = num - 1;
			S.setx(next[num]);
			//System.out.println(num);
		}
		
	}
	public void right()
	{
		timer.setDelay(100);
		if(num < 66)
		{
			num = num + 1;
			S.setx(next[num]);
			//System.out.println(num);
		}
		
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		//KH.keyTyped(e);
		// TODO Auto-generated method stub
		
	}
	
	
	public void GO(Graphics g)
	{
		//turn off the Frame
		System.out.println("Stop From Static");
		Frame.jf3.getContentPane().setVisible(false);
		Frame.jf3.dispose();
		Frame.jf3.getContentPane().removeAll();
		
		//Stop Game mechanicks
		timer.stop();
		timer2.stop();
		timer3.stop();
		timer4.stop();
		setVisible(false);
		removeAll();
		
		
		//Game Over
		ScoreProxy.SpaceOver(Score,wave);
		g.setColor(Color.RED);
		g.setFont(new Font("arial", Font.PLAIN,30));
		g.drawString("Game Over", 150, 150); // Display game over
	}
	public void Win(Graphics g)
	{
		//Game Over
		timer.stop();
		timer2.stop();
		timer3.stop();
		timer4.stop();
		g.setColor(Color.green);
		g.setFont(new Font("arial", Font.PLAIN,30));
		g.drawString("You Won: " + Score, 150, 150); // Display you won and score
		
	}



	
}
