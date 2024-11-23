package ScoreTrack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ScoreManipulate {

	@SuppressWarnings("unused")
	private boolean EnterName = false;
	private int game = 0;
	
	//Q_newrank
	public void Q_newrank(int Nscore ,Leaderboard[] Player, int gameID)
	{
		game = gameID;
		if(Nscore >= Player[9].getScore())
		{
			Name = NewName(Nscore,Player);
			System.out.println("HighScore Set!");
		}
		else
		{
			System.out.println("No HighScore");
			ScoreProxy.gameOver(Player);
		}
	}
	
	public void setNewRanks(Leaderboard[] player)
	{
		
		int i;
	       int k;
	       int posmax;
	       Leaderboard temp;
	       
	       for ( i = player.length - 1 ; i >= 0 ; i-- )
	       {
	           // find largest element in the i elements
	           posmax = 0;
	           for ( k = 0 ; k <= i ; k++ )
	           {
	               if ( player[ k ].getScore() < player[ posmax ].getScore() )
	                    posmax = k;
	           }
	           // swap the largest with the position i             // now the item is in its proper location 
	           temp = player[ i ];
	           player[ i ] = player[posmax ];
	           player[ posmax ] = temp;
	       }  
	       
	}
	
	/*
	public void run(){
        synchronized(this){
        	if(EnterName) {
        		notify();
        	}
        }
    }
	*/
	
	int chara = 0;
	String Name;
	//NewName
	public String NewName(int Nscore ,Leaderboard[] Player)
	{
		
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		
		jf.setTitle("SET GAMER TAG");
		jf.setSize(300,300);
		jf.setContentPane(jp);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jp.setBackground(new Color(192, 192, 192));
		jp.setLayout(null);
		
		JTextField txtNameHere;
		txtNameHere = new JTextField();
		txtNameHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtNameHere.setText("");
			}
		});
		txtNameHere.setText("Name Here");
		txtNameHere.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				chara ++;
			    if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
			    	System.out.println(txtNameHere.getText());
					Name = txtNameHere.getText();
					
					Player[9].setName(Name); 
					Player[9].setScore(Nscore); //sets new score on lowest player 
					setNewRanks(Player);
					
					jf.dispose();
					jf.setVisible(false);
					
					ScoreProxy.gameOver(Player);
					chara = 0;
				}
				if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					chara --;
				}
				if(chara == 20)
				{
					txtNameHere.setText("");
					chara = 0;
				}
				if(chara == 1)
				{
					txtNameHere.setText("");
				}
			 
				
			}
		});
		txtNameHere.setBounds(28, 93, 137, 28);
		
		jp.add(txtNameHere);
		txtNameHere.setColumns(10);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblScore.setBounds(28, 157, 69, 28);
		jp.add(lblScore);
		
		JLabel lblScore_1 = new JLabel(String.valueOf(Nscore));
		lblScore_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblScore_1.setBounds(133, 166, 76, 19);
		jp.add(lblScore_1);
		
		if(game == 2)
		{
			JLabel lblDifficulty = new JLabel("Difficulty:");
			lblDifficulty.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblDifficulty.setBounds(28, 190, 86, 28);
			jp.add(lblDifficulty);
			
			JLabel lblLevel = new JLabel(ScoreProxy.level);
			lblLevel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblLevel.setBounds(133, 199, 76, 19);
			jp.add(lblLevel);
		}
		
		JLabel lblEnterYourGame = new JLabel("Enter Your Game Tag Here:");
		lblEnterYourGame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterYourGame.setBounds(28, 54, 167, 28);
		jp.add(lblEnterYourGame);
		
		JLabel lblMaximumOf = new JLabel("Maximum of 20 Characters");
		lblMaximumOf.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMaximumOf.setBounds(28, 120, 137, 19);
		jp.add(lblMaximumOf);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				chara = 0;
				System.out.println(txtNameHere.getText());
				Name = txtNameHere.getText();
				
				Player[9].setName(Name); 
				Player[9].setScore(Nscore); //sets new score on lowest player 
				setNewRanks(Player);
				
				jf.dispose();
				jf.setVisible(false);
				
				ScoreProxy.gameOver(Player);
			}
		});
		btnSelect.setForeground(Color.BLUE);
		btnSelect.setBackground(Color.LIGHT_GRAY);
		btnSelect.setBounds(175, 96, 89, 23);
		jp.add(btnSelect);
		jp.setVisible(true);
		
		jf.toFront();
		jf.repaint();
		
		return Name;
	}
}
