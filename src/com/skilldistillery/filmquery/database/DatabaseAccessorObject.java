package com.skilldistillery.filmquery.database;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
  @Override
  public Film findFilmById(int filmId) {
    return null;
  }

  
  public Actor findActorById(int actorId) {
	  Actor actor = null;
	 //actor.conn
	  String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  stmt.setInt(1,actorId);
	  ResultSet actorResult = stmt.executeQuery();
	  if (actorResult.next()) {
	    actor = new Actor(); // Create the object
	    // Here is our mapping of query columns to our object fields:
	    actor.setId(actorResult.getInt(1));
	    actor.setFirstName(actorResult.getString(2));
	    actor.setLastName(actorResult.getString(3));
	  }
	  
	  return actor;
	}
}
