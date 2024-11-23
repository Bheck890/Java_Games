package objects;

import java.awt.Color;
import java.awt.Graphics;

public class Brick {

private int x;
private int y;
private int height = 20;
private int width = 43;
private int brickID = 0;

	public Brick(int X, int Y,int brick)
	{
		brickID = brick;
		this.x = X;
		this.y = Y;
	}
	
	public void paintComponent(Graphics g) 
	{
		if(brickID == 0){g.setColor(Color.BLUE);}
		else if(brickID == 1){g.setColor(Color.CYAN);}
		else if(brickID == 2){g.setColor(Color.DARK_GRAY);}
		else if(brickID == 3){g.setColor(Color.GRAY);}
		else if(brickID == 4){g.setColor(Color.GREEN);}
		else if(brickID == 5){g.setColor(Color.LIGHT_GRAY);}
		
		g.fillRect(x, y, width, height);
	}
	
	public void direction()
	{
		//this is the algorithm for the paddle so the ball knows the direction
		// this needs to be implemented into all of the bricks 
		
		//They all need a boundary around them from the X side and the Y 
		// AHHHHHHHHHHH
		
		 
		/*
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
				
				
				
				if(ball1.getY() >= pad.getY())
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
		*/
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getBrickID() {
		return brickID;
	}

	public void setBrickID(int brickID) {
		this.brickID = brickID;
	}
}
