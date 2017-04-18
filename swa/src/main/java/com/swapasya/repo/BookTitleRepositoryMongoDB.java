package com.swapasya.repo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.Assert;

import com.swapasya.domains.BookTitle;

public class BookTitleRepositoryMongoDB implements BookTitleRepository {

	private final MongoOperations operations;

	/**
	 * Creates a new {@link MongoDbCustomerRepository} using the given
	 * {@link MongoOperations}.
	 * 
	 * @param operations
	 *            must not be {@literal null}.
	 */
	@Autowired
	public BookTitleRepositoryMongoDB(MongoOperations operations) {

		Assert.notNull(operations);
		this.operations = operations;
	}

	@Override
	public long count() {
		List<BookTitle> list = operations.findAll(BookTitle.class);
		return list.size();
	}

	@Override
	public void delete(String id) {
		operations.remove(id);
	}

	@Override
	public void delete(BookTitle bookTitle) {
		operations.remove(bookTitle);
		
	}

	@Override
	public void delete(Iterable<? extends BookTitle> iterable) {
		operations.remove(iterable);
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<BookTitle> findAll() {
		
		return operations.findAll(BookTitle.class);
		
	}

	@Override
	public Iterable<BookTitle> findAll(Iterable<String> bookTitleIDlist) {
		Iterator<String> i = bookTitleIDlist.iterator();
		List<BookTitle> l = new ArrayList<>();
		while (i.hasNext()) {

			Query q = new Query(Criteria.where("bookTitleID").is(i));
			BookTitle b = operations.findOne(q, BookTitle.class);
			l.add(b);
		}

		return l;
	}

	@Override
	public BookTitle findOne(String bookTitleID) {
		Query query = Query.query(Criteria.where("bookTitleID").is(bookTitleID));
		return operations.findOne(query, BookTitle.class);

	}

	@Override
	public <S extends BookTitle> S save(S bookTitle) {
		operations.save(bookTitle);
		return bookTitle;
	}

	@Override
	public <S extends BookTitle> Iterable<S> save(Iterable<S> list) {
		Iterator<S> i = list.iterator();
		while (i.hasNext()) {
			BookTitle bookTitle = i.next();
			operations.save(bookTitle);

		}
		return list;
	}

	@Override
	public List<BookTitle> findByBookTitle(String bookTitle) {
		Query query = Query.query(Criteria.where("bookName").is(bookTitle));
		return operations.find(query, BookTitle.class);

	}

	@Override
	public List<BookTitle> findByTag(String tag) {
		Query query = Query.query(Criteria.where("tag").is(tag));
		return operations.find(query, BookTitle.class);

	}

	@Override
	public List<BookTitle> findByAuthor(String author) {
		Query query = Query.query(Criteria.where("author").is(author));
		return operations.find(query, BookTitle.class);

	}

	@Override
	public List<BookTitle> findByPublication(String publication) {
		Query query = Query.query(Criteria.where("publication").is(publication));
		return operations.find(query, BookTitle.class);

	}

	@Override
	public List<BookTitle> findByBookId(String bookId) {
		Query query = Query.query(Criteria.where("BookTitle.bookId").is(bookId));
		return operations.find(query, BookTitle.class);

	}

}
