package appjava.project.snake.views;

import appjava.project.snake.controllers.Player1KeyListener;
import appjava.project.snake.controllers.Player2KeyListener;
import appjava.project.snake.controllers.SnakeApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
        
        JMenuItem gamePref = new JMenuItem("Game preferences");
//        gamePref.addActionListener((ActionEvent e) -> {
//            JDialog prefDialog = new JDialog();
//            prefDialog.setLayout(new GridLayout());
//
//            prefDialog.add(new JLabel("#Rows (30 - 100):"));
//            JTextField tfRow = new JTextField(3);
//            prefDialog.add(tfRow);
//
//            prefDialog.add(new JLabel("#Cols (30 - 100):"));
//            JTextField tfCol = new JTextField(3);
//            prefDialog.add(tfCol);
//
//            JButton cancelButton = new JButton("Cancel");
//            cancelButton.addActionListener((ActionEvent e1)->{
//                prefDialog.dispose();
//            });
//            prefDialog.add(cancelButton);
//
//            JButton confirmButton = new JButton("Apply");
//            confirmButton.addActionListener((ActionEvent e1)->{
//                int row, col;
//                try {
//                    row = Integer.parseInt(tfRow.getText());
//                    if (row < 30 || row > 100) { throw new NumberFormatException(); }
//                } catch (NumberFormatException nfe) {
//                    JOptionPane.showMessageDialog(prefDialog, "Invalid number of rows");
//                    return;
//                }
//
//                try {
//                    col = Integer.parseInt(tfCol.getText());
//                    if (col < 30 || col > 100) { throw new NumberFormatException(); }
//                } catch (NumberFormatException nfe) {
//                    JOptionPane.showMessageDialog(prefDialog, "Invalid number of cols");
//                    return;
//                }
//
//                SnakeApp.app.setProperty("rows", String.valueOf(row));
//                SnakeApp.app.setProperty("cols", String.valueOf(col));
//
//            });
//        });
//        this.mb.add(gamePref);
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
        this.pts1 = new JLabel("3");
        statPanel.add(this.pts1);

        statPanel.add(new JLabel("Points of Player 2:"));
        this.pts2 = new JLabel("3");
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
