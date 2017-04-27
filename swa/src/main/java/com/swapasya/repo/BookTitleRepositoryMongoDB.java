package com.swapasya.repo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.Assert;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.swapasya.domains.AssignList;
import com.swapasya.domains.Book;
import com.swapasya.domains.BookTitle;
import com.swapasya.domains.WaitList;


//   http://joegornick.com/2012/10/25/mongodb-unique-indexes-on-single-embedded-documents/
	
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
		if (findOne(id)!=null)
			return true;
		else
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
		System.out.println(bookTitleID);
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
	
	public List<BookTitle> findByBookTitleRegex(String bookTitle) {
		Query query = Query.query(Criteria.where("bookName").regex(Pattern.compile(bookTitle, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
		return operations.find(query, BookTitle.class);

	}

	@Override
	public List<BookTitle> findByTag(String tag) {
		Query query = Query.query(Criteria.where("tags").is(tag));
		List<BookTitle> listOfBkTitles=operations.find(query, BookTitle.class);
		System.out.println("returning by tags");
		return listOfBkTitles;

	}

	@Override
	public List<BookTitle> findByAuthor(String author) {
		Query query = Query.query(Criteria.where("author").is(author)); 
		return operations.find(query, BookTitle.class);
	}
	
	public List<BookTitle> findByAuthorRegex (String author) {
		Query query = Query.query(Criteria.where("author").regex(Pattern.compile(author, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE))); 
		return operations.find(query, BookTitle.class);
	}

	@Deprecated
	public List<BookTitle> findByAuthor2(String author) {
		// Query query = Query.query(Criteria.where("authour").is(author));
		DBCollection coll = operations.getCollection("BookTitle");
		List<Object> listOfObjects = new ArrayList<>();
		List<BookTitle> listOfbkTitles = new ArrayList<>();
		BasicDBObject key = new BasicDBObject("bookTitleID", true);
		key.append("imgPath", true);
		key.append("bookName", true);
		key.append("author", true);
		key.append("publication", true);
		BasicDBObject initial = new BasicDBObject("", "");
		try {

			BasicDBObject cond = new BasicDBObject();
			cond.put("author", author);

			String reduce = "function(doc,prev){ }";

			BasicDBList returnList = (BasicDBList) coll.group(key, cond, initial, reduce);

			for (Object o : returnList) {
				System.out.println(o);

				if (o instanceof Map) {
					Map<String, BookTitle> map = (Map) o;
					for (Object obj2 : map.entrySet()) {

						if (obj2 instanceof Entry) {
							Entry entry = (Entry) obj2;
							// System.out.println(entry.getValue());
							listOfObjects.add(entry.getValue());
						}
					}

					BookTitle bkTitle = new BookTitle();

					bkTitle.setBookTitleID(listOfObjects.get(0).toString());

					bkTitle.setImgPath("./images/black_book.jpg");
					bkTitle.setBookName(listOfObjects.get(2).toString());
					bkTitle.setAuthor(listOfObjects.get(3).toString());
					bkTitle.setPublication(listOfObjects.get(4).toString());
					listOfObjects.clear();
					listOfbkTitles.add(bkTitle);
				}

			}

			for (int j = 0; j < listOfbkTitles.size(); j++) {
				System.out.println(listOfbkTitles.get(j));
			}

			/*
			 * Map<String, BookTitle> map=returnList.toMap(); Set<String>
			 * set=map.keySet(); Iterator<String> i=set.iterator();
			 * while(i.hasNext()) { BookTitle title= map.get(i.next());
			 * System.out.println(title); }
			 */

			/*
			 * 
			 * Iterator<Object> i=returnList.iterator(); while(i.hasNext()) {
			 * BookTitle bkTitle=(BookTitle) i.next();
			 * System.out.println(bkTitle.getAuthour()+bkTitle.getBookName()); }
			 * 
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listOfbkTitles;
	}

	@Override
	public List<BookTitle> findByPublication(String publication) {
		Query query = Query.query(Criteria.where("publication").is(publication));
		return operations.find(query, BookTitle.class);

	}
	
	// Pattern.compile(input_location, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)
	public List<BookTitle> findByPublicationRegex (String publication) {
		Query query = Query.query(Criteria.where("publication").regex( Pattern.compile(publication, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
		return operations.find(query, BookTitle.class);

	}

	@Override
	public List<BookTitle> findByBookId(String bookId) {
		Query query = Query.query(Criteria.where("books.bookID").is(bookId));
		return operations.find(query, BookTitle.class);

	}

	@Override
	public void insertOne(BookTitle bookTitle) {
		operations.insert(bookTitle);
	}

	@Deprecated
	public void insertOne2(BookTitle bookTitle) {

		// operations.in

		DBCollection coll = operations.getCollection("BookTitle");

		BasicDBObject bkTitle = new BasicDBObject();

		bkTitle.put("bookTitleID", bookTitle.getBookTitleID());
		bkTitle.put("isbnNumber", bookTitle.getIsbnNumber());
		bkTitle.put("bookName", bookTitle.getBookName());
		bkTitle.put("author", bookTitle.getAuthor());
		bkTitle.put("publication", bookTitle.getPublication());
		bkTitle.put("bindingType", bookTitle.getBindingType());
		bkTitle.put("noOfPages", bookTitle.getNoOfPages());
		bkTitle.put("language", bookTitle.getLanguage());
		bkTitle.put("imgPath", bookTitle.getImgPath());
		bkTitle.put("tags", bookTitle.getTags().toArray());

		List<Book> listOfBooks = bookTitle.getBooks();
		BasicDBObject book[] = new BasicDBObject[listOfBooks.size()];
		int j = 0;
		Iterator<Book> i = listOfBooks.iterator();
		while (i.hasNext()) {
			Book b = i.next();

			book[j] = new BasicDBObject();

			book[j].put("bookID", b.getBookID());
			book[j].put("purchaseDate", b.getPurchaseDate());
			book[j].put("price", b.getPrice());
			book[j].put("borrowedBy", b.getBorrowedBy());
			book[j].put("issuedType", b.getIssuedType());
			book[j].put("categoryType", b.getCategoryType());
			book[j].put("issueDate", b.getIssueDate());
			book[j].put("expectedReturnDate", b.getExpectedReturnDate());
			j++;

		}
		bkTitle.put("books", book);
		System.out.println("Till books done");

		BasicDBObject waitLs = new BasicDBObject();
		List<WaitList> waitList = bookTitle.getWaitList();
		Iterator<WaitList> i1 = waitList.iterator();
		while (i1.hasNext()) {
			WaitList w = i1.next();
			waitLs.put("id", w.getId());
			waitLs.put("timestamp", w.getTimestamp());
			bkTitle.put("waitList", waitLs);
		}

		System.out.println("Till waitList");

		BasicDBObject assignLs = new BasicDBObject();
		List<AssignList> assignList = bookTitle.getAssignList();
		Iterator<AssignList> i2 = assignList.iterator();
		while (i2.hasNext()) {
			AssignList a = i2.next();
			assignLs.put("id", a.getId());
			assignLs.put("timestamp", a.getTimestamp());
			bkTitle.put("assignList", assignList);
		}
		System.out.println("Till assignList");
		coll.insert(bkTitle);

	}
	
	
	
	
	// Need to decide best position of these function
	// whether in book class or in this class.
	
	
	public void addBook (String bookTitleID , Book b) {
		
	}
	
	public void removeBook (String bookTitleID , Book b) {
			
	}
	
	public void addToWaitList (String bookTitleID , String personID) {
		
	}
	
	public void removeFromWaitList (String bookTitleID , String personID) {
		
	}
	
	
	
	

}
