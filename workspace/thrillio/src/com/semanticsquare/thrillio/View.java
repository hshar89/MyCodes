package com.semanticsquare.thrillio;

import java.util.List;

import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.controllers.BookmarkController;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.partner.Shareable;

public class View {
	public static void browse(User user, List<List<Bookmark>> bookmarks) {
		System.out.println("\n" + user.getEmail() + " is bookmarking ...");
		int bookmarkCount = 0;

		for (List<Bookmark> bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				//if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);

						System.out.println("New item bookmarked... " + bookmark);
					}
				//}

				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					// Mark as kid firendly
					if (bookmark.isKidFriendlyEligbile()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						KidFriendlyStatus kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstance().setKidFriendlyStatus(user, bookmark, kidFriendlyStatus);
						}
					}

					// Sharing!!
					if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
							&& bookmark instanceof Shareable) {
                      boolean isShared = getShareDecision();
                      if(isShared) {
                    	  BookmarkController.getInstance().share(user,bookmark);
                      }
					}
				}
			}
		}

	}

	private static boolean getShareDecision() {
		return Math.random()<0.5?true:false;
		
	}

	private static KidFriendlyStatus getKidFriendlyStatusDecision(Bookmark bookmark) {
		double decison = Math.random();
		return decison < 0.4 ? KidFriendlyStatus.APPROVED
				: (decison >= 0.4 && decison < 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN;

	}
	/*
	 * public static void bookmark(User user, Bookmark[][] bookmarks) {
	 * System.out.println("\n"+ user.getEmail()+" is bookmarking ..."); for(int
	 * i=0;i<DataStore.USER_BOOKMARK_LIMIT;i++) { int typeOffset = (int)
	 * (Math.random()* DataStore.BOOKMARK_TYPE_COUNT); int bookmarkOffset =
	 * (int)(Math.random()*DataStore.BOOKMARK_COUNT_PER_TYPE); Bookmark bookmark =
	 * bookmarks[typeOffset][bookmarkOffset];
	 * BookmarkController.getInstance().saveUserBookmark(user,bookmark);
	 * 
	 * System.out.println(bookmark); } }
	 */

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		// TODO Auto-generated method stub
		return Math.random() < 0.5 ? true : false;
	}
}
