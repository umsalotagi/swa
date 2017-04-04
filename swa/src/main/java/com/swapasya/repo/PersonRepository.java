package com.swapasya.repo;

import org.springframework.data.repository.CrudRepository;

import com.swapasya.domains.Person;

public interface PersonRepository extends CrudRepository<Person, String>
{

}
