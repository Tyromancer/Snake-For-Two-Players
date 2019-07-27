package appjava.project.snake.models;

import appjava.project.snake.controllers.SnakeApp;

class GameBoard {

    static GameBoard bd;
    private Block[][] board;

    GameBoard() {
        this.board = new Block[SnakeApp.app.getRows()][SnakeApp.app.getCols()];
        for (int i = 0; i < SnakeApp.app.getRows(); i++) {
            for (int j = 0; j < SnakeApp.app.getCols(); j++) {
                this.board[i][j] = new Block();
            }
        }
        GameBoard.bd = this;
    }

    /**
     * Get the status (type) of the specified tile
     * @param r row number of the tile
     * @param c column number of the tile
     * @return status (type) of the tile at (r, c)
     */
    Status getStatus(int r, int c) {
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
    void setStatus(int r, int c, Status status) {
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