package Test;


import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;


public class Frame_Tester extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8519304513241168875L;
	//private JPanel contentPane;
	//private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Frame_Tester frame = new Frame_Tester();
		frame.setVisible(false);
	}

	/**
	 * Create the frame.
	 */
	JFrame jf = new JFrame(); 
	int playerindex = 0;
	
	@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
	public Frame_Tester() 
	{
		
		
		jf.setSize(600, 800);
		jf.setVisible(true);
		jf.getContentPane().setVisible(true);
		
		
		System.out.println("[Pannel] Create Content3");
		//System.out.println("Game Over Screen");
		jf.getContentPane().setVisible(true);
		jf.getContentPane().setBackground(Color.GRAY);
		
		Button button = new Button("Play Again");
		button.setForeground(Color.BLACK);
		button.setBackground(Color.ORANGE);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				/*
				removeAll();
				Game_Menu2.content = 2;
				Game_Menu2.content();
				jf.setVisible(false);
				*/
			}
		});
		button.setBounds(434, 654, 140, 54);
		jf.getContentPane().add(button);
		
		jf.getContentPane().setLayout(null);
		
		JLabel lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblGameOver.setForeground(Color.RED);
		lblGameOver.setBounds(202, 11, 181, 80);
		jf.getContentPane().add(lblGameOver);
		
		JLabel lblTopHigh = new JLabel("Top 10 High Scores");
		lblTopHigh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTopHigh.setForeground(Color.BLACK);
		lblTopHigh.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopHigh.setBounds(174, 102, 209, 32);
		jf.getContentPane().add(lblTopHigh);
		
		Button button_1 = new Button("Menu");
		button_1.setBackground(Color.CYAN);
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				/*
				jf.setSize(450,300);
				//Game_Menu2.content = -1; // must all ways run these two
				//Game_Menu2.content();
				content2 = 0;
				CP(jf);
				//jf1.setSize(450,300);
				jf.setVisible(true);
				System.out.println("[Pannel] Delete Content3");
				*/
			}
		});
		button_1.setBounds(10, 654, 140, 54);
		jf.getContentPane().add(button_1);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(216, 656, 67, 26);
		jf.getContentPane().add(lblScore);
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		lblDifficulty.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblDifficulty.setBounds(172, 682, 111, 26);
		jf.getContentPane().add(lblDifficulty);
		
		JLabel lblNewLabel = new JLabel("Score");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel.setBounds(314, 654, 69, 23);
		jf.getContentPane().add(lblNewLabel);
		
		JLabel lblDifficulty_1 = new JLabel("Difficulty");
		lblDifficulty_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDifficulty_1.setBounds(314, 685, 91, 19);
		jf.getContentPane().add(lblDifficulty_1);
		
		
		
		//makes label
		JLabel label1 = new JLabel("Select Score, to See Player Tag");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label1.setBounds(166, 423, 249, 93);
		jf.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("Player");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label2.setBounds(242, 500, 91, 54);
		jf.getContentPane().add(label2);
		
		//Array of player names that match their score
		String[] PlayerNames = new String[10];
		PlayerNames[0] = "Brandon";
		PlayerNames[1] = "Jake";
		
		JList list = new JList();
		list.setVisibleRowCount(10);
		list.setFont(new Font("Tahoma", Font.BOLD, 17));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"200", "100", "50", "10", "5", "10", "50", "30", "100", "50"};
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
		
		jf.repaint();
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(227, 175, 121, 238);
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);
		jf.getContentPane().add(list);
		
		jf.repaint();
	}
		
		
		//HAVE Read this in file and Export in this format 
		/* 
		 * For Difficulty: (Difficulty)
		 * 1. (Number)
		 * 2. (Number)
		 * 3. (Number)
		 * 
		 * So on so forth...
		 */
		
		
		// Variable-Panel in Frame System Started in v.0.10
		/*
		// Review how YOU Did this and do it for this Game!!!!
		JFrame jf3 = new JFrame();
		jf3.setVisible(false);
		Level lev = new Level();
		lev.CP(jf3);
		
		lev.setVisible(false);
		jf3.getContentPane().setBackground(new Color(255, 255, 255));
		jf3.setTitle("Choose Level");
		jf3.setResizable(false);
		jf3.setSize(450, 500);
		jf3.setBackground(new Color(205, 133, 63));
		jf3.getContentPane().setLayout(null);
		jf3.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf3.setVisible(true);
		*/
		
		
		
		
		
		
		
		
		
	
}
