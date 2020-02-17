
/**
 * Provides data fields and methods to create a player that is smart enough to block opponent and win if possible.
 * Extends BlockingPlayer. 
 * @author wille
 *
 */
public class SmartPlayer extends BlockingPlayer{

	/**
	 * Constructs SmartPlayer with a name and mark used on the board.
	 * @param name String of name for player.
	 * @param mark Char of mark used to represent player on the board.
	 */
	SmartPlayer(String name, char mark) 
	{
		super(name, mark);
	}
	
	/**
	 * Implements players move first by checking for a winning position and then blocks opponent or places randomly.
	 */
	@Override
	public void makeMove()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(testForWinning(i, j) == true)
				{
					super.getBoard().addMark(i, j, super.getMark());
					return;
				}
			}
		}
		super.makeMove();
	}
	
	/**
	 * Checks board if a specified position is available to win the game.
	 * @param row Row of the board.
	 * @param col Column of the board.
	 * @return True if position will win and false if not.
	 */
	public Boolean testForWinning(int row, int col)
	{
		if(super.getBoard().checkSpotEmpty(row, col) == false)
		{
			return false;
		}
		int test = 0;
		for(int i = 0; i < 3; i++)
		{
			if(i != row && super.getMark() == super.getBoard().getMark(i, col))
			{
				test++;
			}
		}
		if(test == 2)
		{
			return true;
		}
		
		test = 0;
		for(int j = 0; j < 3; j++)
		{
			if(j != col && super.getMark() == super.getBoard().getMark(row, j))
			{
				test++;
			}
		}
		if(test == 2)
		{
			return true;
		}
		Boolean inDiagonal = false;
		test = 0;
		for(int i = 0, j = 0; i < 3 && j < 3; i++, j++)
		{
			if(i == row && col == j)
			{
				inDiagonal = true;
			}
			if(i != row && j != col && super.getMark() == super.getBoard().getMark(i, j))
			{
				test++;
			}
			
		}
		if(inDiagonal == true && test == 2)
		{
			return true;
		}
		inDiagonal = false;
		test = 0;
		for(int i = 0, j = 2; i < 3 && j >= 0; i++, j--)
		{
			if(i == row && col == j)
			{
				inDiagonal = true;
			}
			if(i != row && j != col && super.getMark() == super.getBoard().getMark(i, j))
			{
				test++;
			}
			
		}
		if(inDiagonal == true && test == 2)
		{
			return true;
		}
		
		return false;
	}

}
