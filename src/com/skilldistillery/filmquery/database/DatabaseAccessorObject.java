package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.Language;

public class DatabaseAccessorObject implements DatabaseAccessor {
//this class is to find the data from where I tell it to look at. 
	// separation of concern concept classes have a need to know
	// OOP re-usability of code to encapsulate

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private static final String user = "student";
	private static final String pWord = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.err.println("Unable to load Database Driver, Bye!!");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;

		String sql = "SELECT * FROM film WHERE film.id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pWord);
			PreparedStatement stmt = conn.prepareStatement(sql);

			
			stmt.setInt(1, filmId);

			ResultSet rSet = stmt.executeQuery();


			while (rSet.next()) {
			
				int filmIdSearch = rSet.getInt("film.id");
				String title = rSet.getString("title");
				String description = rSet.getString("description");//
				int releaseYear = rSet.getInt("release_year");

				int rental_duration = rSet.getInt("rental_duration");
				double rentalRate = rSet.getDouble("rental_rate");

				int length = rSet.getInt("length");
				double replacementCost = rSet.getDouble("replacement_cost");
				String rating = rSet.getString("rating");
				int languageId = rSet.getInt("language_id");
				String specialFeatures = rSet.getString("special_features");
				film = new Film(filmIdSearch, title, description, releaseYear, languageId,
						rental_duration, languageId, length, replacementCost, rating, specialFeatures, 
						findActorsByFilmId(filmId));
				
				film.setLanguage(findLanguagesByFilmLanguageId(languageId));
				
			}

			rSet.close();
			stmt.close();
			conn.close();
//			return film;

		} catch (SQLException e) {
			System.err.println("404: Film By Id" + filmId);
			System.out.print(e.getMessage());
		}

		return film;
	}


	@Override
	public Actor findActorById(int actorId)  {
		Actor actor = null;

		String sql = "SELECT * FROM actor WHERE id = ?";
		try {

			Connection conn = DriverManager.getConnection(URL, user, pWord);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();
			
			while (actorResult.next()) {

				int actorById = actorResult.getInt("id");
				String firstName = actorResult.getString("first_name");
				String lastName = actorResult.getString("last_name");
				actor = new Actor(actorById, firstName, lastName); // constructor must match exactly as in Actor
				// Here is our mapping of query columns to our object fields:
			}
			actorResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("404: Actor By ID requires attention");
			System.out.println(e.getMessage());
		}
		return actor;

	}

	@Override
	public List<Actor> findActorsByFilmId(int foundFilmId) {
		List<Actor> actors = new ArrayList<>();// actors will be used to create an arrayList after all data has
												// been gathered

		String sql = "SELECT *  FROM actor JOIN film_actor ON actor.id = film_actor.actor_id WHERE film_id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pWord);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,  foundFilmId);
			ResultSet actorSearchResult = stmt.executeQuery();

			while (actorSearchResult.next()) {
				
				int actorId = actorSearchResult.getInt("id");
				String firstName = actorSearchResult.getString("first_name");
				String lastName = actorSearchResult.getString("last_name");
				
				Actor actor = new Actor(actorId, firstName, lastName);
				actors.add(actor);// actors arraylist begins to have data instead of null
			}

			actorSearchResult.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			System.err.println("404: Actors By Film Id requires attention"+ foundFilmId);
			System.out.println(e.getMessage());
		}
		return actors;
	}

	@Override
	public Language findLanguagesByFilmLanguageId(int filmLanguageId) {
		Language language = null;
		String sql = "SELECT id, name \n" + "FROM language\n" + "WHERE id = ?\n";
		try {

			Connection conn = DriverManager.getConnection(URL, user, pWord);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmLanguageId);
			ResultSet searchLang = stmt.executeQuery();

			while (searchLang.next()) {
				int id = searchLang.getInt("id");
				String name = searchLang.getString("name");
				language = new Language(name, id);
			}
			searchLang.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			System.err.println("404: FilmLanguage requires attention");
			System.out.println(e.getMessage());
		}
		return language;
	}

	@Override
	public List<Film> findFilmsByKeyWord(String keyword) {
		List<Film> films = new ArrayList<>();

		String sql = "SELECT *  FROM film WHERE title LIKE ? OR description LIKE ?";
		try {

			Connection conn = DriverManager.getConnection(URL, user, pWord);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet searchKeyWord = stmt.executeQuery();

			while (searchKeyWord.next()) {
				int filmId = searchKeyWord.getInt("id");
				String title = searchKeyWord.getString("title");
				String description = searchKeyWord.getString("description");
				int releaseYear = searchKeyWord.getInt("release_year");
				String rating = searchKeyWord.getString("rating");
//				int filmIdId = searchKeyWord.getInt("film.id");
//				int languageId = searchKeyWord.getInt("film.language_id");

				films.add(new Film(filmId, title, description, releaseYear, rating,
						findActorsByFilmId(searchKeyWord.getInt("film.id")),
						findLanguagesByFilmLanguageId(searchKeyWord.getInt("film.language_id") )));
			}

			searchKeyWord.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			System.err.println("404: Keyword requires attention " + keyword);
			System.out.println(e.getMessage());

		}

		return films;
	}

}
