package appjava.project.snake.models;

import java.util.concurrent.locks.Lock;

import javax.swing.*;

public class Block extends JPanel {
    private Lock lock;
    private Status status;
    private int row, col;

    public Block(int row, int col) {
        super();
        this.status = Status.EMPTY;
        this.row = row;
        this.col = col;
        this.setBorder(Utilities.getBorder());
    }

    public void setStatus(Status s) {
        this.status = s;
    }

    public Status getStatus() {
        return this.status;
    }
    
    public int getRow()
    {
    	return this.row;
    }
    
    public int getCol()
    {
    	return this.col;
    }
    
    public void lock()
    {
    	
    }
    
    public void unlock()
    {
    	
    }
}