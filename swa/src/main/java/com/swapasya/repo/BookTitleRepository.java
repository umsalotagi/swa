package com.swapasya.repo;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.swapasya.domains.BookTitle;

@Repository
@Profile("mongodb")
public interface BookTitleRepository  extends CrudRepository<BookTitle, String>{
	
	List<BookTitle> findByBookTitle(String bookTitle);
	List<BookTitle> findByTag(String tag);
	List<BookTitle> findByAuthor(String author);
	List<BookTitle> findByPublication(String publication);
	List<BookTitle> findByBookId(String bookId);
	void insertOne(BookTitle bookTitle);
	
	
}
