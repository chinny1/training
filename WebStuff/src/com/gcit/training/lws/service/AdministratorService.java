package com.gcit.training.lws.service;

//import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.training.lws.dao.AuthorDAO;
import com.gcit.training.lws.domain.Author;
import com.gcit.training.lws.dao.BookDAO;
import com.gcit.training.lws.domain.Book;
import com.gcit.training.lws.dao.GenreDAO;
import com.gcit.training.lws.domain.Genre;
import com.gcit.training.lws.dao.PublisherDAO;
import com.gcit.training.lws.domain.Publisher;
import com.gcit.training.lws.dao.LibraryBranchDAO;
import com.gcit.training.lws.domain.LibraryBranch;
import com.gcit.training.lws.dao.BorrowerDAO;
import com.gcit.training.lws.domain.Borrower;


public class AdministratorService {

	public void addAuthor(Author author) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new AuthorDAO(conn).addAuthor(author);
			conn.commit();
		} catch(Exception e) {
			conn.rollback();
			throw e;
		}
	}
	
	public List<Author> getAuthors()throws Exception {
		
		
		Connection conn = ConnectionUtil.getConnection();
		
		List<Author> listAuth;
		
		try {
		
			listAuth = new AuthorDAO(conn).readAll(1,5);
			conn.commit();
		} catch(Exception e) {
			conn.rollback();
			throw e;
		}
		
		return listAuth;
		
	}
	
	public List<Author> getAuthors(int pageNo, int pageSize) throws Exception {
		AuthorDAO aDAO = new AuthorDAO(ConnectionUtil.getConnection());
		aDAO.setPageNo(pageNo);
		aDAO.setPageSize(pageSize);
		//return aDAO.readAll(aDAO.getPageNo(),aDAO.getPageSize());
		return aDAO.readAll();
	}
	
//	public List<Book> getBooks() throws Exception {
//		return new BookDAO(ConnectionUtil.getConnection()).readAll(1, 10);
//	}
	
	
	
	public List<LibraryBranch> getLibraryBranches() throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		
		List<LibraryBranch> listBranch;
		try {
			listBranch = new LibraryBranchDAO(conn).readAll();
			conn.commit();
		} catch(Exception e) {
			conn.rollback();
			throw e;
		}
		
		return listBranch;
	}
	
	
	public Author getAuthor(int authorId) throws Exception {
		return new AuthorDAO(ConnectionUtil.getConnection()).readOne(authorId);
	}
	
	public void editAuthor(Author author) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new AuthorDAO(conn).updateAuthor(author);
			conn.commit();
		} catch(Exception e) {
			conn.rollback();
			throw e;
		}
		
	}
	
	public void deleteAuthor(Author author) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new AuthorDAO(conn).removeAuthor(author);
			conn.commit();
		} catch(Exception e) {
			conn.rollback();
			throw e;
		}
	}
	
	public List<Publisher> getPublishers()throws Exception {
		
		
		Connection conn = ConnectionUtil.getConnection();
		
		List<Publisher> listPublisher;
		
		try {
		
			listPublisher = new PublisherDAO(conn).readAll();
			conn.commit();
		} catch(Exception e) {
			conn.rollback();
			throw e;
		}
		
		return listPublisher;
		
	}
	
	public List<Genre> getGenres()throws Exception {
		
		
		Connection conn = ConnectionUtil.getConnection();
		
		List<Genre> listGenre;
		
		try {
		
			listGenre = new GenreDAO(conn).readAll();
			conn.commit();
		} catch(Exception e) {
			conn.rollback();
			throw e;
		}
		
		return listGenre;
		
	}
	
	public void addBook(Book book) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new BookDAO(conn).addBook(book);
			conn.commit();
		} catch(Exception e) {
			conn.rollback();
			throw e;
		}
	}
	
	public List<Book> searchBooks(String searchString) throws Exception {
		return new BookDAO(ConnectionUtil.getConnection()).searchBookByTitle(searchString);
	}
	
	public List<Author> searchAuthors(String searchString) throws Exception {
		
		return new AuthorDAO(ConnectionUtil.getConnection()).searchAuthor(searchString);
	}
	
	
//	public List<Book> getBooks()throws Exception {
//		
//		
//		Connection conn = ConnectionUtil.getConnection();
//		
//		List<Book> listBook;
//		
//		try {
//		
//			listBook = new BookDAO(conn).readAll();
//			conn.commit();
//		} catch(Exception e) {
//			conn.rollback();
//			throw e;
//		}
//		
//		return listBook;
//		
//	}
	
	public List<Book> getBooks() throws Exception {
		return new BookDAO(ConnectionUtil.getConnection()).readAll(1, 10);
	}
	
	public int getBooksCount() throws Exception {
		return new BookDAO(ConnectionUtil.getConnection()).readAllCount();
	}

	
	
	public int getAuthorsCount() throws Exception {
		return new AuthorDAO(ConnectionUtil.getConnection()).readAllCount();
	}
	
	public void addGenre(Genre genre) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new GenreDAO(conn).addGenre(genre);
			conn.commit();
		} catch(Exception e) {
			conn.rollback();
			throw e;
		}
	}
	
	
	public void addPublisher(Publisher publisher) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new PublisherDAO(conn).addPublisher(publisher);
			conn.commit();
		} catch(Exception e) {
			conn.rollback();
			throw e;
		}
	}
	

	public void addLibraryBranch(LibraryBranch libraryBranch) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new LibraryBranchDAO(conn).addLibraryBranch(libraryBranch);
			conn.commit();
		} catch(Exception e) {
			conn.rollback();
			throw e;
		}
	}

	public void addBorrower(Borrower borrower) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new BorrowerDAO(conn).addBorrower(borrower);
			conn.commit();
		} catch(Exception e) {
			conn.rollback();
			throw e;
		}
	}

	
	public List<Book> searchBooks(String searchString, int pageNo, int pageSize) throws Exception {
		return new BookDAO(ConnectionUtil.getConnection()).searchBookByTitle(searchString, pageNo, pageSize);
	}

	public int searchBooksCount(String searchString) throws Exception {
		return new BookDAO(ConnectionUtil.getConnection()).searchBookByTitleCount(searchString);
	}

	public List<Author> searchAuthors(String searchString, int pageNo, int pageSize) throws Exception {
		return new AuthorDAO(ConnectionUtil.getConnection()).searchAuthorByName(searchString, pageNo, pageSize);
	}

	public int searchAuthorsCount(String searchString) throws Exception {
		return new AuthorDAO(ConnectionUtil.getConnection()).searchAuthorByNameCount(searchString);
	}


	
	
	
	
}
