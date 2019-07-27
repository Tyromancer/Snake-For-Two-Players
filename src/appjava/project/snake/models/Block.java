package appjava.project.snake.models;

import java.util.concurrent.locks.Lock;

import javax.swing.*;

public class Block extends JPanel {
    private Lock lock;
    private Status status;

    public Block() {
        super();
        this.status = Status.EMPTY;
    }

    public void setStatus(Status s) {
        this.status = s;
    }

    public Status getStatus() {
        return this.status;
    }
}