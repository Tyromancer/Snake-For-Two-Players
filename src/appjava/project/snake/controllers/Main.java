package appjava.project.snake.controllers;

import appjava.project.snake.views.SnakeView;

public class Main {
    public static void main(String[] args) {
        // initialize view part
        SnakeView.view = new SnakeView();
        SnakeApp.init();
    }
}