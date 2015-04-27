package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.lws.domain.Author;
import com.gcit.training.lws.domain.Book;

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

	public void updateAuthor(Book book) throws SQLException {
	}

	public void removeAuthor(Book book) throws SQLException {
	}

	@SuppressWarnings("unchecked")
	public List<Book> readAll() throws SQLException {
		return (List<Book>) read("select * from tbl_book", null);
	}

	public Author readOne(int authorId) throws SQLException {
		return null;
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
}
