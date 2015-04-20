package com.training.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void addGenre(Genre genre) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "insert into tbl_genre (genreName) values (?)";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, genre.getName());
			pstmt.executeUpdate();

	}
	
	public void updateGenre(Genre genre) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "update tbl_genre set genreName = ? where genre_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, genre.getName());
			pstmt.setInt(2, genre.getGenreId());
			pstmt.executeUpdate();

	}
	
	public void removeGenre(Genre genre) throws SQLException {
		Connection conn = getConnection();

			String removeQuery = "delete from tbl_genre where genre_id=?";
			PreparedStatement pstmt = conn.prepareStatement(removeQuery);
			pstmt.setInt(1, genre.getGenreId());
			pstmt.executeUpdate();

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", null);
		return conn;
	}
	
	public List<Genre> readAll() throws SQLException {
		String select = "select * from tbl_genre";
		PreparedStatement stmt = getConnection().prepareStatement(select);
		ResultSet rs = stmt.executeQuery();
		
		List<Genre> genres = new ArrayList<Genre>();
		while(rs.next()) {
			Genre a = new Genre();
			a.setGenreId(rs.getInt("genre_id"));
			a.setName(rs.getString("genre_name"));
			
			genres.add(a);
		}
		
		return genres;
	}

	
	
}
