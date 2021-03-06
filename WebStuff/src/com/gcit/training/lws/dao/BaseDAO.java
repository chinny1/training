package com.gcit.training.lws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BaseDAO<T> {
	
	
	private int pageNo = -1;
	private int pageSize = 5;

	
	protected Connection conn = null;
	public BaseDAO(Connection conn) {
		this.conn = conn;
	}

	public List<?> read(String query, Object[] vals) throws SQLException {
		

		if(getPageNo() > -1) {
			int start = ((getPageNo()-1)*getPageSize());
			//if(start > 5) start++;
			query = query + " LIMIT " + start + "," + getPageSize();
		}
		
		PreparedStatement stmt = getConnection().prepareStatement(query);
		int count = 1;
		if(vals != null) {
			for (Object obj : vals) {
				stmt.setObject(count++, obj);
			}
		}
		ResultSet rs = stmt.executeQuery();

		return mapResults(rs);
	}
	protected abstract List<?> mapResults(ResultSet rs) throws SQLException;
	
	public List<?> readFirstLevel(String query, Object[] vals) throws SQLException {
		PreparedStatement stmt = getConnection().prepareStatement(query);
		int count = 1;
		if(vals != null) {
			for (Object obj : vals) {
				stmt.setObject(count++, obj);
			}
		}
		ResultSet rs = stmt.executeQuery();

		return mapResultsFirstLevel(rs);
	}
	protected abstract List<?> mapResultsFirstLevel(ResultSet rs) throws SQLException;

	public void save(String query, Object[] vals) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(query);
		int count = 1;
		for (Object obj : vals) {
			pstmt.setObject(count++, obj);
		}
		pstmt.executeUpdate();
	}

	public int saveWithId(String query, Object[] vals) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		int count = 1;
		for (Object obj : vals) {
			pstmt.setObject(count++, obj);
		}
		pstmt.executeUpdate();
		
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()) 
			return rs.getInt(1);
		else 
			return -1;
	}

	protected Connection getConnection() throws SQLException {
		return conn;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
