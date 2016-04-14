package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


/**
 * JFrame to hold board.
 * @author  ALEKSANDAR
 */
public class JavaFrame extends JFrame {

    // Indicate whose turn it is
    private char whoseTurns = 'R';

    // Create cell grid
    private final Cell[][] cells = new Cell[4][4];

    // Create a status label
    JLabel jlblStatus = new JLabel("'R's turn to play ");

    /**
     * No - argument Constructor
     */

    public JavaFrame() {
        // Panel to hold cells
        JPanel panel = new JPanel(new GridLayout(4, 4, 0, 0));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                panel.add(cells[i][j] = new Cell());
            }
        }
        panel.setBorder(new LineBorder(Color.GREEN, 1));
        jlblStatus.setBorder(new LineBorder(Color.BLACK, 1));

        add(panel, BorderLayout.CENTER);
        add(jlblStatus, BorderLayout.SOUTH);

    }

    /**
     * Determine if game board is full.
     *
     * @return True, if game board is full. Otherwise, false.
     */
    public boolean isFull() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (cells[i][j].getSymbol() == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Determine if game board is full.
     *
     * @param symbol Token to test for winning.
     * @return True, if the token has won. Otherwise, false.
     */
    public boolean isWon(char symbol) {
        // check rows
        for (int i = 0; i < 4; i++) {
            if ((cells[i][0].getSymbol() == symbol)
                    && (cells[i][1].getSymbol() == symbol)
                    && (cells[i][2].getSymbol() == symbol)
                    && (cells[i][3].getSymbol() == symbol)) {
                return true;
            }
        }
        // check columns
        for (int j = 0; j < 4; j++) {
            if ((cells[0][j].getSymbol() == symbol)
                    && (cells[1][j].getSymbol() == symbol)
                    && (cells[2][j].getSymbol() == symbol)
                    && (cells[3][j].getSymbol() == symbol)) {
                return true;
            }
        }
        // check diagonals
        if ((cells[0][0].getSymbol() == symbol)
                && (cells[1][1].getSymbol() == symbol)
                && (cells[2][2].getSymbol() == symbol)
                && (cells[3][3].getSymbol() == symbol)) {
            return true;
        }

        if ((cells[0][3].getSymbol() == symbol)
                && (cells[1][1].getSymbol() == symbol)
                && (cells[2][2].getSymbol() == symbol)
                && (cells[3][0].getSymbol() == symbol)) {
            return true;

        }if ((cells[3][3].getSymbol() == symbol)
                && (cells[2][2].getSymbol() == symbol)
                && (cells[1][1].getSymbol() == symbol)
                && (cells[0][0].getSymbol() == symbol)) {
            return true;

        }
        return false;
    }
