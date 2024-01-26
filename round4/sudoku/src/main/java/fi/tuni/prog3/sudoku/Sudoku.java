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

		for (int i = 0; i < 9; i++) {
			if (!checkColumn(i)) {
				return false;
			}
		}
		
		// FIX Check blocks, not flexible solution.
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				if (!checkBlock(i, j)) {
					return false;
				}
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

	private boolean checkColumn(int col) {
		for (int i = 1; i <= 9; i++) {
			int count = 0;

			for (int j = 0; j < 9; j++) {
				if (board[j][col].getValue().equals(Integer.toString(i))) {
					count++;
				}
			}

			if (count > 1) {
				System.out.println("Column " + col + " has multiple " + i + "'s!");
				return false;
			}
		}

		return true;
	}
	
	// FIX. Check 3x3 blocks. More flexible solution preferred.
	private boolean checkBlock(int startRow, int startCol) {
        for (int i = 1; i <= 9; i++) {
            int count = 0;

            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    int currentRow = startRow + x;
                    int currentCol = startCol + y;

                    if (board[currentRow][currentCol].getValue().equals(Integer.toString(i))) {
                        count++;
                    }
                }
            }

            if (count > 1) {
                System.out.println("Block at (" + startRow + ", " + startCol + ") has multiple " + i + "'s!");
                return false;
            }
        }

        return true;
    }

	public void print() {
		System.out.println("#####################################");
		
		for (int i = 0; i<9 ;i++){
			for (int j = 0; j<9;j++){
				if (j%3 == 0){
					System.out.print("# " + board[i][j].getValue() + " ");
				} else {
					System.out.print("| " + board[i][j].getValue() + " ");
				}
			}
			System.out.println("#");
			if ((i+1)%3==0 && i>0){
				System.out.println("#####################################");
			}else{
				System.out.println("#---+---+---#---+---+---#---+---+---#");
			}
		}
	}

}
