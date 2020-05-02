package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

public class FilmQuery {
	
	Scanner sc = new Scanner(System.in);
	
	
	
	
	
	public void launch() throws SQLException {
	    
	    
	    startUserInterface(sc);
	    
	    sc.close();
	  }

	  private void startUserInterface(Scanner sc) {
	    int userChoice;
	    
	    System.out.println("|=======================================|");
	    System.out.println("|    Welcome to Film Query              |");
	    System.out.println("| 1) Press 1: Look up a film by its id  |");
	    System.out.println("| 2) Press 2: Search film by keyword    |");
	    System.out.println("| 3) Press 3: Exit                      |");
	    System.out.println("|=======================================|");
	    System.out.println();
	    System.out.println();
	    
	    
	  }
	
	
	
	
	
}
