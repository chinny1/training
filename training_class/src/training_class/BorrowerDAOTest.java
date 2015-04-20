package com.training.db;

import static org.junit.Assert.*;

import org.junit.Test;

public class BorrowerDAOTest {

	@Test
	public void testAddBorrower() {

		Borrower b = new Borrower();
		
		b.setCardNo(12);
		b.setBorrowerName("Bobafet");
		
		try {
			
			new BorrowerDAO().addBorrower(b);
			
			
		} catch (Exception e) {
			fail(e.getMessage());

		}

			
	}

	@Test
	public void testUpdateBorrower() {
		
		Borrower b = new Borrower();
		
		b.setCardNo(12);
		b.setBorrowerName("Bobafet");
		
		try {
			
			new BorrowerDAO().updateBorrower(b);
			
			
		} catch (Exception e) {
			fail(e.getMessage());

		}

		
	}

	@Test
	public void testRemoveBorrower() {
		
		Borrower b = new Borrower();
		
		b.setCardNo(12);
		b.setBorrowerName("Bobafet");
		
		try {
			
			new BorrowerDAO().removeBorrower(b);
			
			
		} catch (Exception e) {
			fail(e.getMessage());

		}

		
	}

	@Test
	public void testReadAll() {
		
		Borrower b = new Borrower();
		
		//b.setCardNo(12);
		//b.setBorrowerName("Bobafet");
		
		try {
			
			new BorrowerDAO().readAll();
			
			
		} catch (Exception e) {
			fail(e.getMessage());

		}

		
	}

}
