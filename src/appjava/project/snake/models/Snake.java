package appjava.project.snake.models;

import java.util.*;

public class Snake {
    private LinkedList<Block> lst;
    private Direction lastDir, newDir;
    private Owner owner;
    private long moveInterval;
    private boolean isAlive;

    /**
     * assume src.length > 3
     * assume blocks in src is consistent
     * the first element in src is the tail
     * the last element in src is the head 
     * @param src
     * @param startDir
     */
    public Snake(LinkedList<Block> src, Direction startDir, Owner owner) {
        this.lst = new LinkedList<>();
        this.owner = owner;
        this.lastDir = startDir;
        this.newDir = startDir;
        this.moveInterval = 500;
        this.isAlive = true;
        
        for (int i = 0; i < src.size(); i++) {
            lst.add(src.get(i));
        }
        
        for(Block b : lst)
        {
        	switch (owner) {
			case User1:
				b.setBackground(Utilities.getUser1Tail());
				break;
				
			case User2:
				b.setBackground(Utilities.getUser2Tail());
				break;

			default:
				break;
			}
        }
        
        switch (owner) {
		case User1:
			lst.getLast().setBackground(Utilities.getUser1Head());
			break;
			
		case User2:
			lst.getLast().setBackground(Utilities.getUser2Head());

		default:
			break;
		}

    }
    
    /**
     * set the new direction of the snake
     * when the input direction is equal to the opposite of the last direction, nothing happens
     * @param dir the new direction being set
     */
    public void changeDirection(Direction dir)
    {
    	if(dir == Direction.UP && lastDir == Direction.DOWN)
    		return;
    	if(dir == Direction.DOWN && lastDir == Direction.UP)
    		return;
    	if(dir == Direction.LEFT && lastDir == Direction.RIGHT)
    		return;
    	if(dir == Direction.RIGHT && lastDir == Direction.LEFT)
    		return;
    	
    	newDir = dir;
    }
    
    /**
     * move the snake one block toward its direction
     * 
     */
    public void move()
    {
    	//TODO: find the next block
    	//TODO: check the next block
    	//TODO: do the corresponding behavior
    	//TODO: update snake body
    	
    	lastDir = newDir;
    	System.out.println(owner + " move!");
    }
    
    /**
     * move interval is the number of milliseconds to move once
     * @return moveInterval
     */
    public long getMoveInterval()
    {
    	return this.moveInterval;
    }
    
    /**
     * 
     * @return true if snake is alive, false otherwise
     */
    public boolean isAlive()
    {
    	return this.isAlive;
    }
}