/* -------------------------------------------------------
 * Assignment 1 - Question 2 - One possible solution
 * Written by: Nancy Acemian
 * For COMP 248 – Fall 2015
 * -------------------------------------------------------*/

// Given the number of male and female students registered in a class, this program will display the total
// number of students and the percentage of male and female students.

import java.util.Scanner;
public class MaleFemale {

	public static void main(String[] args) {
		// ---------------------
		// Variable declaration
		// ---------------------
		Scanner keyIn = new Scanner(System.in);		// for keyboard input
		int males, females, total;

		// --------
		// Header
		// --------
		System.out.print("---------------------------------------------------------\n"+
				"          Nancy's Male/Female Ratio Program\n" +
				"---------------------------------------------------------\n\n");
		
		// ----------------------
		// Request date from user
		// -----------------------
		System.out.println("How many female students are registered for your course? ");
		females = keyIn.nextInt();
		System.out.println("\nHow many male students are registered for your course? ");
		males = keyIn.nextInt(); 
		total = males + females;
				
		//------------------------------------
		// Display statistics & Closing message
		//-------------------------------------
		System.out.println("Congratulations! You have " + total + " students registered in your course."
				+ "\n\tPercentage of females = " + 1.0*females/total + " or ~" + (int)(1.0*females/total* 100) + "%" 
				+ "\n\tPercentage of males = " + 1.0*males/total + " or ~" + (int)(1.0*males/total * 100) + "%"
				+ "\nHave a good term!!!");
	}

}
