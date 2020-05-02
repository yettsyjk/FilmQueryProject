package com.skilldistillery.filmquery.database;

import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
  public Film findFilmById(int filmId);
//  public Actor findActorById(int actorId);
//  public List<Actor> findActorsByFilmId(int filmId);
}
