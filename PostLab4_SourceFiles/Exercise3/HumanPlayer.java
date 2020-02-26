import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Provides data fields and methods to create a player control by a human in the Tic-Tac-Toe game.
 * Extends Player.
 * @author William Ledingham
 * @version 1.0
 * @since 2020-02-16
 *
 */
public class HumanPlayer extends Player{

	/**
	 * Constructs HumanPlayer with a name and char mark.
	 * @param name String of the name of the player.
	 * @param mark Character of mark used to represent the player on the board.
	 */
	HumanPlayer(String name, char mark) 
	{
		super(name, mark);
		
	}

	/**
	 * Players turn that makes move and passes turn to opponent.
	 * @throws IOException
	 */
	@Override
	public void play() throws IOException
	{
		makeMove();
		if(checkForWinner() == 1)
		{
			super.getOpponent().play();
		}
	}
	
	/**
	 * Prompts user for row and column input and adds mark to the board.
	 * @throws IOException
	 */
	@Override
	public void makeMove() throws IOException
	{
		BufferedReader stdin;
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.printf("\n%s, what row should your next %c be placed in?: ", super.getName(), super.getMark());
		String row = stdin.readLine();
		while (row == null) {
			System.out.print("Please try again: ");
			row = stdin.readLine();
		}
		
		System.out.printf("\n%s, what column should your next %c be placed in?: ", super.getName(), super.getMark());
		String col = stdin.readLine();
		while (col == null) {
			System.out.print("Please try again: ");
			col = stdin.readLine();
		}
		
		int rowInt = Integer.parseInt(row);
		int colInt = Integer.parseInt(col);
		
		super.getBoard().addMark(rowInt, colInt, super.getMark());
		
	}

}
