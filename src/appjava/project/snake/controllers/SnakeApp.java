package appjava.project.snake.controllers;

import javax.swing.*;

import appjava.project.snake.views.SnakeView;

import java.io.*;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public class SnakeApp {
    public static SnakeApp app;
    private Properties props;
    private Logger log;

    private int rows;
    private int cols;

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
    Logger getLogger() {
        return this.log;
    }

    private void loadConfig() {
        this.props = new Properties();
        try {
            File configFile = new File("./conf.properties");
            if (!configFile.exists()) { throw new FileNotFoundException("Config file does not exist"); }
            FileReader reader = new FileReader(configFile);
            props.load(reader);
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Cannot load config file, Default configuration is used instead.");
            this.log.warning("Cannot load config file, Default configuration is used instead.\n");
            loadDefaultConfig();
        }
    }

    private void loadDefaultConfig() {
        // load default configurations
        props.setProperty("p1Color", "Green");
        props.setProperty("p2Color", "Red");
        props.setProperty("emptyColor", "White");
        props.setProperty("itemColor", "Yellow");
        props.setProperty("rows", "15");
        props.setProperty("cols", "15");
        this.rows = 15;
        this.cols = 15;
    }

     void saveConfig() {
        try {
            File configFile = new File("conf.properties");
            FileWriter writer = new FileWriter(configFile);
            props.store(writer, "Game settings");
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(SnakeView.view, String.format("Failed to save configs: %s", e.getMessage()));
            log.severe(String.format("Failed to save configs: %s", e.getMessage()));
        }
    }

    // getter functions

    /**
     * Get the number of rows
     * @return number of rows of the game board
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Get the number of columns
     * @return number of columns of the game board
     */
    public int getCols() {
        return this.cols;
    }


    public SnakeApp() {
        // SnakeApp.app = this;
        this.props = new Properties();
        this.setupLogger();
        this.loadConfig();
    }
}
