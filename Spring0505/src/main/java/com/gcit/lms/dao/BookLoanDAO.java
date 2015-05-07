package com.gcit.lms.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.BookLoan;
import com.gcit.lms.domain.Borrower;
import com.gcit.lms.domain.LibraryBranch;

@Repository
public class BookLoanDAO extends BaseDAO<BookLoan> implements Serializable,
		ResultSetExtractor<List<BookLoan>> {

	@Autowired
	PublisherDAO pDAO;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1619700647002508164L;

	public void addBookLoan(BookLoan bL) throws SQLException {

		Integer pubId = null;
//		if (bk.getPublisher() != null)
//			pubId = bL.getPublisher().getId();

	//	KeyHolder keyHolder = new GeneratedKeyHolder();
		template.update("insert into tbl_book_loans (bookId, branchId, cardNo, dateOut, dueDate) values (?,?,?,?,?)",
				new Object[] { bL.getBook(),bL.getLibraryBranch(),bL.getBorrower(),bL.getDateOut(),bL.getDateDue() });

		//int bookLoanId = keyHolder.getKey().intValue();
     
	
	}

	public void updateBookLoan(BookLoan bookLoan) throws SQLException {
		
		template.update("update tbl_book_loans set dueDate = ? where bookId = ? AND branchId = ? AND cardNo = ?",
				new Object[] { bookLoan.getDateDue(), bookLoan.getBook(), bookLoan.getLibraryBranch(),bookLoan.getBorrower() });
		
	}

	public void removeBookLoan(BookLoan bookLoan) throws SQLException {
		template.update("delete from tbl_book_loans where bookId = ? AND branchId = ? AND cardNo = ? AND dueDate = ? ",
				new Object[] { bookLoan.getBook(), bookLoan.getLibraryBranch(),bookLoan.getBorrower(), bookLoan.getDateDue() });
	}

	public List<BookLoan> readAll(int pageNo, int pageSize) throws SQLException {
		setPageNo(pageNo);
		setPageSize(pageSize);
		return (List<BookLoan>) template.query("select * from tbl_book_loans", this);
	}

	public int readAllCount() throws SQLException {
		return template.queryForObject("select count(1) from tbl_book_loans",
				Integer.class);
	}

	public BookLoan readOne(int authorId) throws SQLException {
		return null;
	}

	@Override
	public List<BookLoan> extractData(ResultSet rs) throws SQLException {
		List<BookLoan> bookLoans = new ArrayList<BookLoan>();

		while (rs.next()) {
			BookLoan bL = new BookLoan();
			Book b = new Book();
			b.setBookId(rs.getInt("bookId"));// creates a book class necessary to pass into the book loan object
			
			LibraryBranch lB = new LibraryBranch();
			lB.setBranchId(rs.getInt("branchId"));
			
			Borrower bor = new Borrower();
			bor.setCardNo(rs.getInt("cardNo"));
			
			bL.setBook(b);
			bL.setLibraryBranch(lB);
			bL.setBorrower(bor);
			bL.setDateOut(rs.getDate("dateOut"));
			bL.setDateDue(rs.getDate("dueDate"));
			bookLoans.add(bL);
		}
		return bookLoans;
	}

	public List<BookLoan> searchBookLoanByTitle(String searchString, int pageNo,
			int pageSize) throws SQLException {
		setPageNo(pageNo);
		setPageSize(pageSize);
		if (searchString == null || searchString.trim().length() == 0) {
			return readAll(pageNo, pageSize);
		} else {
			searchString = "%" + searchString + "%";
			return template.query("select * from tbl_book_loans where title like ?",
					new Object[] { searchString }, this);
		}
	}

	public int searchBookLoanByTitleCount(String searchString) throws SQLException {
		searchString = "%" + searchString + "%";
		return template.queryForObject(
				"select count(1) from tbl_book_loans where title like ?",
				new Object[] { searchString }, Integer.class);
	}
}
