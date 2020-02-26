import java.io.IOException;

/**
 * Provides data fields and methods to create a player that places marks randomly on the board.
 * Extends Player.
 * @author William Ledingham
 * @version 1.0
 * @since 2020-02-16
 *
 */
public class RandomPlayer extends Player{

	/**
	 * RandomGenerator object that is used to create random numbers.
	 */
	private RandomGenerator rand;
	
	/**
	 * Constructs a RandomPlayer with a name and a mark for the board.
	 * @param name String of a name of the player.
	 * @param mark Char of the mark used to represent player on the board.
	 */
	RandomPlayer(String name, char mark) {
		super(name, mark);
		rand = new RandomGenerator();
	}
	
	/**
	 * Implements the players turn by making a move and passing turn to opponent.
	 */
	@Override
	public void play() throws IOException
	{
		System.out.printf("\n");
		makeMove();
		if(super.checkForWinner() == 1)
		{
			super.getOpponent().play();
		}
	}
	/**
	 * Randomly places a mark in an empty place on the board.
	 */
	@Override
	public void makeMove()
	{
		int row;
		int col;
		do{
			row = rand.discrete(0, 2);
			col	= rand.discrete(0, 2);			
		}while(super.getBoard().checkSpotEmpty(row, col) == false);
		super.getBoard().addMark(row, col, super.getMark());
	}

}
