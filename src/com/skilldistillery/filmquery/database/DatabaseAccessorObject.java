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

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.err.println("Unable to load database, Bye!!");
			e.printStackTrace();
		}
	}

	/*
	 * Implement the findFilmById method that takes an int film ID, and returns a
	 * Film object (or null, if the film ID returns no data.)
	 */
	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		String user = "student";
		String pWord = "student";

		// try with resources will have catch throws SQLException
		try {
			Connection conn = DriverManager.getConnection(URL, user, pWord);
	
			String sql = "SELECT * \n" 
			+ "FROM film\n" 
					+ "JOIN film_actor \n" 
			+ "ON film.id = film_actor.film_id\n"
					+ "WHERE film_id = ?\n";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);

			ResultSet rSet = stmt.executeQuery();
			film = new Film();

			while (rSet.next()) {
				film = new Film();
				film.setId(rSet.getInt("id") );
				film.setTitle(rSet.getString("title") );
				film.setDescription(rSet.getString("description") );//
				film.setReleaseYear(rSet.getInt("release_year") );
				film.setLanguageId(rSet.getInt("language_id") );

				film.setRental_duration(rSet.getInt("rental_duration") );
				film.setRentalRate(rSet.getDouble("rental_rate") );

				film.setLength(rSet.getInt("length") );
				film.setReplacementCost(rSet.getDouble("replacement_cost") );
				film.setRating(rSet.getString("rating") );
				film.setSpecialFeatures(rSet.getString("special_features") );
				/*
				 * When a film is retrieved from the database, its actors are also retrieved and
				 * included in the Film object.
				 */
				film.setActorsInFilm(findActorsByFilmId(rSet.getInt("id") )  );
			}

			rSet.close();
			stmt.close();
			conn.close();
			return film;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * Implement findActorById method that takes an int actor ID, and returns an
	 * Actor object (or null, if the actor ID returns no data.)
	 */

	@Override
	public Actor findActorById(int actorId) throws SQLException {
		Actor actor = null;

		String user = "student";
		String pWord = "student";

		String sql = "SELECT * FROM actor WHERE id = ?";

		Connection conn = DriverManager.getConnection(URL, user, pWord);
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, actorId);
		ResultSet actorResult = stmt.executeQuery();
		if (actorResult.next()) {
			actor = new Actor(); // Create the object
			// Here is our mapping of query columns to our object fields:
			actor.setId(actorResult.getInt("id"));
			actor.setFirstName(actorResult.getString("first_name"));
			actor.setLastName(actorResult.getString("last_name"));
			actor.setFilms((List<Film>) findFilmById(actorId));
		}
		actorResult.close();
		stmt.close();
		conn.close();
		return actor;
	}

	/*
	 * Implement findActorsByFilmId with an appropriate List implementation that
	 * will be populated using a ResultSet and returned.
	 */
	@Override
	public List<Actor> findActorsByFilmId(int foundFilmId) {
		ArrayList<Actor> actors = new ArrayList<>();// actors will be used to create an arrayList after all data has
													// been gathered

		try {
			String user = "student";
			String pWord = "student";
			String sql = "SELECT * FROM actor WHERE id = ?";

			Connection conn = DriverManager.getConnection(URL, user, pWord);
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet actorSearchResult = stmt.executeQuery();

			while (actorSearchResult.next()) {
				Actor actor = new Actor();
				actor.setId(actorSearchResult.getInt("id"));
				actor.setFirstName(actorSearchResult.getString("first_name"));
				actor.setLastName(actorSearchResult.getString("last_name"));
				actors.add(actor);// actors arraylist begins to have data instead of null
			}

			actorSearchResult.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}
	@Override
	public Language findLanguagesByFilmLanguageId(int filmLangId) {
		Language language = null;
		String user = "student";
		String pWord = "student";
		try {
			String sql ="SELECT language.id, language.name \n" + 
					"FROM language\n" + 
					"WHERE id = ?\n" + 
					";";
			Connection conn = DriverManager.getConnection(URL, user, pWord);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,  filmLangId);
			ResultSet searchLang = stmt.executeQuery();
			while(searchLang.next()) {
				int id = searchLang.getInt("langauge.id");
				String name = searchLang.getString("language.name");
				language = new Language(name, id);
			}
			searchLang.close();
			stmt.close();
			conn.close();
			
		}catch(SQLException e) {
			System.err.println(e.getMessage() + "FilmLanguage requires attention");
		} catch (NullPointerException e) {
			return null;
		}
		return language;
	}

	@Override
	public ArrayList<Film> findFilmsByKeyWord(String keyword) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
