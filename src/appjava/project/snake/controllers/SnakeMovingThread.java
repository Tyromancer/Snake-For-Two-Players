package appjava.project.snake.controllers;

import java.util.Random;

import appjava.project.snake.models.Direction;
import appjava.project.snake.models.Snake;

/**
 * the snake will keep moving whenever it moves
 *
 */
public class SnakeMovingThread extends Thread{
	private Snake snake;
	
	/**
	 * create a thread of snake
	 * @param snake
	 */
	public SnakeMovingThread(Snake snake) {
		this.snake = snake;
	}
	
	/**
	 * snake will keep moving when it lives
	 */
	@Override
	public void run()
	{
		while(!SnakeApp.app.isEnd() && snake.isAlive())
		{
			try {
				Thread.sleep(snake.getMoveInterval());

				// if is AI snake, let the RNG decide
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
