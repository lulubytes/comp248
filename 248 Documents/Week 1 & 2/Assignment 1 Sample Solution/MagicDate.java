/* -------------------------------------------------------
 * Assignment 1 - Question 1 - One possible solution
 * Written by: Nancy Acemian
 * For COMP 248 – Fall 2015
 * -------------------------------------------------------*/

/* This program determines if a date entered by the user is a magic date:
 * A date mm/dd/yyyy is a magic date if
 * 1) mm*dd is a 1-digit number that matches the last digit of yyyy
 * 2) mm*dd is a 2-digit number that matches the last 2 digits of yyyy
 * 3) mm*dd is a 3-digit number that matches the last 3 digits of yyyy, */

import java.util.Scanner;
public class MagicDate {

	public static void main(String[] args) {
		// ---------------------
		// Variable declaration
		// ---------------------
		Scanner keyIn = new Scanner(System.in);		// for keyboard input
		int day, month, year;						// entered date by user
		int productDayMonth;

		// --------
		// Header
		// --------
		System.out.print("---------------------------------------------------------\n"+
						 "          Nancy's Magic Date Program\n" +
						 "---------------------------------------------------------\n\n");
		
		// ----------------------
		// Request date from user
		// -----------------------
		System.out.println("Enter a date as mm dd yyyy and I will tell you if it is magic or not: ");
		month = keyIn.nextInt();
		day = keyIn.nextInt();
		year = keyIn.nextInt();
		productDayMonth = day * month;
		
		//--------------------
		// Is it a magic date?
		//--------------------
		System.out.print(month + "/" + day + "/" + year + " is ");
		if (productDayMonth  < 10 && productDayMonth == year%10 )
			System.out.println("a magic date!!!!");
		else if (productDayMonth  >= 10 && productDayMonth  < 100 && productDayMonth == year%100)
			System.out.println("a magic date!!!!");
		else if (productDayMonth  >= 100 && productDayMonth  < 1000 && productDayMonth == year%1000)
			System.out.println("a magic date!!!!");
		else
			System.out.println("NOT a magic date!!!");
		
		//----------------
		// Closing message
		//----------------
		System.out.println("\nCome back for another try sometime!");
	}

}
