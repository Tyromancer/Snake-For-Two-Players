package appjava.project.snake;

import javax.swing.*;
import java.util.*;

class Snake {
    private List<Block> lst;

    Snake(List<Block> src) {
        this.lst = new LinkedList<>();
        for (int i = 0; i < src.size(); i++) {
            lst.add(src.get(i));
        }
    }
}