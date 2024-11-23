package brickCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import java.sql.Time;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import frames.Frame;
import objects.*;

import java.util.Date;


@SuppressWarnings("serial")

/*
 * ToDO
 * Create levels with diffrent shapes
 * Add Power boosters
 * 
 * 
 */
public class brickCode extends JPanel implements KeyListener, ActionListener, MouseListener{

	int[] Pos = new int[100];
	
	public boolean pause = false;
	public boolean move = false;
	
	
	
	public boolean onLeft = false;
	public boolean onRight = false;
	public int tran = 0;
	
	
	public int fameStartTime;
	
	public int brickRow = 11;
	public int brickX = 30;
	public int brickY = 80;
	public int Bx = brickX;
	public int brickYSeperate = 25;
	
	public double angle = 3; //Slope
	public double angleX = angle;
	public double angleY = angle;
	
	public int padright = 440; // farthest x that th paddle can go
	public int right = 580; // right side of frame
	public int left = 4; //left side of frame
	
	public int speed = 37;
	public int horizontal;
	public int vertical;
	
	Date today = new Date();

	ArrayList<Brick> Br = new ArrayList<Brick>(); //bricks
	Paddle pad = new Paddle(300,525);
	Ball ball1 = new Ball(pad.getX(),pad.getY()-15);
	
	Timer timer;
	Timer timer2;
	
	public void Start()
	{
		System.out.println("Game is Called");
		setFocusable(true);
		addKeyListener(this);
		setFocusTraversalKeysEnabled(false);
        addMouseListener(this);
		
		fameStartTime = (int) today.getTime();
		
		CreateBricks(brickY,0);
		brickY = brickY + brickYSeperate;
		CreateBricks(brickY,1);
		brickY = brickY + brickYSeperate;
		CreateBricks(brickY,2);
		brickY = brickY + brickYSeperate;
		CreateBricks(brickY,3);
		brickY = brickY + brickYSeperate;
		CreateBricks(brickY,4);
		
		
		timer = new Timer(100, this::timerMethod); //Paddle Movement
		timer.start();
		
		timer2 = new Timer(speed, this::timerTwoMethod); // Ball Movement
		timer2.start();
		
		
	}
	
	public void Restart()
	{
		angleX = angle;
		angleY = angle;
		
		ball1.setX(pad.getX());
		ball1.setY(pad.getY()-15);
		
		timer.start();
		timer2.start();
	}
	
	public void CreateBricks(int Y, int ID)
	{
		
		for(int i = 0; i <= brickRow;i++)
		{
			Br.add(new Brick(Bx,Y,ID));
			Bx = Bx + 45;
		}
		Bx = brickX;
	}
	
	private void timerMethod(ActionEvent e) //Player Move
	{
		Frame.jf4.setBackground(Color.BLUE);
		
		//mouse controls
		Point b = Frame.jf4.getMousePosition();
		try
		{
			pad.setX(((int) b.getX())-48);
			if(!move && (pad.getX() < 443) && (pad.getX() > 5))
			{
				ball1.setX(pad.getX()+65);
			}
			
		}
		catch(NullPointerException e1)
		{
			//System.out.println("Left Boundries");
		}
		
		
		
		
		
		repaint();
	}
	
