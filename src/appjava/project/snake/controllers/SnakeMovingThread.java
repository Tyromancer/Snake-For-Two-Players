package appjava.project.snake.controllers;

import java.util.Random;

import appjava.project.snake.models.Direction;
import appjava.project.snake.models.Snake;

public class SnakeMovingThread extends Thread{
	private Snake snake;
	
	public SnakeMovingThread(Snake snake) {
		this.snake = snake;
	}
	
	@Override
	public void run()
	{
		while(!SnakeApp.app.isEnd() && snake.isAlive())
		{
			try {
				Thread.sleep(snake.getMoveInterval());
				if(snake.isAI())
				{
					int pick = new Random().nextInt(Direction.values().length);
				    snake.changeDirection(Direction.values()[pick]);
				}
				snake.move();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
	}
}
