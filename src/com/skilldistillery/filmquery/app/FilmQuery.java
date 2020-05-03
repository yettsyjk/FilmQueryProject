package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
		boolean keepGoing = true;
		System.out.println("=========================");
		System.out.println("     Film Query          ");
		System.out.println("=========================");
		int userChoice = 0;

		do {
			System.out.println("|=======================================|");
			System.out.println("|    Welcome to Film Query              |");
			System.out.println("| 1) Press 1: Look up a film by its ID  |");
			System.out.println("| 2) Press 2: Search film by keyword    |");
			System.out.println("| 3) Press 3: Exit                      |");
			System.out.println("|=======================================|");
			userChoice = sc.nextInt();

			switch (userChoice) {
			case 1:
				System.out.println("Enter a film id to search (Between 1 to 1000): ");
				int filmSearchId = sc.nextInt();
				filmLookUpById(filmSearchId);
				break;
			case 2:
				System.out.println("Search for movie by one keyword: ");
				String keywordChoice = sc.next();
				filmLookUpByKeyword(keywordChoice);

				break;
			case 3:
				System.out.println("GoodBye, Come Back To See Us Soon!");
				keepGoing = false;
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println();
		} while (keepGoing);

	}

	public void filmLookUpById(int id) {
		Film filmById = db.findFilmById(id);
		if (filmById.getTitle() != null) {
			System.out.println("=====================");
			System.out.println("Film ID: " + filmById.getId());
			System.out.println("Film Title: " + filmById.getTitle());
			System.out.println("Film Year: " + filmById.getReleaseYear());
			System.out.println("Film Rating: " + filmById.getRating());
			System.out.println("Film Description: " + filmById.getDescription());
			System.out.println("Film Language: " + filmById.getLanguage());
			System.out.println("=====================");
		} else {
			System.out.println("Invalid Movie Choice, Please try again");
			System.out.println();
		}
	}

	public void filmLookUpByKeyword(String keywordChoice) {
		List<Film> filmsByKeyWord = db.findFilmsByKeyWord(keywordChoice);
		
		if (filmsByKeyWord.size() == 0) {
			System.out.println("No Match Found, Please Try Again.");
			System.out.println();
		} else {
			
			for (Film filmByKeyword : filmsByKeyWord) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Film ID: " + filmByKeyword.getId());
				System.out.println("Film Title: " + filmByKeyword.getTitle());
				System.out.println("Film Year: " + filmByKeyword.getReleaseYear());
				System.out.println("Film Rating: " + filmByKeyword.getRating());
				System.out.println("Film Description: " + filmByKeyword.getDescription());
				System.out.println("Film Language"+ filmByKeyword.getLanguage() );
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
		}
	}

}
