package appjava.project.snake.controllers;

import appjava.project.snake.models.PlayerAction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player2KeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (SnakeController.controller == null) { return; }

        int code = e.getKeyCode();
        if (code == SnakeApp.p2Up) {
            SnakeController.controller.performAction(PlayerAction.user2Up);
        } else if (code == SnakeApp.p2Down) {
            SnakeController.controller.performAction(PlayerAction.user2Down);
        } else if (code == SnakeApp.p2Left) {
            SnakeController.controller.performAction(PlayerAction.user2Left);
        } else if (code == SnakeApp.p2Right) {
            SnakeController.controller.performAction(PlayerAction.user2Right);
        }
//        switch (code) {
//
//            case 38:
//                // up arrow
//                System.out.println("up arrow pressed");
//                SnakeController.controller.performAction(PlayerAction.user2Up);
//                break;
//
//            case 37:
//                // left arrow
//                System.out.println("left arrow pressed");
//                SnakeController.controller.performAction(PlayerAction.user2Left);
//                break;
//
//            case 40:
//                // down arrow
//                System.out.println("down arrow pressed");
//                SnakeController.controller.performAction(PlayerAction.user2Down);
//                break;
//
//            case 39:
//                // right arrow
//                System.out.println("right arrow pressed");
//                SnakeController.controller.performAction(PlayerAction.user2Right);
//                break;
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
