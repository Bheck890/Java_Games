package ScoreTrack;

import java.awt.Color;

import frames.Frame;
import snakeCode.SnakeMask;

public class ScoreProxy {
	static SnakeMask sh = new SnakeMask();
	static RetrieveScores RS = new RetrieveScores();
	static ScoreManipulate SM = new ScoreManipulate();
	static AuditTheScore ATS = new AuditTheScore();
	
	static String[] PlayerNames = new String[11];
	static int[] PlayerScores = new int[11];
	static String[] PlayerScoresS = new String[10];
	
	static String level = "";
	static int Score1 = 0;
	static int Wave1 = 0;
	static int game = 0;
	
	public static void SnakeOver(int score, String Level) {
		game = 2;
		level = Level;
		Score1 = score;
		ScoreAudit(score);
	}
	
	public static void SpaceOver(int score, int wave) {
		game = 3;
		level = "Space";
		Wave1 = wave;
		Score1 = score;
		ScoreAudit2(score);
	}
	
	//Snake Game
	public static void ScoreAudit(int Score)
	{
		//Gather Text file for leaderboard arrays
		RS.retrieve_from_txt(level); //From TXT document creates Arrays
		// Sets Array from Returned and adds to this class
		getPlayers(); // PlayerNames
		getScores(); //PlayerScores
		
		
		System.out.println("Seting Up Leaderboard");
		//set leaderboard
		Leaderboard[] Players = new Leaderboard[10];
		for(int i = 0; i < Players.length; i++)
		{
			Players[i] = new Leaderboard(PlayerScores[i],PlayerNames[i]);
		}
		
		//User Needs to Enter a User Name.
		SM.Q_newrank(Score, Players,game);
		
	}
	
	//Space Game
	public static void ScoreAudit2(int Score)
	{
		//Gather Text file for leaderboard arrays
		RS.retrieve_from_txt(level); //From TXT document creates Arrays
		// Sets Array from Returned and adds to this class
		getPlayers(); // PlayerNames
		getScores(); //PlayerScores
		
		
		System.out.println("Seting Up Leaderboard");
		//set leaderboard
		Leaderboard[] Players = new Leaderboard[10];
		for(int i = 0; i < Players.length; i++)
		{
			Players[i] = new Leaderboard(PlayerScores[i],PlayerNames[i]);
		}
		
		//User Needs to Enter a User Name.
		SM.Q_newrank(Score, Players,game);
		
	}
	
	
	public static void gameOver(Leaderboard[] players)
	{
		
		//printPlayers(players); //Troubleshoot Highscore Rank
		
		breakArray(players);
		
		//print the arrays back into the text documents
		ATS.write(level, PlayerScoresS, PlayerNames);
		
		sh.GameOver(PlayerScoresS,PlayerNames,level,Score1);
	}
	
	public static void gameOver2(Leaderboard[] players)
	{
		GameOver G = new GameOver();
		//printPlayers(players); //Troubleshoot Highscore Rank
		
		breakArray(players);
		
		//print the arrays back into the text documents
		ATS.write(level, PlayerScoresS, PlayerNames);
		
		Frame.jf2.getContentPane().removeAll();
		Frame.jf2.setSize(600, 800);
		Frame.jf2.setBackground(Color.GRAY);

		// score and player array add here
		G.PlayerNames = PlayerNames;
		G.PlayerScores = PlayerScoresS;
		G.level = level;
		G.Score = Score1;
		
		G.Container();
		
		Frame.jf2.getContentPane().setLayout(null);
		
		Frame.jf2.setVisible(true);
		G.setVisible(true);
	}
	
	
	
	public static void printPlayers(Leaderboard[] Players)
	{
		System.out.println("Leaderboard");
		for(Leaderboard h: Players)
		{
			System.out.println(h.getScore() + " - " + h.getName());
		}
		
		System.out.println("\nLeaderboard Take apart");
		for(int i = 0; i < PlayerScores.length; i++)
		{
			PlayerScoresS[i] = Integer.toString(Players[i].getScore());
			PlayerNames[i] = Players[i].getName();
		}
		
		System.out.println("\nLeaderboard Confirmation");
		for(int i = 0; i < PlayerScores.length; i++)
		{
			System.out.println(PlayerScoresS[i] + " - " + PlayerNames[i]);
		}
	}
	
	public static void breakArray(Leaderboard[] Players) {
		for(int i = 0; i < PlayerScores.length; i++)
		{
			PlayerScoresS[i] = Integer.toString(Players[i].getScore());
			PlayerNames[i] = Players[i].getName();
		}
	}
	
	
	private static void getPlayers() {
		PlayerNames = RS.getPlayer();
	}

	private static void getScores() {
		PlayerScores = RS.getScore();
	}

	
	
	
	
	// FIRST IN
	// Read Score file put 10 scores into an array 
	// Read Player File put player names in array of same size
	
	// SECOND RANK
	//Receive new score and rank score into array and move lower ranks down and delete the bottom
	
	//if players score is on leader board call for user to input a name and graduate the player on setting a high score 
	//else pass default arrays to Game over 
	
	//add player name to player array list and move down the rest then remove the bottom
	
	// THIRD OUT
	// send new arrays to Game over Panel and display them
	
	
	
	
	
}
