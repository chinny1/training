////package com.gcit.lms;
////
////import java.text.DateFormat;
////import java.util.Date;
////import java.util.Locale;
////
////import org.slf4j.Logger;
////import org.slf4j.LoggerFactory;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Scope;
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestMethod;
////
////import com.gcit.lms.service.AdministratorService;
////
/////**
//// * Handles requests for the application home page.
//// */
////@Controller
////public class HomeController {
////	
////	@Autowired
////	private AdministratorService adminService;
////	
////	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
////	
////	/**
////	 * Simply selects the home view to render by returning its name.
////	 */
////	@RequestMapping(value = "/", method = RequestMethod.GET)
////	public String home(Locale locale, Model model) {
////		logger.info("Welcome home! The client locale is {}.", locale);
////		
////		Date date = new Date();
////		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
////		
////		String formattedDate = dateFormat.format(date);
////		
////		model.addAttribute("serverTime", formattedDate );
////		
////		return "home";
////	}
////	
////}
//
//
//package com.gcit.lms;
//
//import java.sql.SQLException;
//import java.text.DateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.gcit.lms.dao.AuthorDAO;
//import com.gcit.lms.dao.BookDAO;
//import com.gcit.lms.domain.Author;
//import com.gcit.lms.domain.Book;
//
///**
// * Handles requests for the application home page.
// */
//@RestController
//public class HomeController_0507 {
//
//	@Autowired
//	private AuthorDAO authorDAO;
//
//	@Autowired
//	private BookDAO bookDAO;
//
//	private static final Logger logger = LoggerFactory
//			.getLogger(HomeController.class);
//
//	/**
//	 * Simply selects the home view to render by returning its name.
//	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
//				DateFormat.LONG, locale);
//
//		String formattedDate = dateFormat.format(date);
//
//		model.addAttribute("serverTime", formattedDate);
//
//		return "home";
//	}
//
//	@RequestMapping(value = "/authors/get", method = { RequestMethod.GET,
//			RequestMethod.POST }, produces = { "application/json" })
//	public List<Author> getAllAuthors() {
//		try {
//			return authorDAO.readAll();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	@RequestMapping(value = "/books/get/{pageNo}/{pageSize}", method = {
//			RequestMethod.GET, RequestMethod.POST }, produces = { "application/json" })
//	public List<Book> getAllBooks(@PathVariable int pageNo,
//			@PathVariable int pageSize) {
//		try {
//			return bookDAO.readAll(pageNo, pageSize);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	@Transactional
//	@RequestMapping(value = "/author/add", method = RequestMethod.POST, 
//		consumes = "application/json")
//	public String addAuthor(@RequestBody Author author) {
//		try {
//			authorDAO.addAuthor(author);
//			return "Author Added succesfully!";
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return "failed: " + e.getMessage();
//		}
//	}
//
//}
