/*
Ermiyas Liyeh
30711570
Lab Section - MW 2:00PM to 3:15PM 
I did not collaborate with anyone on this assignment.
*/

import java.util.Scanner;   //imported a scanner to accept user informations

//This class(golf) extends the class playgame
public class Course extends playgame{
	
	
	final static int hole_g = 18;
    final static int [] yardage_g = {530,305,331,201,500,226,409,410,229,433,363,174,545,419,512,410,320,170};
    final static int [] par_g = {5,4,4,3,5,3,4,4,3,4,4,3,5,4,5,4,4,3};
    
    /*This method(geneseegame()) uses the the above final values/arraylists 
    when calling the method Playgame(hole_g, yardage_g, par_g) from the class playgame.*/
    public static void geneseegame() {
    	Playgame(hole_g, yardage_g, par_g);	
	}
    

    
	final static int hole_o = 18;
	final static int [] yardage_o = {376,453,397,480,568,412,371,175,352,386,174,348,465,618,455,423,495,357};
	final static int [] par_o = {4,4,4,4,5,4,4,3,4,4,3,4,4,5,4,4,4,4};
	
	 /*This method(geneseegame()) uses the the above final values/arraylists 
     when calling the method Playgame(hole_o, yardage_o, par_o) from the class playgame.*/
	public static void oldCoursegame() {
		Playgame(hole_o, yardage_o, par_o);
	}


	
	final static int hole_m = 18;
    final static int [] yardage_m = {445,575,350,240,455,180,450,570,460,495,505,155,510,440,530,170,440,465};
    final static int [] par_m = {4,5,4,3,4,3,4,5,4,4,4,3,5,4,5,3,4,4};
    
    /*This method(geneseegame()) uses the the above final values/arraylists 
    when calling the method Playgame(hole_m, yardage_m, par_m) from the class playgame.*/
    public static void mastergame() {
    	Playgame(hole_m, yardage_m, par_m);
	}
    
    
}
