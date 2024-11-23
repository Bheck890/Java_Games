package ScoreTrack;

public class Leaderboard {
	private int score;
	private String Name;
	
	public Leaderboard(int score,String Name)
	{
		this.score = score;
		this.Name = Name;
	}
	
	 public void setName(String Tag)
	 {
	     this.Name = Tag;
	 }
	 public String getName()
	 {
		 return Name;
	 }
	   
	 public void setScore(int score)
	 {
	     this.score = score;
	 }
	 public int getScore()
	 {
	     return score;
	 }
	 
	 public void AsetScore(int[] Scores)
	 {
		 
	 }
	 public void AsetNames(String[] Names)
	 {
		 
	 }
}
