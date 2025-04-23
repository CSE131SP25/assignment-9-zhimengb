package assignment9;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Food food;
	private Snake snake;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		//FIXME - construct new Snake and Food objects
		food =new Food();
		snake=new Snake();
	}
	
	public void play() {
	    while (!StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
	    	StdDraw.setPenColor(Color.BLACK);
	    	StdDraw.text(0.5, 0.8, "Game Start!");
	    	StdDraw.show();
	    }

			StdDraw.clear();
		while (snake.isInbounds()==true) { //TODO: Update this condition to check if snake is in bounds
			int dir = getKeypress();
			//Testing only: you will eventually need to do more work here
			System.out.println("Keypress: " + dir);
			
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
			
			snake.changeDirection(dir);
			snake.move();
			if (snake.eatFood(food)==true) {
				Food newfood = new Food();
				food=newfood;
			}
			updateDrawing();
		}
		
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		//FIXME
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
		StdDraw.clear();
		
		snake.draw();
		food.draw();
		StdDraw.setPenColor(Color.BLACK);
	    StdDraw.text(0.1, 0.9, "Length: " + snake.getLength());//creative
		StdDraw.pause(50);
		StdDraw.show();
	}
	
	
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}