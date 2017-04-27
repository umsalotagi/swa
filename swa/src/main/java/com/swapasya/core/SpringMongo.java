package com.swapasya.core;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;
import com.swapasya.dataTypes.BookTitleProp;
import com.swapasya.domains.Book;
import com.swapasya.domains.BookTitle;
import com.swapasya.model.DBConnect;
import com.swapasya.repo.BookTitleRepositoryMongoDB;

public class SpringMongo {

	MongoOperations mongoOps;

	public SpringMongo() {

		try {

			mongoOps = DBConnect.getConnection();
			System.out.println("Connect to database successfully");

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private void addBookTitleAndBook(String bookTitleID, String isbnNumber, String bookName, String authour,
			String categoryType, String publication, float price, Date purchaseDate, String bindingType,
			ArrayList<String> tags, int noOfPages, String language, String bookID) {

		BookTitle bt = new BookTitle(bookTitleID, isbnNumber, bookName, authour, publication, bindingType, tags,
				noOfPages, language);

		Book b = new Book(bookID, purchaseDate, price, categoryType);

		if (bt != null) {
			bt.getBooks().add(b);

			mongoOps.insert(bt);
		}

	}

	public void addBook(String bookID, String isbnNumber, String bookName, String authour, String categoryType,
			String publication, float price, Date purchaseDate, String bindingType, ArrayList<String> tags,
			int noOfPages, String language) {

		Query q = new Query();
		q.addCriteria(Criteria.where("bookName").is(bookName));
		q.addCriteria(Criteria.where("authour").is(authour));

		BookTitle bt = mongoOps.findOne(q, BookTitle.class);

		if (bt == null) {
			String bookTitleID = "T_" + bookID;
			addBookTitleAndBook(bookTitleID, isbnNumber, bookName, authour, categoryType, publication, price,
					purchaseDate, bindingType, tags, noOfPages, language, bookID);
		} else {
			Book bb = new Book(bookID, purchaseDate, price, categoryType);
			bt.addBook(bb);
			new BookTitleRepositoryMongoDB(mongoOps).save(bt);

		}

	}

}
