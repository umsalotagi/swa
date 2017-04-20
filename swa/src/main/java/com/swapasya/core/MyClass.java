package com.swapasya.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;

import com.swapasya.domains.AssignList;
import com.swapasya.domains.Book;
import com.swapasya.domains.BookTitle;
import com.swapasya.domains.WaitList;
import com.swapasya.model.DBConnect;
import com.swapasya.repo.BookTitleRepositoryMongoDB;

public class MyClass {

	public static void main(String[] args) {
		MongoOperations op=DBConnect.getConnection();
		BookTitleRepositoryMongoDB mdb=new BookTitleRepositoryMongoDB(op);
		
		ArrayList<String> tags=new ArrayList<>();
		tags.add(".net");
		tags.add("ASP");
		
		
		List<Book> books=new ArrayList<>();
		Book book=new Book("b001",new Date(12, 10, 2016), 800, "xx");
		Book book1=new Book("b002",new Date(11, 10, 2016), 800, "xx");
		books.add(book);
		books.add(book1);
		
		
		List<WaitList> waitList=new ArrayList<>();
		List<AssignList> assignList=new  ArrayList<>();
		
		
	BookTitle bkTitle=new BookTitle(".Net", "1232u348", "Pro ASP.NET Core MVC", "Adam Freeman","XXX", "Folded",tags , 2000, "English");
		
		bkTitle.setBooks(books);
		bkTitle.setWaitList(waitList);
		bkTitle.setAssignList(assignList);
		
		mdb.insertOne(bkTitle);
		System.out.println("Inserted Successfully");

	}

}
