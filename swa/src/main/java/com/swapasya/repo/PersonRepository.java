package com.swapasya.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.swapasya.domains.Person;

public interface PersonRepository extends CrudRepository<Person, String>
{
	List<Person> findByName(String personName);
	List<Person> findByDegree(String degree);
	List<Person> findByBranch(String branch);
}
