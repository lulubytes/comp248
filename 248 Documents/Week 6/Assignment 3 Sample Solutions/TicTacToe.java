import java.util.Scanner;
public class TicTacToe {

	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);		// for keyboard input
		int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};	// TicTacToe grid
		final int gridSize = 3;
		final char X = 'X', O = 'O';
		final int XX = 10, OO=0;
		int countGames, X_won, O_won;				// games played and won
		countGames = X_won = O_won = 0;
		int row, col;
		int countPositionsUsed = 0;					// positions used to date
		char turn = 'X'; // whose turn is it
		int  loc; 
		boolean validMove;							// was that a valid move?
		boolean winner;								// do we have a winner?
		do{
			do {
				// request a location to mark
				do {
					printGrid(grid,XX,OO);
					System.out.print("Player " + turn + " - Enter the position you wish to mark: ");
					loc = keyIn.nextInt();		
					if (loc <1 || loc > 9) System.out.println("Not a valid choice!");
				}while (loc <1 || loc > 9);  // valid location?

				// Is that location free?
				row = (loc-1)/gridSize;
				col = (loc-1)%gridSize;
				if (grid[row][col] == loc)  // valid move
				{
					grid[row][col] = turn==X?XX:OO;
					validMove = true;
					countPositionsUsed++;
				}
				else // not a valid move already has an X or O there
				{
					validMove = false;
					System.out.println("That position is not available");
				}
			}while (!validMove);

			// Do we have a winner?
			winner = false;
			// check diagonals
			if ((grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2])||
					(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]))
				winner = true;
			else // check rows and columns
				for (int i = 0; i < gridSize; i++)
					if((grid[i][0] == grid[i][1] &&grid[i][1] == grid[i][2]) ||
							(grid[0][i] == grid[1][i] &&grid[1][i] == grid[2][i]) )
					{
						winner = true;
						break;
					}

			if (winner)
			{
				printGrid(grid,XX,OO);
				if(turn == X)
					X_won++;
				else
					O_won++;

				// Show standings at this point
				System.out.println("Congratulations Player " + turn + 
						" - You win"+ "\nGames played to date is " + countGames +
						"Player X has won " + X_won + " games(s); Player O has won " + O_won +
						" game(s),");			
			}
			else if (countPositionsUsed == gridSize * gridSize)
				System.out.println("This game is a tie" + "\nGames played to date is " + countGames +
						"\nPlayer X has won " + X_won + " games(s); Player O has won " + O_won +
						" game(s),");
			else 
			{
				System.out.println("There is no winner yet");
				turn = turn==X?O:X;
			}

		}while (!winner && countPositionsUsed < gridSize * gridSize);
		keyIn.close();
 
	} // end of main
	
	// Static Functions
	//-----------------
	public static void  printGrid(int[][] grid, int XX, int OO)
	{
		for (int r = 0; r < grid.length; r++)
		{
			for (int c = 0; c < grid.length; c++)
			{
				if(grid[r][c]== XX)
					System.out.print('X');
				else if(grid[r][c]== 00)
					System.out.print('O');
				else
					System.out.print(grid[r][c]);
				System.out.print(' ');
			}
			System.out.println();
		}
	} // end of printGrid()
}//end of class

