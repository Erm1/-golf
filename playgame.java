/*
Ermiyas Liyeh
30711570
Lab Section - MW 2:00PM to 3:15PM 
I did not collaborate with anyone on this assignment.
*/

import java.util.Scanner;   //imported a scanner to accept user informations
import java.util.Random;   //imported a Random class to access the nextGaussian() method for gaussian calculations

public class playgame {
	
	//This method takes in three inputs and processes the entire game
	public static void Playgame(int hole, int [] yardage, int [] par) {
    	Scanner scnr = new Scanner(System.in);
    	Random rndm = new Random();
    	
    	int totscore = 0; //totscore is initially zero and it keeps changing once the for loop starts
    	
    	club a = new club(); //a is an instance of the class club and I created it to access the informations in that class
    	puther b = new puther();
    	
    	loop:  //will be used to break out of the for loop
    	for (int i = 0; i<hole; i++) {
    		int score = par[i];
    		int dist = yardage[i];
    		String quitgame = null;
    		int j = i + 1;
    		System.out.println("You are at tee number "+j+". "+yardage[i] +" yards, Par "+par[i]);
    		
    		//a while loop which keeps on working until (Math.abs(dist)>3) or until the user quits the game
    		while(Math.abs(dist)>3) {

    			//a while loop which keeps on working until (Math.abs(dist)>=20) or until the user quits the game
    			while(Math.abs(dist)>=Math.abs(20)) {
    				
					System.out.println("\nYou are in the fairway.");
					System.out.print("Choose your club[1-10]: ");
					int clubNum = scnr.nextInt();
					
					if(clubNum < 1 || (clubNum > 10 && clubNum != 111)) {
						System.out.println("Wrong entry, try again");
						break;
						}  //will enable the user to input a valid club number
					
					
					System.out.print("Choose power[1-10]: ");
					int power = scnr.nextInt();
					
					if(power < 1 || (power > 10 && power != 111)) {
						System.out.println("Wrong entry, try again");
						break;
						}  //will enable the user to input a valid power
					
					if(power == 111 || clubNum == 111) {
						golf playing = new golf();
						quitgame = quiter();
			
						if(quitgame.equalsIgnoreCase("Quit"))
							break loop;
						String round = new_round();
						if(!quitgame.equalsIgnoreCase("Quit") && round.equalsIgnoreCase("n"))
							continue;   //will continue from where it last stopped
						if(!quitgame.equalsIgnoreCase("Quit") && round.equalsIgnoreCase("y"))
							playing.lovegame();
						
					}  //based on user preferences it follows different routes[change course, quit ongoing game, quit the game]
					
					//these three lines of code are used to calculate the distance covered at each stroke
					double mean_adj = a.Mean_yds[clubNum-1] * power/10.0;
					double stddev_adj = (a.stdDev_yds[clubNum-1] * power/10.0);
					double val = (int) Math.abs(rndm.nextGaussian() * stddev_adj + mean_adj);
					System.out.println("You hit the ball "+val+ " yards.");
					
					//keeps track of the distance between the hole and the golfball
					dist = (int) (Math.abs(dist) -  val);
					Math.abs(dist); //if the distance is negative, the absolute value of that distance will be taken
					score -= 1; //for every shot, score lowers by 1
					
					
					System.out.println("You are " + Math.abs(dist) + " away from the hole.");
					
						
    			
    			}
    		
    		//in this conditional statement, since the distance is less or equal to 20 yards, the user only needs a power
    		if (Math.abs(dist)<=Math.abs(20)) {
    			
    			//the hole is 3 yards of diameter and the game continues untill the ball lands in this 3 yard diameter
    			while (Math.abs(dist) > Math.abs(3)) {
    			System.out.println("\nYou are on the green.");
    			System.out.print("Choose power[1-10]: ");
        		int power = scnr.nextInt();
        		
        		if(power < 1 || (power > 10 && power != 111) ) {
        			System.out.println("Wrong entry, try again");
        			break;
        			}  //will enable the user to input a valid power
        		if(power == 111) {
        			golf playing = new golf();
    				quitgame = quiter();

    				if(quitgame.equalsIgnoreCase("Quit"))
    					break loop;
    				String round = new_round();
    				if(!quitgame.equalsIgnoreCase("Quit") && round.equalsIgnoreCase("n"))
    					continue;
    				if(!quitgame.equalsIgnoreCase("Quit") && round.equalsIgnoreCase("y"))
    					playing.lovegame();
    					
    			}//based on user preferences it follows different routes[change course, quit ongoing game, quit the game]
				
        		//these three lines of code are used to calculate the distance covered at each stroke
				double mean_adj = b.Mean_yds[power-1] * power/10.0;
        		double stddev_adj = (b.stdDev_yds[power-1] * power/10.0);
        		double val = (int) Math.abs(rndm.nextGaussian() * stddev_adj + mean_adj);
        		System.out.println("You hit the ball "+val+ " yards.");
        		
        		//keeps track of the distance between the hole and the golfball
				dist = (int) (Math.abs(dist) -  val);
				Math.abs(dist); //if the distance is negative, the absolute value of that distance will be taken
				score -= 1; //for every shot, score lowers by 1
        		System.out.println("You are " + Math.abs(dist) + " away from the hole.");
    			
        		
    			}
    			
    		}
    		
    		if (Math.abs(dist) <= Math.abs(3)) {
    			System.out.println("\nCongratulations! you've put the golf in to the hole!");
    			if((-1*score)<=0)
    				if((-1*score) == -1)
    					System.out.println("Birdie!");  //Extra credit
    				else if((-1*score) == -2)
    					System.out.println("Eagle!");  
    				else
    					System.out.println("Par : "+ (-1*score));   //Extra credit
    				
    			else if((-1*score)>0)
    				System.out.println("Par : "+ "+" +(-1*score));
    				if((-1*score) == 1)
    					System.out.println("Bogey!");   //Extra credits
    		}  //considered as the golf is put in the hole
    		
    		
    		
    		}
    		
    		//calling the method quiter() after the player finishes each hole to ask if player wants to quit
    		quitgame = quiter();
			if (quitgame.equalsIgnoreCase("Quit")) 
				break;
				
			totscore += (-1*score);  //keeping track of the total score of all the holes in a course
			
			if(i == hole - 1) {
				if(totscore <= 0)
				System.out.println("your total score for this game is "+ totscore);
				else
					System.out.println("your total score for this game is "+"+"+ totscore);
			}
    		
    	}
    	
    	
    	golf playing = new golf();  //creating instance of golf to access all the methods within it or in it's extended class
    	
    	//calling the method new_round() after the player finishes each hole to ask if player wants to quit and play a new course
    	String round = new_round();
		if(round.equalsIgnoreCase("n")) {
			playing.byebye();
			}
			
		Course cont = new Course();
		if(round.equalsIgnoreCase("y")) {
			playing.lovegame();
			}
		
    }

	//This method returns the user input quitgame
	public static String quiter() {
		Scanner scnr = new Scanner(System.in);
		System.out.print("\nDo you want to quit this game?[quit,noquit] ");
		String quitgame = scnr.nextLine();
		return quitgame;
	}

	//This method returns the user input round
	public static String new_round() {
		Scanner scnr = new Scanner(System.in);
		System.out.print("\nDo you want to play a new round[Y/N]? ");
		String round = scnr.nextLine();
		return round;	
	}
 
}
