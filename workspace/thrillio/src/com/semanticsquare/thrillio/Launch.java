package com.semanticsquare.thrillio;

import java.util.List;

import com.semanticsquare.thrillio.bgjobs.WebPageDownloaderTask;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import com.semanticsquare.thrillio.managers.UserManager;

public class Launch {
	private static List<User> users;
	private static List<List<Bookmark>> bookmarks;

	private static void loadData() {
		DataStore.loadData();
	}

	private static void printUserData() {
        for(User user: users) {
        	System.out.println(user);
        }
	}
    private static void printBookmarkData() {
    	for(List<Bookmark> blist: bookmarks) {
    		for(Bookmark bookmark: blist) {
    			System.out.println(bookmark);
    		}
    	}
    }
    private static void start() {
		//System.out.println("\n2. Bookmarking...");
		for(User user: users) {
			View.browse(user, bookmarks);
		}
	}
	public static void main(String[] args) {
		System.out.println("1. Loading data... ");
		loadData();
		
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();

		System.out.println("Printning data ....");
		printUserData();
		printBookmarkData();
		
		start();
		runDownloaderJob();
	}
	private static void runDownloaderJob() {
		WebPageDownloaderTask task = new WebPageDownloaderTask(true);
		(new Thread(task)).start();
	}

}
