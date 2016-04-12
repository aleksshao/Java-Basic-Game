package com.company;

import javafx.scene.control.Cell;
import javax.swing.*;
import java.awt.*;

/**
 * JFrame to hold board.
 * Created by ALEKSANDAR on 4/12/2016.
 */
public class JavaFrame1 extends JFrame {

    // Create cell grid
    private final Cell[][] cells = new Cell[4][4];

    public JavaFrame1() {
        // Panel to hold cells
        JPanel panel = new JPanel(new GridLayout(4, 4, 0, 0));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                panel.add(cells[i][j] = new Cell());
            }
        }

        /**
         * Determine if game board is full.
         *
         * @return True, if game board is full. Otherwise, false.
         */

    public boolean isFull() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (cells[i][j].getToken() == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}