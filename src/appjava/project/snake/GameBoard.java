package appjava.project.snake;

class GameBoard {

    static GameBoard bd;
    private char[][] board;

    GameBoard() {
        this.board = new char[SnakeApp.app.getRows()][SnakeApp.app.getCols()];
        GameBoard.bd = this;
    }

    /**
     * Get the status (type) of the specified tile
     * @param r row number of the tile
     * @param c column number of the tile
     * @return status (type) of the tile at (r, c). If r or c is out of bound, -1 is returned to indicate an error
     */
    char getStatus(int r, int c) {
        if (r < 0 || r > board.length || c < 0 || c > board[0].length) {
            return -1;
        }
        return board[r][c];
    } 

    /**
     * Set the type (status) of tile at the given coordinate.
     * @param r row number
     * @param c column number
     * @param status {@link byte}
     */
    void setStatus(int r, int c, char status) {
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
        board[r][c] = status;
    }
}