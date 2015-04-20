package com.training.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryBranchDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void addLibraryBranch(LibraryBranch LibraryBranch) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "insert into tbl_library_branch (branchName) values (?)";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, LibraryBranch.getBranchName());
			pstmt.executeUpdate();

	}
	
	public void updateLibraryBranch(LibraryBranch LibraryBranch) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "update tbl_library_branch set LibraryBranchName = ? where LibraryBranchId = ?";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, LibraryBranch.getBranchName());
			pstmt.setInt(2, LibraryBranch.getBranchId());
			pstmt.executeUpdate();

	}
	
	public void removeLibraryBranch(LibraryBranch LibraryBranch) throws SQLException {
		Connection conn = getConnection();

			String removeQuery = "delete from tbl_library_branch where LibraryBranchId=?";
			PreparedStatement pstmt = conn.prepareStatement(removeQuery);
			pstmt.setInt(1, LibraryBranch.getBranchId());
			pstmt.executeUpdate();

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", null);
		return conn;
	}
	
	public List<LibraryBranch> readAll() throws SQLException {
		String select = "select * from tbl_library_branch";
		PreparedStatement stmt = getConnection().prepareStatement(select);
		ResultSet rs = stmt.executeQuery();
		
		List<LibraryBranch> LibraryBranches = new ArrayList<LibraryBranch>();
		while(rs.next()) {
			LibraryBranch a = new LibraryBranch();
			a.setBranchId(rs.getInt("branchId"));
			a.setBranchName(rs.getString("branchName"));
			
			LibraryBranches.add(a);
		}
		
		return LibraryBranches;
	}

}
