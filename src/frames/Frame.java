package frames;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import brickCode.Title;
import invaderCode.ShipMenu;
import snakeCode.SnakeMask;

/*
 * Games to create
 * 
 * Snake
 * Space invaders
 * Galaga
 * Brick Breaker
 * Pong
 * 
 * Then create an App for phone
 * Note pad, others
 * 
 * ADD to all games a menu when you press ESC it pulls up a menu with leader board and option to resume or quit
 * just hide all of them and stop the timers then on resume show them! 
 * 
 * Then Create Finance Application
 * 
 * 
 */
public class Frame {

	public static JFrame jf1; // Menu select Game
	public static JFrame jf2; // Snake Menu to begin
	public static JFrame jf3; // Galiga
	public static JFrame jf4; // Brick
	public static int content;
	public static String FrameName = "Pioneer Game Construct";
	
	public static void main(String[] args) 
	{
		content = 1;
		content();
        
	}
	



	public static void content()
	{
		
		jf1 = new JFrame(); //Menus
		jf2 = new JFrame(); //Snake Game Frame
		jf3 = new JFrame(); //Galiga Game Frame
		jf4 = new JFrame(); //Galiga Game Frame
		
		
		ContentChange CG = new ContentChange();
		SnakeMask sh = new SnakeMask();
		ShipMenu SM = new ShipMenu();
		Title BT = new Title();
		
		
		jf2.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
            	System.exit(0);
                ((JFrame)(e.getComponent())).dispose();
            }
        });
		jf3.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
            	System.exit(0);
                ((JFrame)(e.getComponent())).dispose();
            }
        });
		jf4.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
            	System.exit(0);
                ((JFrame)(e.getComponent())).dispose();
            }
        });
		
		
		if(content == 1)//Game Menu (BEGIN/Create Frame)
		{
			
			jf2.dispose();;
			jf2.getContentPane().setVisible(false);
			jf2.setVisible(false);
			
			jf3.dispose();;
			jf3.getContentPane().setVisible(false);
			jf3.setVisible(false);
			
			
			
			System.out.println("[Frame] 1 Create Menu");
			//Set these Window Attributes then add the parts to the Container Class
			jf1.setTitle(FrameName);
			jf1.setSize(800,500);
			jf1.setContentPane(CG);
			jf1.setVisible(true);
			jf1.setResizable(false);
			jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ContentChange.content2 = 1;
			CG.CP(jf1);
		}
		if(content == 2)//Snake Game
		{
			System.out.println("[Frame] 2 Game Panel");
			CG.setVisible(false);
			jf1.setVisible(false);
			
			jf2.setTitle(FrameName);
			jf2.setSize(600, 600);
			jf2.setVisible(true);
			jf2.setResizable(false);
			jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.out.println("Snake Game Screen");
			
			jf2.setContentPane(sh);
			//sh.StartGame();
			sh.AI_begin();
			sh.setLayout(null);
			//sh.Components(jf2);
			sh.setBackground(Color.LIGHT_GRAY);
		}
		if(content == 3)//Galiga Game
		{
			System.out.println("[Frame] 3 Game Panel");
			CG.setVisible(false);
			jf1.setVisible(false);
			
			jf3.setTitle(FrameName);
			jf3.setSize(600, 600);
			jf3.setVisible(true);
			jf3.setResizable(false);
			jf3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.out.println("Galiga Game Screen");
			
			
			jf3.setContentPane(SM);;
			SM.shipBegin();
			SM.setBackground(Color.black);
		}
		if(content == 4)//Brick Breaker
		{
			System.out.println("[Frame] 4 Game Panel");
			CG.setVisible(false);
			jf1.setVisible(false);
			
			jf4.setTitle(FrameName);
			jf4.setSize(600, 600);
			jf4.setVisible(true);
			jf4.setResizable(false);
			jf4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.out.println("Brick Game Screen");
			
			
			jf4.setContentPane(BT);
			BT.BrickBegin();
			BT.setBackground(new Color(100, 149, 237));
		}
	}


	
	
	
	
	
	
}

/*
 * To Do 
 * Pause, Resume, and Quit Button in Game
 * Different Difficulty's
 * Game Over Score System for each Difficulty
 * 
 * Then you are Done and move on to the next project
 * Desktop APP
 * - Galliga
 * - Then can work on Finance Application to Replace Excel Sheet (GOAL)
 * [When finish program make it an actual APP that windows can use](put a windows cover over it)
 * 
 * 
 * Phone APP
 * - Notes APP 
 * - Resume APP (GOAL)
 * - Create a game on the phone
 * 
 * 
 * 
 *
 * VERSIONS
 * Previous:
 * Rough Drafts to create this
 * 0.1 
 *  * New Difficulty Selector
 *  - Organized code for easier to edit and change
 *  
 * 
 * 
 * 
 */


