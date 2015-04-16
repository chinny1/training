package training_class;

public class Assignment3dot1 {

	//purpose: assingment 3; I'm creating listing the query statements that correspond to the 7 or 8 questions in the
	// assignment
	
	public static void main( String [] args ) {
		
		
		String queries[] = new String[]{ "", "", "", "", "", "", "", "" };
		
		
		//what I learned: have to think of tables as a generic "concentric" or "fractile" concept. Two or more tables can be
		// added together via UNION. inner join can be used to "add together" two tables that have a common field
		
		//join two tables by their shared branchIds
		//need to: update to search by name and not strictly number; should require using multiple left joins
		queries[1] = " SELECT * FROM ( "
				+ "SELECT tbl_book_copies.noOfCopiesopies FROM tbl_book_copies INNER JOIN tbl_library_branch ON tbl_library_branch.branchId = tbl_book_copies.branchId"
				+ "UNION"
				+ "SELECT * FROM tbl_book_copies INNER JOIN tbl_book.bookId = tbl_book_copies.bookId "
				+ ") WHERE tbl_book. = 'Harry Potter' AND tbl_library_branch.branchName = 'north'";
		
		//action: returns total number of copies of one book belonging to each/all library branches
		//questions: is there a "for each" style loop in MySQL that allows one to alternate between conditions (ie library bran names)
		queries[2] = " SELECT * FROM ( "
				+ "SELECT tbl_book_copies.noOfCopiesopies FROM tbl_book_copies INNER JOIN tbl_library_branch ON tbl_library_branch.branchId = tbl_book_copies.branchId"
				+ "UNION"
				+ "SELECT * FROM tbl_book_copies INNER JOIN tbl_book.bookId = tbl_book_copies.bookId "
				+ ") WHERE tbl_book. = 'Harry Potter'";
		
		//action: retrieve names of borrowers with no books
		queries[3] = "SELECT tbl_borrower.name FROM tbl_borrower INNER JOIN tbl_book_loans.cardNo = tbl_borrower.cardNo WHERE COUNT(tbl_borrower.cardNo)= 0 ";
		
		
		//notes: involves tables tbl_book_loans, tbl_borrower (name, address), tbl_book (title)
		queries[4] = "SELECT tbl_borrower.name,tbl_borrower.address,tbl_book.title ("
				+ "SELECT * FROM tbl_book_loans INNER JOIN tbl_book_loans.cardNo = tbl_borrower.cardNo"
				+ "UNION"
				+ ""
				+ "SELECT * FROM tbl_book INNER JOIN tbl_book_loans.bookId = tbl_book.bookId"
				+ "UNION"
				+ "SELECT * FROM tbl_library_branch INNER JOIN tbl_library_branch.branchId = tbl_book_loans.branchId"
				+ ") WHERE tbl_library_branch.branchName = 'South' AND tbl_book_loans.dueDate ";
		
		// notes: involves tables tbl_library_branch
		//personal note: I'm kind of iffy on the count I used here 
		queries[5] = "SELECT tbl_library_branch.branchName, COUNT(tbl_book_loans.branchId) AS numBooks FROM tbl_library_branch INNER JOIN tbl_library_branch.branchId = tbl_book_loans.branchId";
		
		
		//notes: 
		queries[6] = "SELECT tbl_borrower.name, tbl_borrower.address, COUNT(tbl_book_loans.cardNo) AS numBooks FROM tbl_borrower INNER JOIN tbl_borrower.cardNo = tbl_book_loans.cardNo WHERE numBooks > 5";
		
		//notes:
		queries[7] = "SELECT tbl_book_copies.noOfCopies, [table].title ( "
				+ "SELECT * FROM tbl_book_loans INNER JOIN tbl_book_loans.branchId = tbl_book_copies.branchId"
				+ "UNION"
				+ "SELECT * FROM tbl_book INNER JOIN tbl_book_loans.bookId = tbl_book.bookId"
				+ "UNION"
				+ "SELECT * FROM tbl_book_loans INNER JOIN tbl_book_loans.bookId = tbl_book_authors.bookId"
				+ "UNION"
				+ "SELECT * FROM tbl_book_authors INNER JOIN tbl_author.authorId = tbl_book_authors.authorId"
				+ " ) WHERE tbl_author.authorName = 'Stephen King' AND tbl_library_branch.branchName = 'Central' ";
		
	}
	
	
	
	
	
}
