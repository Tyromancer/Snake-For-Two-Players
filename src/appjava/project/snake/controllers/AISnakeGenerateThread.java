package appjava.project.snake.controllers;
import appjava.project.snake.models.*;
import appjava.project.snake.views.GameBoard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class AISnakeGenerateThread extends Thread {
    private static final int interval = 5000;

//    private List<Block> getBlocks(int r, int c, Direction d) {
//        switch
//    }

    @Override
    public void run() {


        while (!SnakeApp.app.isEnd()) {
            try {
                Thread.sleep(interval);
            } catch (Exception e) {
                e.printStackTrace();
            }

            int rows = SnakeApp.app.getRows();
            int cols = SnakeApp.app.getCols();


            Random random = new Random();
            int r = random.nextInt( ( rows - 2 ) + 1 ) + 2;
            int c = random.nextInt( ( cols - 2 ) + 1 ) + 2;

            LinkedList<Block> body = new LinkedList<>();
            // get the randomized init direction
            Direction direction = Direction.UP;
            int d = random.nextInt(4);
            switch (d) {
                case 0:
                    direction = Direction.UP;
                    body.add(GameBoard.bd.getBlock(r, c));
                    body.add(GameBoard.bd.getBlock(r - 1, c));
                    body.add(GameBoard.bd.getBlock(r - 2, c));
                    break;

                case 1:
                    direction = Direction.LEFT;
                    body.add(GameBoard.bd.getBlock(r, c));
                    body.add(GameBoard.bd.getBlock(r, c - 1));
                    body.add(GameBoard.bd.getBlock(r, c - 2));
                    break;

                case 2:
                    direction = Direction.DOWN;
                    body.add(GameBoard.bd.getBlock(r, c));
                    body.add(GameBoard.bd.getBlock(r + 1, c));
                    body.add(GameBoard.bd.getBlock(r + 2, c));
                    break;

                default:
                    direction = Direction.RIGHT;
                    body.add(GameBoard.bd.getBlock(r, c));
                    body.add(GameBoard.bd.getBlock(r, c + 1));
                    body.add(GameBoard.bd.getBlock(r, c + 2));
                    break;
            }

            // blink the area
            for (int i = 0; i < 5; i++) {
                if (body.get(i).isLocked()) { continue; }

                for (Block b : body) {
                    if (b.getStatus() != Status.PLAYER1 && b.getStatus() != Status.PLAYER2) {

                        b.lock();
                        b.setStatus(Status.BLINK);
                        b.setBackground(Utilities.getColor("Cyan"));

                        b.unlock();
                    }
                }

                try {
                    Thread.sleep(600);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                for (Block b : body) {
                    if (b.getStatus() == Status.BLINK) {
                        b.lock();
                        b.setBackground(Utilities.emptyColor());
                        b.unlock();
                    }
                }

                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            boolean isConflict = false;
            for (Block b : body) {
                if (b.isLocked() || b.getStatus() == Status.PLAYER1 || b.getStatus() == Status.PLAYER2 || b.getStatus() == Status.AI) {
                    isConflict = true;
                    break;
                }
            }

            if (!isConflict) {
                Snake snake = new Snake(body, direction, Owner.AI);
                new SnakeMovingThread(snake).start();
            } else {
                for (Block b : body) {
                    if (!b.isLocked() && b.getStatus() != Status.PLAYER1 && b.getStatus() != Status.PLAYER2 && b.getStatus() != Status.AI) {
                        b.lock();
                        b.setStatus(Status.POINT_ITEM);
                        b.unlock();
                    }
                }
            }
            // new SnakeMovingThread(snake)
        }
    }
}
