package com.training.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class assignment4dot1 {

	//purpose: asking for input and then running some administrator functions.
	//Might link the input to the administrator functions
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			// parameters are table name, database host name, database password 
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", null);
			
			Statement stmt = con.createStatement();


			Scanner scan = new Scanner(System.in);
			
			String pers = "";
			String action = "";
			String value = "";
			
			
			while ( pers.length() == 0){
				//action: ask for position
				System.out.println("Welcome to the GCIT Library Management System. Which category of a user are you"

	+	" \n 1) Librarian " +

		" \n 2) Administrator"+

		" \n 3) Borrower");
				
				
				pers = scan.next();
				
			}
			
			while( action.length() == 0){
				//action: ask for action from user id add/update/delete
				System.out.println("What action would you like to take ? Remember to please type"
						+ "either BookAuthor, Publisher, Branches, Borrowers, BookLoan in place of []."
						+ " No spaces and terms are case sensitive"
						+ ""
						+ "\n 1) add/[]"
						+ "\n 2) update/[]"
						+ "\n 3) delete/[]");

				action = scan.next();
				
			}
			
			
			
			System.out.println("");
			System.out.println("successfully passed through all of the while loops");
			System.out.println("");
			
			//Add/Update/Delete Book and Author
			
		
			if ( pers.equals("admin") ){
				
				System.out.println("yezzir");
			}
			
			PreparedStatement pstmt = con.prepareStatement("");//just initializing to stop future errors.
			
			
			
			
			if ( pers.equals("admin") && action.equals("add/BookAuthor") ){
				//action: insert
				System.out.println("got in add/bookauthor");
				String updateQuery = "insert into tbl_book_authors (authorName) values (?,?)";
				
				pstmt = con.prepareStatement(updateQuery);
				
				while ( value.length() == 0){
					//action: get the values from the user; the delimiter will be the commas
					
					System.out.println("Please enter the book id and author id. Please enter your values separated by commas");
					
					value = scan.next();
					
				}
				
				
				String[] parts = value.split(",");

				for(int i = 0; i < parts.length; i++){
					//action: iteratively replaces above "?" symbols with values input by user
					pstmt.setString(i, parts[i-1]);
					
				}
				
				
				
				
				
			}else if ( pers.equals("admin") && action.equals("udpate/BookAuthor") ){
				//action: update
				String updateQuery = "UPDATE tbl_book_authors SET bookId = ? WHERE authorId = ?";
				
				pstmt = con.prepareStatement(updateQuery);
				
				
				while ( value.length() == 0){
					//action: get the values from the user; the delimiter will be the commas
					
					System.out.println("Please enter your book and author id. Please enter your values separated by commas");
					
					value = scan.next();
					
				}
				
				String[] parts = value.split(",");

				for(int i = 0; i < parts.length; i++){
					//action: iteratively replaces above "?" symbols with values input by user
					pstmt.setString(i, parts[i-1]);
					
				}
				
				
				
			}else if (pers.equals("admin") && action.equals("delete/BookAuthor") ){
				
				//action delete;
				//NOTE: anything can be accepted for value but the value won't be used
				//
				String updateQuery = "DELETE FROM tbl_book_authors WHERE bookId = ?";
				
				pstmt = con.prepareStatement(updateQuery);
				
				while ( value.length() == 0){
					//action: get the values from the user; the delimiter will be the commas
					
					System.out.println("Please enter the book id whose record you want to delete. Just need one value");
					
					value = scan.next();
					
				}
				
				String[] parts = value.split(",");

				for(int i = 0; i < parts.length; i++){
					//action: iteratively replaces above "?" symbols with values input by user
					pstmt.setString(i, parts[i-1]);
					
				}
			}
			 
			 
			 
			 //Add/Update/Delete Publishers
		
			if ( pers.equals("admin") && action.equals("add") ){
				//action: insert
				String updateQuery = "insert into tbl_publisher (authorName) values (?,?,?,?)";
				
				pstmt = con.prepareStatement(updateQuery);
				
				
				String[] parts = value.split(",");// separating input values from given user
				
				for(int i = 0; i < parts.length; i++){
					//action: iteratively replaces above "?" symbols with values input by user
					pstmt.setString(i, parts[i-1]);
					
				}
				
				
				
				
				
			}else if ( pers.equals("admin") && action.equals("update")  ){
				//action: update
				String updateQuery = "UPDATE tbl_book_authors SET bookId = ? WHERE authorId = ?";
				
				pstmt = con.prepareStatement(updateQuery);
				
				
				String[] parts = value.split(",");// separating input values from given user
				
				for(int i = 0; i < parts.length; i++){
					//action: iteratively replaces above "?" symbols with values input by user
					pstmt.setString(i, parts[i-1]);
					
				}
					
				
				
				
			}else if (pers.equals("admin") && action.equals("delete") ){
				
				//action delete;
				//NOTE: anything can be accepted for value but the value won't be used
				//
				String updateQuery = "DELETE FROM tbl_book_authors WHERE bookId = ?";
				
				pstmt = con.prepareStatement(updateQuery);
				
				
				String[] parts = value.split(",");// separating input values from given user
				
				for(int i = 0; i < parts.length; i++){
					//action: iteratively replaces above "?" symbols with values input by user
					pstmt.setString(i, parts[i-1]);
					
				}
				
			}
			 
			 
			 
			 // Add/Update/Delete Library Branches
			 
		
			
			if ( pers.equals("admin") && action.equals("add") ){
				//action: insert
				String updateQuery = "insert into tbl_book_authors (authorName) values (?,?)";
				
				pstmt = con.prepareStatement(updateQuery);
				
				
				String[] parts = value.split(",");// separating input values from given user
				
				for(int i = 0; i < parts.length; i++){
					//action: iteratively replaces above "?" symbols with values input by user
					pstmt.setString(i, parts[i-1]);
					
				}
				
				
				
				
				
			}else if ( pers.equals("admin") && action.equals("update") ){
				//action: update
				String updateQuery = "UPDATE tbl_book_authors SET bookId = ? WHERE authorId = ?";
				
				pstmt = con.prepareStatement(updateQuery);
				
				String[] parts = value.split(",");// separating input values from given user
				
				for(int i = 0; i < parts.length; i++){
					//action: iteratively replaces above "?" symbols with values input by user
					pstmt.setString(i, parts[i-1]);
					
				}
				
				
				
			}else if (pers.equals("admin") && action.equals("delete") ){
				
				//action delete;
				//NOTE: anything can be accepted for value but the value won't be used
				//
				String updateQuery = "DELETE FROM tbl_book_authors WHERE bookId = ?";
				
				pstmt = con.prepareStatement(updateQuery);
				
				String[] parts = value.split(",");// separating input values from given user
				
				for(int i = 0; i < parts.length; i++){
					//action: iteratively replaces above "?" symbols with values input by user
					pstmt.setString(i, parts[i-1]);
					
				}
				
			} 
			
			
			
			// Add/Update/Delete Borrowers
			
			
			if ( pers.equals("admin") && action.equals("add") ){
				//action: insert
				String updateQuery = "insert into tbl_borrower (cardNo, name, address, phone) values (?,?,?,?)";
				
				pstmt = con.prepareStatement(updateQuery);
				
				
				String[] parts = value.split(",");// separating input values from given user
				
				for(int i = 0; i < parts.length; i++){
					//action: iteratively replaces above "?" symbols with values input by user
					pstmt.setString(i, parts[i-1]);
					
				}

				
				
				
				
			}else if ( pers.equals("admin") && action.equals("update")  ){
				//action: update name
				String updateQuery = "UPDATE tbl_borrower SET name = ?, address = ?, phone = ? WHERE cardNo = ?";
				
				pstmt = con.prepareStatement(updateQuery);
				
				
				String[] parts = value.split(",");// separating input values from given user
				
				for(int i = 0; i < parts.length; i++){
					//action: iteratively replaces above "?" symbols with values input by user
					pstmt.setString(i, parts[i-1]);
					
				}

				
				
			}else if (pers.equals("admin") && action.equals("delete") ){
				
				//action delete;
				//NOTE: anything can be accepted for value but the value won't be used
				//
				String updateQuery = "DELETE FROM tbl_borrower WHERE cardNo = ?";
				
				pstmt = con.prepareStatement(updateQuery);
				
				
				String[] parts = value.split(",");// separating input values from given user
				
				for(int i = 0; i < parts.length; i++){
					//action: iteratively replaces above "?" symbols with values input by user
					pstmt.setString(i, parts[i-1]);
					
				}
				
			}
			
			// Over-ride Due Date for a Book Loan

			
			if ( pers.equals("admin") && action.equals("update")  ){
				//action: update
				String updateQuery = "UPDATE tbl_book_loans SET dueDate = ? WHERE bookId = ? AND cardNo = ?";
				
				pstmt = con.prepareStatement(updateQuery);
				
				
				String[] parts = value.split(",");// separating input values from given user
				
				for(int i = 0; i < parts.length; i++){
					//action: iteratively replaces above "?" symbols with values input by user
					pstmt.setString(i, parts[i-1]);
					
				}

				
				
			}
			
			
			pstmt.executeUpdate();
			 
			 
			stmt.close();//close statment before close closing the connection
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
