package appjava.project.snake.models;

import appjava.project.snake.controllers.SnakeApp;

public class GameBoard {

    public static GameBoard bd;
    private Block[][] board;

    public GameBoard() {
        this.board = new Block[SnakeApp.app.getRows()][SnakeApp.app.getCols()];
        GameBoard.bd = this;
    }

    public void setBlock(int r, int c, Block src) {
        this.board[r][c] = src;
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