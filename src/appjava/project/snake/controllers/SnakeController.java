package appjava.project.snake.controllers;

import java.util.LinkedList;

import appjava.project.snake.models.Block;
import appjava.project.snake.models.Direction;
import appjava.project.snake.models.Owner;
import appjava.project.snake.models.PlayerAction;
import appjava.project.snake.models.Snake;
import appjava.project.snake.views.GameBoard;
/**
 * generate player1 and player2 and player's operation
 *
 */
public class SnakeController {
	public static SnakeController controller = new SnakeController();
	private Snake user1, user2;
	private SnakeMovingThread user1Thread, user2Thread;
	
	private SnakeController() {}

	/**
	 * Initialize Player 1
	 */
	public void generateUser1()
	{
		// build snake by adding blocks
		LinkedList<Block> lst = new LinkedList<Block>();
		lst.add(GameBoard.bd.getBlock(0, 0));
		lst.add(GameBoard.bd.getBlock(0, 1));
		lst.add(GameBoard.bd.getBlock(0, 2));

		// player 1 will move to the right at start of game
		this.user1 = new Snake(lst, Direction.RIGHT, Owner.PLAYER1);
		this.user1Thread = new SnakeMovingThread(user1);
	}

	/**
	 * Initialize player 2
	 */
	public void generateUser2()
	{
		LinkedList<Block> lst = new LinkedList<Block>();
		lst.add(GameBoard.bd.getBlock(SnakeApp.app.getRows() - 1, SnakeApp.app.getCols() - 1));
		lst.add(GameBoard.bd.getBlock(SnakeApp.app.getRows() - 1, SnakeApp.app.getCols() - 2));
		lst.add(GameBoard.bd.getBlock(SnakeApp.app.getRows() - 1, SnakeApp.app.getCols() - 3));
		this.user2 = new Snake(lst, Direction.LEFT, Owner.PLAYER2);
		this.user2Thread = new SnakeMovingThread(user2);
	}
	/**
	 * start the game
	 */
	public void start()
	{
		user1Thread.start();
		user2Thread.start();
	}

	/**
	 * Change snake direction
	 * @param action Enum that represents the action taken by user
	 */
	public void performAction(PlayerAction action) {
		switch (action) {
			case user1Up:
				user1.changeDirection(Direction.UP);
				break;

			case user1Left:
				user1.changeDirection(Direction.LEFT);
				break;

			case user1Down:
				user1.changeDirection(Direction.DOWN);
				break;

			case user1Right:
				user1.changeDirection(Direction.RIGHT);
				break;

			case user2Up:
				user2.changeDirection(Direction.UP);
				break;

			case user2Left:
				user2.changeDirection(Direction.LEFT);
				break;

			case user2Down:
				user2.changeDirection(Direction.DOWN);
				break;

			case user2Right:
				user2.changeDirection(Direction.RIGHT);
				break;
			default:
				return;
		}
	}
}
