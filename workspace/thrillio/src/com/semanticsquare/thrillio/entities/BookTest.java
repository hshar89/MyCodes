package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.managers.BookmarkManager;

class BookTest {

	@Test
	void testIsKidFriendlyEligbile() {
		Book book  = BookmarkManager.getInstance().createBook(4000, "Walden",1854,"Wilder Publications",
				new String[] { "Henry David Thoreau" },BookGenre.PHILOSOPHY, 4.3);
		boolean isKidFriendly = book.isKidFriendlyEligbile();
		assertFalse("For Philosophy Genre should return fasle",isKidFriendly);
		
		book  = BookmarkManager.getInstance().createBook(4000, "Walden",1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" },BookGenre.SELF_HELP,4.3);
		isKidFriendly = book.isKidFriendlyEligbile();
		assertFalse("For Self help Genre should return fasle",isKidFriendly);
	}

}
