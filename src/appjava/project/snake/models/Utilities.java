package appjava.project.snake.models;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Utilities {
	private static Border border = BorderFactory.createLineBorder(Color.BLACK);
	private static String user1Head = "Red";
	private static String user1Tail = "Pink";
	private static String user2Head = "Orange";
	private static String user2Tail = "Yellow";
	
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
    
    public static Border getBorder()
    {
    	return border;
    }
    
    public static Color getUser1Head()
    {
    	return getColor(user1Head);
    }
    
    public static Color getUser1Tail()
    {
    	return getColor(user1Tail);
    }
    
    public static Color getUser2Head()
    {
    	return getColor(user2Head);
    }
    
    public static Color getUser2Tail()
    {
    	return getColor(user2Tail);
    }
}