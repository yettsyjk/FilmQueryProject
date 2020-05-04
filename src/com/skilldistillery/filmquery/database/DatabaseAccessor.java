package com.skilldistillery.filmquery.database;


import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.Language;





public interface DatabaseAccessor {
  public Film findFilmById(int filmId);
  
  public Actor findActorById(int actorId);
  
  public List<Actor> findActorsByFilmId(int filmId);
  
  public List<Film> findFilmsByKeyWord(String keyword); 
  
  public Language findLanguagesByFilmLanguageId(int filmLanguageId);
}
