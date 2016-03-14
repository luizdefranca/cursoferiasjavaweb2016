package org.eleicoes2014.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.eleicoes2014.modelo.Tweet;

public class TwitterDAO {

	public Tweet get(long id) throws SQLException {
		Tweet tweet = null;
		Connection conn = null;
		try {
			conn = getConnection();
			
			PreparedStatement pstmt = 
				conn.prepareStatement(
					"select * from twitter.tweets where id = ?");
			pstmt.setLong(1, id);
			
			ResultSet rst = pstmt.executeQuery();
			if(rst.next()) {
				tweet = new Tweet();
				tweet.setId(rst.getLong("id"));	
				tweet.setUser(rst.getString("user"));
				tweet.setCreatedAt(rst.getDate("createdAt"));
				tweet.setText(rst.getString("text"));
				tweet.setSource(rst.getString("source"));
				tweet.setTruncated(rst.getBoolean("isTruncated"));
				tweet.setInReplyToStatusId(rst.getLong("inReplyToStatusId"));
				tweet.setInReplyToUserId(rst.getInt("inReplyToUserId"));
				tweet.setFavorited(rst.getBoolean("isFavorited"));
				tweet.setInReplyToScreenName(rst.getString("inReplyToScreenName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (conn != null) {
				conn.close();
			}
		}
		return tweet;
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	
	public void insert (Tweet tweet) {}
	public void update (Tweet tweet) {}
	public void delete (Tweet tweet) {}
	public List<Tweet> search (Tweet tweet) { return null;}	
	
	private static final String URL = 
			"jdbc:mysql://localhost/twitter";
	
	private static final String USER = "root";
	private static final String PASSWORD = null;
	private static final String DRIVER_CLASS = 
			"com.mysql.jdbc.Driver";
	
	public TwitterDAO() throws Exception {
		Class.forName(DRIVER_CLASS);
	}
}
