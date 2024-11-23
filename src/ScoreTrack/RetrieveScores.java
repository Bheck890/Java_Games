package ScoreTrack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class RetrieveScores {
	// these must be in a specific file on the computer (can not be in the jar to retrieve and rewrite)
	
	//String gameFolderPath = System.getenv().get("APPDATA") + "\\CooArcade" + "\\Leaderboard";
	String gameFolderPath = new File("").getAbsolutePath();
	String gameSubFolderPath = gameFolderPath + "\\Leaderboard";
	
	//Need to write to place outside of this and the Jar
	String fileES = gameSubFolderPath +"/Easy.txt";
    String fileEP = gameSubFolderPath +"/EasyPlayers.txt";
    String fileMS = gameSubFolderPath +"/Medium.txt";
    String fileMP = gameSubFolderPath +"/MediumPlayers.txt";
    String fileHS = gameSubFolderPath +"/Hard.txt";
    String fileHP = gameSubFolderPath +"/HardPlayers.txt";
	
    //Space Invaders Files
    String fileSS = gameSubFolderPath +"/Space.txt";
    String fileSP = gameSubFolderPath +"/SpacePlayers.txt";
    
    
    int[] Scores = new int[10]; 
	String[] Players = new String[10]; 
	
	public void retrieve_from_txt(String Level)
	{
		 //System.out.println( new File("").getAbsolutePath());
		 //System.out.println(thispath);
		
		if(Level == "Easy")
		{
			System.out.println("Geting Scores and Players for Easy Rank");
			
			//Scores
			try {
				Scores = Scoretxt(fileES);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Scores = DefaultScores();
			}
			
			// Players
			try {
				Players = Playertxt(fileEP);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Players = DefaultPlayers();
			}
		}
		else if(Level == "Medium")
		{
			//Scores
			try {
				Scores = Scoretxt(fileMS);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Scores = DefaultScores();
			}
			
			// Players
			try {
				Players = Playertxt(fileMP);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Players = DefaultPlayers();
			}
		}
		else if(Level == "Hard")
		{
			//Scores
			try {
				Scores = Scoretxt(fileHS);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Scores = DefaultScores();
			}
			
			// Players
			try {
				Players = Playertxt(fileHP);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Players = DefaultPlayers();
			}
		}
		else if(Level == "Space")
		{
			//Scores
			try {
				Scores = Scoretxt(fileSS);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Scores = DefaultScores();
			}
			
			// Players
			try {
				Players = Playertxt(fileSP);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Players = DefaultPlayers();
			}
		}
		
		createFolders();
		
	}
	

	
    @SuppressWarnings("resource")
	int[] Scoretxt(String file) throws IOException
	{
		int[] scores = new int[10];
		
		int i = 0;
		String token = "";
		/*
		//Scanner in = new Scanner(new File(getClass().getResource(file).getFile()));
		Scanner in = new Scanner(file);
		while(in.hasNext()){
			token = in.next();
			
			if(i>-1)
			scores[i] = Integer.parseInt(token);
			
			i++;
		}
		
		*/
		
		BufferedReader in = new BufferedReader(new FileReader(file));
		while(in.ready()){
			token = in.readLine();
			//if(i>0)
			scores[i] = Integer.parseInt(token);
			
			i++;
		}
		
		/*
		for(int h: scores)
		{
			System.out.println(h);
		}
		*/
		
		return (scores);
	}
	
    @SuppressWarnings({ "resource" })
	String[] Playertxt(String file) throws IOException 
	{
		String[] players = new String[10];
		
		int i = 0;
		String token = "";
		//Scanner in = new Scanner(new File(getClass().getResource(file).getFile()));
		/*
		Scanner in = new Scanner(file);
		while(in.hasNext()){
			token = in.next();
			
			if(i>-1)
			players[i] = token;
			
			i++;
		}
		*/
		
		BufferedReader in = new BufferedReader(new FileReader(file));
		while(in.ready()){
			token = in.readLine();
			players[i] = token;
			i++;
		}
		/*
		for(String h: players)
		{
			System.out.println(h);
		}
		*/
		return (players);
		
	}
	
	
	
	String[] DefaultPlayers()
	{
		String[] Default = new String[10];
		
		for(int i = 0; i < Default.length; i++)
		{
			Default[i] = "Default" + i ;
		}
		
		
		for(String h: Default)
		{
			System.out.println(h);
		}
		
		
		return Default;
	}
	int[] DefaultScores()
	{
		int[] Default = new int[10];
		Default[0] = 200;
		Default[1] = 150;
		Default[2] = 125;
		Default[3] = 100;
		Default[4] = 90;
		Default[5] = 75;
		Default[6] = 50;
		Default[7] = 25;
		Default[8] = 10;
		Default[9] = 5;
		
		
		for(int h: Default)
		{
			System.out.println(h);
		}
		
		
		return Default;
	}
	
	
	public int[] getScore()
	{
		return Scores;
	}
	
	
	public String[] getPlayer()
	{
		return Players;
	}
	
	
	public void createFolders()
	{
		
		//File gameFolder = new File(gameFolderPath);
		File gameFolder = new File(gameSubFolderPath);
		System.out.println("Folder Begin");
		
		if (!gameFolder.exists()) {
		    // Folder doesn't exist. Create it
		    if (gameFolder.mkdir()) {
		        // Folder created
		    	System.out.println("Folder created");
		    	Scores = DefaultScores();
		    	Players = DefaultPlayers();
		    	/*
		        File gameFile = new File(gameFilePath);
		        
		        if (!gameFile.exists()) {
		            // File doesn't exists, create it
		            try {
		                if (gameFile.createNewFile()) {
		                    // mGameFile created in %APPDATA%\myGame !
		                	TextFileCopy.CopyBintoAppData();
		                }
		                else {
		                    // Error
		                }
		            } catch (IOException ex) {
		                // Handle exceptions here
		            } catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        else {
		            // File exists
		        	System.out.println("File Exists");
		        }
		        */
		    }
		    else {
		        // Error
		    	System.out.println("Rec: Error Creating folder");
		    	
		    }
		}
		else {
		    // Folder exists
			System.out.println("Folder Exists");
		}
	}
	

}
