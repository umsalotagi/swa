package com.swapasya.repo;

import java.lang.annotation.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.swapasya.domains.BookTitle;

@Repository
@Profile("mongodb")
public class BookTitleRepository {
	
	private final MongoOperations operations;
	
	/**
	 * Creates a new {@link MongoDbCustomerRepository} using the given {@link MongoOperations}.
	 * 
	 * @param operations must not be {@literal null}.
	 */
	@Autowired
	public BookTitleRepository(MongoOperations operations) {

		Assert.notNull(operations);
		this.operations = operations;
	}
	
	public BookTitle findOne(Long id) {
		Query query = Query.query(Criteria.where("id").is(id));
		return operations.findOne(query, BookTitle.class);
	}
	
	public BookTitle save(BookTitle bookTitle) {
		operations.save(bookTitle);
		return bookTitle;
	}
	
	

}
