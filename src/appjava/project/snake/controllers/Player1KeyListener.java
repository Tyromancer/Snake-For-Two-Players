package appjava.project.snake.controllers;

import appjava.project.snake.models.PlayerAction;

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

        int code = e.getKeyCode();
        switch (code) {
            case 87:
                // w
                SnakeController.controller.performAction(PlayerAction.user1Up);
                break;

            case 65:
                // a --> move left
                SnakeController.controller.performAction(PlayerAction.user1Left);
                break;

            case 83:
                // s --> move down
                SnakeController.controller.performAction(PlayerAction.user1Down);
                break;

            case 68:
                // d --> move right
                SnakeController.controller.performAction(PlayerAction.user1Right);
                break;
            default:
                return;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        return;
    }
}
