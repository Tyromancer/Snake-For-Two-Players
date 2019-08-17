package appjava.project.snake.models;

import java.util.concurrent.locks.ReentrantLock;

import javax.swing.*;
/**
 * Block class
 * contains information of its location(row and colimn) and it status
 *
 */
public class Block extends JPanel {
    private ReentrantLock lock;
    private Status status;
    private int row, col;

    /**
     * create a block
     * @param row block's row location
     * @param col block's col location
     */
    public Block(int row, int col) {
        super();
        this.status = Status.EMPTY;
        this.setBackground(Utilities.emptyColor());
        this.row = row;
        this.col = col;
        this.lock = new ReentrantLock();
        // this.setBorder(Utilities.getBorder());
    }

    /**
     *  set the status of block
     * @param s block's status
     */
    public void setStatus(Status s) {
        this.status = s;
    }

    /**
     * get the status of block
     * @return the status of current block
     */
    public Status getStatus() {
        return this.status;
    }
    
    /**
     * get the row
     * @return the row of current block
     */
    public int getRow()
    {
    	return this.row;
    }
    
    /**
     * get the column
     * @return  the column of current block
     */
    public int getCol()
    {
    	return this.col;
    }
    
    /**
     * lock the current block(cannot be modified by other thread)
     */
    public void lock()
    {
    	lock.lock();
    }
    
    /**
     * unlock the current block(can be modified by other thread)
     */
    public void unlock()
    {
    	lock.unlock();
    }
    
    /**
     * check the block's lock status( if the current block lock or unlock)
     * @return the block's status
     */
    public boolean isLocked()
    {
    	return lock.isLocked();
    }
}