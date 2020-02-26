


/**
 * 
 * Implements a board for the Tic-Tac-Toe game that holds the value of the spaces on the game board.
 * This object will store mark values, display the board, and check for a winner.
 * 
 * @author Given file for exercise 4
 * @version 1.0
 * @since 2020-02-02
 *
 */
public class Board implements Constants {
	/**
	 * 3x3 character array that holds the X, O, or space.
	 */
	private char theBoard[][];
	/**
	 * Counts how many spaces are filled in the board.
	 */
	private int markCount;

	/**
	 * Constructs a Board and sets the board to all spaces.
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/**
	 * Gets the Mark at a specified row and column.
	 * @param row The row of the wanted Mark.
	 * @param col The column of the wanted Mark.
	 * @return The char Mark.
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * Checks if the board is full of marks.
	 * @return Returns true if full.
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * Checks if the 'X' player has won.
	 * @return Returns true if 'X' player won.
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Checks if the 'O' player has won.
	 * @return Returns true if 'O' player won.
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Displays the game board with X's and O's on the console.
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * Adds a mark to the game board in specified row and col.
	 * @param row The row of the new mark.
	 * @param col The col of the new mark.
	 * @param mark The mark type of the new mark (X or O).
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}
	/**
	 * Checks is a board at a position has a mark in it or not.
	 * @param row Row of board to check.
	 * @param col Column of board to check.
	 * @return Boolean true if empty, false if filled.
	 */
	public Boolean checkSpotEmpty(int row, int col)
	{
		if(theBoard[row][col] != SPACE_CHAR)
		{
			return false;
		}
		return true;
	}

	/**
	 * Clears all of the marks from the board and sets them all to spaces.
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * Checks if player has won the game.
	 * @param mark The player being checked if they won.
	 * @return Return true if the player has won.
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * Displays the column headers of the game board.
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * Displays hyphens for the construction of the game board.
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * Displays spaces for the construction of the game board.
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
