package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.lws.domain.Author;
import com.gcit.training.lws.domain.Book;
import com.gcit.training.lws.domain.Publisher;

public class BookDAO extends BaseDAO<Book> implements Serializable {

	public BookDAO(Connection conn) {
		super(conn);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1619700647002508164L;

	public void addBook(Book book) throws SQLException {

		Integer pubId = null;
		if (book.getPublisher() != null)
			pubId = book.getPublisher().getId();

		int bookId = saveWithId(
				"insert into tbl_book (title, pubId) values (?,?)", new Object[] {
						book.getTitle(), pubId });

		for (Author a : book.getAuthors()) {
			save("insert into tbl_book_authors (bookId, authorId) values (?,?)",
					new Object[] { bookId, a.getAuthorId() });
		}
	}

	public void updateBook(Book book) throws SQLException {
		
		save("update tbl_book set title = ? where bookId = ?",
				new Object[] { book.getTitle(), book.getBookId() });
	}

	public void removeBook(Book book) throws SQLException {
		save("delete from tbl_book where  bookId = ?",
				new Object[] { book.getBookId() });
	}

	@SuppressWarnings("unchecked")
	public List<Book> readAll() throws SQLException {
		return (List<Book>) read("select * from tbl_book", null);
	}

	@SuppressWarnings("unchecked")
	public List<Book> readAll(int pageNo, int pageSize) throws SQLException {
		setPageNo(pageNo);
		setPageSize(pageSize);
		return (List<Book>) read("select * from tbl_book", null);
	}
	
	public Author readOne(int authorId) throws SQLException {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> searchBookByTitle(String searchString) throws SQLException {
		searchString = "%" + searchString + "%";
		return (List<Book>) read("select * from tbl_book where title like ?", new Object[]{searchString});
	}
	
	public int searchBookByTitleCount(String searchString) throws SQLException {
		searchString = "%" + searchString + "%";
		PreparedStatement stmt = getConnection().prepareStatement("select count(1) from tbl_book where title like ?");
		stmt.setString(1, searchString);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) 
			return rs.getInt(1);
		else 
			return 0;
	}
	
	@Override
	protected List<Book> mapResults(ResultSet rs) throws SQLException {
		List<Book> books = new ArrayList<Book>();
		PublisherDAO pDAO = new PublisherDAO(conn);
		AuthorDAO aDAO = new AuthorDAO(conn);
		
		while (rs.next()) {
			Book b = new Book();
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			b.setPublisher(pDAO.readOne(rs.getInt("pubId")));
			
			List<Author> authors = (List<Author>) aDAO.readFirstLevel("select * from library.tbl_author where authorId in "
					+ "(select authorId from library.tbl_book_authors where bookId = ?)", new Object[]{b.getBookId()});
			b.setAuthors(authors);//not allowing the book author to be shown
			
			books.add(b);
		}
		return books;
	}

	@Override
	protected List<Book> mapResultsFirstLevel(ResultSet rs) throws SQLException {
		List<Book> books = new ArrayList<Book>();
		PublisherDAO pDAO = new PublisherDAO(conn);
		AuthorDAO aDAO = new AuthorDAO(conn);
		
		while (rs.next()) {
			Book b = new Book();
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			b.setPublisher(pDAO.readOne(rs.getInt("pubId")));
			
			books.add(b);
		}
		return books;
	}

	public List<Book> searchBookByTitle(String searchString, int pageNo, int pageSize) throws SQLException {
		setPageNo(pageNo);
		setPageSize(pageSize);
		if(searchString == null || searchString.trim().length() == 0) {
			return readAll(pageNo, pageSize);
		} else {
			searchString = "%" + searchString + "%";
			return (List<Book>) read("select * from tbl_book where title like ?", new Object[]{searchString});
		}
	}

	public int readAllCount() throws SQLException {
		PreparedStatement stmt = getConnection().prepareStatement("select count(1) from tbl_book");
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) 
			return rs.getInt(1);
		else 
			return 0;
	}


}
