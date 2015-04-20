package com.training.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowerDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6464966553788578707L;
	
	public void addBorrower(Borrower borrower) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "insert into tbl_borrower (borrowerName) values (?)";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, borrower.getBorrowerName());
			pstmt.executeUpdate();

	}
	
	public void updateBorrower(Borrower borrower) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "update tbl_borrower set borrowerName = ? where cardNo = ?";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, borrower.getBorrowerName());
			pstmt.setInt(2, borrower.getCardNo());
			pstmt.executeUpdate();

	}
	
	public void removeBorrower(Borrower borrower) throws SQLException {
		Connection conn = getConnection();

			String removeQuery = "delete from tbl_borrower where cardNo=?";
			PreparedStatement pstmt = conn.prepareStatement(removeQuery);
			pstmt.setInt(1, borrower.getCardNo());
			pstmt.executeUpdate();

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", null);
		return conn;
	}
	
	public List<Borrower> readAll() throws SQLException {
		String select = "select * from tbl_borrower";
		PreparedStatement stmt = getConnection().prepareStatement(select);
		ResultSet rs = stmt.executeQuery();
		
		List<Borrower> borrowers = new ArrayList<Borrower>();
		while(rs.next()) {
			Borrower a = new Borrower();
			a.setCardNo(rs.getInt("cardNo"));
			a.setBorrowerName(rs.getString("borrowerName"));
			
			borrowers.add(a);
		}
		
		return borrowers;
	}


}
