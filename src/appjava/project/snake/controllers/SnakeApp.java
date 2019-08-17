package appjava.project.snake.controllers;

import javax.swing.*;

import appjava.project.snake.models.Owner;
import appjava.project.snake.views.GameBoard;
import appjava.project.snake.views.SnakeView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

/**
 * snake GUI
 *
 */
public class SnakeApp {
    public static final SnakeApp app = new SnakeApp();
    private Properties props;
    private Logger log;

    public static int p1Up;
    public static int p1Down;
    public static int p1Left;
    public static int p1Right;
    public static int p2Up;
    public static int p2Down;
    public static int p2Left;
    public static int p2Right;

    private int rows;
    private int cols;
    private int maxPts;
    private boolean isEnd;

    /**
     * set up the logger for snake GUI
     */
    private void setupLogger() {
        this.log = Logger.getLogger("SnakeApp");
        StreamHandler handler;
        try {
            handler = new FileHandler();
        } catch (Exception e) {
            log.warning(String.format("Unable to create global logger file handler: %s\n", e.getMessage()));
            return;
        }
        handler.setFormatter(new SimpleFormatter());
        log.addHandler(handler);
    }

    /**
     * Get the global logger for debug output and information
     * @return {@link Logger} global logger of the game
     */
    public Logger getLogger() {
        return this.log;
    }

    private void loadConfig() {
        this.props = new Properties();
        loadDefaultConfig();
    }

    private void loadDefaultConfig() {
        // load default configurations
        props.setProperty("p1Color", "Green");
        props.setProperty("p2Color", "Red");
        props.setProperty("emptyColor", "White");
        props.setProperty("itemColor", "Yellow");
        props.setProperty("rows", "40");
        props.setProperty("cols", "40");
        props.setProperty("maxPts", "30");

        this.maxPts = 30;
        this.rows = 40;
        this.cols = 40;
    }

    // getter functions

    /**
     * Get the number of rows
     * @return number of rows of the game board
     */
    public int getRows() {
        return Integer.parseInt(props.getProperty("rows"));
    }

    /**
     * Get the number of columns
     * @return number of columns of the game board
     */
    public int getCols() {
        return Integer.parseInt(props.getProperty("cols"));
    }
    
    public boolean isEnd()
    {
    	return this.isEnd;
    }

    public String getProperty(String k) {
        return this.props.getProperty(k);
    }

    public void setProperty(String k, String v) {
        this.props.setProperty(k, v);
    }

    public int getMaxPts() {
        return maxPts;
    }

    private SnakeApp()
    {
    	
    }

    public void winGame(Owner player) {
        this.isEnd = true;
        if (player == Owner.PLAYER1) {
            JOptionPane.showMessageDialog(SnakeView.view, "Player 1 WON!");
        } else {
            JOptionPane.showMessageDialog(SnakeView.view, "Player 2 WON!");
        }
    }

    public void endGame(Owner player) {
        this.isEnd = true;
        if (player == Owner.PLAYER1) {
            JOptionPane.showMessageDialog(SnakeView.view, "Player 2 WON!");
        } else {
            JOptionPane.showMessageDialog(SnakeView.view, "Player 1 WON!");
        }
    }

    /**
     * Show a popup window to let the user config the game
     */
    public static void init() {
    	app.isEnd = false;
        // load properties, set up global logger
        app.props = new Properties();
        app.setupLogger();

        app.loadConfig();

        JDialog pref = new JDialog();
        pref.setLayout(new GridLayout(5, 2));

        pref.add(new JLabel("#Rows (30 - 100):"));
        JTextField tfRow = new JTextField(3);
        tfRow.setText("40");
        pref.add(tfRow);

        pref.add(new JLabel("#Cols (30 - 100)"));
        JTextField tfCol = new JTextField(3);
        tfCol.setText("40");
        pref.add(tfCol);

        pref.add(new JLabel("Player 1 key bindings:"));
        String[] p1keys = {"WASD", "ZXCV"};
        JComboBox<String> player1Keys = new JComboBox<>(p1keys);
        player1Keys.setSelectedItem("WASD");
        pref.add(player1Keys);

        pref.add(new JLabel("Player 2 key bindings:"));
        String[] p2Keys = {"ARROWS", "HJKL"};
        JComboBox<String> player2Keys = new JComboBox<>(p2Keys);
        player2Keys.setSelectedItem("ARROWS");
        pref.add(player2Keys);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener((ActionEvent e) -> {
            pref.dispose();
            return;
        });
        pref.add(cancelButton);

        JButton confirmButton = new JButton("Apply");
        confirmButton.addActionListener((ActionEvent e) -> {
            int row, col;
            try {
                row = Integer.parseInt(tfRow.getText());
                if (row < 30 || row > 100) { throw new NumberFormatException(); }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(pref, "Invalid number of rows");
                return;
            }

            try {
                col = Integer.parseInt(tfCol.getText());
                if (col < 30 || col > 100) { throw new NumberFormatException(); }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(pref, "Invalid number of cols");
                return;
            }

            SnakeApp.app.setProperty("rows", String.valueOf(row));
            SnakeApp.app.setProperty("cols", String.valueOf(col));

            String p1Binding = (String) player1Keys.getSelectedItem();
            if (p1Binding.equals("WASD")) {
                p1Up = 87;
                p1Down = 83;
                p1Left = 65;
                p1Right = 68;
            } else {
                p1Up = 67;
                p1Down = 88;
                p1Left = 90;
                p1Right = 86;
            }

            String p2Binding = (String) player2Keys.getSelectedItem();
            if (p2Binding.equals("ARROWS")) {
                p2Up = 38;
                p2Down = 40;
                p2Left = 37;
                p2Right = 39;
            } else {
                p2Up = 75;
                p2Down = 74;
                p2Left = 72;
                p2Right = 76;
            }

            // initialize game board
            GameBoard.init();

            // generate player 1 and player 2
            SnakeController.controller.generateUser1();
            SnakeController.controller.generateUser2();

            AutoPointGenerator a = new AutoPointGenerator();
            AISnakeGenerateThread my_b = new AISnakeGenerateThread();
            a.start();
            my_b.start();

            SnakeView.view.initGame();
            SnakeController.controller.start();

            pref.dispose();
        });

        pref.add(confirmButton);
        pref.pack();
        pref.setVisible(true);

    }
}
