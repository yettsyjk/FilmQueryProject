package com.skilldistillery.filmquery.entities;

public class Language {
	/*
	 *User Story 4 film language displayed not ID
	 */
	private String filmLanguage;
	private String name;
	private int id;
	
	
	public Language(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	
	}
	
	public void add(Language langugae) {
	}
	
	
	public String getFilmLanguage() {
		return filmLanguage;
	}
	public void setFilmLanguage(String filmLanguage) {
		this.filmLanguage = filmLanguage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filmLanguage == null) ? 0 : filmLanguage.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Language other = (Language) obj;
		if (filmLanguage == null) {
			if (other.filmLanguage != null)
				return false;
		} else if (!filmLanguage.equals(other.filmLanguage))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return name;
	}
	
	
	
	
	
	
	
}
