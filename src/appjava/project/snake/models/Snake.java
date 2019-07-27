package appjava.project.snake.models;

import javax.swing.*;

import java.util.*;

public class Snake {
    private LinkedList<Block> lst;
    private Direction lastDir, newDir;

    /**
     * assume src.length > 3
     * assume blocks in src is consistent
     * the first element in src is the tail
     * the last element in src is the head 
     * @param src
     * @param startDir
     */
    public Snake(List<Block> src, Direction startDir) {
        this.lst = new LinkedList<>();
        for (int i = 0; i < src.size(); i++) {
            lst.add(src.get(i));
        }
        
        this.lastDir = startDir;
        this.newDir = startDir;
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
    }
}