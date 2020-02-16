import java.io.*;

/**
 * Provides data fields and methods to create a Player in the Tic-Tac-Toe game.
 * Can check if the player has won and prompt the player when it is there turn.
 * 
 * @author William Ledingham
 * @version 1.0
 * @since 2020-02-02
 *
 */
abstract class Player {

	/**
	 * String the that contains the name of the player.
	 */
	private String name;
	/**
	 * Board the player uses in the game.
	 */
	private Board board;
	/**
	 * Reference to the other player object that is the opponent for the game.
	 */
	private Player opponent;
	/**
	 * The mark the player uses on the board (X or O).
	 */
	private char mark;
	
	/**
	 * Constructs Player with a name and mark type.
	 * @param name Players name.
	 * @param mark Players mark.
	 */
	Player(String name, char mark)
	{
		this.name = name;
		this.mark = mark;
	}
	
	/**
	 * Checks for player win and passes turn to opponent.
	 * Calls makeMove() and displays board.
	 * @throws IOException
	 */
	public void play() throws IOException
	{
		makeMove();
		if(checkForWinner() == 1)
		{
			opponent.play();
		}
	}
	
	public int checkForWinner()
	{
		board.display();
		if(board.xWins())
		{
			System.out.printf("Game Over. %s is the Winner!\n", name);
			return 0;
		}
		else if(board.oWins())
		{
			System.out.printf("Game Over. %s is the Winner!\n", name);
			return 0;
		}
		else if(board.isFull())
		{
			System.out.println("Game Over. It is a Tie");
			return 0;
		}
		return 1;
	}
	
	/**
	 * Prompts user for row and column input and adds mark to the board.
	 * @throws IOException
	 */
	public void makeMove () throws IOException
	{
		BufferedReader stdin;
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.printf("\n%s, what row should your next %c be placed in?: ", name, mark);
		String row = stdin.readLine();
		while (row == null) {
			System.out.print("Please try again: ");
			row = stdin.readLine();
		}
		
		System.out.printf("\n%s, what column should your next %c be placed in?: ", name, mark);
		String col = stdin.readLine();
		while (col == null) {
			System.out.print("Please try again: ");
			col = stdin.readLine();
		}
		
		int rowInt = Integer.parseInt(row);
		int colInt = Integer.parseInt(col);
		
		board.addMark(rowInt, colInt, mark);
		
	}
	
	
	/**
	 * Set the opponent for this player.
	 * @param opponent Player object to be set as the opponent player.
	 */
	public void setOpponent(Player opponent)
	{
		this.opponent = opponent;
	}
	/**
	 * Gets the opponent for this player.
	 * @return Player object.
	 */
	public Player getOpponent()
	{
		return this.opponent;
	}
	/**
	 * Set the board for this player.
	 * @param theBoard Board object to be set as playing board.
	 */
	public void setBoard(Board theBoard)
	{
		this.board = theBoard;
	}
	/**
	 * Gets the Board object that stores the game marks.
	 * @return Board object.
	 */
	public Board getBoard()
	{
		return this.board;
	}
	/**
	 * Gets the mark of the player displayed on the board.
	 * @return Char of mark.
	 */
	public char getMark()
	{
		return this.mark;
	}
	/**
	 * Gets the name of the player.
	 * @return String of players name.
	 */
	public String getName()
	{
		return this.name;
	}
}
