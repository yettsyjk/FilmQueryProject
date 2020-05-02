package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.Language;

public interface DatabaseAccessor {
  public Film findFilmById(int filmId);
  
  public Actor findActorById(int actorId) throws Exception;
  
  public List<Actor> findActorsByFilmId(int filmId);
  
  public ArrayList<Film> findFilmsByKeyWord(String keyword) throws SQLException; 
  
  public Language findLanguagesByFilmLanguageId(int filmLangId);
}
