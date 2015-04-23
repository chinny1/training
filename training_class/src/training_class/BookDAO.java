package com.training.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7658796790770245666L;
	
	public void addBook(Book book) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "insert into tbl_book (title) values (?)";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, book.getTitle());
			pstmt.executeUpdate();

	}
	
	public void updateBook(Book book) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "update tbl_book set title = ? where bookId = ?";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, book.getTitle());
			pstmt.setInt(2, book.getBookId());
			pstmt.executeUpdate();

	}
	
	public void removeBook(Book book) throws SQLException {
		Connection conn = getConnection();

			String removeQuery = "delete from tbl_book where bookId=?";
			PreparedStatement pstmt = conn.prepareStatement(removeQuery);
			pstmt.setInt(1, book.getBookId());
			pstmt.executeUpdate();

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", null);
		return conn;
	}
	
	public List<Book> readAll() throws SQLException {
		String select = "select * from tbl_book";
		PreparedStatement stmt = getConnection().prepareStatement(select);
		ResultSet rs = stmt.executeQuery();
		
		List<Book> books = new ArrayList<Book>();
		while(rs.next()) {
			Book a = new Book();
			a.setBookId(rs.getInt("bookId"));
			a.setTitle(rs.getString("title"));
			
			books.add(a);
		}
		
		return books;
	}

	

}
