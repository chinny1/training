package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.lws.domain.LibraryBranch;

public class LibraryBranchDAO extends BaseDAO<LibraryBranch> implements Serializable {

	public LibraryBranchDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1619700647002508164L;

	public void addLibraryBranch(LibraryBranch libraryBranch) throws SQLException {
		save("insert into tbl_library_branch (branchName,branchAddress) values (?,?)",
				new Object[] { libraryBranch.getBranchName(), libraryBranch.getBranchAddress() });

	}

	public void updateLibraryBranch(LibraryBranch libraryBranch) throws SQLException {
		save("update tbl_library_branch set branchName = ? where branchId = ?",
				new Object[] { libraryBranch.getBranchName(), libraryBranch.getBranchId() });
	}

	public void removeLibraryBranch(LibraryBranch libraryBranch) throws SQLException {
		save("delete from tbl_library_branch where branchId = ?",
				new Object[] { libraryBranch.getBranchId() });
	}

	@SuppressWarnings("unchecked")
	public List<LibraryBranch> readAll() throws SQLException {
		return (List<LibraryBranch>) read("select * from tbl_library_branch", null);
	}

	public LibraryBranch readOne(int branchId) throws SQLException {
		@SuppressWarnings("unchecked")
		List<LibraryBranch> libraryBranches = (List<LibraryBranch>) read(
				"select * from tbl_library_branch where branchId = ?",
				new Object[] { branchId });
		if (libraryBranches != null && libraryBranches.size() > 0) {
			return libraryBranches.get(0);
		} else {
			return null;
		}
	}

	@Override
	protected List<LibraryBranch> mapResults(ResultSet rs) throws SQLException {
		List<LibraryBranch> libraryBranches = new ArrayList<LibraryBranch>();
		while (rs.next()) {
			LibraryBranch a = new LibraryBranch();
			a.setBranchId(rs.getInt("branchId"));
			a.setBranchName(rs.getString("branchName"));

			libraryBranches.add(a);
		}
		return libraryBranches;
	}

	@Override
	protected List<?> mapResultsFirstLevel(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
