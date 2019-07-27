package appjava.project.snake.controllers;

import javax.swing.*;

import appjava.project.snake.models.Utilities;
import appjava.project.snake.views.SnakeView;

import java.awt.*;
import java.awt.event.*;

public class SetColorActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog colorDialog = new JDialog();
            colorDialog.setLayout(new GridLayout(4, 2));
            colorDialog.setBackground(Utilities.getColor(SnakeApp.app.getProperty("uiColor")));

            String[] colorOptions = {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};

            colorDialog.add(new JLabel("Color for living cells: "));
            JComboBox<String> jcbLiveColor = new JComboBox<>(colorOptions);
            jcbLiveColor.setSelectedItem(SnakeApp.app.getProperty("liveColor"));
            colorDialog.add(jcbLiveColor);

            colorDialog.add(new JLabel("Color for dead cells: "));
            JComboBox<String> jcbDeadColor = new JComboBox<>(colorOptions);
            jcbDeadColor.setSelectedItem(SnakeApp.app.getProperty("deadColor"));
            colorDialog.add(jcbDeadColor);

            colorDialog.add(new JLabel("Color for UI: "));
            JComboBox<String> jcbUI = new JComboBox<>(colorOptions);
            jcbUI.setSelectedItem(SnakeApp.app.getProperty("uiColor"));
            colorDialog.add(jcbUI);

            JButton cancelButton = new JButton("Cancel");
            cancelButton.setBackground(Utilities.getColor(SnakeApp.app.getProperty("uiColor")));
            cancelButton.addActionListener((ActionEvent e1) -> {
                colorDialog.dispose();
            });
            colorDialog.add(cancelButton);

            JButton confirmButton = new JButton("Confirm");
            confirmButton.setBackground(Utilities.getColor(SnakeApp.app.getProperty("uiColor")));
            confirmButton.addActionListener((ActionEvent e1) -> {
                SnakeApp.app.setProperty("liveColor", (String) jcbLiveColor.getSelectedItem());
                SnakeApp.app.setProperty("deadColor", (String) jcbDeadColor.getSelectedItem());
                SnakeApp.app.setProperty("uiColor", (String) jcbUI.getSelectedItem());
                // SnakeView.view.refreshDisplay();
                colorDialog.dispose();
            });
            colorDialog.add(confirmButton);

            colorDialog.pack();
            colorDialog.setLocationRelativeTo(SnakeView.view);
            colorDialog.setVisible(true);
    }
}