package com.training.db;

import static org.junit.Assert.*;

import org.junit.Test;

public class AuthorDAOTest {

	@Test
	public void testAddAuthor() {
		System.out.println("Inside testAddAuthor"); 
		
		Author a = new Author();
		
		a.setAuthorId(12);
		a.setAuthorName("Boogey Woogey");
		
		try {
			
			new AuthorDAO().addAuthor(a);
			
		} catch (Exception e) {
			fail(e.getMessage());

		}
		
		
	}

	@Test
	public void testUpdateAuthor() {
		System.out.println("Inside testUpdateAuthor");
		
		Author a = new Author();
		
		a.setAuthorId(12);
		a.setAuthorName("Boogey Woogey");
		
		try {
			
			new AuthorDAO().updateAuthor(a);
		} catch (Exception e) {
			fail(e.getMessage());

		}
		
	}

	@Test
	public void testRemoveAuthor() {
		System.out.println("Inside testRemoveAuthor()"); 
		
		Author a = new Author();
		
		a.setAuthorId(12);
		a.setAuthorName("Boogey Woogey");
		
		try {
			
			new AuthorDAO().removeAuthor(a);
		} catch (Exception e) {
			fail(e.getMessage());

		}

		
		
	}

	@Test
	public void testReadAll() {
		System.out.println("Inside testReadAll()");
		
		Author a = new Author();
		
		a.setAuthorId(12);
		a.setAuthorName("Boogey Woogey");
		
		try {
			
			new AuthorDAO().readAll();
		} catch (Exception e) {
			fail(e.getMessage());

		}
		
	}

}
