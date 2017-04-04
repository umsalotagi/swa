package com.swapasya.repo;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.swapasya.domains.BookTitle;

@Repository
@Profile("mongodb")
public interface BookTitleRepository  extends CrudRepository<BookTitle, Long>{
	
}
