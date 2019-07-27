package appjava.project.snake.models;

import javax.swing.*;

import java.util.*;

public class Snake {
    private List<Block> lst;

    public Snake(List<Block> src) {
        this.lst = new LinkedList<>();
        for (int i = 0; i < src.size(); i++) {
            lst.add(src.get(i));
        }
    }
}