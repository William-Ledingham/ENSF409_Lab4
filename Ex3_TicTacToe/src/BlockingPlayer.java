
public class BlockingPlayer extends RandomPlayer{

	BlockingPlayer(String name, char mark) 
	{
		super(name, mark);
	}
	
	@Override
	public void makeMove()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(testForBlocking(i, j) == true)
				{
					super.getBoard().addMark(i, j, super.getMark());
					return;
				}
			}
		}
		super.makeMove();
		
	}
	
	public Boolean testForBlocking(int row, int col)
	{
		if(super.getBoard().checkSpotEmpty(row, col) == false)
		{
			return false;
		}
		int test = 0;
		for(int i = 0; i < 3; i++)
		{
			if(i != row && super.getOpponent().getMark() == super.getBoard().getMark(i, col))
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
			if(j != col && super.getOpponent().getMark() == super.getBoard().getMark(row, j))
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
			if(i != row && j != col && super.getOpponent().getMark() == super.getBoard().getMark(i, j))
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
			if(i != row && j != col && super.getOpponent().getMark() == super.getBoard().getMark(i, j))
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
