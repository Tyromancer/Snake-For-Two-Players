package appjava.project.snake.views;

import javax.swing.*;

public class SnakeView extends JFrame {
    /**
     * static reference to this instance
     */
    public static SnakeView view;

    private JMenuBar mb;
    // private SnakeApp sApp;


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
        this.add(GameBoard.bd);
        
    }

    public void initGame() {
        this.setupMenu();
        this.initDisplay();

        this.pack();
        this.setVisible(true);
    }

    public SnakeView() {
        super("Snake for two players");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
