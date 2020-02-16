import java.io.IOException;

public class RandomPlayer extends Player{

	private RandomGenerator rand;
	
	RandomPlayer(String name, char mark) {
		super(name, mark);
		rand = new RandomGenerator();
	}
	
	
	@Override
	public void play() throws IOException
	{
		makeMove();
		if(super.checkForWinner() == 1)
		{
			super.getOpponent().play();
		}
	}
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
