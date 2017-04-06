package com.swapasya.core;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;
import com.swapasya.domains.Book;
import com.swapasya.domains.BookTitle;

public class SpringMongo {
	
	
MongoOperations mongoOps;
	
	public SpringMongo(String nameSpace) {

		try{
			
	         // To connect to mongodb server
			MongoClient mongoClient = new MongoClient("localhost", 27017);
	         	
	         // Now connect to your databases

	         mongoOps = new MongoTemplate(mongoClient, "test");
	         System.out.println("Connect to database successfully");
	    //     boolean auth = db.authenticate(myUserName, myPassword);
	    //     System.out.println("Authentication: "+auth);

	      }catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }

	}
	
	
	private void addBookTitleAndBook(String bookTitleID, String isbnNumber, String bookName, String authour,
			String categoryType, String publication, float price, Date purchaseDate, String bindingType,
			ArrayList<String> tags, int noOfPages, String language, String bookID ) {
		
		BookTitle bt = new BookTitle(bookTitleID, isbnNumber, bookName, authour, 
				publication, bindingType, tags, noOfPages, language);
		
		Book b = new Book(bookID, purchaseDate, price, categoryType);
		
		if (bt!=null) {
			bt.getBooks().add(b);
			
			mongoOps.insert(bt);
		}
		

	}
	
	private void addBookTitle(String bookTitleID, String isbnNumber, String bookName, String authour,
			String categoryType, String publication, float price, Date purchaseDate, String bindingType,
			ArrayList<String> tags, int noOfPages, String language) {
		
		BookTitle bt = new BookTitle(bookTitleID, isbnNumber, bookName, authour, 
				publication, bindingType, tags, noOfPages, language);
		
		
		mongoOps.insert(bt);

	}
	
	// if personID does not exists :
	// KeyFactory.createKey created any random key not null
	// datastore.get throws exception EntityNotFoundException
	
	// if property does not exists it is returns null ( no exception thrown)
	
	private void addBookInBookTitle(BookTitle bt, String bookID, String bookName, String authour,
			String categoryType, float price, Date purchaseDate) {

		Book b = new Book(bookID, purchaseDate, price, categoryType);
		
		if (bt!=null) {
			bt.getBooks().add(b);
			
			mongoOps.insert(bt);
		}
	}

	public void addBook(String bookID, String isbnNumber, String bookName, String authour, String categoryType,
			String publication, float price, Date purchaseDate, String bindingType, ArrayList<String> tags,
			int noOfPages, String language) {
		
		
		Query q = new Query();
		q.addCriteria(new Criteria().where("bookName").is(bookName));
		q.addCriteria(new Criteria().where("authour").is(authour));
		
		BookTitle bt = mongoOps.findOne(q , BookTitle.class);
		
		if (bt==null) {
			String bookTitleID = "T_" + bookID;
			addBookTitleAndBook(bookTitleID, isbnNumber, bookName, authour, categoryType, publication, price, 
					purchaseDate, bindingType, tags, noOfPages, language, bookID);
		} else {
			addBookInBookTitle(bt, bookID, bookName, authour, categoryType, price, purchaseDate);
		}
		
	}
	

}
