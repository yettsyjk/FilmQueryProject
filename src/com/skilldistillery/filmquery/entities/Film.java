package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {
	private String title, description, specialFeatures, rating;
	private int id, releaseYear, languageId, rental_duration, length, actorId;
	private double rentalRate, replacementCost;
	/*
	 * Modify your Film class to include a List of actors for the film's cast. 
	 */
	private List<Actor> actorsInFilm;
	
	private Language language;
	
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	
	public Film() {
	}

	public Film(String title, String description, String rating, String special_features, int id, int release_year,
			int language_id, int rental_duration, int length, int actor_id, double rental_rate, double replacement_cost,
			List<Actor> actorsInFilm) {
		super();
		this.title = title;//
		this.description = description;//
		
		
		this.id = id;//
		this.releaseYear = release_year;//
		this.languageId = language_id;//
		this.rental_duration = rental_duration;//
		this.rentalRate = rental_rate;//
		this.rating = rating;//
		this.specialFeatures = special_features;//
		this.actorId = actor_id;
		this.length = length;
		this.replacementCost = replacement_cost;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRental_duration() {
		return rental_duration;
	}

	public void setRental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public List<Actor> getActorsInFilm() {
		return actorsInFilm;
	}

	public void setActorsInFilm(List<Actor> actorsInFilm) {
		this.actorsInFilm = actorsInFilm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actorsInFilm == null) ? 0 : actorsInFilm.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + languageId;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releaseYear;
		long temp;
		temp = Double.doubleToLongBits(rentalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + rental_duration;
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actorsInFilm == null) {
			if (other.actorsInFilm != null)
				return false;
		} else if (!actorsInFilm.equals(other.actorsInFilm))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (languageId != other.languageId)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (Double.doubleToLongBits(rentalRate) != Double.doubleToLongBits(other.rentalRate))
			return false;
		if (rental_duration != other.rental_duration)
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Film [title=" + title + ", description=" + description + ", specialFeatures=" + specialFeatures
				+ ", rating=" + rating + ", id=" + id + ", releaseYear=" + releaseYear + ", languageId=" + languageId
				+ ", rental_duration=" + rental_duration + ", length=" + length + ", rentalRate=" + rentalRate
				+ ", replacementCost=" + replacementCost + ", actorsInFilm=" + actorsInFilm + "]";
	}

}
