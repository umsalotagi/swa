package com.swapasya.repo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.Assert;

import com.swapasya.domains.NonValidPerson;

public class NonValidPersonRepoMBD implements NonValidPersonRepo {
	
	private final MongoOperations operations;
	
	@Autowired
	public NonValidPersonRepoMBD (MongoOperations operations) {
		Assert.notNull(operations);
		this.operations = operations;
	}

	@Override
	public <S extends NonValidPerson> S save(S entity) {
		operations.save(entity);
		return entity;
	}

	@Override
	public <S extends NonValidPerson> Iterable<S> save(Iterable<S> listEntities) {
		Iterator<S> i = listEntities.iterator();
		while (i.hasNext()) {
			NonValidPerson nonValidPerson = i.next();
			operations.save(nonValidPerson);

		}
		return listEntities;
	}

	@Override
	public NonValidPerson findOne(String id) {
		Query query = Query.query(Criteria.where("nonValidPersonID").is(id));
		return operations.findOne(query, NonValidPerson.class);
	}
	
	public List<NonValidPerson> findByPersonNameRegex (String personName) {
		Query query = Query.query(Criteria.where("personName").regex(Pattern.compile(personName, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE))); 
		return operations.find(query, NonValidPerson.class);
	}

	@Override
	public boolean exists(String id) {
		if (findOne(id)!=null)
			return true;
		else
			return false;
	}

	@Override
	public Iterable<NonValidPerson> findAll() {
		return operations.findAll(NonValidPerson.class);
	}

	@Override
	public Iterable<NonValidPerson> findAll(Iterable<String> ids) {
		Iterator<String> i = ids.iterator();
		List<NonValidPerson> l = new ArrayList<>();
		while (i.hasNext()) {

			Query q = new Query(Criteria.where("nonValidPersonID").is(i));
			NonValidPerson b = operations.findOne(q, NonValidPerson.class);
			l.add(b);
		}

		return l;
	}

	@Override
	public long count() {
		List<NonValidPerson> list = operations.findAll(NonValidPerson.class);
		return list.size();
	}

	@Override
	public void delete(String id) {
		operations.remove(id);
		
	}

	@Override
	public void delete(NonValidPerson entity) {
		operations.remove(entity);
		
	}

	@Override
	public void delete(Iterable<? extends NonValidPerson> entities) {
		operations.remove(entities);
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertOne(NonValidPerson nonValidPerson) {
		operations.insert(nonValidPerson);
		
	}

}
