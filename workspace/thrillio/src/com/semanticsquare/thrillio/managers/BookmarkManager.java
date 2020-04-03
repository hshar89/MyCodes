package com.semanticsquare.thrillio.managers;

import java.util.List;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.dao.BookmarkDao;
import com.semanticsquare.thrillio.entities.Book;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.Movie;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.entities.UserBookmark;
import com.semanticsquare.thrillio.entities.Weblink;
import com.semanticsquare.thrillio.util.HttpConnect;
import com.semanticsquare.thrillio.util.IOUtil;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao bdao = new BookmarkDao();

	private BookmarkManager() {
	};

	public static BookmarkManager getInstance() {
		return instance;
	}

	public Movie createMovie(long id, String title, int releaseYear, String[] cast,
			String[] directors, MovieGenre genre, double imdbRating, String profileUrl) {
		Movie movie = new Movie();
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setId(id);
		movie.setImdbRating(imdbRating);
		movie.setReleaseYear(releaseYear);
		movie.setProfileUrl(profileUrl);
		movie.setTitle(title);
		return movie;
	}

	public Book createBook(long id, String title, int publicationYear,String publisher, String[] authors, BookGenre genre,
			double amazonRating) {
		Book book = new Book();
		book.setAmazonRating(amazonRating);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setId(id);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setTitle(title);
		return book;
	}

	public Weblink createWeblink(long id, String title, String url, String host) {
		Weblink weblink = new Weblink();
		weblink.setHost(host);
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setUrl(url);
		return weblink;
	}

	public List<List<Bookmark>> getBookmarks() {
		return bdao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userbookmark = new UserBookmark();
		userbookmark.setBookmark(bookmark);
		userbookmark.setUser(user);
		
		/*
		if(bookmark instanceof Weblink) {
			try {
				String url = ((Weblink)bookmark).getUrl();
				if(!url.endsWith(".pdf")) {
					String webpage = HttpConnect.download(url);
					System.out.println("Webpage "+webpage);
					if(webpage!=null) {
						IOUtil.write(webpage,bookmark.getId());
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}*/
		bdao.saveUserBookmark(userbookmark);
	}

	public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyStatus, Bookmark bookmark) {
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		bookmark.setKidFriendlyMarkedBy(user);
		bdao.updateKidFriendlyStatus(bookmark);
		System.out.println(
				"Kid- Friendly status " + kidFriendlyStatus + " " + bookmark + " Marked by: " + user.getEmail());
	}

	public void share(User user, Bookmark bookmark) {
	  bookmark.setSharedBy(user);
	  System.out.println("Data to be shared: ");
	  if(bookmark instanceof Book) {
		  System.out.println(((Book) bookmark).getItemData());
	  }else if(bookmark instanceof Weblink) {
		  System.out.println(((Weblink)bookmark).getItemData());
	  }
	  bdao.sharedByInfo(bookmark);
	}
}
