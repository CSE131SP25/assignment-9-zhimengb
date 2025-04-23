package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
		segments=new LinkedList<>();
		segments.add(new BodySegment(0,0,SEGMENT_SIZE));
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		//FIXME
		for(int i=segments.size()-1; i>0;i--) {
			BodySegment segmenti1=segments.get(i-1);
			BodySegment segmenti=segments.get(i);
			double x=segmenti1.getX();
			double y=segmenti1.getY();
			segmenti.setX(x);
			segmenti.setY(y);
		}
		BodySegment segment0=segments.get(0);
		double x=segment0.getX();
		double y=segment0.getY();
		segment0.setX(x+deltaX);
		segment0.setY(y+deltaY);
	}
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		//FIXME
		BodySegment segment0=segments.get(0);
		for(int i=0; i<segments.size();i++) {
			BodySegment segmenti=segments.get(i);
			segmenti.draw();
		}
		
	}
	/**
	 * Creative portion:
	 * gets the length of the snake to be displayed
	 */
	public int getLength() {
	    return segments.size();
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		//FIXME
		BodySegment segment0=segments.get(0);
		double x=segment0.getX();
		double y=segment0.getY();
		if (Math.sqrt(Math.pow((x-f.getX()),2)+Math.pow((y-f.getY()),2))<=SEGMENT_SIZE){
			segments.addFirst(new BodySegment(f.getX()+SEGMENT_SIZE,f.getY(),SEGMENT_SIZE));
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		//FIXME
		BodySegment segment0=segments.get(0);
		double x=segment0.getX();
		double y=segment0.getY();
		if (x<0 || x>1 || y<0 || y>1) {
			
			return false;
		}
		return true;
	}
}