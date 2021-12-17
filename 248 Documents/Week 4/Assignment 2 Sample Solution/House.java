
/* -------------------------------------------------------
 * Assignment 2 - One possible solution
 * Written by: Nancy Acemian
 * For COMP 248 – Fall 2015
 * -------------------------------------------------------*/

// This program displays a simple house based on the even height and width entered by the user.
import java.util.Scanner;
public class House {

	public static void main(String[] args) {
		// ---------------------
		// Variable declaration
		// ---------------------
		Scanner keyIn = new Scanner(System.in);		// for keyboard input
		int height, width;							// dimensions of house
		int count;									// number of times dimensions entered
		int numOfHouses = 0;						// number of houses drawn
		String again, name;							// repeat process & user's name

		// -------------------------
		// Header & welcome message 
		// -------------------------
		System.out.print("---------------------------------------------------------\n"+
				"          Nancy's Silly House Drawing Program\n" +
				"---------------------------------------------------------\n\n");
		System.out.print("What is your name? ");
		name = keyIn.next();
		System.out.println("Well " + name + ", welcome to my silly house drawing program.");
		do
		{
			System.out.print("Do you want me to draw a simple house for you? (yes/no) ");
			again = keyIn.next();
		}while (!again.equalsIgnoreCase("yes")&& !again.equalsIgnoreCase("no"));

		// -------------------------------------------
		// As long as say yes continue drawing houses
		// -------------------------------------------
		while (again.equalsIgnoreCase("yes"))
		{
			//Prompt user for input
			//---------------------
			System.out.print("Enter height and width of the house you want me to draw (must be even numbers): ");
			height = keyIn.nextInt();
			width  = keyIn.nextInt();

			// Validate input; if odd ask up to 3 times. If still not even, end program
			count = 0;
			while(height%2 != 0 & count < 3)
			{
				System.out.print("\nYou enter " + height +" for the height. Not an even number!\n" +
						"Please enter an even number for the height of the house: ");
				count++;
				height = keyIn.nextInt();
			}
			// Is height even?
			if (height%2 != 0)
			{
				System.out.println("\n--> "+ name + 
						", it seems you are having troubles entering even numbers! Program ending now.");
				System.exit(0);
			}
			
			//is width even?
			count = 0;
			while(width%2 != 0 & count < 3)
			{
				System.out.print("\nYou entered " + width +" for the width. Not an even number!\n" +
						"Please enter an even number for the width of the house: ");
				count++;
				width = keyIn.nextInt();
			}
			if (width%2 != 0)
			{
				System.out.println("\n--> "+ name + 
						", it seems you are having troubles entering even numbers! Program ending now.");
				System.exit(0);
			}	

			// Drawing the house
			//-------------------
			numOfHouses++;	// increment houses drawn counts

			//Step 1: Draw roof of house
			//------
			// Number of rows to print is half the width of the house with the top row being 2 stars
			int row = 1;
			while(row <= width/2)
			{	
				// Spaces to left of roof
				int spaces = 1;
				while(spaces <= width/2 - row)
				{
					System.out.print(' ');
					spaces++;
				}
				//Top of roof
				if(row == 1)
					System.out.print("**");
				else // sides of roof
					System.out.print("/");
				
				//Spaces to right side of roof
				spaces = 1;
				while (spaces <= 2*row-2)
				{
					System.out.print(' ');
					spaces++;
				}	
				if(row == 1)
					System.out.println();
				else
					System.out.println("\\");
				row++;
			}

			// Step 2: Print body of house
			//-------
			// Ceiling
			int i = 1;
			while( i <= width)
			{
				System.out.print('-');
				i++;
			}
			System.out.println();

			// Walls - Draw left wall, then (width - 2) spaces they right wall
			row = 1;
			while(row <= height)
			{
				System.out.print("|");
				for(int col = 1; col <= (width-2); col++)
					System.out.print(' ');
				System.out.println("|");
				row++;
			}
			
			// Floor
			i = 1;
			while(i <= width)
			{
				System.out.print('-');
				i++;
			}
			System.out.println();

			// Another house?
			// -------------
			System.out.println("\n" + name + ", do you want me to draw another house for you (yes to continue)?");
			again = keyIn.next();
		} // end of while again

		// ---------------
		//Closing message
		// ---------------
		if (numOfHouses == 0) 
			System.out.println("\nSorry you decided not to have any houses drawn!");
		else if (numOfHouses == 1)
			System.out.println("\nHope you like your house!");
		else
			System.out.println("\nHope you like your " + numOfHouses + " houses!");
		System.out.println("\nCome back soon " + name + "...");
	}

}
