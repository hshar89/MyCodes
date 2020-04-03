package com.semanticsquare.thrillio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.semanticsquare.thrillio.DataStore;
import com.semanticsquare.thrillio.entities.Book;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.Movie;
import com.semanticsquare.thrillio.entities.UserBookmark;
import com.semanticsquare.thrillio.entities.Weblink;

public class BookmarkDao {
	public List<List<Bookmark>> getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userbookmark) {
		//DataStore.add(userbookmark);
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?useSSL=false","root","Destiny.008");
				Statement stmt = conn.createStatement();){
				if(userbookmark.getBookmark() instanceof Book) {
					saveUserBook(userbookmark,stmt);
				}else if(userbookmark.getBookmark() instanceof Movie) {
					saveUsermovie(userbookmark,stmt);
				}else {
					saveUserWeblink(userbookmark,stmt);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	private void saveUserWeblink(UserBookmark userbookmark, Statement stmt) throws SQLException {
		// TODO Auto-generated method stub
		String query = "Insert into User_Weblink (user_id, weblink_id) values ("+userbookmark.getUser().getId()
				+","+userbookmark.getBookmark().getId()+");";
		 stmt.executeUpdate(query);	
	}

	private void saveUsermovie(UserBookmark userbookmark, Statement stmt) throws SQLException {
		// TODO Auto-generated method stub
		String query = "Insert into User_Movie (user_id, movie_id) values ("+userbookmark.getUser().getId()
				+","+userbookmark.getBookmark().getId()+");";
		 stmt.executeUpdate(query);	
	}

	private void saveUserBook(UserBookmark userbookmark, Statement stmt) throws SQLException {
		// TODO Auto-generated method stub
		String query = "Insert into User_Book (user_id, book_id) values ("+userbookmark.getUser().getId()
				+","+userbookmark.getBookmark().getId()+");";
		 stmt.executeUpdate(query);
		 
	}

	public List<Weblink> getAllWeblinks(){
		List<Weblink> result = new ArrayList<>();
		List<List<Bookmark>> bookmarks = DataStore.getBookmarks();
		List<Bookmark> allWeblinks = bookmarks.get(0);
		for(Bookmark bookmark: allWeblinks) {
			result.add((Weblink)bookmark);
		}
		return result;
	}
	public List<Weblink> getWebLinks(Weblink.DownloadStatus downloadStatus){
		List<Weblink> result = new ArrayList<>();
		List<Weblink> allWebLinks = getAllWeblinks();
		for(Weblink weblink : allWebLinks) {
			if(weblink.getDownloadStatus().equals(downloadStatus)) {
				result.add(weblink);
			}
		}
		return result;
	}

	public void updateKidFriendlyStatus(Bookmark bookmark) {
		// TODO Auto-generated method stub
		int kidFriendlyStatus = bookmark.getKidFriendlyStatus().ordinal();
		long userid = bookmark.getKidFriendlyMarkedBy().getId();
		String tableToUpdate= "Book";
		if(bookmark instanceof Movie) {
			tableToUpdate="Movie";
		}else if(bookmark instanceof Weblink) {
			tableToUpdate = "Weblink";
		}
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?useSSL=false","root","Destiny.008");
				Statement stmt = conn.createStatement();){
				String query = "update " +tableToUpdate +" set kid_friendly_status = "+ kidFriendlyStatus +", kid_friendly_marked_by="
						+userid+" where id = "+bookmark.getId();
				System.out.println("query (kid friendly status update: "+query);
				stmt.executeUpdate(query);
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}

	public void sharedByInfo(Bookmark bookmark) {
		// TODO Auto-generated method stub
		long userid = bookmark.getSharedBy().getId();
		String tableToUpdate = "Book";
		if(bookmark instanceof Weblink) {
			tableToUpdate = "weblink";
		}
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?useSSL=false","root","Destiny.008");
				Statement stmt = conn.createStatement();){
				String query = "update " +tableToUpdate +" set shared_by = "+
						+userid+" where id = "+bookmark.getId();
				System.out.println("query (kid friendly marked by ): "+query);
				stmt.executeUpdate(query);
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
}
