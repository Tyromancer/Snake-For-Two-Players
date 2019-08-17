package appjava.project.snake.models;

import java.util.*;

import appjava.project.snake.controllers.SnakeApp;
import appjava.project.snake.views.GameBoard;
import appjava.project.snake.views.SnakeView;

/**
 * Snake class
 *
 */
public class Snake {
    private LinkedList<Block> lst;
    private Direction lastDir, newDir;
    private Owner owner;
    private long moveInterval;
    private boolean isAlive;

    /**
     * assume src.length > 3
     * assume blocks in src is continuous
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
        this.moveInterval = 200;
        this.isAlive = true;
        
        for (int i = 0; i < src.size(); i++) {
            lst.add(src.get(i));
        }
        
        for(Block b : lst)
        {
        	b.lock();
        }
        
        for(Block b : lst)
        {
        	switch (owner) {
			case PLAYER1:
				b.setStatus(Status.PLAYER1);
				b.setBackground(Utilities.getUser1Tail());
				break;
				
			case PLAYER2:
				b.setStatus(Status.PLAYER2);
				b.setBackground(Utilities.getUser2Tail());
				break;

			case AI:
				b.setStatus(Status.AI);
				b.setBackground(Utilities.aiColor());
				break;

			default:
				break;
			}
        }
        
        switch (owner) {
		case PLAYER1:
			lst.getLast().setBackground(Utilities.getUser1Head());
			break;
			
		case PLAYER2:
			lst.getLast().setBackground(Utilities.getUser2Head());
			break;

		case AI:
			lst.getLast().setBackground(Utilities.aiColor().darker());
			break;

		default:
			break;
		}
        
        for(Block b : lst)
        {
        	b.unlock();
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
    	Block head = lst.getLast();
    	int row = head.getRow();
    	int col = head.getCol();
    	switch (newDir) {
		case UP:
			row--;
			break;
			
		case DOWN:
			row++;
			break;
			
		case LEFT:
			col--;
			break;
			
		case RIGHT:
			col++;
			break;

		default:
			break;
		}
    	
    	if(row < 0 || col < 0 || row >= SnakeApp.app.getRows() || col >= SnakeApp.app.getCols())
    	{
    		System.out.println(String.format("ROW: %d COL: %d", row, col));
    		die();
    		return;
    	}
    	Block next = GameBoard.bd.getBlock(row, col);
    	next.lock();
    	Status nextStat = next.getStatus();
    	
    	boolean getPoint = false;
    	switch (nextStat) {
		case POINT_ITEM:
			getPoint = true;
			if (owner == Owner.PLAYER1) {
				SnakeView.view.addPts1();
			} else if (owner == Owner.PLAYER2) {
				SnakeView.view.addPts2();
			}

			break;
			
		case EMPTY:
			
			break;

		case BLINK:

			break;
			
		case SPEED_UP:
			speedUp();
			break;
			
		case SPEED_DOWN:
			speedDown();
			break;

		default:
			next.unlock();
			die();
			return;
		}
    	
    	switch (owner) {
		case PLAYER1:
			lst.getLast().setBackground(Utilities.getUser1Tail());
			next.setStatus(Status.PLAYER1);
			next.setBackground(Utilities.getUser1Head());
			lst.add(next);
			next.unlock();
			break;
			
		case PLAYER2:
			lst.getLast().setBackground(Utilities.getUser2Tail());
			next.setStatus(Status.PLAYER2);
			next.setBackground(Utilities.getUser2Head());
			lst.add(next);
			next.unlock();
			break;

		case AI:
			lst.getLast().setBackground(Utilities.aiColor());
			next.setStatus(Status.AI);
			next.setBackground(Utilities.aiColor().darker());
			lst.add(next);
			next.unlock();
			break;
			
		default:
			break;
		}
    	
    	if(!getPoint)
    	{
    		Block tail = lst.removeFirst();
        	tail.lock();
        	tail.setStatus(Status.EMPTY);
        	tail.setBackground(Utilities.emptyColor());
        	tail.unlock();

    	}

		if (this.lst.size() == SnakeApp.app.getMaxPts()) {
			SnakeApp.app.winGame(owner);
		}
    	
    	lastDir = newDir;
    	//System.out.println(owner + " move!");
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
    
    /**
     * kill the snake
     */
    public void die()
    {
    	this.isAlive = false;
    	System.out.println(owner + " died!");
    	if(owner == Owner.AI)
    	{
    		for(Block b : lst)
    		{
    			b.lock();
    		}
    		
    		for(Block b : lst)
    		{
    			b.setStatus(Status.POINT_ITEM);
    			b.setBackground(Utilities.pointColor());
    		}
    		
    		for(Block b : lst)
    		{
    			b.unlock();
    		}
    	} else {
    		SnakeApp.app.endGame(this.owner);

		}


    }
    
    /**
     * increase the snake's speed
     */
    public void speedUp()
    {
    	this.moveInterval *= 0.9;
    	if (owner == Owner.PLAYER1) {
    		SnakeView.view.setV1(1.0 / this.moveInterval);
		} else if (owner == Owner.PLAYER2) {
    		SnakeView.view.setV2(1.0 / this.moveInterval);
		}
    }
    
    /**
     * decrease the snake's speed
     */
    public void speedDown()
    {
    	this.moveInterval /= 0.9;
		if (owner == Owner.PLAYER1) {
			SnakeView.view.setV1(1.0 / this.moveInterval);
		} else if (owner == Owner.PLAYER2) {
			SnakeView.view.setV2(1.0 / this.moveInterval);
		}
    }
    
    /**
     * check if the snake is AI
     * @return true if the snake is AI, false if the snake is player
     */
    public boolean isAI()
    {
    	return this.owner == Owner.AI;
    }
}