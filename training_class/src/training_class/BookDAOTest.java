package com.training.db;

import static org.junit.Assert.*;

import org.junit.Test;



public class BookDAOTest {

	@Test
	public void testAddBook() {
		

		Book b = new Book();
		
		b.setBookId(12);
		b.setTitle("charley and the chocolate factory");
		
		try {
			
			new BookDAO().addBook(b);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}

		
	}

	@Test
	public void testUpdateBook() {
		
		
		Book b = new Book();
		
		b.setBookId(12);
		b.setTitle("Back 2 the Future");
		
		try {
			
			new BookDAO().updateBook(b);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}

	@Test
	public void testRemoveBook() {

		Book b = new Book();
		
		b.setBookId(12);
		b.setTitle("charley and the chocolate factory");
		
		try {
			
			new BookDAO().removeBook(b);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}

	@Test
	public void testReadAll() {
		

		Book b = new Book();
		
		//b.setBookId(12);
		//b.setTitle("charley and the chocolate factory");
		
		try {
			
			new BookDAO().readAll();
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		
		
	}

}
