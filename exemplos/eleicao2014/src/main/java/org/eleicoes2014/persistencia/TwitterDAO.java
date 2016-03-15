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
	
	
	public void insert (Tweet tweet) throws SQLException {
	
		Connection conn = null;
		try {
			conn = getConnection();
	
			conn.setAutoCommit(false);
			
			StringBuilder sql = new StringBuilder();
			
			
			sql.append("INSERT INTO twitter.tweets");
			sql.append("(");
			sql.append("user,");
			sql.append("createdAt,");
			sql.append("text,");
			sql.append("source,");
			sql.append("isTruncated,");
			sql.append("inReplyToStatusId,");
			sql.append("inReplyToUserId,");
			sql.append("isFavorited,");
			sql.append("inReplyToScreenName)");
			sql.append(" VALUES ");
			sql.append("(");
			sql.append("?,");
			sql.append("?,");
			sql.append("?,");
			sql.append("?,");
			sql.append("?,");
			sql.append("?,");
			sql.append("?,");
			sql.append("?,");
			sql.append("?)");		
			
			PreparedStatement pstmt = 
				conn.prepareStatement(sql.toString());
			
			/*("user,");*/pstmt.setString(1, tweet.getUser());
			/*("createdAt,");*/pstmt.setDate(2, new java.sql.Date(tweet.getCreatedAt().getTime()));
			/*("text,");*/pstmt.setString(3, tweet.getText());
			/*("source,");*/pstmt.setString(4, tweet.getSource());
			/*("isTruncated,");*/pstmt.setBoolean(5, tweet.isTruncated());
			/*("inReplyToStatusId,");*/pstmt.setLong(6, tweet.getInReplyToStatusId());
			/*("inReplyToUserId,");*/pstmt.setLong(7, tweet.getInReplyToUserId());
			/*("isFavorited,");*/pstmt.setBoolean(8, tweet.isFavorited());
			/*("inReplyToScreenName)");*/pstmt.setString(9, tweet.getInReplyToScreenName());			
						
			int executeUpdate = pstmt.executeUpdate();
			
			System.out.println(executeUpdate);

			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
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
