package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQuery {
	DatabaseAccessor db = new DatabaseAccessorObject();
	Scanner sc = new Scanner(System.in);
	
	
	
	
	
	public void launch() throws SQLException {
	    
	    
	    startUserInterface(sc);
	    
	    sc.close();
	  }

	  private void startUserInterface(Scanner sc) {
	    int userChoice =0;
	    
	    while (userChoice != 3) {
	    System.out.println("|=======================================|");
	    System.out.println("|    Welcome to Film Query              |");
	    System.out.println("| 1) Press 1: Look up a film by its id  |");
	    System.out.println("| 2) Press 2: Search film by keyword    |");
	    System.out.println("| 3) Press 3: Exit                      |");
	    System.out.println("|=======================================|");
	    userChoice = sc.nextInt();
	    
	    switch(userChoice) {
	    case 1:
	    	System.out.println("Enter a film id to search (Between 1 to 1000): ");
	    	int filmSearchId = sc.nextInt();
	    	Film filmById = db.findFilmById(filmSearchId);
	    	if(filmById.getTitle() != null) {
	    		System.out.println("Film Title: "+ filmById.getTitle());
	    		System.out.println("Film Year: "+ filmById.getReleaseYear());
	    		System.out.println("Film Rating: "+ filmById.getRating() );
    			System.out.println("Film Description: "+ filmById.getDescription() );
    			System.out.println("Film Language: "+ filmById.getFilmLanguage() );
	    	} else {
	    		System.out.println("Invalid Movie, Please try again");
	    	}
	    	break;
	    case 2:
	    	System.out.println("Search for movie by one keyword: ");
	    	String keyword = sc.next();
	    	ArrayList<Film> films = new ArrayList<>();
	    	try {
	    		
	    		films = db.findFilmsByKeyWord(keyword);
	    		
	    	} catch (SQLException e) {
	    		System.out.println(e.getMessage() + "line 63");
	    	}
	    	if(films.size() >0 ) {
	    		for (Film filmByKeyword : films) {
	    			System.out.println("Film Title: "+ filmByKeyword.getTitle());
	    			System.out.println("Film Year: "+ filmByKeyword.getReleaseYear());
	    			System.out.println("Film Rating: "+ filmByKeyword.getRating() );
	    			System.out.println("Film Description: "+ filmByKeyword.getDescription() );
	    			System.out.println("Film Language: "+ filmByKeyword.getFilmLanguage() );
	    		}
	    	} else {
	    		System.out.println("No Match Found, Please Try Again.");
	    	}
	    	break;
	    case 3:
	    	System.out.println("GoodBye");
	    	break;
	    	default:
	    		System.out.println("Invalid Choice");
	    }
	    System.out.println();
	    }
	    
	  }
	
	
	
	
	
}
