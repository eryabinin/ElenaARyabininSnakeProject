package com.elena;
//original code author@Clara
//modified by Elena R with tutor
import java.util.Random;

public class Spider {

	/** Identifies a random square to display a spider
	 * Any square is ok, so long as it doesn't have any snake segments in it. 
	 * There is only one Spider and when the snake eats it, then it moves.
         * 
         * used Kibble.java code created by Clara (refer to the Snake-master project from gitHub)
	 */
	
	private int spiderX; //This is the square number (not pixel)
	private int spiderY;  //This is the square number (not pixel)
	
	public Spider(Snake s){
		//Spider needs to know where the snake is, so it does not create a spider in the snake
		//Pick a random location for spider, check if it is in the snake
		//If in snake, try again
		moveSpider(s);
	}
	
	protected void moveSpider(Snake s){
		
		Random rng = new Random();
		boolean spiderInSnake = true;
		while (spiderInSnake == true) {
			//Generate random spider location
			spiderX = rng.nextInt(SnakeGame.xSquares);
			spiderY = rng.nextInt(SnakeGame.ySquares);
			spiderInSnake = s.isSnakeSegment(spiderX, spiderY);
		}
		
		
	}

	public int getSpiderX() {
		return spiderX;
	}

	public int getSpiderY() {
		return spiderY;
	}


	
}
