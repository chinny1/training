package com.training.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublisherDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void addPublisher(Publisher publisher) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "insert into tbl_publisher (publisherName) values (?)";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, publisher.getName());
			pstmt.executeUpdate();

	}
	
	public void updatePublisher(Publisher publisher) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "update tbl_publisher set publisherName = ? where publisherId = ?";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, publisher.getName());
			pstmt.setInt(2, publisher.getId());
			pstmt.executeUpdate();

	}
	
	public void removePublisher(Publisher publisher) throws SQLException {
		Connection conn = getConnection();

			String removeQuery = "delete from tbl_publisher where publisherId=?";
			PreparedStatement pstmt = conn.prepareStatement(removeQuery);
			pstmt.setInt(1, publisher.getId());
			pstmt.executeUpdate();

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", null);
		return conn;
	}
	
	public List<Publisher> readAll() throws SQLException {
		String select = "select * from tbl_publisher";
		PreparedStatement stmt = getConnection().prepareStatement(select);
		ResultSet rs = stmt.executeQuery();
		
		List<Publisher> publishers = new ArrayList<Publisher>();
		while(rs.next()) {
			Publisher a = new Publisher();
			a.setId(rs.getInt("publisherId"));
			a.setName(rs.getString("publisherName"));
			
			publishers.add(a);
		}
		
		return publishers;
	}
	
	
	
	
}
