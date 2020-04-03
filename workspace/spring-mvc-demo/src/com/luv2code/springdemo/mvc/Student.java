package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;

	private String lastName;

	private String country;
	
	private String favouriteLanguage;
	
	private String[] operatingSystems;
	
	private LinkedHashMap<String,String> favoriteLanguages;
	
    private LinkedHashMap<String,String> countryOptions;
    
	public Student() {
      //populate country options
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("IN", "India");
		countryOptions.put("GM", "Germany");
		countryOptions.put("RU", "Russia");
		countryOptions.put("US", "United States");
		
		favoriteLanguages = new LinkedHashMap<>();
		favoriteLanguages.put("Java", "Java");
		favoriteLanguages.put("C#", "C#");
		favoriteLanguages.put("Kotlin", "Kotlin");
		favoriteLanguages.put("Ruby", "Ruby");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public LinkedHashMap<String, String> getFavoriteLanguages() {
		return favoriteLanguages;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
}
