/*
Ermiyas Liyeh
30711570
Lab Section - MW 2:00PM to 3:15PM 
I did not collaborate with anyone on this assignment.
*/

import java.util.Scanner;   //imported a scanner to accept user informations

public class GameIntro {
	/*This method has instances of type course and asks the user for Course Number and based on the user 
	preferences, it calls for the type of course the user chose to play. If the user chooses a course Number
	which is not in the list, the program will quit executing a print line statement with information.*/
	public static void lovegame() {
		Scanner scnr = new Scanner(System.in);
		
		Course play1 = new Course();
		
		System.out.print("Welcome to TTY Golf!"+"\nTo quit the game at any point, Enter "+
				"\"111\" to club num or/and power."+"\nPLEASE SELECT A COURSE NUMBER," 
				+"\n1. Genesee Valley Park North Course"+"\n2. The Old Course at St. Andrews"
		         +"\n3. The Master Course at the Augusta National Golf Club course");
		
		System.out.print("\nYour choice [1,2,3]: ");
		int courseNum = scnr.nextInt();
		
		
		if (courseNum == 1) {
			System.out.println("\nWelcome to The Genesee Valley Park North Course");
			play1.geneseegame();  //calls a method geneseegame() from the class course
		}
		else if (courseNum == 2) {
			System.out.println("\nWelcome to The Old Course at St. Andrews");
			play1.oldCoursegame();  //calls a method oldCoursegame() from the class course
		}
		else if (courseNum == 3) {
			System.out.println("\nWelcome to The Master Course at the Augusta National Golf Club course");
			play1.mastergame();  //calls a method mastergame() from the class course
		}
		else {
			System.out.print("\nGame forced to Quit! Enter a valid Course Number next time!");
		}
		
	}
	
	//This method is called in the class playgame when the player forces the game to quit.
	public static void byebye() {
		System.out.println("Thank you for playing the game of Golf, see you soon!");
	}
	
}
