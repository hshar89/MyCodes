package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.managers.BookmarkManager;

class WeblinkTest {

	@Test
	void testIsKidFriendlyEligbile() {
		//Test 1 -- porn in url -- false
		Weblink wl = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--porn-2.html",
				"http://www.javaworld.com");
		boolean isKidFriendly = wl.isKidFriendlyEligbile();
		assertFalse("For porn in URL - isKidFriendlyEligible() must return false",isKidFriendly);
		//Test 2 : porn in title -- false
		wl = BookmarkManager.getInstance().createWeblink(2000, "Taming porn, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		isKidFriendly= wl.isKidFriendlyEligbile();
		assertFalse("For porn in title must return false",isKidFriendly);
		//Test 3 : adult in host -- false 
		wl = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.adult.com");
		isKidFriendly= wl.isKidFriendlyEligbile();
		assertFalse("For adult in host must return false",isKidFriendly);
		//Test 4 : adult in url, but not in host -- true
		wl = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-adult/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		isKidFriendly= wl.isKidFriendlyEligbile();
		assertTrue("For adult in url but not in host return true",isKidFriendly);
		//Test 5 : adult in title only -- true
		wl = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger Adult, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		isKidFriendly= wl.isKidFriendlyEligbile();
		assertTrue("For adult only int title return true",isKidFriendly);
	}

}
