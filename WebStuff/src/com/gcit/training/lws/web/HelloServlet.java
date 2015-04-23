package com.gcit.training.lws.web;

import java.io.IOException;

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
@WebServlet("/HelloServlet")
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String authorName = request.getParameter("authorName");
		
		//adding author:
		if (authorName != null){
			

			Author author = new Author();
			author.setAuthorName(authorName);
			
			try {
				new AdministratorService().addAuthor(author);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		
		
		//adding Book:
		String title = request.getParameter("title");
		int pubId = request.getParameter("pubId");
		
		if (title != null && pubId != 0){
			

			Book book = new Book();
			Publisher pub = new Publisher();
			
			//note: I'm iffy on the next two statements; just wanted title and pub Id to tbl_book
			book.setPublisher(pub);
			pub.setId(pubId);
			
			try {
				new AdministratorService().addBook(book);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		//adding Genre:
		
		String genreName =  request.getParameter("name");

		if (genreName != null){
			
		
			Genre genre = new Genre();
			
			try {
				new AdministratorService().addGenre(genre);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		String pubName =  request.getParameter("name");
		String pubAddr =  request.getParameter("address");
		String pubPhone =  request.getParameter("name");
		
		
		//adding Publisher: 
		if (pubName != null){
			

			Publisher publ = new Publisher();
			publ.setName(pubName);
			publ.setAddress(pubAddr);
			publ.setPhoneNumber(pubPhone);
			
			
			try {
				new AdministratorService().addPublisher(publ);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		
		
		// add library branch:
		
		//TBC
		
		
		
		// add borrower: 
		
		
		//TBC
		
		
		
	}

}
