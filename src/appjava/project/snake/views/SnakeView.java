package appjava.project.snake.views;

import appjava.project.snake.controllers.Player1KeyListener;
import appjava.project.snake.controllers.Player2KeyListener;

import javax.swing.*;
import java.awt.*;

public class SnakeView extends JFrame {
    /**
     * static reference to this instance
     */
    public static SnakeView view;

    private JMenuBar mb;
    private JLabel pts1;
    private JLabel pts2;
    private JLabel v1;
    private JLabel v2;
    // private SnakeApp sApp;


    /**
     * Increase points gained by player 1 by one
     */
    public void addPts1() {
        this.pts1.setText(String.valueOf( Integer.parseInt(this.pts1.getText()) + 1 ));
    }

    /**
     * Increase points gained by player 2 by one
     */
    public void addPts2() {
        this.pts2.setText(String.valueOf( Integer.parseInt(this.pts2.getText()) + 1 ));
    }

    public void setV1(double v) {
        this.v1.setText(String.format("%.4f", 1 + v));
    }

    public void setV2(double v) {
        this.v2.setText(String.format("%.4f", 1 + v));
    }

    private void setupMenu() {
        this.mb = new JMenuBar();
        setPreferenceMenu();
        this.setJMenuBar(this.mb);
    }

    private void setPreferenceMenu() {
        JMenuItem colorPref = new JMenuItem("Color preferences");
        
        JMenuItem gamePref = new JMenuItem("Game preferences");
        this.mb.add(colorPref);
        this.mb.add(gamePref);
    }

    private void initDisplay() {
        // setup the rest of the UI
        // game board and info area
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));

        // TODO: implement the game board using a custom JComponent class or just draw rect (since it is faster) ?
        // GamePanel gp = new GamePanel();
        // gp.setAlignmentX(Component.LEFT_ALIGNMENT);
        // gp.setAlignmentY(Component.TOP_ALIGNMENT);
        // gp.setSize(100 * SnakeApp.app.getCols(), 100 * SnakeApp.app.getRows());
        // this.add(gp);
        GameBoard.bd.setAlignmentX(Component.LEFT_ALIGNMENT);
        GameBoard.bd.setAlignmentY(Component.TOP_ALIGNMENT);
        this.add(GameBoard.bd);

        JPanel statPanel = new JPanel();
        statPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        statPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        statPanel.setLayout(new GridLayout(4, 2));

        statPanel.add(new JLabel("Points of Player 1:"));
        this.pts1 = new JLabel("0");
        statPanel.add(this.pts1);

        statPanel.add(new JLabel("Points of Player 2:"));
        this.pts2 = new JLabel("0");
        statPanel.add(this.pts2);

        statPanel.add(new JLabel("Speed of Player 1:"));
        this.v1 = new JLabel(String.format("%.3f", 1.0 / 200.0));
        statPanel.add(this.v1);

        statPanel.add(new JLabel("Speed of Player 2:"));
        this.v2 = new JLabel(String.format("%.3f", 1.0 / 200.0));
        statPanel.add(this.v2);

        this.add(statPanel);
    }

    public void initGame() {
        this.setupMenu();
        this.initDisplay();
        this.addKeyListener(new Player1KeyListener());
        this.addKeyListener(new Player2KeyListener());

        this.pack();
        this.setVisible(true);
    }

    public SnakeView() {
        super("Snake for two players");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
