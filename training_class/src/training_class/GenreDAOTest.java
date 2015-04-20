package com.training.db;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenreDAOTest {

	@Test
	public void testAddGenre() {
		
		Genre g = new Genre();
		
		g.setGenreId(12);
		g.setName("zomby");
		
		try {
			
			new GenreDAO().addGenre(g);
			
		} catch (Exception e) {
			
			fail(e.getMessage());
			
		}
		
	}

	@Test
	public void testUpdateGenre() {

Genre g = new Genre();
		
		g.setGenreId(12);
		g.setName("zomby");
		
		try {
			
			new GenreDAO().updateGenre(g);
			
		} catch (Exception e) {
			
			fail(e.getMessage());
			
		}
		
	}

	@Test
	public void testRemoveGenre() {

Genre g = new Genre();
		
		g.setGenreId(12);
		g.setName("zomby");
		
		try {
			
			new GenreDAO().removeGenre(g);
			
		} catch (Exception e) {
			
			fail(e.getMessage());
			
		}
		
	}

	@Test
	public void testReadAll() {
		
		Genre g = new Genre();
		
		//g.setGenreId(12);
		//g.setName("zomby");
		
		try {
			
			new GenreDAO().readAll();
			
		} catch (Exception e) {
			
			fail(e.getMessage());
			
		}
		
	}

}
