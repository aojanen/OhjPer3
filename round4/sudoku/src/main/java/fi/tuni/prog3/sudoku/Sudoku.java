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

		public void setValue(String value) {
			if (!value.matches("[1-9 ]")) {
				throw new IllegalArgumentException();
			}
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public boolean isEmpty() {
			return value.equals(" ");
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

	public void set(int i, int j, char c) {
		if (i > 8 || j > 8) {
			System.out.format("Trying to access illegal cell (%d, %d)!%n", i, j);
			return;
		}

		try {
			board[i][j].setValue(Character.toString(c));
		} catch (IllegalArgumentException e) {
			System.out.format("Trying to set illegal character %s to (%d, %d)!%n", Character.toString(c), i, j);
		}
	}

	public Boolean check() {
		for (int i = 0; i < 9; i++) {
			if (!checkRow(i)) {
				return false;
			}
		}

		return true;

	}

	private boolean checkRow(int row) {
		for (int i = 1; i <= 9; i++) {
			int count = 0;

			for (int j = 0; j < 9; j++) {
				if (board[row][j].getValue().equals(Integer.toString(i))) {
					count++;
				}
			}

			if (count > 1) {
				System.out.println("Row " + row + " has multiple " + i + "'s!");
				return false;
			}
		}

		return true;
	}

	public void print() {
		System.out.println("Out of order! Stay calm and wait for further instructions.");
	}

}
