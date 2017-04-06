package com.swapasya.repo;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.swapasya.domains.BookTitle;

@Repository
@Profile("mongodb")
public interface BookTitleRepository  extends CrudRepository<BookTitle, String>{
	
}
