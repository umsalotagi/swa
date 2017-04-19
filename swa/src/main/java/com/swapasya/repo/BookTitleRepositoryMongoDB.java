package com.swapasya.repo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
//		Query query = Query.query(Criteria.where("authour").is(author));
		DBCollection coll = operations.getCollection("BookTitle");
List<Object> listOfObjects=new ArrayList<>();
List<BookTitle> listOfbkTitles=new ArrayList<>();
		BasicDBObject key = new BasicDBObject("bookTitleID", true);
		key.append("imgPath", true);
		key.append("bookName", true);
		key.append("authour",true);
		key.append("publication",true);
	    BasicDBObject initial = new BasicDBObject("","");
try {


	        BasicDBObject cond = new BasicDBObject();
	        cond.put("authour", author);

	        String reduce = "function(doc,prev){ }";
	        
	        BasicDBList returnList = (BasicDBList) coll.group(key, cond, initial, reduce);
	        
	        Object multi[][]=new Object[1][5];
	        int i=0;
	            for (Object o : returnList) {
	            	System.out.println(o);
	            	

	                if (o instanceof Map) {
	                    Map<String,BookTitle> map = (Map) o;
	                    for (Object obj2 : map.entrySet()) {
	                    	
	                        if (obj2 instanceof Entry) {
	                            Entry entry = (Entry) obj2;
	                           //System.out.println(entry.getValue());
	       listOfObjects.add(entry.getValue());                 }
	                    }
	                    
	                    BookTitle bkTitle=new BookTitle();
	                    
	                    bkTitle.setBookTitleID(listOfObjects.get(0).toString());
	                    
	                    bkTitle.setImgPath("./images/black_book.jpg");
	                    bkTitle.setBookName(listOfObjects.get(2).toString());
	                    bkTitle.setAuthor(listOfObjects.get(3).toString());
	                    bkTitle.setPublication(listOfObjects.get(4).toString());
	                    listOfObjects.clear();
	                    listOfbkTitles.add(bkTitle);
	                }

	                
	            }
	            	
	            	for(int j=0;j<listOfbkTitles.size();j++)
	            	{
	            		System.out.println(listOfbkTitles.get(j));
	            	}
	            
	            
	                /*
	            Map<String, BookTitle> map=returnList.toMap();
	            	Set<String> set=map.keySet();
	            Iterator<String> i=set.iterator();
	            while(i.hasNext())
	            {
	            	BookTitle title= map.get(i.next());
	            	System.out.println(title);
	            }
	            	*/
	         
	        
	        
	        
	        
	        
	        /*
	        
	        Iterator<Object> i=returnList.iterator();
	            while(i.hasNext())
	            {
	            	BookTitle bkTitle=(BookTitle) i.next();
	            	System.out.println(bkTitle.getAuthour()+bkTitle.getBookName());
	            }
	            
	          */  
}catch (Exception e) {
	e.printStackTrace();
}


		    
		return listOfbkTitles;
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
