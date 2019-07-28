package appjava.project.snake.controllers;

import java.util.LinkedList;

import appjava.project.snake.models.Block;
import appjava.project.snake.models.Direction;
import appjava.project.snake.models.Owner;
import appjava.project.snake.models.Snake;
import appjava.project.snake.views.GameBoard;

public class SnakeGenerator {
	public static SnakeGenerator generator = new SnakeGenerator();
	private Snake user1, user2;
	
	private SnakeGenerator() {}
	
	public void generateUser1()
	{
		LinkedList<Block> lst = new LinkedList<Block>();
		lst.add(GameBoard.bd.getBlock(0, 0));
		lst.add(GameBoard.bd.getBlock(0, 1));
		lst.add(GameBoard.bd.getBlock(0, 2));
		this.user1 = new Snake(lst, Direction.RIGHT, Owner.User1);
	}
	
	public void generateUser2()
	{
		LinkedList<Block> lst = new LinkedList<Block>();
		lst.add(GameBoard.bd.getBlock(SnakeApp.app.getRows()-1, SnakeApp.app.getCols()-1));
		lst.add(GameBoard.bd.getBlock(SnakeApp.app.getRows()-1, SnakeApp.app.getCols()-2));
		lst.add(GameBoard.bd.getBlock(SnakeApp.app.getRows()-1, SnakeApp.app.getCols()-3));
		this.user2 = new Snake(lst, Direction.LEFT, Owner.User2);
	}
}