	private void timerTwoMethod(ActionEvent e) //Ball Move
	{
		
		if(move)
		{
			
		Direction(angleX,true);  //X
		Direction(angleY,false); //Y
		
		
		// bounce off of left and right boundries
		if(ball1.getX() >= right || ball1.getX() <= left)
		{
			angleX = angleX * -1;
		}
		
		//bounce off of the top
		if(ball1.getY() <= 30)  
		{
			angleY = angleY * -1;
		}
		
		
		onRight = (ball1.getX() >= pad.getX()+(pad.getWidth()/2));
		
		onLeft = (ball1.getX() <= pad.getX()+(pad.getWidth()/2));
		
		if(ball1.getY() <= 400)
		{
			if(!onRight)
			{
				tran = 1;
				//System.out.println("On Right side");
			}
			
			
			
			if(!onLeft)
			{
				tran = 2;
				//System.out.println("On Left side");
			}
			
		}
		// bounce off of the paddle
		if(ball1.getX() >= pad.getX())
		{//Left point
			if(ball1.getX() <= pad.getX()+pad.getWidth())
			{//Right point
				//System.out.println("Inside X boundries");
				
				
				
				//if(ball1.getY() >= pad.getY())
				if(ball1.getY() >= 515)
				{ //From the Top
					if(ball1.getY() <= pad.getY()+pad.getHeight())
					{//inside/ below the paddle
						
						
						
						
						//System.out.println("Inside Y2 boundries");
						if(onLeft && (tran == 1))  // from left side
						{//Left
							System.out.println("Stay on Left side");
							angleX = angleX * -1;
						}
						else if(onRight && (tran == 2))
						{//Right
							System.out.println("Stay on right side");
							angleX = angleX * -1;
						}
						
						angleY = angleY * -1;
						tran = 0;
					}
				}
			}
		}
		
		for(int i = 0; i < Br.size(); i++) //If hit a brick
	  	{
			if(ball1.getX() >= Br.get(i).getX()) //if in left side of ball
			{ //x left
				if(ball1.getX() <= Br.get(i).getX()+30) //if in right side of ball
				{ //x right
					
					
					if(ball1.getY() >= Br.get(i).getY()) //if in the bottom of the ball  
					{//y bottom
						if(ball1.getY() <= Br.get(i).getY()+24) //if in the top of the ball  
						{ //y top
							// you hit the brick
							
							
							if(ball1.getX() <= Br.get(i).getX())
							{
								angleX = angleX * -1;
								System.out.println("Hit the brick X1");
							}
							else if(ball1.getX() >= Br.get(i).getX())
							{
								angleX = angleX * -1;
								System.out.println("Hit the brick X2");
							}
						    
							
							if(ball1.getY() > Br.get(i).getY()+20)
							{
								angleY = angleY * -1;
								System.out.println("Hit the brick Y1");
							}
							else if(ball1.getY() < Br.get(i).getY())
							{
								angleY = angleY * -1;
								System.out.println("Hit the brick Y2");
							}
							
							Br.remove(i);
							System.out.println("brick");
						}
					}
				}
			}
		}
		
		
		}
	}
	
	public void Direction(double angle,boolean axis) // true = up - false = down 
	{
		//Auto Up and sets a negative angle to go opposite direction
		if(axis)
		{
			ball1.setX(ball1.getX() - angle);
		}
		else
		{
			ball1.setY(ball1.getY() - angle);
		}
		
	}
	
	
	public void paintComponent(Graphics g) // Repaint / Render
	{
		super.paintComponent(g);
		setBackground(new Color(30, 144, 255));
		
		
		Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		
		if(!((pad.getX() >= padright) || (pad.getX() <= left)))
		{
			pad.paintComponent(g2d);
		}
		else if(pad.getX() >= (padright)) // right
		{
			pad.setX(padright);
		    pad.paintComponent(g2d);
		}
		else if(pad.getX() <= left) //left
		{
			pad.setX(left);
			pad.paintComponent(g2d);
		}
		
		ball1.paintComponent(g2d);
		
		for(int i = 0; i < Br.size();i++)
		{
			Br.get(i).paintComponent(g);
		}
		
		//Lost Ball
		if(ball1.getY() >= pad.getY()+pad.getHeight())  
		{
			NewBall(g);
			move = false;
		}
		g2d.dispose();
	}
	
	public void NewBall(Graphics g)
	{
		
		timer.stop();
		timer2.stop();
		
		g.setColor(Color.RED);
		g.setFont(new Font("arial", Font.PLAIN,30));
		g.drawString("Press Q for new ball", 150, 150); 
		
		pause = true;
		
	}
	

	@Override
	public void keyPressed(KeyEvent k) {
		// TODO Auto-generated method stub
		if(k.getKeyCode() == KeyEvent.VK_Q)
		{
			System.out.println("Restart");
			Restart();
			move = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		
		System.out.println("test");
		
		
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent m) {
		// TODO Auto-generated method stub
		move = true;
		if((ball1.getX() > 225))
		{
			angleX = angleX *-1;
		}
	}

	@Override
	public void mouseReleased(MouseEvent m) {
		// TODO Auto-generated method stub
		
	}
	

}

