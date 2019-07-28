package appjava.project.snake.views;

import java.awt.GridLayout;

import javax.swing.JPanel;

import appjava.project.snake.controllers.SnakeApp;
import appjava.project.snake.models.Block;
import appjava.project.snake.models.Status;

public class GameBoard extends JPanel {

    public static final GameBoard bd = new GameBoard();
    private Block[][] board;

    private GameBoard() {
    	
    }
    
    public static void init()
    {
    	bd.board = new Block[SnakeApp.app.getRows()][SnakeApp.app.getCols()];
    	bd.setLayout(new GridLayout(SnakeApp.app.getRows(), SnakeApp.app.getCols()));

        for (int i = 0; i < SnakeApp.app.getRows(); i++) {
            for (int j = 0; j < SnakeApp.app.getCols(); j++) {
                Block b = new Block(i, j);
                bd.board[i][j] = b;
                bd.add(b);
            }
        }
    }

    public Block getBlock(int r, int c) {
        return this.board[r][c];
    }

    /**
     * Get the status (type) of the specified tile
     * @param r row number of the tile
     * @param c column number of the tile
     * @return status (type) of the tile at (r, c)
     */
    public Status getStatus(int r, int c) {
        if (r < 0 || r > board.length || c < 0 || c > board[0].length) {
            throw new RuntimeException("Index out of bound when setting tile status");
        }
        return board[r][c].getStatus();
    } 

    /**
     * Set the type (status) of tile at the given coordinate.
     * @param r row number
     * @param c column number
     * @param status 
     */
    public void setStatus(int r, int c, Status status) {
        // check if index out of bound
        if (r < 0 || r > board.length || c < 0 || c > board[0].length) {
            throw new RuntimeException("Index out of bound when setting tile status");
        }

        // protocol:
        // 1 --> player 1's snake
        // 2 --> player 2's snake
        // 3 --> AI snake
        // o --> point item
        // etc
        board[r][c].setStatus(status);;
    }
}