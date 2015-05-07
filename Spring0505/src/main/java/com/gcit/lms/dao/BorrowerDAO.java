package com.gcit.lms.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.gcit.lms.domain.Borrower;
import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.Publisher;

public class BorrowerDAO extends BaseDAO<Borrower> implements Serializable,
ResultSetExtractor<List<Borrower>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1619700647002508164L;

	public void addBorrower(Borrower borrower) throws SQLException {
		template.update("insert into tbl_borrower ( name, address, phone) values (?,?,?)",
				new Object[] { borrower.getBorrowerName(), borrower.getBorrowerAddress(),borrower.getBorrowerPhone() });

	}

	public void updateBorrower(Borrower borrower) throws SQLException {
		template.update("update tbl_borrower set name = ?, address = ?, phone = ? where cardNo = ?",
				new Object[] {  borrower.getBorrowerName(), borrower.getBorrowerAddress(),borrower.getBorrowerPhone(), borrower.getCardNo() });
	}

	public void removeBorrower(Borrower borrower) throws SQLException {
		template.update("delete from tbl_borrower where cardNo = ?",
				new Object[] { borrower.getCardNo() });
	}

	@SuppressWarnings("unchecked")
	public List<Borrower> readAll() throws SQLException {
		return (List<Borrower>) template.query("select * from tbl_borrower", this);
	}

	public Borrower readOne(int cardNo) throws SQLException {
		@SuppressWarnings("unchecked")
		List<Borrower> borrowers = (List<Borrower>) template.query(
				"select * from tbl_borrower where cardNo = ?",
				new Object[] { cardNo }, this);
		if (borrowers != null && borrowers.size() > 0) {
			return borrowers.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Borrower> extractData(ResultSet rs) throws SQLException {
		List<Borrower> borrowers = new ArrayList<Borrower>();
		BookDAO bDAO = new BookDAO();
		while (rs.next()) {
			Borrower a = new Borrower();
			a.setCardNo(rs.getInt("cardNo"));
			a.setBorrowerName(rs.getString("name"));
			a.setBorrowerAddress(rs.getString("address"));
			a.setBorrowerPhone(rs.getString("phone"));

//			List<Book> books = (List<Book>) bDAO.readFirstLevel("select * from tbl_book where bookId in "
	//				+ "(select bookId from tbl_book_borrowers where cardNo = ?)", new Object[]{a.getCardNo()});
			//a.setCardNo();
			
			borrowers.add(a);
		}
		return borrowers;
	}

//	@Override
//	protected List<Borrower> mapResultsFirstLevel(ResultSet rs) throws SQLException {
//		List<Borrower> borrowers = new ArrayList<Borrower>();
//		BookDAO bDAO = new BookDAO(conn);
//		while (rs.next()) {
//			Borrower a = new Borrower();
//			a.setCardNo(rs.getInt("cardNo"));
//			a.setBorrowerName(rs.getString("name"));
//			a.setBorrowerAddress(rs.getString("address"));
//			a.setBorrowerPhone(rs.getString("phone"));
//			
//			borrowers.add(a);
//		}
//		return borrowers;
//	}
}