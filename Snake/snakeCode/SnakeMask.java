package snakeCode;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ScoreTrack.GameOver;
import frames.Frame;

public class SnakeMask extends AI_Snake_BackGround implements KeyListener  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Game
	Snake_Obects_CORE AI = new Snake_Obects_CORE();
	GameOver G = new GameOver();
	
	public SnakeMask(){
		
		AI.setFocusable(true);
		AI.addKeyListener(this);
		AI.setFocusTraversalKeysEnabled(false);
		
		setFocusable(true);
		addKeyListener(this);
		setFocusTraversalKeysEnabled(false);
		
		Frame.jf2.setFocusable(true);
		Frame.jf2.addKeyListener(this);
		Frame.jf2.setFocusTraversalKeysEnabled(false);
		
		
		
    }
	
	
	//menu
	public void AI_begin() {
		
		Frame.jf1.setVisible(false);
		Snake_AI();
		
		setLayout(null);
		setVisible(true);
		
		Button button = new Button("Begin");
		button.setBackground(new Color(0, 100, 50));
		button.setForeground(new Color(0, 0, 0));
		button.setFont(new Font("Bauhaus 93", Font.ITALIC, 20));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				
				Difficulty();
				
				System.out.println("[Snake Menu Pannel] Difficulty Menu");
				
			}
		});
		button.setBounds(200, 200, 150, 95);
		Frame.jf2.add(button);
	}
	
	public void Difficulty() {
		Button button = new Button("Easy");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				stop();
				AI.easy = true;
				AI.medium = false;
				AI.hard = false;
				StartGame();
				System.out.println("[Snake Menu Pannel] Begin Game: Easy");
				
				//ScoreProxy.ScoreAudit(14, "Medium");
			}
		});
		button.setBounds(180, 122, 70, 22);
		Frame.jf2.add(button);
		
		Button button2 = new Button("Medium");
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				stop();
				AI.easy = false;
				AI.medium = true;
				AI.hard = false;
				StartGame();
				System.out.println("[Snake Menu Pannel] Begin Game: Medium");
			}
		});
		button2.setBounds(180, 196, 70, 22);
		Frame.jf2.add(button2);
		
		Button button3 = new Button("Hard");
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				stop();
				AI.easy = false;
				AI.medium = false;
				AI.hard = true;
				StartGame();
				System.out.println("[Snake Menu Pannel] Begin Game: Hard");
			}
		});
		button3.setBounds(180, 280, 70, 22);
		Frame.jf2.add(button3);
		
		
	}
	
	public void StartGame() {
		System.out.println("[Snake Menu] Snake Game Begin");
		Frame.jf2.setContentPane(AI);
		Frame.jf2.setBackground(Color.LIGHT_GRAY);
		Frame.jf2.setLayout(null);
		AI.SnakeGame(); //start game
		AI.Components(Frame.jf2); // add jpannel components
		
		
		//THIS SETS THE LISTENER INPORTANT
		AI.setFocusable(true);
		AI.addKeyListener(this);
		AI.setFocusTraversalKeysEnabled(false);
		
		Frame.jf2.setVisible(true);
		AI.setVisible(true);
		
		
	}
	
	public void GameOver(String[] scores, String[] Names,String Level, int score) {
		
		
		
		Frame.jf2.getContentPane().removeAll();
		Frame.jf2.setSize(600, 800);
		Frame.jf2.setBackground(Color.GRAY);

		// score and player array add here
		G.PlayerNames = Names;
		G.PlayerScores = scores;
		G.level = Level;
		G.Score = score;
		
		G.Container();
		
		Frame.jf2.getContentPane().setLayout(null);
		
		Frame.jf2.setVisible(true);
		G.setVisible(true);
		
	}
	
	public void todo() {
		//start fake snake game in background
		//have start button on front
		//change to difficulty menu
		//then start the game
		//when it ends make come back here and create game over 
	}

	
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		
		//All Keys gets over written to The core Commands
		AI.keyPressed(e);
		
		
		// P still dose a command in this part
		if(e.getKeyCode() == KeyEvent.VK_P) 
		{
			System.out.println("2press");
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
