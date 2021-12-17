/* -------------------------------------------------------
 * Assignment 1 - Question 3 - One possible solution
 * Written by: Nancy Acemian
 * For COMP 248 – Fall 2015
 * -------------------------------------------------------*/
// Given the letter of the Internet package and the number of hours used up, this program will display the
// resulting monthly bill along with possible savings if customer was with one of the higher packages.

import java.util.Scanner;
public class InternetCharge {


	public static void main(String[] args) {
		// ---------------------
		// Variable declaration
		// ---------------------
		Scanner keyIn = new Scanner(System.in);		// for keyboard input
		int hoursUsed;
		String internetPackage;
		double costA=9.95, costB=13.95, costC=19.95;

		// --------
		// Header
		// --------
		System.out.print("-----------------------------------------------------\n"+
				"       Nancy's Internet Use Monthly Bill Program\n" +
				"------------------------------------------------------\n\n");

		// ----------------------
		// Request date from user
		// ----------------------
		System.out.print("How many hours did you use (whole number please): ");
		hoursUsed = keyIn.nextInt();
		System.out.print("Do you have package A, B or C? ");
		internetPackage = keyIn.next();
		 
		
		//----------------------------------
		// Calculate cost for each package
		//----------------------------------
		if (hoursUsed >10) costA += (hoursUsed - 10) * 2;
		if (hoursUsed >20) costB += (hoursUsed - 20) * 1;
		
		//------------------------------------------
		//Display monthly bill and possible savings
		//------------------------------------------
		System.out.print("\n\tYour monthly bill with Package " + internetPackage + " is $" );
		if(internetPackage.equals("A"))
		{
			System.out.println(costA);
			if (costA>costB )
				System.out.println("\tIf you were on Package B you could have saved $" + (costA-costB));
			if (costA>costC )
				System.out.println("\tIf you were on Package C you could have saved $" + (costA-costC));
		}
		else if(internetPackage.equals("B"))
		{
			System.out.println(costB);
			if (costB>costC )
				System.out.println("\tIf you were on Package C you could have saved $" + (costB-costC));
		}
		else if(internetPackage.equals("C"))
		{
			System.out.println(costC);
		}
		else
		{
			System.out.println("--.--\nSorry but unable to calculate your monthly bill since Package " + internetPackage
					+ " does not exist.");
		}
		
		//----------------
		//Closing message
		//----------------
		System.out.println("\nCome back next month ...");

	}

}
