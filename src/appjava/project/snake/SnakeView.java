package appjava.project.snake;

import javax.swing.*;

public class SnakeView extends JFrame {
    /**
     * Package-wise static reference to this instance
     */
    static SnakeView view;

    private JMenuBar mb;
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

    private SnakeView() {
        super("Snake for two players");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeView.view = this;
        this.setupMenu();

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {

    }
}
