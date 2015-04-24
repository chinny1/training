package com.gcit.training.lws.service;

//import static org.junit.Assert.fail;

import java.sql.Connection;

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
	
	public void getAuthor(Author author)throws Exception {
		
		
		Connection conn = ConnectionUtil.getConnection();
		
	
		
		try {
		
			new AuthorDAO(conn).updateAuthor(author);
			conn.commit();
		} catch(Exception e) {
			conn.rollback();
			throw e;
		}
		
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
	
	
	
}
