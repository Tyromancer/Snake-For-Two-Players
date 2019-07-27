package appjava.project.snake.controllers;

import appjava.project.snake.views.SnakeView;

public class Main {
    public static void main(String[] args) {
        SnakeView.view = new SnakeView();
        SnakeApp.app = new SnakeApp();
        SnakeView.view.initGame();
    }
}