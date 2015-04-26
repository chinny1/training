package com.gcit.training.lws.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcit.training.lws.service.AdministratorService;
import com.gcit.training.lws.domain.Author;
import com.gcit.training.lws.domain.Book;
import com.gcit.training.lws.domain.Genre;
import com.gcit.training.lws.domain.Publisher;





/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/HelloServlet")
@WebServlet({"/HelloServlet","/addAuthor", "/addPublisher", "/addBook", "/deleteAuthor",
"/editAuthor" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void oldDoGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
//	protected void oldDoPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//		String authorName = request.getParameter("authorName");
//		
//		//authorName = "Mr. twain";
//		//status: checked
//		//adding author:
//		if (authorName != null){
//			
//
//			Author author = new Author();
//			author.setAuthorName(authorName);
//			
//			try {
//				new AdministratorService().addAuthor(author);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			
//		}
//		
//		
//		//adding Book:
//		//status: pubId not being checked
////		String title = request.getParameter("title");
////		String pubId = request.getParameter("pubid");//having issues with this parameter
////		
////		
////		if (title != null && pubId != null){
////			
////
////			int intPubId = Integer.parseInt(pubId);
////			
////			System.out.println("intPubId is equal to: " + intPubId);
////			
////			Book book = new Book();
////			Publisher pub = new Publisher();
////			
////			//note: I'm iffy on the next two statements; just wanted title and pub Id to tbl_book
////			pub.setId(intPubId);
////			book.setPublisher(pub);
////			
////			
////			try {
////				new AdministratorService().addBook(book);
////			} catch (Exception e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////			
////		}
//		
//		
//		
//		//adding Genre:
//		//status: checked
//		String genreName =  request.getParameter("name");
//
//		if (genreName != null){
//			
//		
//			Genre genre = new Genre();
//			
//			genre.setName(genreName);
//			
//			try {
//				new AdministratorService().addGenre(genre);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//		}
//		
//		
//		String pubName =  request.getParameter("name");
//		String pubAddr =  request.getParameter("address");
//		String pubPhone =  request.getParameter("name");
//		
//		
//		//adding Publisher: 
//		if (pubName != null){
//			
//
//			Publisher publ = new Publisher();
//			publ.setName(pubName);
//			publ.setAddress(pubAddr);
//			publ.setPhoneNumber(pubPhone);
//			
//			
//			try {
//				new AdministratorService().addPublisher(publ);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//			
//		}
//		
//		
//		
//
//		
//		
//		
//		
//	}
//	
	

    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String authorId = request.getParameter("authorId");
		Author a = new Author();
		a.setAuthorId(Integer.parseInt(authorId));
		try {
			new AdministratorService().deleteAuthor(a);
			request.setAttribute("result", "Author removed succesfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("result",
					"Author remove failed!: " + e.getMessage());
		}
	
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/listAuthors.jsp");
		rd.forward(request, response);
		
	}

    
    
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
    
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String function = request.getRequestURI().substring(
				request.getContextPath().length(),
				request.getRequestURI().length());

		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/admin.jsp");
		switch (function) {
		case "/addAuthor": {
			addAuthor(request);
			break;
		}
		case "/addBook": {
			addBook(request);
			break;
		}
		case "/addPublisher": {
			addPublisher(request);
			break;
		}
		case "/editAuthor": {
			editAuthor(request);
			rd = getServletContext().getRequestDispatcher("/listAuthors.jsp");
			break;
		}

		default:
			break;
		}

		rd.forward(request, response);
	}

	private void addBook(HttpServletRequest request) {
		String authorId = request.getParameter("authorId");
		//1,26,7
		String publisherId = request.getParameter("publisherId");
		String title = request.getParameter("title");

		Author author = new Author();
		author.setAuthorId(Integer.parseInt(authorId));
		
		Book b = new Book();
		b.setAuthors(new ArrayList<Author>());
		b.getAuthors().add(author);
		
		Publisher p = new Publisher();
		p.setId(Integer.parseInt(publisherId));
		
		b.setPublisher(p);
		b.setTitle(title);

		try {
			new AdministratorService().addBook(b);
			request.setAttribute("result", "Book added succesfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("result",
					"Book add failed!: " + e.getMessage());
		}
	}

	
	private void addPublisher(HttpServletRequest request) {
		String publisherName = request.getParameter("publisherName");
		String publisherAddress = request.getParameter("publisherAddress");
		String publisherPhone = request.getParameter("publisherPhone");

		Publisher p = new Publisher();
		p.setName(publisherName);
		p.setAddress(publisherAddress);
		p.setPhoneNumber(publisherPhone);

		try {
			new AdministratorService().addPublisher(p);
			request.setAttribute("result", "Publisher added succesfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("result",
					"Publisher add failed!: " + e.getMessage());
		}

	}

	private void addAuthor(HttpServletRequest request) {
		String authorName = request.getParameter("authorName");

		Author author = new Author();
		author.setAuthorName(authorName);

		try {
			new AdministratorService().addAuthor(author);
			request.setAttribute("result", "Author added succesfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("result",
					"Author add failed!: " + e.getMessage());
		}
	}

	private void editAuthor(HttpServletRequest request) {
		String authorName = request.getParameter("authorName");
		String authorId = request.getParameter("authorId");

		Author author = new Author();
		author.setAuthorId(Integer.parseInt(authorId));
		author.setAuthorName(authorName);

		try {
			new AdministratorService().editAuthor(author);
			request.setAttribute("result", "Author edited succesfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("result",
					"Author edit failed!: " + e.getMessage());
		}
	}

	

	
	
	// add library branch:
	
	//TBC
	
	
	
	// add borrower: 
	
	
	//TBC

}
