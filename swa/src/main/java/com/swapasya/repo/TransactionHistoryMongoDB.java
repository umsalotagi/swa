package com.swapasya.repo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.Assert;

import com.swapasya.domains.TransactionHistory;

public class TransactionHistoryMongoDB implements TransactionHistoryRepository 
{

	private final MongoOperations operations;
	
	public TransactionHistoryMongoDB(MongoOperations operations) {

		Assert.notNull(operations);
		this.operations = operations;
	}
	
	@Override
	public long count() {
		List<TransactionHistory> list = operations.findAll(TransactionHistory.class);
		return list.size();
	}

	@Override
	public void delete(String id) {
		operations.remove(id);
		
	}

	@Override
	public void delete(TransactionHistory transactionHistory) {
		operations.remove(transactionHistory);
		
	}

	@Override
	public void delete(Iterable<? extends TransactionHistory> iterable) {
		operations.remove(iterable);
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<TransactionHistory> findAll() {
		return operations.findAll(TransactionHistory.class);
	}

	@Override
	public Iterable<TransactionHistory> findAll(Iterable<String> transactionIDlist) {
		Iterator<String> i = transactionIDlist.iterator();
		List<TransactionHistory> l = new ArrayList<>();
		while (i.hasNext()) {

			Query q = new Query(Criteria.where("transactionID").is(i));
			TransactionHistory b = operations.findOne(q, TransactionHistory.class);
			l.add(b);
		}

		return l;
	}

	@Override
	public TransactionHistory findOne(String id) {
		Query query = Query.query(Criteria.where("transactionID").is(id));
		return operations.findOne(query, TransactionHistory.class);
	}

	@Override
	public <S extends TransactionHistory> S save(S transactionHistory) {
		operations.save(transactionHistory);
		return transactionHistory;
	}

	@Override
	public <S extends TransactionHistory> Iterable<S> save(Iterable<S> list) {
		Iterator<S> i = list.iterator();
		while (i.hasNext()) {
			TransactionHistory transactionHistory = i.next();
			operations.save(transactionHistory);

		}
		return list;
	}


}
