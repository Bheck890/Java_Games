package ScoreTrack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class AuditTheScore {
	
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
    
    String fileSS = gameSubFolderPath +"/Space.txt";
    String fileSP = gameSubFolderPath +"/SpacePlayers.txt";
    
	public void write(String Level, String[] Scores, String[] Names) {
		
		//createFolders();
		
		if(Level == "Easy")
		{
			System.out.println("Audit Scores and Players for Easy Rank for next Game");
			
			//Scores
				try {
					txtScore(fileES,Scores);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			// Players
				try {
					txtName(fileEP,Names);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		if(Level == "Medium")
		{
			System.out.println("Audit Scores and Players for Medium Rank for next Game");
			
			//Scores
				try {
					txtScore(fileMS,Scores);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			// Players
				try {
					txtName(fileMP,Names);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		if(Level == "Hard")
		{
			System.out.println("Audit Scores and Players for Hard Rank for next Game");
			
			//Scores
				try {
					txtScore(fileHS,Scores);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			// Players
				try {
					txtName(fileHP,Names);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		if(Level == "Space")
		{
			System.out.println("Audit Scores and Players Of Space Invaders for next Game");
			
			//Scores
				try {
					txtScore(fileSS,Scores);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			// Players
				try {
					txtName(fileSP,Names);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	}
	
	public void txtScore(String file,String[] Scores) throws FileNotFoundException
	{
		//PrintWriter PW = new PrintWriter(new File(getClass().getResource(file).getFile()));
		PrintWriter PW = new PrintWriter(file);
		
		for(int i = 0; i < Scores.length ; i++)
		{
			//System.out.println(Scores[i]);
			PW.println(Scores[i]);
		}
		
		PW.close();
	}
	
	public void txtName(String file,String[] Names) throws FileNotFoundException
	{
		//PrintWriter PW = new PrintWriter(new File(getClass().getResource(file).getFile()));
		PrintWriter PW = new PrintWriter(file);
		
		for(int i = 0; i < Names.length ; i++)
		{
			//System.out.println(Names[i]);
			PW.println(Names[i]);
		}
		
		PW.close();
	}
	
	
	public void createFolders()
	{
		File gameFolder = new File(gameSubFolderPath);
		//File gameFolder2 = new File(gameSubFilePath);
		System.out.println("Folder Begin");
		
		if (!gameFolder.exists()) {
		    // Folder doesn't exist. Create it
		    if (gameFolder.mkdir()) {
		        // Folder created
		    	System.out.println("Folder created");
		    	
		    	
		    	
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
		    	System.out.println("AUD: Error Creating folder");
		    	
		    }
		}
		else {
		    // Folder exists
			System.out.println("Folder Exists");
		}
	}
	
}
