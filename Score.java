package com.elena;

/** Keeps track of, and display the user's score
 * 
 */
//original code author@Clara
//modified by Elena R with tutor

public class Score {

	protected static int score;
	protected static int highScore = 0;
	protected static int incrementForKiddle;
	protected static int incrementForSpider;//additional increment added for spider food
	
	public Score(){
		score = 0;
		incrementForKiddle = 1;  //how many points for eating a kibble
		incrementForSpider = 2; // twice more points for eating a spider

	}
	
	public static void resetScore() {
		score = 0;	
	}
	
	public static void increaseScoreForKibble() {
		
		score = score + incrementForKiddle;
		
	}
	//created method to increase score when snake eats spider
	public static void increaseScoreForSpider() {
        
                score = score +  incrementForSpider;
        
    }
	public int getScore(){
		return score;
	}
	
	//Checks if current score is greater than the current high score. 
	//updates high score and returns true if so.
	
	public boolean gameOver(){
		boolean a =  false;
		if (score > highScore) {
			highScore = score;
			a= true;
		}
		return a;
	}

	//These methods are useful for displaying score at the end of the game
	
	public String getStringScore() {
		return Integer.toString(score);
	}

	public String newHighScore() {
		String scoreUpdateTxt = "";
		if (score > highScore) {
			highScore = score;
			scoreUpdateTxt = "New High Score!!";
		}
		return scoreUpdateTxt;
	}

	public String getStringHighScore() {
		return Integer.toString(highScore);
	}
	
}

