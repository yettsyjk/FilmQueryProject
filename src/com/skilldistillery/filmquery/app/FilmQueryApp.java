package com.skilldistillery.filmquery.app;



import java.sql.SQLException;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();
  
  
  
  
  public static void main(String[] args) throws SQLException {
//    FilmQueryApp app = new FilmQueryApp();
    FilmQuery searchFilm = new FilmQuery();
  //  app.test();
    searchFilm.launch();
  }

//  private void test() {
//    Film film = db.findFilmById(1);
//    System.out.println(film);
//    
//  }

  

}
