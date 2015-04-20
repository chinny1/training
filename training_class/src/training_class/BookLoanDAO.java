package com.training.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookLoanDAO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3709720364232847304L;
	
	
	public void addBookLoan(BookLoan bookLoan) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "insert into tbl_book_loans (bookId,branchId,cardNo) values (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setObject(1, bookLoan.getBook());
			pstmt.setObject(2, bookLoan.getLibraryBranch());
			pstmt.setObject(3, bookLoan.getBorrower());
			pstmt.executeUpdate();

	}
	
	public void updateBookLoan(BookLoan bookLoan) throws SQLException {
		//action: updating cardno
		Connection conn = getConnection();

			String updateQuery = "update tbl_book_loans set cardNo = ? where bookId = ? AND branchId = ? AND cardNo =? ";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setInt(1, 7);//just choosing 7 to set the new card number to 
			pstmt.setObject(2, bookLoan.getBook());
			pstmt.setObject(3, bookLoan.getLibraryBranch());
			pstmt.setObject(4, bookLoan.getBorrower());
			
			pstmt.executeUpdate();

	}
	
	public void removeBook(BookLoan bookLoan) throws SQLException {
		Connection conn = getConnection();

			String removeQuery = "delete from tbl_book_loans where bookId=? AND cardNo = ?" ;
			PreparedStatement pstmt = conn.prepareStatement(removeQuery);
			pstmt.setObject(1, bookLoan.getBook());
			pstmt.setObject(2, bookLoan.getBorrower());
			pstmt.executeUpdate();

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "root");
		return conn;
	}
	
	public List<BookLoan> readAll() throws SQLException {
		String select = "select * from tbl_book_loans";
		PreparedStatement stmt = getConnection().prepareStatement(select);
		ResultSet rs = stmt.executeQuery();
		
		List<BookLoan> bookLoans = new ArrayList<BookLoan>();
		while(rs.next()) {
			BookLoan a = new BookLoan();
			a.setBook((Book) rs.getObject("Book"));
			a.setBorrower((Borrower) rs.getObject("Borrower"));
			
			bookLoans.add(a);
			
		}
		
		return bookLoans;
	}
	
	
	
	
}
