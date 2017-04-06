package com.swapasya.repo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.Assert;

import com.swapasya.domains.RulesLibrary;

public class RulesLibraryRepositoryMongoDB implements RulesLibraryRepository 
{

	private final MongoOperations operations;
	
	public RulesLibraryRepositoryMongoDB(MongoOperations operations) {

		Assert.notNull(operations);
		this.operations = operations;
	}
	
	@Override
	public long count() {
		List<RulesLibrary> list = operations.findAll(RulesLibrary.class);
		return list.size();
	}

	@Override
	public void delete(String id) {
		operations.remove(id);
		
	}

	@Override
	public void delete(RulesLibrary rulesLibrary) {
		operations.remove(rulesLibrary);
		
	}

	@Override
	public void delete(Iterable<? extends RulesLibrary> iterable) {
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
	public Iterable<RulesLibrary> findAll() {
		return operations.findAll(RulesLibrary.class);
	}

	@Override
	public Iterable<RulesLibrary> findAll(Iterable<String> idList) {
		Iterator<String> i = idList.iterator();
		List<RulesLibrary> l = new ArrayList<>();
		while (i.hasNext()) {

			Query q = new Query(Criteria.where("readerType_BkCatORissueType").is(i));
			RulesLibrary b = operations.findOne(q, RulesLibrary.class);
			l.add(b);
		}

		return l;
	}

	@Override
	public RulesLibrary findOne(String id) {
		Query query = Query.query(Criteria.where("readerType_BkCatORissueType").is(id));
		return operations.findOne(query, RulesLibrary.class);
	}

	@Override
	public <S extends RulesLibrary> S save(S rulesLibrary) {
		operations.save(rulesLibrary);
		return rulesLibrary;
	}

	@Override
	public <S extends RulesLibrary> Iterable<S> save(Iterable<S> list) {
		Iterator<S> i = list.iterator();
		while (i.hasNext()) {
			RulesLibrary rulesLibrary = i.next();
			operations.save(rulesLibrary);

		}
		return list;
	}


}
