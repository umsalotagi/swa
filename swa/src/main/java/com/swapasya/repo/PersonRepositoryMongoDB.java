package com.swapasya.repo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.Assert;

import com.swapasya.domains.BookTitle;
import com.swapasya.domains.Person;

public class PersonRepositoryMongoDB implements PersonRepository 
{
	
	private final MongoOperations operations;
	
	public PersonRepositoryMongoDB(MongoOperations operations) {

		Assert.notNull(operations);
		this.operations = operations;
	}
	
	@Override
	public long count() {
		List<Person> list = operations.findAll(Person.class);
		return list.size();
	}

	@Override
	public void delete(String id) {
		operations.remove(id);
		
	}

	@Override
	public void delete(Person person) {
		operations.remove(person);
		
	}

	@Override
	public void delete(Iterable<? extends Person> iterable) {
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
	public Iterable<Person> findAll() {
		return operations.findAll(Person.class);
	}

	@Override
	public Iterable<Person> findAll(Iterable<String> personIDlist) {
		Iterator<String> i = personIDlist.iterator();
		List<Person> l = new ArrayList<>();
		while (i.hasNext()) {

			Query q = new Query(Criteria.where("personID").is(i));
			Person b = operations.findOne(q, Person.class);
			l.add(b);
		}

		return l;
	}

	@Override
	public Person findOne(String id) {
		Query query = Query.query(Criteria.where("personID").is(id));
		return operations.findOne(query, Person.class);
	}

	@Override
	public <S extends Person> S save(S person) {
		operations.save(person);
		return person;
	}

	@Override
	public <S extends Person> Iterable<S> save(Iterable<S> list) {
		Iterator<S> i = list.iterator();
		while (i.hasNext()) {
			Person person = i.next();
			operations.save(person);

		}
		return list;
	}

	@Override
	public List<Person> findByName(String personName) {
		Query query = Query.query(Criteria.where("personName").is(personName));
		return operations.find(query, Person.class);
	}

	@Override
	public List<Person> findByDegree(String degree) {
		Query query = Query.query(Criteria.where("degree").is(degree));
		return operations.find(query, Person.class);
	}

	@Override
	public List<Person> findByBranch(String branch) {
		Query query = Query.query(Criteria.where("branch").is(branch));
		return operations.find(query, Person.class);
	}
	

}
