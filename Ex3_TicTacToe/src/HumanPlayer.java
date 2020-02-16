import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player{

	HumanPlayer(String name, char mark) 
	{
		super(name, mark);
		
	}
	@Override
	public void play() throws IOException
	{
		makeMove();
		if(checkForWinner() == 1)
		{
			super.getOpponent().play();
		}
	}
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
