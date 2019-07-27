package appjava.project.snake;

import java.util.concurrent.locks.Lock;

import javax.swing.*;

class Block extends JPanel {
    private Lock lock;
    private Status status;

    Block() {
        super();
        this.status = Status.EMPTY;
    }

    void setStatus(Status s) {
        this.status = s;
    }

    Status getStatus() {
        return this.status;
    }
}