package com.elena;

import java.awt.*;
import java.util.LinkedList;

import javax.swing.JPanel;

/** This class responsible for displaying the graphics, so the snake, grid, kibble, instruction text and high score
 * 
 * @author Clara
 *
 */
//original code author@Clara
//modified by Elena R with tutor
public class DrawSnakeGamePanel extends JPanel {
	
	private static int gameStage = SnakeGame.BEFORE_GAME;  //use this to figure out what to paint
	
	private Snake snake;
	private Kibble kibble;
	private Spider spider;
	private Score score;
	
	DrawSnakeGamePanel(Snake s, Kibble k, Spider sp, Score sc){
		this.snake = s;
		this.kibble = k;
		this.spider = sp;
		this.score = sc;
	}
	
	public Dimension getPreferredSize() {
        return new Dimension(SnakeGame.xPixelMaxDimension, SnakeGame.yPixelMaxDimension);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); 

        /* Where are we at in the game? 4 phases.. 
         * 1. Before game starts
         * 2. During game
         * 3. Game lost aka game over
         * 4. or, game won
         */

        gameStage = SnakeGame.getGameStage();
        //define game at different stages
        switch (gameStage) {
        case 1: {
        	displayInstructions(g);//at start display instructions
        	break;
        } 
        case 2 : {
        	displayGame(g);//display game
        	break;
        }
        case 3: {
        	displayGameOver(g);//display game over text
        	break;
        }
        case 4: {
        	displayGameWon(g);//display winning text- can't win, so not sure how it looks
        	break;
        }
        }
        
        
        
    }

	private void displayGameWon(Graphics g) {

            g.setFont(new Font("Dialog", Font.BOLD, 40));
            g.clearRect(100,100,350,350);
            g.drawString("YOU WON SNAKE!!!", 180, 180);
		
	}
	private void displayGameOver(Graphics g) {

			//g.clearRect(120,120,480,480);
		g.setColor(Color.WHITE);
		g.fillRect(60,60,480,480);
		g.setFont(new Font("Dialog", Font.BOLD, 35));
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 180, 180);

		String textScore = score.getStringScore();
		String textHighScore = score.getStringHighScore();
		String newHighScore = score.newHighScore();

		g.setFont(new Font("Dialog", Font.PLAIN, 20));
		g.drawString("SCORE = " + textScore, 180, 240);

		g.drawString(newHighScore, 180, 300);
		g.drawString("HIGH SCORE = " + textHighScore, 180, 360);


		g.setColor(Color.BLUE);
		g.drawString("Press a key to play again.", 180, 420);
		g.drawString("Press q to quit the game.", 180, 480);

	}

	private void displayGame(Graphics g) {
		displayGameGrid(g);
		displaySnake(g);
		displayKibble(g);
		displaySpider(g);
	}

	private void displayGameGrid(Graphics g) {

		int maxX = SnakeGame.xPixelMaxDimension;
		int maxY= SnakeGame.yPixelMaxDimension;
		int squareSize = SnakeGame.squareSize;
		
		g.clearRect(0, 0, maxX, maxY);

		g.setColor(Color.BLACK); // line color set to blue

		//Draw grid - horizontal lines
		for (int y=0; y <= maxY ; y+= squareSize){			
			g.drawLine(0, y, maxX, y);
		}
		//Draw grid - vertical lines
		for (int x=0; x <= maxX ; x+= squareSize){			
			g.drawLine(x, 0, x, maxY);
		}
	}

	private void displayKibble(Graphics g) {

		//Draw the kibble in orange
		g.setColor(Color.ORANGE);

		int x = kibble.getKibbleX() * SnakeGame.squareSize;
		int y = kibble.getKibbleY() * SnakeGame.squareSize;

		//g.fillRect(x+1, y+1, SnakeGame.squareSize-2, SnakeGame.squareSize-2);
		g.fillOval(x+1, y+1, SnakeGame.squareSize-2, SnakeGame.squareSize-2);
	}
	
	  private void displaySpider(Graphics g) {

        //Draw the spider in red
		g.setColor(Color.RED);

		int x = spider.getSpiderX() * SnakeGame.squareSize;
		int y = spider.getSpiderY() * SnakeGame.squareSize;

		g.fillRect(x+1, y+1, SnakeGame.squareSize-2, SnakeGame.squareSize-2);
	  }

	private void displaySnake(Graphics g) {

		LinkedList<Point> coordinates = snake.segmentsToDraw();
		
		//Draw head in grey
		g.setColor(Color.GREEN); // updated LIGHT_GRAY to GREEN
		Point head = coordinates.pop();
		g.fillRect((int)head.getX(), (int)head.getY(), SnakeGame.squareSize, SnakeGame.squareSize);
		
		
		//Draw rest of snake in black
		g.setColor(Color.BLACK);
		for (Point p : coordinates) {
			g.fillRect((int)p.getX(), (int)p.getY(), SnakeGame.squareSize, SnakeGame.squareSize);
		}

	}

	private void displayInstructions(Graphics g) {
	    // start game with greeting. Instruct the key to start and quit the game
	    g.setFont(new Font("Dialog", Font.BOLD, 40));
	    g.drawString("HELLO!",220,180);
	    
	    g.setFont(new Font("Dialog", Font.BOLD, 20));
	    g.setColor(Color.BLACK);
		g.drawString("Press any key to begin!",180,300);
		g.drawString("Press q to quit the game.",180,240);
	}
	
    
}

