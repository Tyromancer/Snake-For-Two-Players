package appjava.project.snake.controllers;

import appjava.project.snake.models.PlayerAction;
import appjava.project.snake.models.Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player1KeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        // TODO: check if game started and status of snake 1
        if (SnakeController.controller == null) { return; }
//        int up = SnakeApp.p1Up;
//        int down = SnakeApp.p1Down;
//        int left = SnakeApp.p1Left;
//        int right = SnakeApp.p1Right;

        int code = e.getKeyCode();
        if (code == SnakeApp.p1Up) {
            SnakeController.controller.performAction(PlayerAction.user1Up);
        } else if (code == SnakeApp.p1Down) {
            SnakeController.controller.performAction(PlayerAction.user1Down);
        } else if (code == SnakeApp.p1Left) {
            SnakeController.controller.performAction(PlayerAction.user1Left);
        } else if (code == SnakeApp.p1Right) {
            SnakeController.controller.performAction(PlayerAction.user1Right);
        }
//        switch (code) {
//            case SnakeApp.p1Up:
//                // w
//                SnakeController.controller.performAction(PlayerAction.user1Up);
//                break;
//
//            case 65:
//                // a --> move left
//                SnakeController.controller.performAction(PlayerAction.user1Left);
//                break;
//
//            case 83:
//                // s --> move down
//                SnakeController.controller.performAction(PlayerAction.user1Down);
//                break;
//
//            case 68:
//                // d --> move right
//                SnakeController.controller.performAction(PlayerAction.user1Right);
//                break;
//            default:
//                return;
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        return;
    }
}
