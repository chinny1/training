package com.training.db;

import static org.junit.Assert.*;

import org.junit.Test;

public class PublisherDAOTest {

	@Test
	public void testAddPublisher() {


		Publisher pub = new Publisher();
		
		pub.setId(12);
		pub.setName("Motown");
		
		try {
			
			new PublisherDAO().addPublisher(pub);
			
		} catch (Exception e) {
			
			fail(e.getMessage());
		}
		
	}

	@Test
	public void testUpdatePublisher() {

		Publisher pub = new Publisher();
		
		pub.setId(12);
		pub.setName("upTown");
		
		try {
			
			new PublisherDAO().updatePublisher(pub);
			
		} catch (Exception e) {
			
			fail(e.getMessage());
		}
		
	}

	@Test
	public void testRemovePublisher() {
		
Publisher pub = new Publisher();
		
		pub.setId(12);
		pub.setName("uptown");
		
		try {
			
			new PublisherDAO().removePublisher(pub);
			
		} catch (Exception e) {
			
			fail(e.getMessage());
		}
		
	}

	@Test
	public void testReadAll() {

		Publisher pub = new Publisher();
		
		//pub.setId(12);
		//pub.setName("Motown");
		
		try {
			
			new PublisherDAO().readAll();
			
		} catch (Exception e) {
			
			fail(e.getMessage());
		}
		
		
	}

}
