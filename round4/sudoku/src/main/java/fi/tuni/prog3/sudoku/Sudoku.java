/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.sudoku;

/**
 *
 * @author ttakoj
 */
public class Sudoku {
	
	private static class Cell {
        private String value;

        public Cell() {
            this.value = " ";
        }
    }
	
	private Cell[][] board;
	
	public Sudoku() {
        board = new Cell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = new Cell();
            }
        }
    }
	
}
