package appjava.project.snake.controllers;

import java.util.Random;

import appjava.project.snake.models.Block;
import appjava.project.snake.models.Status;
import appjava.project.snake.models.Utilities;
import appjava.project.snake.views.GameBoard;

/**
 * automatically generate the new items on the board.
 * 3 different items in total: regular item, speed-up, speed down
 * regular item make snake grow
 * speed-up item make snake travel faster
 * speed-down item slow the snake down
 *
 */
public class AutoPointGenerator extends Thread {
	
	public static int interval = 1000;
	
	/**
	 * main function
	 * generate items randomly
	 * ratio: 7 regular item : 2 speed-up item : 1 slow-down item
	 */
	public void run()
	{
		while(!SnakeApp.app.isEnd())
		{
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}

			interval -= 10;

			int total_row = SnakeApp.app.getRows();
			int total_col = SnakeApp.app.getCols();
			
			while (true)
			{
				Random rand = new Random();
				int rand_row = rand.nextInt(total_row);
				int rand_col = rand.nextInt(total_col);
				int rand_item = rand.nextInt(100);
				
				
				Block b = GameBoard.bd.getBlock(rand_row, rand_col);
				if (b.isLocked()) continue;
				if (b.getStatus() != Status.EMPTY) continue;
				try
				{
					b.lock();
					
					if (rand_item<70) 
					{
						b.setStatus(Status.POINT_ITEM);
						b.setBackground(Utilities.pointColor());
					}
					else if (rand_item>70 && rand_item < 90)
					{
						b.setStatus(Status.SPEED_UP);
						b.setBackground(Utilities.speedUpColor());
					}
					else if (rand_item>90)
					{
						b.setStatus(Status.SPEED_DOWN);
						b.setBackground(Utilities.speedDownColor());
					}
				}
				finally
				{
					b.unlock();
				}
				break;
			}
			
			
		}
	}
	
}
