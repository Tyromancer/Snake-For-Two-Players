package appjava.project.snake.controllers;

import appjava.project.snake.models.Snake;

public class SnakeMovingThread extends Thread{
	private Snake snake;
	
	public SnakeMovingThread(Snake snake) {
		this.snake = snake;
	}
	
	@Override
	public void run()
	{
		while(snake.isAlive())
		{
			try {
				Thread.sleep(snake.getMoveInterval());
				snake.move();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
	}
}
