package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligbile() {
		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5,"");
		boolean isKidFriendly = movie.isKidFriendlyEligbile();
		assertFalse("For Horror Genre should return false",isKidFriendly);
		
		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5,"");
		isKidFriendly = movie.isKidFriendlyEligbile();
		assertFalse("For Thrillers Genre should return false",isKidFriendly);
	}

}
