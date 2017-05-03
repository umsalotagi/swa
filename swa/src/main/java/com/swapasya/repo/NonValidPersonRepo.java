package com.swapasya.repo;



import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swapasya.domains.NonValidPerson;

@Repository
@Profile("mongodb")
public interface NonValidPersonRepo  extends CrudRepository<NonValidPerson, String>{
	
	void insertOne(NonValidPerson nonValidPerson);
	
	
}
