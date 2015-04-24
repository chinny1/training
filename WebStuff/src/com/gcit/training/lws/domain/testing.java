package com.gcit.training.lws.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.gcit.training.lws.service.AdministratorService;
import com.gcit.training.lws.domain.Author;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			
			// parameters are table name, database host name, database password 
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", null);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		
		String authorName = "test twain";
		
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


	}

}
