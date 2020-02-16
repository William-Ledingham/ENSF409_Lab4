import java.io.IOException;

/**
 * Provides data fields and methods to create a Referee in the Tic-Tac-Toe game.
 * Referee starts the game and sets the players opponents and hands the play off
 * initially to the X player.
 * 
 * @author William Ledingham
 * @version 1.0
 * @since 2020-02-02
 *
 */
public class Referee {

	/**
	 * The player with the X mark.
	 */
	private Player xPlayer;
	/**
	 * The player with the O mark.
	 */
	private Player oPlayer;
	/**
	 * Object for the game board to be played on.
	 */
	private Board board;
	
	/**
	 * Constructs default values.
	 */
	Referee(){}
	
	/**
	 * Sets players as opponents, displays the board, and starts play with X player.
	 * @throws IOException
	 */
	public void runTheGame() throws IOException
	{
		System.out.printf("\nReferee started the game...\n\n");
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		board.display();
		xPlayer.play();
	}
	
	/**
	 * Sets playing board.
	 * @param board Board object to be set as playing board.
	 */ 
	public void setBoard(Board board)
	{
		this.board = board;
	}
	
	/**
	 * Sets player with O mark.
	 * @param oPlayer Player object that is the O player.
	 */
	public void setoPlayer(Player oPlayer)
	{
		this.oPlayer = oPlayer;
	}
	
	/**
	 * Sets player with X mark.
	 * @param xPlayer Player object that is the X player
	 */
	public void setxPlayer(Player xPlayer)
	{
		this.xPlayer = xPlayer;
	}
	
}
