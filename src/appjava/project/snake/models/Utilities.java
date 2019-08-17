package appjava.project.snake.models;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * 
 *
 */
public class Utilities {
	private static Border border = BorderFactory.createLineBorder(Color.BLACK);
	private static String user1Head = "Red";
	private static String user1Tail = "Pink";
	private static String user2Head = "Orange";
	private static String user2Tail = "Yellow";
	private static Color speedUp = new Color(178,156,231);
	private static Color speedDown = new Color(111,123,11);
	
    /**
     * Get color based on string input
     * @param color string representing a color
     * @return {@link Color} reference required
     */
    public static Color getColor(String color) {
        // return color based on string input

        if (color == null) {
            return Color.WHITE;
        }
        Color c = Color.WHITE;
        if (color.equals("Black")) {
            c = Color.BLACK;
        } else if (color.equals("Blue")) {
            c = Color.BLUE;
        } else if (color.equals("Cyan")) {
            c = Color.CYAN;
        } else if (color.equals("Dark Gray")) {
            c = Color.DARK_GRAY;
        } else if (color.equals("Gray")) {
            c = Color.GRAY;
        } else if (color.equals("Green")) {
            c = Color.GREEN;
        } else if (color.equals("Light Gray")) {
            c = Color.LIGHT_GRAY;
        } else if (color.equals("Magenta")) {
            c = Color.MAGENTA;
        } else if (color.equals("Orange")) {
            c = Color.ORANGE;
        } else if (color.equals("Pink")) {
            c = Color.pink;
        } else if (color.equals("Red")) {
            c = Color.RED;
        } else if (color.equals("White")) {
            c = Color.WHITE;
        } else if (color.equals("Yellow")) {
            c = Color.YELLOW;
        }

        return c;
    }
    
    /**
     * Get the border
     * @return border
     */
    public static Border getBorder()
    {
    	return border;
    }
    
    /**
     * Get the color of player1 head
     * @return the color of header of player1
     */
    
    public static Color getUser1Head()
    {
    	return getColor(user1Head);
    }
    
    
    /**
     * Get the color of player1's tail
     * @return the color of tail of player1
     */
    public static Color getUser1Tail()
    {
    	return getColor(user1Tail);
    }
    
    /**
     * Get the color of player1 head
     * @return the color of header of player2
     */
    public static Color getUser2Head()
    {
    	return getColor(user2Head);
    }
    
    /**
     * Get the color of player2 tail
     * @return the color of player2's tail
     */
    public static Color getUser2Tail()
    {
    	return getColor(user2Tail);
    }
    
    /**
     * Get the color of empty block
     * @return the color of empty block
     */
    public static Color emptyColor()
    {
    	return getColor("WHITE");
    }
    
    /**
     * Get the color of regular point item
     * @return the color of regular point item
     */
    public static Color pointColor()
    {
    	return getColor("Green");
    }
    
    /**
     * Get the color of speed-up item
     * @return the color of speed up item color
     */
    public static Color speedUpColor()
    {
    	return speedUp;
    }
    
    /**
     * Get the color of speed-down item
     * @return the color of speed down item color
     */
    public static Color speedDownColor()
    {
    	return speedDown;
    }
    
    /**
     * Get the color of AI snake
     * @return the color of ai snake
     */
    public static Color aiColor()
    {
    	return getColor("Cyan");
    }
}