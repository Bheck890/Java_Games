package ScoreTrack;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import frames.Frame;

@SuppressWarnings("serial")
public class GameOver extends JPanel{

	public GameOver()
	{
		
	}
	
	public String level = "None";
	public int Score = 0;
	int playerindex = 0;
	public String[] PlayerNames = new String[10];
	public String[] PlayerScores = new String[10];
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public void Container() {
		Frame.jf2.getContentPane().setVisible(false);
		Frame.jf2.getContentPane().removeAll();
		
		
		
		Button button = new Button("Play Again");
		button.setForeground(Color.BLACK);
		button.setBackground(Color.ORANGE);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Frame.jf2.getContentPane().removeAll();
				setVisible(false);
				Frame.jf2.dispose();
				
				Frame.content = ScoreProxy.game;
				Frame.content();
				
				System.out.println("[G Over Pannel] Back to Snake Menu (RESET FRAME)");
				
			}
		});
		button.setBounds(434, 654, 140, 54);
		Frame.jf2.getContentPane().add(button);
		
		
		JLabel lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblGameOver.setForeground(Color.RED);
		lblGameOver.setBounds(202, 11, 181, 80);
		Frame.jf2.getContentPane().add(lblGameOver);
		
		JLabel lblTopHigh = new JLabel("Top 10 High Scores");
		lblTopHigh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTopHigh.setForeground(Color.BLACK);
		lblTopHigh.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopHigh.setBounds(172, 102, 209, 32);
		Frame.jf2.getContentPane().add(lblTopHigh);
		
		Button button_1 = new Button("Menu");
		button_1.setBackground(Color.CYAN);
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Frame.jf2.getContentPane().removeAll();
				setVisible(false);
				Frame.jf2.dispose();
				
				Frame.content = 1;
				Frame.content();
				
				System.out.println("[G Over Pannel] Back to Menu");
				
			}
		});
		button_1.setBounds(10, 654, 140, 54);
		Frame.jf2.getContentPane().add(button_1);
		
		JLabel lblGame = new JLabel("Game:");
		lblGame.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblGame.setBounds(216, 626, 67, 26);
		Frame.jf2.getContentPane().add(lblGame);
		
		if(ScoreProxy.game == 2)
		{
			JLabel lblNewLabel = new JLabel("Snake");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBounds(314, 624, 100, 23);
			Frame.jf2.getContentPane().add(lblNewLabel);
		}
		else if(ScoreProxy.game == 3)
		{
			JLabel lblNewLabel = new JLabel("Space Invaders");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBounds(314, 624, 150, 23);
			Frame.jf2.getContentPane().add(lblNewLabel);
		}
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(216, 656, 67, 26);
		Frame.jf2.getContentPane().add(lblScore);
		
		JLabel lblNewLabel = new JLabel(Integer.toString(Score));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel.setBounds(314, 654, 69, 23);
		Frame.jf2.getContentPane().add(lblNewLabel);
		
		if(ScoreProxy.game == 2)
		{
			JLabel lblDifficulty = new JLabel("Difficulty:");
			lblDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
			lblDifficulty.setFont(new Font("Sitka Small", Font.BOLD, 20));
			lblDifficulty.setBounds(172, 682, 111, 26);
			Frame.jf2.getContentPane().add(lblDifficulty);
			
			JLabel lblDifficulty_1 = new JLabel(level);
			lblDifficulty_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblDifficulty_1.setBounds(314, 685, 91, 19);
			Frame.jf2.getContentPane().add(lblDifficulty_1);
			Frame.jf2.getContentPane().setVisible(true);
		}
		else if(ScoreProxy.game == 3)
		{
			JLabel lblDifficulty = new JLabel("Wave:");
			lblDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
			lblDifficulty.setFont(new Font("Sitka Small", Font.BOLD, 20));
			lblDifficulty.setBounds(195, 682, 111, 26);
			Frame.jf2.getContentPane().add(lblDifficulty);
			
			JLabel lblDifficulty_1 = new JLabel("" + ScoreProxy.Wave1);
			lblDifficulty_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblDifficulty_1.setBounds(314, 685, 91, 19);
			Frame.jf2.getContentPane().add(lblDifficulty_1);
			Frame.jf2.getContentPane().setVisible(true);
		}
		
		
		
		//makes label
		JLabel label1 = new JLabel("Select Score, to See Player Tag");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label1.setBounds(166, 423, 249, 93);
		Frame.jf2.getContentPane().add(label1);
				
		JLabel label2 = new JLabel("Player");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label2.setBounds(242, 500, 91, 54);
		Frame.jf2.getContentPane().add(label2);
				
		//Array of player names that match their score
		// Player names are passed into this class from Score-Proxy
		//PlayerNames[0] = "Brandon";
		//PlayerNames[1] = "Jake";
	    
		JList list = new JList();
		list.setVisibleRowCount(10);
		list.setFont(new Font("Tahoma", Font.BOLD, 17));
		list.setModel(new AbstractListModel() {
			//String[] values = new String[] {"200", "100", "50", "10", "5"};
			String[] values = PlayerScores;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				
				return values[index];
			}
		});
		
		list.addListSelectionListener(new ListSelectionListener() {			
	    @Override
		public void valueChanged(ListSelectionEvent arg0) {
	    	if (!arg0.getValueIsAdjusting()) {
	    		playerindex = list.getSelectedIndex();
		        label2.setText(PlayerNames[playerindex]);
		        //label1.setText(list.getSelectedValue().toString());
		 }
		}
		});
				
		Frame.jf2.repaint();
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(227, 175, 121, 238);
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);
		Frame.jf2.getContentPane().add(list);
		
		Frame.jf2.getContentPane().setBackground(Color.GRAY);
		Frame.jf2.setBackground(Color.GRAY);		
		Frame.jf2.repaint();
		
		
		
	}
	
	
	
	
	
	
	public static void close()
	{
		
		// work on putting the Scores in the text document
		// add the algorithm to put highest on top and go down 10 then get rid of high scores
		// print out to console when have score
		// then add to Game over Panel
		
	}
}
