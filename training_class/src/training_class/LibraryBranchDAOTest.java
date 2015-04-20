package com.training.db;

import static org.junit.Assert.*;

import org.junit.Test;

public class LibraryBranchDAOTest {

	@Test
	public void testAddLibraryBranch() {

		LibraryBranch lb = new LibraryBranch();
		
		lb.setBranchId(12);
		lb.setBranchName("Sesame Street");
		
		try {
			
			new LibraryBranchDAO().addLibraryBranch(lb);
			
		} catch (Exception e) {
			
			fail(e.getMessage());
			
		}

		
	}

	@Test
	public void testUpdateLibraryBranch() {
		
		LibraryBranch lb = new LibraryBranch();
		
		lb.setBranchId(12);
		lb.setBranchName("Next Street");
		
		try {
			
			new LibraryBranchDAO().updateLibraryBranch(lb);
			
		} catch (Exception e) {
			
			fail(e.getMessage());
		}

		
	}

	@Test
	public void testRemoveLibraryBranch() {
		
		
		LibraryBranch lb = new LibraryBranch();
		
		lb.setBranchId(12);
		lb.setBranchName("Next Street");
		
		try {
			
			new LibraryBranchDAO().removeLibraryBranch(lb);
			
		} catch (Exception e) {
			
			fail(e.getMessage());
		}
	}

	@Test
	public void testReadAll() {
		LibraryBranch lb = new LibraryBranch();
		
		//lb.setBranchId(12);
		//lb.setBranchName("Next Street");
		
		try {
			
			new LibraryBranchDAO().readAll();
			
		} catch (Exception e) {
			
			fail(e.getMessage());
		}
	}

}
