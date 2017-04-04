package com.swapasya.repo;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.Assert;

import com.swapasya.domains.BookTitle;

public class BookTitleRepositoryMongoDB implements BookTitleRepository
{


	private final MongoOperations operations;
	
	/**
	 * Creates a new {@link MongoDbCustomerRepository} using the given {@link MongoOperations}.
	 * 
	 * @param operations must not be {@literal null}.
	 */
	@Autowired
	public BookTitleRepositoryMongoDB(MongoOperations operations) {

		Assert.notNull(operations);
		this.operations = operations;
	}
	/*
	public BookTitle findOne(Long id) {
		Query query = Query.query(Criteria.where("id").is(id));
		return operations.findOne(query, BookTitle.class);
	}
	
	public BookTitle save(BookTitle bookTitle) {
		operations.save(bookTitle);
		return bookTitle;
	}*/

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BookTitle bookTitle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends BookTitle> iterable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<BookTitle> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<BookTitle> findAll(Iterable<Long> iterable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookTitle findOne(Long id) {
		Query query = Query.query(Criteria.where("id").is(id));
		return operations.findOne(query, BookTitle.class);
		
	}

	@Override
	public <S extends BookTitle> S save(S bookTitle) {
		operations.save(bookTitle);
		return bookTitle;
	}

	@Override
	public <S extends BookTitle> Iterable<S> save(Iterable<S> iterable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	
}
